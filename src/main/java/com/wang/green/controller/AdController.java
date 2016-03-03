package com.wang.green.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.green.domain.Result;
import com.wang.green.service.AdService;

@Controller
@RequestMapping("ad")
public class AdController {
	@Resource
	private AdService adService;
	
	@ResponseBody
	@RequestMapping("findNewAd")
	public Result getAd(int status){
		
		return adService.getAd(status);
		
		
	}
	
}
