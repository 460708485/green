package com.wang.green.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.green.domain.Result;
import com.wang.green.service.WholeSaleService;

@Controller
@RequestMapping("WholeSale")
public class WholeSaleController {
	
@SuppressWarnings("unused")
private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private WholeSaleService wholeSaleService;
	
	@ResponseBody
	@RequestMapping("getWholeSales")
	public Result getWholeSales(){
		
		return wholeSaleService.getUsers();
		
	}
	
	@ResponseBody
	@RequestMapping("getGoodWholeSales")
	public Result getGoodWholeSales(){
		
		return wholeSaleService.getGoodUsers();
	}
	
	
	@ResponseBody
	@RequestMapping("getWholeSaleById")
	public Result getWholeSaleById(int id ){
		
		return wholeSaleService.getUserById(id);
		
	}
	
	
}
