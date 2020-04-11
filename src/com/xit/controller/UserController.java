package com.xit.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xit.common.Constant;
import com.xit.pojo.Role;
import com.xit.pojo.User;
import com.xit.service.RoleService;
import com.xit.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="roleService")
	private RoleService roleService;
	
	/*-------------------------------------------------------------------------------------*/
	/*��̨�û�����*/
	@RequestMapping(value = "/backUserlist")
	public String backUserlist(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "role_id", required = false) Integer role_id,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, HttpSession session,Model model) {
		// ��ȡ�����������û�����
		List<User> userList = userService.findByCondition(name, role_id, pageNo, Constant.PAGESIZE);
		// ��ȡ���������ļ�¼����
		int totalSize = userService.findCountByCondition(name, role_id);
		// ��ȡ��ҳ��
		int totalPage = totalSize % Constant.PAGESIZE == 0 ? totalSize / Constant.PAGESIZE
				: totalSize / Constant.PAGESIZE + 1;
		// ��ѯ��ɫ��Ϣ
		List<Role> roleList = roleService.findRoleList();

		model.addAttribute("userList", userList);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("name", name);
		model.addAttribute("role_id", role_id);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", Constant.PAGESIZE);
		//model.addAttribute("roleList", roleList);
		session.setAttribute("roleList", roleList);
		
		return "b-userlist";
	}
	/*ɾ���û�*/
	@RequestMapping(value="/removeUser")
	public String deleteClublist(@RequestParam("id")Integer id){
		//��ȡǰ̨�����id��ɾ��user������Ӧid������
		int result=userService.removeClubById(id);
		if(result>0) {
			return "redirect:/user/backUserlist";
		}else {
			return "404";
		}
	}
	//�޸��û�
	@RequestMapping(value="/usermodify")
	public String getUserById(@RequestParam("id")Integer id,Model model,HttpSession session) {
		session.setAttribute("message", "");
		//��ȡǰ̨�����id����ѯuser������Ӧid�����ݣ��������ǰ̨��ʾ
		User user = userService.findUserById(id);
		model.addAttribute("user", user);//ˢ��session�е�user��ֵ
		return "b-usermodify";
	}
	@RequestMapping(value="/usermodifysave")
	public String modifyUserSave(User user,HttpServletRequest request,HttpSession session) {
		String address=null;
		String userPhone=request.getParameter("phone");
		String userName=request.getParameter("name");
		if(userName!="") {//�ж��û����Ƿ�Ϊ��
			if(userPhone.length()==11) {//�жϵ绰�����Ƿ�Ϊ11λ
				//��ȡ�������ֵ����user������޸ģ���ˢ��session���м�Ϊuser��ֵ
				userService.backmodifyUser(user);
				address="redirect:/user/backUserlist";
			}else {
				session.setAttribute("message", "��������ȷ���ֻ�����");
				address="b-usermodify";
			}
		}else {
			session.setAttribute("message", "��������Ϊ��");
			address="b-usermodify";
		}
		return address;
	}

	
}
