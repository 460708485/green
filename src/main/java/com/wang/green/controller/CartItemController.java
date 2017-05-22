package com.wang.green.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wang.green.domain.CartItem;
import com.wang.green.domain.Result;
import com.wang.green.service.CartItemService;

@RestController
@RequestMapping("cart")
public class CartItemController {
	@Resource
	private CartItemService cartItemService;
	@ResponseBody
	@RequestMapping("getById")
	public Result getById(Integer user_id){
		Result result=cartItemService.getById(user_id);
		return result;
	}; 
	
	@ResponseBody
	@RequestMapping("update/{id}")
	public Result update(@RequestBody CartItem cartItem,@PathVariable int id){
		cartItem.setId(id);
		Result result=cartItemService.update(cartItem);
		return result;
	};
	
	@ResponseBody
	@RequestMapping("delete")
	public Result delete(int id){
		Result result=cartItemService.delete(id);
		return result;
	};
	
	@ResponseBody
	@RequestMapping("insert")
	public Result insert(@RequestBody String json){
		Gson gson=new Gson();
		CartItem cartItem=gson.fromJson(json, CartItem.class);
		Result result=cartItemService.insert(cartItem);
		return result;
	};

}
