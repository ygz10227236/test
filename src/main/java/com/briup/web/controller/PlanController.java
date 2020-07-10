package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月5日 上午10:40:58 
* 类说明 
*/
@Controller
public class PlanController {
	
	@RequestMapping("toPlan")
	public String toPlan() {
		return "pages/plan";
	}
	
	@RequestMapping("toplanadd")
	public String toPlanAdd() {
		return "pages/plan_add";
	}

	@RequestMapping("toplanedit")
	public String toPlanEdit() {
		return "pages/plan_edit";
	}
	
	@RequestMapping("toplandetail")
	public String toPlanDetail() {
		return "pages/plan_detail";
	}
	
}
