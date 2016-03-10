package com.wang.green.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.ProvinceDao;
import com.wang.green.domain.Province;
@Repository
public class ProvinceDaoImpl extends BaseDaoImpl<Province> implements ProvinceDao{

	public List<Province> getAll() {
		
		return this.sqlMapClientTemplate.queryForList("province.findAll");
	}

	public Province getById(int id) {
		return (Province) this.sqlMapClientTemplate.queryForObject("province.findById", id);
	}
}
