package com.xit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xit.pojo.Joinclub;



public interface JoinclubDao {
	public int insertJoin(@Param("clubId")Integer clubId,@Param("userId")Integer userId);
	public List<Joinclub> selectJoinlist(@Param("userId")Integer userId);
	public int deleteJoin(@Param("clubId")Integer clubId,@Param("userId") Integer userId);
	public Joinclub selectjoin(@Param("clubId")Integer clubId,@Param("userId") Integer userId);
	public List<Joinclub> selectJoinClublist(@Param("clubId")Integer clubId,@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
	public int selectCount(@Param("clubId")Integer clubId);
	public int deleteJoin2(@Param("id")Integer id);
}
