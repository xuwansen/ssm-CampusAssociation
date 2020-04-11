package com.xit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xit.pojo.User;

public interface UserDao {
	
	
	public User selectByAccountAndPassword(@Param("account")String account,@Param("password")String password);
	public User selectUserById(@Param("id")Integer id);
	//修改用户信息
	public int updateUserinfo(User user);
	public int updatePassword(@Param("id")Long id, @Param("password")String password);
	
	
	public List<User> selectByCondition(@Param("name")String name,@Param("role_id")Integer role_id,@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
	public int selectCountByCondition(@Param("name")String name,@Param("role_id")Integer role_id);
	public int deleteUser(@Param("id")Integer id);
	public int updateUser(User user);
	public User findclubId(@Param("userId")Long userId);
	public int insertUser(User user);
}
