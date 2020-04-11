package com.xit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xit.dao.RoleDao;
import com.xit.pojo.Role;
import com.xit.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public List<Role> findRoleList() {
		return roleDao.selectRoleList();
	}
}
