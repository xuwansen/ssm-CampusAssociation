package com.xit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xit.pojo.Joinclub;

public interface JoinclubService {
	public int addJoin(Integer clubId, Integer userId);
	public List<Joinclub> findJoinlist(Integer userId);
	public int removeJoin(Integer clubId, Integer userId);
	public Joinclub findJoin(Integer clubId, Integer userId);
	public List<Joinclub> findJoinClublist(Integer clubId,Integer pageNo,Integer pageSize);
	public int findCount(Integer clubId);
	public int removeJoin2(Integer id);
}
