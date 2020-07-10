package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.dao.SalesDao;
import com.briup.service.ISalesService;

/** 
* @author 作者 ygz: 
* @version 创建时间：2020年4月1日 下午2:28:36 
* 类说明 
*/
@Service
public class SalesServiceImpl implements ISalesService {
	@Autowired
	private SalesDao dao;

//	@Override
//	public void saveChance(Chance chance, Integer cretorId, Integer handerId) {
//		// TODO Auto-generated method stub
//	}
	@Override
	public void saveChance(Chance chance) {
		chance.setStatus("保存");
		dao.save(chance);
	}
	@Override
	public Page<Chance> findChances(Integer pageIndex, String customer, String address) {
		customer = "".equals(customer)?null:customer;
		if (customer!=null && address!=null) {
			return dao.findByCustomerAndAddress(customer, address, PageRequest.of(pageIndex, 2));
		}else if (customer!=null && address==null) {
			return dao.findByCustomer(customer, PageRequest.of(pageIndex, 2));
		}else if (customer==null && address!=null) {
			return dao.findByAddress(address, PageRequest.of(pageIndex, 2));
		}else {
			return dao.findAll(PageRequest.of(pageIndex, 2));
		}
	}

	@Override
	public Chance findById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}
