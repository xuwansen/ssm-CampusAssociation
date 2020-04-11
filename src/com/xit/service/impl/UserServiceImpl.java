package com.xit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xit.dao.UserDao;
import com.xit.pojo.User;
import com.xit.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	@Override
	public User login(String account, String password) {
		// TODO Auto-generated method stub
		return userDao.selectByAccountAndPassword(account, password);
	}
	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(id);
	}
	@Override
	public int modifyUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserinfo(user);
	}
	@Override
	public int modifyPassword(Long id, String password) {
		// TODO Auto-generated method stub
		return userDao.updatePassword(id,password);
	}
	@Override
	public List<User> findByCondition(String name, Integer role_id, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer page = (pageNo-1)*pageSize;
		return userDao.selectByCondition(name, role_id, page, pageSize);
	}
	@Override
	public int findCountByCondition(String name, Integer role_id) {
		// TODO Auto-generated method stub
		return userDao.selectCountByCondition(name, role_id);
	}
	@Override
	public int removeClubById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}
	@Override
	public int backmodifyUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	@Override
	public User findclubId(Long userId) {
		// TODO Auto-generated method stub
		return userDao.findclubId(userId);
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}
	

}
