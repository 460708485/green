package com.wang.green.service;

import com.wang.green.domain.Result;

public interface DistrictService {

	public Result getById(int id);
	
	
	public Result getByCityId(int city_id); 
	
}
