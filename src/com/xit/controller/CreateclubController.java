package com.xit.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xit.common.Constant;
import com.xit.pojo.Club;
import com.xit.pojo.Createclub;
import com.xit.service.CreateclubService;

@Controller
@RequestMapping(value="/create")
public class CreateclubController {
	@Resource(name="createclubService")
	private CreateclubService createclubService;
	
	//前台创建社团
	@RequestMapping(value="/Createclub")
	public String Createclub(@RequestParam("userId")Integer userId,@RequestParam("clubname")String clubname,@RequestParam("clubbrief")String clubbrief,Model model){
		int result=0;
		if(userId==null) {//判断用户是否登录，若未登录则跳转至登录页面
			return "f-login";
		}else {//否则提交创建社团请求
			if(createclubService.findCreatclub(userId)>0) {
				model.addAttribute("message", "创建社团失败，您已经创建了社团，请耐心等待社团管理员审批");
				return "f-creatclub";
			}else{
				if(!clubname.isEmpty()&&!clubbrief.isEmpty()) {
					result=createclubService.Creatclub(userId,clubname,clubbrief);//新建创建社团请求
					model.addAttribute("message", "成功提交创建社团请求，请耐心等待社团管理员审批");
					return "f-creatclub";
				}else {//否则，继续停留在创建社团页面
					model.addAttribute("message", "创建社团失败，请输入合法的创建社团请求");
					return "f-creatclub";
				}
			}
			
		}
	}
	//-----------------------------------------------------------------------------------------------------------
	
	//后台创建社团列表显示
	@RequestMapping(value="/createlist")
	public String cretelist(@RequestParam(value="pageNo",required=false,defaultValue="0")Integer pageNo,Model model) {
		List<Createclub> createclublist= createclubService.Createclublist(pageNo,Constant.PAGESIZE);//查询所有创建社团请求
		int totalSize = createclubService.findCount();//统计创建社团请求表中的总记录数
		int totalPage = totalSize%Constant.PAGESIZE==0?totalSize/Constant.PAGESIZE:totalSize/Constant.PAGESIZE+1;//根据统计后记录数，得出总页数
		model.addAttribute("createclublist", createclublist);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", Constant.PAGESIZE);
		return "b-createlist";
	}
	//后台同意创建社团请求
	@RequestMapping(value="/agreecreate")
	public String agreecreate(@RequestParam("clubname")String clubname,@RequestParam("clubbrief")String clubbrief,@RequestParam("userid")String userid) {
			int result=createclubService.addclub(clubname,clubbrief,userid);
			if(result>0) {
				//删除创建社团请求信息并修改用户角色
				createclubService.removecreateclub(userid);
				createclubService.modifyrole_id(userid);
				return "redirect:/club/backClublist";
			}else {
				return "redirect:/create/createlist";
			}
	}
	//后台不同意创建社团请求
	@RequestMapping(value="disagreecreate")
	public String disagreecreate(@RequestParam("createclubId")Integer createclubId) {
		int result=createclubService.removeclubrequest(createclubId);
		if(result>0) {
			return "redirect:/create/createlist";
		}else{
			return null;
		}
	}
}
