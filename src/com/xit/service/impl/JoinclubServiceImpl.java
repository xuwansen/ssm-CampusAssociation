package com.xit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xit.dao.JoinclubDao;
import com.xit.pojo.Joinclub;
import com.xit.service.JoinclubService;
@Service("joinclubService")
public class JoinclubServiceImpl implements JoinclubService {

	@Resource(name="joinclubDao")
	private JoinclubDao joinclubDao;
	@Override
	public int addJoin(Integer clubId, Integer userId) {
		// TODO Auto-generated method stub
		return joinclubDao.insertJoin(clubId,userId);
	}
	@Override
	public List<Joinclub> findJoinlist(Integer userId) {
		// TODO Auto-generated method stub
		return joinclubDao.selectJoinlist(userId);
	}
	@Override
	public int removeJoin(Integer clubId, Integer userId) {
		// TODO Auto-generated method stub
		return joinclubDao.deleteJoin(clubId,userId);
	}
	@Override
	public Joinclub findJoin(Integer clubId, Integer userId) {
		// TODO Auto-generated method stub
		return joinclubDao.selectjoin(clubId,userId);
	}
	
	@Override
	public List<Joinclub> findJoinClublist(Integer clubId, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer page = (pageNo-1)*pageSize;
		return joinclubDao.selectJoinClublist(clubId, page, pageSize);
	}
	@Override
	public int findCount(Integer clubId) {
		// TODO Auto-generated method stub
		return joinclubDao.selectCount(clubId);
	}
	@Override
	public int removeJoin2(Integer id) {
		// TODO Auto-generated method stub
		return joinclubDao.deleteJoin2(id);
	}
	
	
	
	
	

}
