package com.xit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xit.dao.ClubDao;
import com.xit.pojo.Club;
import com.xit.pojo.User;
import com.xit.service.ClubService;
@Service(value="clubService")
public class ClubServiceImpl implements ClubService {
	@Resource(name="clubDao")
	private ClubDao clubDao;
	@Override
	public List<Club> findByCondition(Integer clubId, String clubName, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer page = (pageNo-1)*pageSize;
		return clubDao.selectByCondition(clubId, clubName, page, pageSize);
	}

	@Override
	public int findCountByCondition(Integer clubId, String clubName) {
		// TODO Auto-generated method stub
		return clubDao.selectCountByCondition(clubId, clubName);
	}

	@Override
	public int addClub(Club club) {
		// TODO Auto-generated method stub
		return clubDao.insertClub(club);
	}

	@Override
	public int removeClubById(Integer clubId) {
		// TODO Auto-generated method stub
		return clubDao.deleteClubById(clubId);
	}

	@Override
	public int modifyClub(Club club) {
		// TODO Auto-generated method stub
		return clubDao.updateClub(club);
	}

	@Override
	public Club findClubById(Integer clubId) {
		// TODO Auto-generated method stub
		return clubDao.selectClubById(clubId);
	}

	@Override
	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return clubDao.findUser(userId);
	}


	
	


}
