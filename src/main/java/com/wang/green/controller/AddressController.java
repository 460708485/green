package com.wang.green.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wang.green.domain.Address;
import com.wang.green.domain.Result;
import com.wang.green.service.AddressService;

@Controller
@RequestMapping("address")
public class AddressController {
	@Resource
	private AddressService service;
	
	@ResponseBody
	@RequestMapping("findAll")
	public Result findAll(){
		return service.findAll();
	};
	
	@ResponseBody
	@RequestMapping("findByUserId")
	public Result findByUserId(int userId){
		return service.findByUserId(userId);
	}
	
	@ResponseBody
	@RequestMapping("add")
	public Result insert(@RequestBody String address){
		Gson gson=new Gson();
		Address a=gson.fromJson(address, Address.class);
		return service.insert(a);
	}
	
	@ResponseBody
	@RequestMapping(value="update")
	public Result update(@RequestBody String address){
		Gson gson=new Gson();
		Address a=gson.fromJson(address, Address.class);
		System.out.println("****"+address);
		return service.update(a);
	}
	
	
}
