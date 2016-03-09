package com.wang.green.service;

import com.wang.green.domain.Result;

public interface CityService {

	public Result getById(int city_id);
	
	public Result getByProvinceId(int province_id);
	
}
