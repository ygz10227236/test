package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CustomerContribution;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerContributionService;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月5日 上午11:28:07 
* 类说明 
*/
@Service
public class CustomerContributionImpl implements ICustomerContributionService {

	@Autowired
	CustomerDao dao;
	
	@Override
	public List<CustomerContribution> NameAnalyze() {
		
		List<CustomerContribution> list = new ArrayList<>();
		int nums = dao.findAll().size();
		String[] names = {"tom","briup","王晨","刘静","田丰"};
		
		for (String name : names) {
			float num = dao.findByName(name).size();
			float y = num/nums *100;
			CustomerContribution na = new CustomerContribution(name,y,name);
			list.add(na);
		}
		System.out.println(list);
		return list;
	}
}
