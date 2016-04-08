package com.wang.green.service;

import com.wang.green.domain.Result;

public interface WholeSaleService {
	
	public Result getUsers();

	public Result getUserGoodsById(int id);
	
	public Result getUserGoodsByName(String name);
	
	public Result getGoodUsers();
	
	public Result getUserGoods();
	
	public Result  getUserGoodsByAddress(String address);
	public Result  getUserGoodsByWPId(int wpinfo_id);
}
