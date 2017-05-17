package com.wang.green.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
		
		return wholeSaleService.getUserGoodsById(id);
		
	}
	
	@ResponseBody
	@RequestMapping("getWholeSaleByWPId")
	public Result getWholeSaleByWPId(int wpinfo_id ){
		return wholeSaleService.getUserGoodsByWPId(wpinfo_id);
		
	}
	
	@ResponseBody
	@RequestMapping("getWholeSaleByName")
	public Result getWholeSaleByName(String name ){
		try {
			URLDecoder.decode(URLDecoder.decode(name, "UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("***"+name);
		return wholeSaleService.getUserGoodsByName(name);
	}
	
	@ResponseBody
	@RequestMapping("getWholeSaleByAddress")
	public Result getWholeSaleByAddress(String address){
		 try {
			URLDecoder.decode(URLDecoder.decode(address, "UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("***"+address);
		return wholeSaleService.getUserGoodsByAddress(address);
	}
	
	@ResponseBody
	@RequestMapping("getAllGoods")
	public Result getWholeSaleGoods(){
		
		return wholeSaleService.getUserGoods();
		
	}
	
	
	
}
