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
	/*后台用户管理*/
	@RequestMapping(value = "/backUserlist")
	public String backUserlist(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "role_id", required = false) Integer role_id,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, HttpSession session,Model model) {
		// 获取满足条件的用户集合
		List<User> userList = userService.findByCondition(name, role_id, pageNo, Constant.PAGESIZE);
		// 获取满足条件的记录总数
		int totalSize = userService.findCountByCondition(name, role_id);
		// 获取总页数
		int totalPage = totalSize % Constant.PAGESIZE == 0 ? totalSize / Constant.PAGESIZE
				: totalSize / Constant.PAGESIZE + 1;
		// 查询角色信息
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
	/*删除用户*/
	@RequestMapping(value="/removeUser")
	public String deleteClublist(@RequestParam("id")Integer id){
		//获取前台请求的id，删除user表中相应id的数据
		int result=userService.removeClubById(id);
		if(result>0) {
			return "redirect:/user/backUserlist";
		}else {
			return "404";
		}
	}
	//修改用户
	@RequestMapping(value="/usermodify")
	public String getUserById(@RequestParam("id")Integer id,Model model,HttpSession session) {
		session.setAttribute("message", "");
		//获取前台请求的id，查询user表中相应id的数据，将其放入前台显示
		User user = userService.findUserById(id);
		model.addAttribute("user", user);//刷新session中的user的值
		return "b-usermodify";
	}
	@RequestMapping(value="/usermodifysave")
	public String modifyUserSave(User user,HttpServletRequest request,HttpSession session) {
		String address=null;
		String userPhone=request.getParameter("phone");
		String userName=request.getParameter("name");
		if(userName!="") {//判断用户名是否为空
			if(userPhone.length()==11) {//判断电话号码是否为11位
				//获取表单键入的值，对user表进行修改，并刷新session域中键为user的值
				userService.backmodifyUser(user);
				address="redirect:/user/backUserlist";
			}else {
				session.setAttribute("message", "请输入正确的手机号码");
				address="b-usermodify";
			}
		}else {
			session.setAttribute("message", "姓名不能为空");
			address="b-usermodify";
		}
		return address;
	}

	
}
