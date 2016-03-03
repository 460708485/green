package com.wang.green.service;

import com.wang.green.domain.CartItem;
import com.wang.green.domain.Result;

public interface CartItemService {
	
	public Result getById(int id); 
	
	public Result update(CartItem CartItem);
	
	public Result delete(int id);
	
	public Result insert(CartItem CartItem);

}
