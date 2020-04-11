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
	//��������
	@RequestMapping(value="/joinClub")
	public String joinClub(@RequestParam("clubId")Integer clubId,@RequestParam("userId")Integer userId,HttpSession session,Model model){
		session.setAttribute("message", "");//����messageֵ
		if(userId!=null) {//�ж��û��Ƿ��¼�����û�δ��¼��ת����¼ҳ��
				List<Joinclub> joinclublist=joinclubService.findJoinlist(userId);//��ѯ�û���������ż���
				int i=0;
				for(Joinclub joinclub:joinclublist) {
					i++;
					System.out.println(joinclub.toString()+"      "+i);
					int clubID=joinclub.getClubId();
					if(i>=3) {
						session.setAttribute("message", "�����������������ţ�������������ѵ���3����");
						return "redirect:/club/frontClublist";
					}
					if(clubId==clubID) {
						session.setAttribute("message","���Ѿ���������˸����ţ������ĵȺ��糤֪ͨ");
						return "redirect:/club/frontClublist";
					}
				}
				int result1=joinclubService.addJoin(clubId,userId);//��userId,clubId�����"joinclub"��
				//����userId,clubId��ѯ�õ��Ľ�������joinclublist������joinclublist��ӵ�session����
				Joinclub joinclub=joinclubService.findJoin(clubId,userId);
				joinclublist.add(joinclub);
				session.setAttribute("joinclublist", joinclublist);
				if(result1>0) {
					session.setAttribute("message", "��������ɹ��������ĵȺ��糤֪ͨ");
					return "redirect:/club/frontClublist";
				}else {
					session.setAttribute("message", "���������������뿼����������");
					return "redirect:/club/frontClublist"; 
				}
			}
		return "f-login";
	}	
	//ȡ����������
	@RequestMapping(value="/exitClub")
	public String exitClub(@RequestParam("clubId")Integer clubId,@RequestParam("userId")Integer userId,HttpSession session) {
		Joinclub join=joinclubService.findJoin(clubId,userId);//����clubId,userId��ѯ"joinclub"��
		if(join!=null){
			int result=joinclubService.removeJoin(clubId,userId);//���û��������������,����ȡ���ĵ�clubId��userId��ֵ��ɾ����joinclub���еĶ�Ӧ��¼
			List<Joinclub> joinclublist=joinclubService.findJoinlist(userId);//��ȡ�û�������������ţ���ŵ�joinclublist
			Iterator<Joinclub> i = joinclublist.iterator();//������ȡjoinclublist��ֵ
			//�����������ɾ����Ӧ��
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
			session.setAttribute("message", "���ļ��������ѱ��糤�ܾ�");
			return "redirect:/club/frontClublist";
		}
		
	}
	
	
/*//	---------------------------------------------------------------------------*/
	
	//ǰ̨����������Ա��ʾ
		@RequestMapping(value="/frontJoinlist")
		public String frontJoinlist(@RequestParam("clubId")Integer clubId,@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,HttpSession session,Model model) {
			System.out.println(clubId+"++++++++++++++++++++++++++++++++++++++++++++++++++++");
			List<Joinclub> JoinClublist=joinclubService.findJoinClublist(clubId, pageNo, Constant.PAGESIZE);
			for(Joinclub joinclublist:JoinClublist) {
				System.out.println("��������"+joinclublist.toString());
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
	//ɾ����������������Ա
		@RequestMapping(value="/removeJoin")
		public String frontJoinlist(@RequestParam("joinclubid")Integer joinclubid,HttpServletRequest request) {
			System.out.println("�û�idΪ"+joinclubid);
			int result=joinclubService.removeJoin2(joinclubid);
			if(result>0) {
				return "redirect:/notice/selectNotice";
			}else {
				return null;
			}
			
		}
		
		
	

















}
