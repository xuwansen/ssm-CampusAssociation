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

	// 用户登录
	@RequestMapping(value = "/dologin")
	public String doLogin(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpServletRequest request, HttpSession session) {
		User user = userService.login(account, password);// 登录，并将结果设置到session域中
		if (user != null) {// 若用户值不为空，则登录成功。若用户为空，则跳转至登录界面。
			// 连接user和club两张表查询,查询用户userId，clubId，并设置到session域中
			Long userId = user.getId();
			User user1 = userService.findclubId(userId);
			int clubId = user1.getClubId();
			session.setAttribute("userId", userId);
			session.setAttribute("clubId", clubId);
			session.setAttribute("user", user);
			int role_id = user1.getRole_id();// 获取用户的角色id，若为社团管理员跳转至后台
			if (role_id == 1) {
				return "redirect:/user/backUserlist";
			} else {
				return "redirect:/notice/selectNotice";
			}
		} else {
			request.setAttribute("error", "用户名或密码不正确");
			return "f-login";
		}

	}

//		用户注销
	@RequestMapping(value = "/exit")
	public String exit(HttpSession session) {
		// 获取session域中键为user的值
		if (session.getAttribute("user") != null) {// 获取session域中，键为user的值
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
			int resut = userService.modifyUser(user);// 修改个人信息
			model.addAttribute("message", "修改成功");
			address = "f-modifyUser";
		} else {
			model.addAttribute("message", "个人信息不能为空");
			address = "f-modifyUser";
		}
		return address;

		/*
		 * //获取前台表单键入的值，对user表进行修改，并刷新session域中键为user的值 int
		 * result=userService.modifyUser(user); session.setAttribute("user", user);
		 * if(result > 0) { return "redirect:/notice/selectNotice"; }else { return
		 * "404"; }
		 */
	}

	/* 用户修改个人信息 */
	@RequestMapping(value = "/f-modifyUser")
	public String f_modifyUser(HttpSession session, Model model, @RequestParam("accouunt") Integer id) {
		model.addAttribute("message", "");
		User user = userService.findUserById(id);// 将已经登录的用户，根据其userid获取到user对象，并放入到model中
		session.setAttribute("user", user);
		return "f-modifyUser";
	}

	/* 用户注册 */
	@RequestMapping(value = "/register")
	public String register(@RequestParam("account") String account, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("phone") String phone,
			@RequestParam("grade") String grade, @RequestParam("professional") String professional) {
		// 创建user对象，将获取前台表单键入的值对其注入值。
		User user = new User(account, name, password, 3, phone, grade, professional);
		int result = userService.addUser(user);// 将已经创建的user，添加到“user”表中
		if (result > 0) {
			return "f-login";
		} else {
			return "f-register";
		}

	}
}
