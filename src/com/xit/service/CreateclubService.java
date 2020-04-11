package com.xit.service;

import java.util.List;

import com.xit.pojo.Createclub;

public interface CreateclubService {
	public int Creatclub(Integer userId, String clubName, String clubBrief);
	public List<Createclub> Createclublist(Integer pageNo, Integer pageSize);
	public int findCount();
	public int addclub(String clubname, String clubbrief, String userid);
	public void removecreateclub(String userid);
	public void modifyrole_id(String userid);
	public int removeclubrequest(Integer createclubId);
	public int findCreatclub(Integer userId);
}

