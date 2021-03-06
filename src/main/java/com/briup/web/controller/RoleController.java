package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年3月27日 上午11:50:54 
* 类说明 :角色管理模块
*/
@Controller
public class RoleController {
	
	//service层
	@Autowired
	private IRoleService service;
	
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		//将数据库中所有角色信息查询出来,保存到session之中
		Page<Role> roles = service.findAllRoles();
		session.setAttribute("roles", roles);
//		System.out.println(roles.getTotalPages()+"-------");
		return "pages/role";
	}
	
	@RequestMapping("saveRole")
	@ResponseBody
	public String saveRole(Role role) {
		//将角色信息保存到session之中
		Integer id = role.getId();
		if(id==null) {
			service.saveRole(role);
			return "添加成功";
		}else {
			service.saveRole(role);
			return "修改成功";
		}
	}
	
	@RequestMapping("deleteRole")
	@ResponseBody
	public String deleteRole(Integer id) {
		service.deleteRole(id);
		return "删除成功";
	}
	
	//根据指定页码，查询数据
	@RequestMapping("pageRole")
	public String updatePageRole(Integer pageIndex,HttpSession session) {
		Page<Role> roles = service.findAllRoles(pageIndex);
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	
	//根据id，查询指定角色
	@RequestMapping("findRoleById")
	@ResponseBody
	public Role findRoleById(Integer id) {
		return service.findRoleById(id);
	}
	
}
