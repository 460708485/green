package com.wang.green.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.green.dao.AdDao;
import com.wang.green.domain.Result;
import com.wang.green.service.AdService;

@Service
public class AdServiceImpl implements AdService{
	
	@Resource
	private AdDao adDao;
	
	public Result getAd(int status) {
		Result result=new Result();
		result.setData(adDao.findNew(status));
		return result;
	}

	
}
