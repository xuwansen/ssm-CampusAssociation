package com.xit.service;

import java.util.List;

import com.xit.pojo.User;

public interface UserService {
	public User login(String a,String password);
	public User findUserById(Integer id);
	public int modifyUser(User user);//修改用户信息
	public int modifyPassword(Long id, String password);
	
	
	
	public List<User> findByCondition(String name,Integer role_id,Integer pageNo,Integer pageSize);
	public int findCountByCondition(String name,Integer role_id);
	public int removeClubById(Integer id);
	public int backmodifyUser(User user);
	public User findclubId(Long userId);
	public int addUser(User user);
}
