package com.wang.green.dao;

import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.City;

public interface CityDao extends BaseDao<City>{
	
	public City getByCityId(int city_id);
	
	public List<City> getByProvinceId(int province_id);

}
