package com.wang.green.service;

import com.wang.green.domain.Result;

public interface ProductService {
	
	public Result getProductByClassId(Integer class_id);

	public Result getProductById(int id);
	
	public Result getWProductByClassId(int class_id);
	
	
}
