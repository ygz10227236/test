package com.briup.service;
/** 
* @author 作者 ygz: 
* @version 创建时间：2020年3月27日 下午2:34:34 
* 类说明 
*/

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;

public interface IRoleService {
	//查询刚进去角色管理模块的所有角色
	Page<Role> findAllRoles();
	
	//查询指定页上的数据信息
	Page<Role> findAllRoles(Integer pageIndex);
	
	//新增
	void saveRole(Role role);
	
	//通过id找到对应的role
	Role findRoleById(Integer id);
	
	//删除
	void deleteRole(Integer id);
	
	//查询所有角色信息
	List<Role> allRoles();
}
