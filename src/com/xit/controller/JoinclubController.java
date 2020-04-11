package com.xit.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xit.common.Constant;
import com.xit.pojo.Joinclub;
import com.xit.service.JoinclubService;
@Controller
@RequestMapping(value="/join")
public class JoinclubController {
	@Resource(name="joinclubService")
	private JoinclubService joinclubService;
	//加入社团
	@RequestMapping(value="/joinClub")
	public String joinClub(@RequestParam("clubId")Integer clubId,@RequestParam("userId")Integer userId,HttpSession session,Model model){
		session.setAttribute("message", "");//重置message值
		if(userId!=null) {//判断用户是否登录，若用户未登录跳转至登录页面
				List<Joinclub> joinclublist=joinclubService.findJoinlist(userId);//查询用户加入的社团集合
				int i=0;
				for(Joinclub joinclub:joinclublist) {
					i++;
					System.out.println(joinclub.toString()+"      "+i);
					int clubID=joinclub.getClubId();
					if(i>=3) {
						session.setAttribute("message", "不可申请加入过多社团，您申请的社团已到达3个！");
						return "redirect:/club/frontClublist";
					}
					if(clubId==clubID) {
						session.setAttribute("message","您已经申请加入了该社团，请耐心等候社长通知");
						return "redirect:/club/frontClublist";
					}
				}
				int result1=joinclubService.addJoin(clubId,userId);//将userId,clubId添加至"joinclub"表
				//根据userId,clubId查询得到的结果添加至joinclublist，并将joinclublist添加到session域中
				Joinclub joinclub=joinclubService.findJoin(clubId,userId);
				joinclublist.add(joinclub);
				session.setAttribute("joinclublist", joinclublist);
				if(result1>0) {
					session.setAttribute("message", "加入申请成功，请耐心等候社长通知");
					return "redirect:/club/frontClublist";
				}else {
					session.setAttribute("message", "社团人数已满，请考虑其他社团");
					return "redirect:/club/frontClublist"; 
				}
			}
		return "f-login";
	}	
	//取消加入社团
	@RequestMapping(value="/exitClub")
	public String exitClub(@RequestParam("clubId")Integer clubId,@RequestParam("userId")Integer userId,HttpSession session) {
		Joinclub join=joinclubService.findJoin(clubId,userId);//根据clubId,userId查询"joinclub"表
		if(join!=null){
			int result=joinclubService.removeJoin(clubId,userId);//当用户点击撤销申请是,将获取来的的clubId，userId的值，删除“joinclub”中的对应记录
			List<Joinclub> joinclublist=joinclubService.findJoinlist(userId);//获取用户加入的所有社团，存放到joinclublist
			Iterator<Joinclub> i = joinclublist.iterator();//迭代获取joinclublist的值
			//逐个遍历，将删除对应的
			Joinclub joinclub=joinclubService.findJoin(clubId,userId);
			while(i.hasNext()) {
				if(joinclub==i.next()) {
					i.remove();
				}
			}
			session.setAttribute("joinclublist", joinclublist);
			session.setAttribute("message", "");
			if(result>0) {
				return "redirect:/club/frontClublist";
			}else {
				return "404";
			}
		}else {
			session.setAttribute("message", "您的加入请求已被社长拒绝");
			return "redirect:/club/frontClublist";
		}
		
	}
	
	
/*//	---------------------------------------------------------------------------*/
	
	//前台加入社团人员显示
		@RequestMapping(value="/frontJoinlist")
		public String frontJoinlist(@RequestParam("clubId")Integer clubId,@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,HttpSession session,Model model) {
			System.out.println(clubId+"++++++++++++++++++++++++++++++++++++++++++++++++++++");
			List<Joinclub> JoinClublist=joinclubService.findJoinClublist(clubId, pageNo, Constant.PAGESIZE);
			for(Joinclub joinclublist:JoinClublist) {
				System.out.println("加入社团"+joinclublist.toString());
			}
			int totalSize = joinclubService.findCount(clubId);
			int totalPage = totalSize%Constant.PAGESIZE==0?totalSize/Constant.PAGESIZE:totalSize/Constant.PAGESIZE+1;
			session.setAttribute("JoinClublist", JoinClublist);
			session.setAttribute("totalSize", totalSize);
			session.setAttribute("totalPage", totalPage);
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("pageSize", Constant.PAGESIZE);
			return "f-joinlist";
		}
	//删除加入社团申请人员
		@RequestMapping(value="/removeJoin")
		public String frontJoinlist(@RequestParam("joinclubid")Integer joinclubid,HttpServletRequest request) {
			System.out.println("用户id为"+joinclubid);
			int result=joinclubService.removeJoin2(joinclubid);
			if(result>0) {
				return "redirect:/notice/selectNotice";
			}else {
				return null;
			}
			
		}
		
		
	

















}
