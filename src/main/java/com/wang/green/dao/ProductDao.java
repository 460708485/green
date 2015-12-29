package com.wang.green.dao;

import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.Product;

public interface ProductDao extends BaseDao<Product>{
	 
	public List<Product> getProductByClassId(int class_id);
	
}
