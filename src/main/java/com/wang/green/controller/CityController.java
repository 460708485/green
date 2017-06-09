package com.wang.green.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.green.domain.Result;
import com.wang.green.service.CityService;
@RestController
@RequestMapping("city")
public class CityController {
	
	@Resource
	private CityService cityService;
	
	@ResponseBody
	@RequestMapping("getById")
	public Result getById(int id){
		
		return cityService.getById(id);
	}
	
	@ResponseBody
	@RequestMapping("getByProvinceId")
	public Result getByAll(int province_id){
		
		return cityService.getByProvinceId(province_id);
	}
}
