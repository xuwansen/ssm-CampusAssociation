package com.xit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xit.pojo.Club;
import com.xit.pojo.User;

public interface ClubService {
	public List<Club> findByCondition(Integer clubId,String clubName,Integer pageNo,Integer pageSize);
	public int findCountByCondition(Integer clubId,String clubName);
	public int addClub(Club club);
	public int removeClubById(Integer clubId);
	public Club findClubById(Integer clubId);
	public int modifyClub(Club club);
	public User findUser(String userId);
	
}
