package com.xit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xit.pojo.Club;
import com.xit.pojo.User;

public interface ClubDao {
	public List<Club> selectByCondition(@Param("clubId")Integer clubId,@Param("clubName")String clubName,@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
	public int selectCountByCondition(@Param("clubId")Integer clubId,@Param("clubName")String clubName);
	public int insertClub(Club club);
	public int deleteClubById(@Param("clubId")Integer clubId);
	public Club selectClubById(@Param("clubId")Integer clubId);
	public int updateClub(Club club);
	public User findUser(@Param("userId")String userId);//≤È—Ø”√ªß
	
}
