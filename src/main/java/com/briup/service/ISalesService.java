package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;

/**
 * @author 作者 ygz:
 * @version 创建时间：2020年4月1日 下午2:11:27 类说明
 */
public interface ISalesService {
	// 保存商机
//	void saveChance(Chance chance,Integer cretorId,Integer handerId);
	
	void saveChance(Chance chance);

	// 查询显示
//	Page<Chance> findChances(String customer, String address);
	Page<Chance> findChances(Integer pageIndex, String customer, String address);

	// 根据id查询
	Chance findById(Integer id);

	// 删除商机
	void deleteById(Integer id);
}
