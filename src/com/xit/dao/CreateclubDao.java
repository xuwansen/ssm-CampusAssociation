package com.xit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xit.pojo.Createclub;

public interface CreateclubDao {
	public int insertCreateclub(@Param("userid")Integer userId, @Param("clubName")String clubName,@Param("clubBrief") String clubBrief);
	public List<Createclub> selectBypage(@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
	public int selectCount();
	public int insertClub(@Param("clubname")String clubname,@Param("clubbrief") String clubbrief,@Param("userid") String userid);
	public void deletecreateclub(@Param("userid")String userid);
	public void updaterole_id(@Param("userid")String userid);
	public int deletecreaterequest(@Param("createclubId")Integer createclubId);
	public int selectCreateclub(@Param("userid")Integer userId);

}
