package com.briup.service;
/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月3日 上午10:43:52 
* 类说明 
*/

import java.util.List;

import com.briup.bean.CustomerConstitute;

public interface ICustomerConstituteService {
	//地区分类
	List<CustomerConstitute> regionAnalyze();
	
	//等级分类
	List<CustomerConstitute> levelAnalyze();
}
