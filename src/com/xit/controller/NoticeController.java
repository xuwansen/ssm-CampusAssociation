package com.xit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.xit.pojo.Notice;
import com.xit.service.NoticeService;


@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	//	ǰ̨������Ϣ��ʾ
	@RequestMapping(value="/selectNotice")
	public String selectNotice(Model model,HttpSession session) {
		session.setAttribute("message","");
		//��ѯ�����ǰ���������������ҳ
		List<Notice> noticelist=noticeService.findNotice();
		for(Notice notice:noticelist) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String date=sdf.format(notice.getDate());
			notice.setFormatDate(date);
		}
		model.addAttribute("noticelist", noticelist);
		return "homepage-1";
	}
	/*-------------------------------------------------------------------------------------*/
//	��̨������Ϣ����
	@RequestMapping(value="/backNoticelist")
	public String findNoticeByCondition(@RequestParam(value="id",required=false)Integer id,@RequestParam(value="title",required=false)String title,@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,Model model) {
		List<Notice> noticelist=noticeService.findNoticeByCondition(id, title, pageNo, Constant.PAGESIZE);
		 int totalSize=noticeService.findNoticeCountByCondition(id, title);
		 int totalPage=totalSize%Constant.PAGESIZE==0?totalSize/Constant.PAGESIZE:totalSize/Constant.PAGESIZE+1;
		 model.addAttribute("noticelist",noticelist);
		 model.addAttribute("totalSize", totalSize);
		 model.addAttribute("totalPage", totalPage);
		 model.addAttribute("pageNo", pageNo);
		 model.addAttribute("pageSize", Constant.PAGESIZE);
		 model.addAttribute("id", id);
		 model.addAttribute("title", title);
		 for(Notice notice:noticelist) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date noticeDate=notice.getDate();
				if(noticeDate!=null) {
					String date=sdf.format(noticeDate);
					notice.setFormatDate(date);
				}
		}
		return "b-noticelist";
	}
	/*��ӹ���*/
	@RequestMapping(value="/addNotice")
	public String addClub(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		session.setAttribute("message", "");
		String address=null;
		Notice notice=new Notice();
		String title=request.getParameter("title");
		String article=request.getParameter("article");
		if(!title.isEmpty()) {//1
			if(!article.isEmpty()) {//2
				if(title.length()>0 && title.length()<=20) {//3,4
					if(article.length()>0 && article.length()<=50) {//5,6
						notice.setTitle(title);
						notice.setArticle(article);
						notice.setDate(new Date());
						noticeService.addNotice(notice);
						address="redirect:/notice/backNoticelist";
					}else {//7
						session.setAttribute("message", "���ݳ��Ȳ�����");
						address= "b-noticeadd";
					}
				}else {//8
					session.setAttribute("message", "���ⳤ�Ȳ�����");
					address= "b-noticeadd";
				}
			}else {//9
				session.setAttribute("message", "���ݲ���Ϊ��");
				address= "b-noticeadd";
			}
		}else{//10
			session.setAttribute("message", "���ⲻ��Ϊ��");
			address= "b-noticeadd";
		}  
		return address;
	}
	/*ɾ������*/
	@RequestMapping(value="removeNotice")
	public String deleteClublist(@RequestParam("id")Integer id){
		int result=noticeService.removeNoticeById(id);
		if(result>0) {
			return "redirect:/notice/backNoticelist";
		}else {
			return "404";
		}
	}
	/*�޸Ĺ���*/
	@RequestMapping(value="/modifyNotice")
	public String modifyNotice(@RequestParam("id")Integer id,Model model,HttpSession session){
		session.setAttribute("message", "");
		Notice notice=noticeService.findNoticeById(id);
		model.addAttribute("notice", notice);
		return "b-noticemodify";
	}
	@RequestMapping(value="/modifyNoticeSave")
	public String modifyNoticeSave(HttpServletRequest request,HttpSession session,Notice notice){
		String address=null;
		String title=request.getParameter("title");
		String article=request.getParameter("article");
		if(!title.isEmpty()) {//1
			if(!article.isEmpty()) {//2
				if(title.length()>0 && title.length()<=20) {//3,4
					if(article.length()>0 && article.length()<=50) {//5,6
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						notice.setDate(new Date());
						Date noticeDate=notice.getDate();
						if(noticeDate!=null) {
							String d=sdf.format(noticeDate);
							notice.setFormatDate(d);
						}
						noticeService.modifyNoticle(notice);
						address="redirect:/notice/backNoticelist";
					}else {//7
						session.setAttribute("message", "���ݳ��Ȳ�����");
						address= "b-noticemodify";
					}
				}else {//8
					session.setAttribute("message", "���ⳤ�Ȳ�����");
					address= "b-noticemodify";
				}
			}else {//9
				session.setAttribute("message", "���ݲ���Ϊ��");
				address= "b-noticemodify";
			}
		}else{//10
			session.setAttribute("message", "���ⲻ��Ϊ��");
			address= "b-noticemodify";
		}  
		return address;
	}
}
