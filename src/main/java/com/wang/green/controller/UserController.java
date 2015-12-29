package com.wang.green.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.green.domain.Result;
import com.wang.green.service.UserService;

/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */
@Controller
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
}
