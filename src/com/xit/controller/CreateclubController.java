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
	
	//ǰ̨��������
	@RequestMapping(value="/Createclub")
	public String Createclub(@RequestParam("userId")Integer userId,@RequestParam("clubname")String clubname,@RequestParam("clubbrief")String clubbrief,Model model){
		int result=0;
		if(userId==null) {//�ж��û��Ƿ��¼����δ��¼����ת����¼ҳ��
			return "f-login";
		}else {//�����ύ������������
			if(createclubService.findCreatclub(userId)>0) {
				model.addAttribute("message", "��������ʧ�ܣ����Ѿ����������ţ������ĵȴ����Ź���Ա����");
				return "f-creatclub";
			}else{
				if(!clubname.isEmpty()&&!clubbrief.isEmpty()) {
					result=createclubService.Creatclub(userId,clubname,clubbrief);//�½�������������
					model.addAttribute("message", "�ɹ��ύ�����������������ĵȴ����Ź���Ա����");
					return "f-creatclub";
				}else {//���򣬼���ͣ���ڴ�������ҳ��
					model.addAttribute("message", "��������ʧ�ܣ�������Ϸ��Ĵ�����������");
					return "f-creatclub";
				}
			}
			
		}
	}
	//-----------------------------------------------------------------------------------------------------------
	
	//��̨���������б���ʾ
	@RequestMapping(value="/createlist")
	public String cretelist(@RequestParam(value="pageNo",required=false,defaultValue="0")Integer pageNo,Model model) {
		List<Createclub> createclublist= createclubService.Createclublist(pageNo,Constant.PAGESIZE);//��ѯ���д�����������
		int totalSize = createclubService.findCount();//ͳ�ƴ�������������е��ܼ�¼��
		int totalPage = totalSize%Constant.PAGESIZE==0?totalSize/Constant.PAGESIZE:totalSize/Constant.PAGESIZE+1;//����ͳ�ƺ��¼�����ó���ҳ��
		model.addAttribute("createclublist", createclublist);
		model.addAttribute("totalSize", totalSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", Constant.PAGESIZE);
		return "b-createlist";
	}
	//��̨ͬ�ⴴ����������
	@RequestMapping(value="/agreecreate")
	public String agreecreate(@RequestParam("clubname")String clubname,@RequestParam("clubbrief")String clubbrief,@RequestParam("userid")String userid) {
			int result=createclubService.addclub(clubname,clubbrief,userid);
			if(result>0) {
				//ɾ����������������Ϣ���޸��û���ɫ
				createclubService.removecreateclub(userid);
				createclubService.modifyrole_id(userid);
				return "redirect:/club/backClublist";
			}else {
				return "redirect:/create/createlist";
			}
	}
	//��̨��ͬ�ⴴ����������
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
