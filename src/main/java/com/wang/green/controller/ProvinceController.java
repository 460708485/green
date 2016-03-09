package com.wang.green.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.green.domain.Result;
import com.wang.green.service.ProvinceService;

@Controller
@RequestMapping("province")
public class ProvinceController {
	
	@Resource
	private ProvinceService provinceService;
	
	@ResponseBody
	@RequestMapping("getById")
	public Result getById(int id){
		
		return provinceService.getById(id);
	}
	
	@ResponseBody
	@RequestMapping("getAll")
	public Result getByAll(){
		
		return provinceService.getAll();
	}
	
}
