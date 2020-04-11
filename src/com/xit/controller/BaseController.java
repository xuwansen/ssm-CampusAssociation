package com.xit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xit.pojo.User;
import com.xit.service.UserService;

@Controller
@RequestMapping("/base")
public class BaseController {
	@Autowired
	private UserService userService;

	// �û���¼
	@RequestMapping(value = "/dologin")
	public String doLogin(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpServletRequest request, HttpSession session) {
		User user = userService.login(account, password);// ��¼������������õ�session����
		if (user != null) {// ���û�ֵ��Ϊ�գ����¼�ɹ������û�Ϊ�գ�����ת����¼���档
			// ����user��club���ű��ѯ,��ѯ�û�userId��clubId�������õ�session����
			Long userId = user.getId();
			User user1 = userService.findclubId(userId);
			int clubId = user1.getClubId();
			session.setAttribute("userId", userId);
			session.setAttribute("clubId", clubId);
			session.setAttribute("user", user);
			int role_id = user1.getRole_id();// ��ȡ�û��Ľ�ɫid����Ϊ���Ź���Ա��ת����̨
			if (role_id == 1) {
				return "redirect:/user/backUserlist";
			} else {
				return "redirect:/notice/selectNotice";
			}
		} else {
			request.setAttribute("error", "�û��������벻��ȷ");
			return "f-login";
		}

	}

//		�û�ע��
	@RequestMapping(value = "/exit")
	public String exit(HttpSession session) {
		// ��ȡsession���м�Ϊuser��ֵ
		if (session.getAttribute("user") != null) {// ��ȡsession���У���Ϊuser��ֵ
			session.removeAttribute("user");
		}
		return "f-login";
	}

	@RequestMapping(value = "/modifyUserSave")
	public String modifyClubSave(HttpServletRequest request, Model model, User user, HttpSession session) {
		String address = null;
		String userName = request.getParameter("name");
		String userPassword = request.getParameter("password");
		String userPhone = request.getParameter("phone");
		String major = request.getParameter("professional");
		String grade = request.getParameter("grade");
		if (userName != "" && userPassword != "" && userPhone != "" && major != "" && grade != "") {
			int resut = userService.modifyUser(user);// �޸ĸ�����Ϣ
			model.addAttribute("message", "�޸ĳɹ�");
			address = "f-modifyUser";
		} else {
			model.addAttribute("message", "������Ϣ����Ϊ��");
			address = "f-modifyUser";
		}
		return address;

		/*
		 * //��ȡǰ̨�������ֵ����user������޸ģ���ˢ��session���м�Ϊuser��ֵ int
		 * result=userService.modifyUser(user); session.setAttribute("user", user);
		 * if(result > 0) { return "redirect:/notice/selectNotice"; }else { return
		 * "404"; }
		 */
	}

	/* �û��޸ĸ�����Ϣ */
	@RequestMapping(value = "/f-modifyUser")
	public String f_modifyUser(HttpSession session, Model model, @RequestParam("accouunt") Integer id) {
		model.addAttribute("message", "");
		User user = userService.findUserById(id);// ���Ѿ���¼���û���������userid��ȡ��user���󣬲����뵽model��
		session.setAttribute("user", user);
		return "f-modifyUser";
	}

	/* �û�ע�� */
	@RequestMapping(value = "/register")
	public String register(@RequestParam("account") String account, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("phone") String phone,
			@RequestParam("grade") String grade, @RequestParam("professional") String professional) {
		// ����user���󣬽���ȡǰ̨�������ֵ����ע��ֵ��
		User user = new User(account, name, password, 3, phone, grade, professional);
		int result = userService.addUser(user);// ���Ѿ�������user����ӵ���user������
		if (result > 0) {
			return "f-login";
		} else {
			return "f-register";
		}

	}
}
