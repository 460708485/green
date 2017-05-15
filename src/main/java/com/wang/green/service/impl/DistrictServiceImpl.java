package com.wang.green.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.green.dao.DistrictDao;
import com.wang.green.domain.Result;
import com.wang.green.service.DistrictService;
@Service
public class DistrictServiceImpl implements DistrictService{
	@Resource
	private DistrictDao districtDao;

	public Result getById(int id) {
		Result result=new Result();
		result.setStatus(1);
		result.setData(districtDao.getById(id));
		return result;
	}

	public Result getByCityId(int city_id) {
		Result result=new Result();
		result.setStatus(1);
		result.setData(districtDao.getByCityId(city_id));
		return result;
	}

	
}
