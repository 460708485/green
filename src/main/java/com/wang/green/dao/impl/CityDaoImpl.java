package com.wang.green.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.CityDao;
import com.wang.green.domain.City;

@Repository
public class CityDaoImpl extends BaseDaoImpl<City> implements CityDao{

	public City getByCityId(int city_id) {
		return (City) this.sqlMapClientTemplate.queryForObject("city.findById", city_id);
	}

	public List<City> getByProvinceId(int province_id) {
		return this.sqlMapClientTemplate.queryForList("city.findByProvinceId", province_id);
	}
	

}
