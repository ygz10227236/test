package com.briup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Chance;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月1日 下午2:27:43 
* 类说明 
*/
public interface SalesDao extends JpaRepository<Chance,Integer>  {
	//查询商机
	Page<Chance> findByCustomerAndAddress(String customer,String address,Pageable page);
	
	//根据客户名查询商机
	Page<Chance> findByCustomer(String customer,Pageable page);
	
	//根据地质查询
	Page<Chance> findByAddress(String address,Pageable page);
}
