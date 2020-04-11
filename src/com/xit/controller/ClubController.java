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
import com.xit.pojo.User;
import com.xit.service.ClubService;

@Controller
@RequestMapping(value="/club")
public class ClubController {
	@Resource(name="clubService")
	private ClubService clubService;
	/*前台社团检索*/ 
	
	@RequestMapping(value="/frontClublist")
	public String frontClublist(HttpSession session,@RequestParam(value="clubId",required=false)Integer clubId,@RequestParam(value="clubName",required=false)String clubName,@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,Model model) {
		//获取满足条件的用户集合
		List<Club> clubList = clubService.findByCondition( clubId , clubName , pageNo , Constant.PAGESIZE );
		//获取满足条件的记录总数
		int totalSize = clubService.findCountByCondition(clubId, clubName);
		//获取总页数
		int totalPage = totalSize%Constant.PAGESIZE==0?totalSize/Constant.PAGESIZE:totalSize/Constant.PAGESIZE+1;
		model.addAttribute("clubList", clubList);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", Constant.PAGESIZE);
		return "f-clublist";
	}
	
	/*-------------------------------------------------------------------------------------*/
	/*后台社团管理*/
	@RequestMapping(value="/backClublist")
	public String backClublist(HttpSession session,@RequestParam(value="clubId",required=false)Integer clubId,@RequestParam(value="clubName",required=false)String clubName,@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,Model model) {
		session.setAttribute("message", "");
		//获取满足条件的用户集合
		List<Club> clubList = clubService.findByCondition( clubId , clubName , pageNo , Constant.PAGESIZE );
		//获取满足条件的记录总数
		int totalSize = clubService.findCountByCondition(clubId, clubName);
		//获取总页数
		int totalPage = totalSize%Constant.PAGESIZE==0?totalSize/Constant.PAGESIZE:totalSize/Constant.PAGESIZE+1;
		model.addAttribute("clubList", clubList);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("clubId", clubId);
		model.addAttribute("clubName",clubName);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", Constant.PAGESIZE);
		return "b-clublist";
	}
	/*添加社团*/
	@RequestMapping(value="/addClub")
	public String addClub(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		session.setAttribute("message", "");
		String address=null;
		String clubName=request.getParameter("clubName");
		String userId=request.getParameter("userId");
		String clubBrief=request.getParameter("clubBrief");
		if(!userId.isEmpty()&&!clubName.isEmpty()) {//判断用户ID和社团名是否为空
			User user=clubService.findUser(userId);
			if(user!=null) {//查询有无此用户，若有则添加成功
				Club club=new Club();
				club.setClubName(clubName);
				club.setClubBrief(clubBrief);
				club.setUserId(userId);
				int result=clubService.addClub(club);
				if(result>0) {
					address="redirect:/club/backClublist";
				} 
			}
			session.setAttribute("message", "该用户不存在");
			address="b-clubadd";
		}else {
			session.setAttribute("message", "社长号，社团名不能为空");
			address="b-clubadd";
		}
		
		return address;
	}
//	删除社团
	@RequestMapping(value="/removeClub")
	public String deleteClublist(@RequestParam("id")Integer id){
		int result=clubService.removeClubById(id);
		if(result>0) {
			return "redirect:/club/backClublist";
		}else {
			return "404";
		}
	}
//	修改社团
	@RequestMapping(value="/modifyClub")
	public String modifyClublist(@RequestParam("id")Integer clubId,Model model){
		Club club=clubService.findClubById(clubId);
		model.addAttribute("club", club);
		return "b-clubmodify";
	}
	@RequestMapping(value="/modifyClubSave")
	public String modifyClubSave(HttpSession session,HttpServletRequest request,Model model,Club club){
		String address=null;
		String clubName=request.getParameter("clubName");
		System.out.println("--------------------------------------"+clubName);
		if(clubName!="") {
			clubService.modifyClub(club);
			address="redirect:/club/backClublist";
		}else {
			session.setAttribute("message", "社团名不能为空");
			address="b-clubmodify";
		}
		return address;
	}
	
}
			
