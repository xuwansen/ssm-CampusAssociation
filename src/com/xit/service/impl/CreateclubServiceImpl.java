package com.xit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xit.dao.CreateclubDao;
import com.xit.pojo.Createclub;
import com.xit.service.CreateclubService;
@Service("createclubService")
public class CreateclubServiceImpl implements CreateclubService {
	@Resource(name="createclubDao")
	private CreateclubDao createclubDao;

	@Override
	public int Creatclub(Integer userId,String clubname, String clubbrief) {
		// TODO Auto-generated method stub
		return createclubDao.insertCreateclub(userId,clubname,clubbrief);
	}

	@Override
	public List<Createclub> Createclublist(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer page = (pageNo-1)*pageSize;
		return createclubDao.selectBypage(pageNo,pageSize);
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return createclubDao.selectCount();
	}

	@Override
	public int addclub(String clubname, String clubbrief, String userid) {
		// TODO Auto-generated method stub
		return createclubDao.insertClub(clubname,clubbrief,userid);
	}

	@Override
	public void removecreateclub(String userid) {
		// TODO Auto-generated method stub
		createclubDao.deletecreateclub(userid);
	}

	@Override
	public void modifyrole_id(String userid) {
		// TODO Auto-generated method stub
		createclubDao.updaterole_id(userid);
	}


	@Override
	public int findCreatclub(Integer userId) {
		// TODO Auto-generated method stub
		return createclubDao.selectCreateclub(userId);
	}

	@Override
	public int removeclubrequest(Integer createclubId) {
		return createclubDao.deletecreaterequest(createclubId);
	}


}
