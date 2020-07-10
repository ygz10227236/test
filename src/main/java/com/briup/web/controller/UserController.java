package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.service.IRoleService;
import com.briup.service.IUserService;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年3月26日 下午4:32:31 
* 类说明 
*/
@Controller
public class UserController {

	//service层
	@Autowired
	private IUserService service;
	
	@Autowired
	private IRoleService roleService;
	
	//获取前台输入的用户名和密码，进行校验
	@RequestMapping("user/login")
	@ResponseBody
	public String login(String name,String password,HttpSession session) {
		//需要判断用户名和密码是否为空
		User user = service.findByName(name);
		if(user==null) {
			//调用service层，来判断用户和密码
			return "当前用户不存在";
		}
		//判断密码是否正确
		if(!user.getPassword().equals(password)) {
			return "密码错误";
		}
		//判断用户状态，1为正常，2位注销
		if(user.getFlag()!=1) {
			return "该用户已被注销";
		}
		//System.out.println(user);
		
		//将数据保存在session范围中，供前台使用
		session.setAttribute("user",user);
		
		return "success";
	} 
	
	
	//退出功能
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	
	@RequestMapping("toUser")
	public String toRole(HttpSession session,Integer roleId) {
		session.setAttribute("roleId", roleId);
		
		//将数据库中所有用户信息查询出来,保存到session之中
		Page<User> users = service.findUserByRole(roleId);
		session.setAttribute("users", users);
		//查询角色信息
		List<Role> allRoles = roleService.allRoles();
		session.setAttribute("allRoles", allRoles);
		
		return "pages/user";
	}
	
	@RequestMapping(value = "saveUser",method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(User user) {
		//将用户信息保存到session之中
		Integer id = user.getId();
		if(id==null) {
			service.saveUser(user);
			return "添加成功";
		}else {
			service.saveUser(user);
			return "修改成功";
		}
	}
	
	@RequestMapping(value = "user/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
		return "删除成功";
	}
	//根据指定页码，查询数据
	@RequestMapping("updateUserPage")
	public String updatePageUser(Integer pageIndex,HttpSession session) {
		Integer roleId = (Integer) session.getAttribute("roleId");
		
		Page<User> users = service.findUserByRole(roleId, pageIndex);
		System.out.println("User DEBUG:" + users.getContent());
		session.setAttribute("users", users);
		return "pages/user";
	}
		
	//根据id，查询指定用户
	@RequestMapping(value = "user/{id}",method = RequestMethod.GET)
	@ResponseBody
	public User findUserById(@PathVariable Integer id) {
		return service.findUserById(id);
	}
	
	//重置
	@RequestMapping("resetUser")
	@ResponseBody
	public String resetUser(HttpSession session) {
		session.removeAttribute("roleId");
		return "重置成功";
	}
	
}









