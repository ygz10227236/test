package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CustomerConstitute;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerConstituteService;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月3日 上午10:44:02 
* 类说明
*/
@Service
public class CustomerConstituteImpl implements ICustomerConstituteService {

	@Autowired
	CustomerDao dao;
	
	@Override
	public List<CustomerConstitute> regionAnalyze() {
		List<CustomerConstitute> list = new ArrayList<>();
		
		//从数据库将所有客户信息查找出来   需要获取总数
		int nums = dao.findAll().size();
		String[] regions = {"华中","华南","华东","华北"};
		
		//然后根据地区进行筛选，然后封装成list自定义对象
		for (String region : regions) {
			//根据地区，查出数据库中对应的条目数
			float num = dao.findByRegion(region).size();
			//获取百分比
			float y = num/nums *100;
			CustomerConstitute cc = new CustomerConstitute(region,y,region);
			list.add(cc);
			
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<CustomerConstitute> levelAnalyze() {
		
		List<CustomerConstitute> list = new ArrayList<>();
		int nums = dao.findAll().size();
		String[] levels = {"普通客户","大客户","重点开发客户","合作伙伴","战略合作伙伴"};
		
		for (String level : levels) {
			float num = dao.findByLevel(level).size();
			float y = num/nums *100;
			CustomerConstitute lv = new CustomerConstitute(level,y,level);
			list.add(lv);
		}
		System.out.println(list);
		return list;
	}
	
}
