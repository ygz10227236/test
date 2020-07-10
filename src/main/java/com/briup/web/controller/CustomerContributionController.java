package com.briup.web.controller;
/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月5日 上午11:07:58 
* 类说明 
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.CustomerContribution;
import com.briup.service.ICustomerContributionService;

@Controller
public class CustomerContributionController {

	@Autowired
	private ICustomerContributionService service;
	
	@RequestMapping("tocustomerContribution")
	public String tocustomerContribution() {
		return "pages/customerContribution";
	}

	@RequestMapping("Analyze")
	@ResponseBody
	public List<CustomerContribution> toAnalyze() {
		return service.NameAnalyze();
	}
}
