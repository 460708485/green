package com.wang.green.dao;

import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.District;

public interface DistrictDao extends BaseDao<District>{

		public District getById(int id);
		
		public List<District> getByCityId(int city_id);
	
}
