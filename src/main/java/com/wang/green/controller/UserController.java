package com.wang.green.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wang.green.domain.Result;
import com.wang.green.domain.User;
import com.wang.green.service.UserService;

/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */
@RestController
public class UserController {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/getUserByID")
	public Result getUserByID(int id){
		Result result=userService.getUserByID(id);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/check")
	public Result check(String username,String password){
		return userService.checkUserByName(username, password);
	}
	@ResponseBody
	@RequestMapping("/register")
	public Result register(@RequestBody String json){
		Gson gson=new Gson();
		User user=gson.fromJson(json, User.class);
		return userService.addUser(user);
		
	}
}
