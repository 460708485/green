package com.wang.green.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.green.dao.CityDao;
import com.wang.green.domain.Result;
import com.wang.green.service.CityService;
@Service
public class CityServiceImpl implements CityService{
	@Resource
	private CityDao cityDao;
	
	public Result getById(int city_id) {
		Result result=new Result();
		result.setStatus(1);
		result.setData(cityDao.getByCityId(city_id));
		return result;
	}

	public Result getByProvinceId(int province_id) {
		Result result=new Result();
		result.setStatus(1);
		result.setData(cityDao.getByProvinceId(province_id));
		return result;
	}
	
}
