package com.briup.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.IUserService;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年3月26日 下午4:51:15 
* 类说明 和User用户祥光的Service逻辑
*/
@Service
public class UserServiceImpl implements IUserService{

	//dao层
	@Autowired
	private UserDao dao;
	
	@Override
	public User findByName(String name) {
		
		return dao.findByName(name);
	}	

	@Override
	public Page<User> findUserByRole(Integer roleId) {
		return findUserByRole(roleId, 0);
	}

	@Override
	public Page<User> findUserByRole(Integer roleId,Integer pageIndex) {
		Page<User> users = null;
		if(roleId == null) {
			//将所有用户查询出来
			users = dao.findAll(PageRequest.of(pageIndex, 3));
		}else {
			Role role = new Role();
			role.setId(roleId);
			users = dao.findByRole(role, PageRequest.of(pageIndex, 3));
		}
		return users;
	}

	@Override
	public void saveUser(User user) {
		dao.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		return dao.getOne(id);
		//orElse(xxx):获取类对象，同时如果对象不存在可以指定默认值
		//return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteUser(Integer id) {
		dao.deleteUserById(id);
	}

	@Override
	public List<User> findByJingli(Integer id) {
		return dao.findByRoleId(id);
	}

}











