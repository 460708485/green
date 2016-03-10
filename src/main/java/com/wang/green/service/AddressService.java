package com.wang.green.service;

import com.wang.green.domain.Address;
import com.wang.green.domain.Result;

public interface AddressService {

	public Result findAll();
	
	public Result insert(Address a);
	
	public Result update(Address a);
	
	public Result findByUserId(int userId);
}
