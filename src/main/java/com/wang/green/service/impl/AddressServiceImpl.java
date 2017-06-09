package com.wang.green.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.green.dao.AddressDao;
import com.wang.green.domain.Address;
import com.wang.green.domain.Result;
import com.wang.green.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Resource
	private AddressDao addressDao;
	
	public Result findAll() {
		Result result=new Result();
		List<Address> lists=addressDao.findAll();
		result.setData(lists);
		result.setStatus(1);
		return result;
	}

	public Result insert(Address a) {
		Result result =new Result();
		addressDao.insert(a);
		result.setStatus(1);
		return result;
	}

	public Result update(Address a) {
		Result result=new Result();
		int num=addressDao.update(a);
		if(0!=num){
			result.setStatus(1);
			result.setMsg("success");
			return result;
		}
		result.setStatus(0);
		result.setMsg("fail");
		return result;
	}

	public Result findByUserId(int userId) {
		Result result=new Result();
		List<Address> lists=addressDao.findByUserId(userId);
		result.setData(lists);
		result.setStatus(1);
		return result;
	}
	

}
