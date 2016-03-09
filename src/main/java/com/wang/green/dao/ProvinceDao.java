package com.wang.green.dao;

import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.Province;

public interface ProvinceDao extends BaseDao<Province>{
	
	public List<Province> getAll();
	
	public Province getById(int id);
	
}
