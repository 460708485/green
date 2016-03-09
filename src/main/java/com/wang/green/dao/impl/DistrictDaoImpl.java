package com.wang.green.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.DistrictDao;
import com.wang.green.domain.District;

@Repository
public class DistrictDaoImpl extends BaseDaoImpl<District> implements DistrictDao {

	public District getById(int id) {
		return (District) this.sqlMapClientTemplate.queryForObject("district.findById", id);
	}

	public List<District> getByCityId(int city_id) {
		return this.sqlMapClientTemplate.queryForList("district.findByCityId", city_id);
	}
	

}
