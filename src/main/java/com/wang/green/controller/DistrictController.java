package com.wang.green.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.green.domain.Result;
import com.wang.green.service.DistrictService;
@RestController
@RequestMapping("district")
public class DistrictController {

	
	@Resource
	private DistrictService districtService;
	
	@ResponseBody
	@RequestMapping("getById")
	public Result getById(int id){
		
		return districtService.getById(id);
	}
	
	@ResponseBody
	@RequestMapping("getByCityId")
	public Result getByAll(int city_id){
		
		return districtService.getByCityId(city_id);
	}
	
}
