package com.wang.green.service;

import com.wang.green.domain.Result;

public interface WholeSaleService {
	
	
	public Result getUsers();

	public Result getUserGoodsById(int id);
	
	public Result getGoodUsers();
	
	public Result getUserGoods();
	
	
}
