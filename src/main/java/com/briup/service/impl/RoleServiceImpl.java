package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.dao.RoleDao;
import com.briup.service.IRoleService;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年3月27日 下午2:46:14 
* 类说明 
*/
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleDao dao;
	
	@Override
	public Page<Role> findAllRoles() {
		return findAllRoles(0);
	}

	@Override
	public Page<Role> findAllRoles(Integer pageIndex) {
		//指定查看第几页数据，并且指定一页显示多少条数据
		Page<Role> page = dao.findAll(PageRequest.of(pageIndex, 2));
		return page;
	}

	@Override
	public void saveRole(Role role) {
		dao.save(role);
	}

	@Override
	public Role findRoleById(Integer id) {
		return dao.getOne(id);
	}

	@Override
	public void deleteRole(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Role> allRoles() {
		return dao.findAll();
	}
	
}
