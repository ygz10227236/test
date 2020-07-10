package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.User;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年3月26日 下午4:47:57 
* 类说明 
*/
public interface IUserService {

	public User findByName(String name);
	
	//查询所有用户
	Page<User> findUserByRole(Integer roleId);
	
	//查询指定页上的数据信息
	Page<User> findUserByRole(Integer roleId,Integer pageIndex);
	
	//新增
	void saveUser(User user);
		
	//通过id找到对应的user
	User findUserById(Integer id);
		
	//删除
	void deleteUser(Integer id);
	
	//查询经理
	List<User> findByJingli(Integer id);
}
