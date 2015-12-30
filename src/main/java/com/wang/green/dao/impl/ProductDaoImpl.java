package com.wang.green.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.ProductDao;
import com.wang.green.domain.Product;
import com.wang.green.domain.WPinfo;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	@SuppressWarnings("unchecked")
	public List<Product> getProductByClassId(int class_id) {
	
		return this.sqlMapClientTemplate.queryForList("getProductByClassId", Integer.valueOf(class_id));
	}

	public Product getProductByProductId(int id) {
		
		return (Product)this.sqlMapClientTemplate.queryForObject("getProductByProductId", Integer.valueOf(id));
	}

	@SuppressWarnings("unchecked")
	public List<WPinfo> getWProductByClassId(int class_id) {
		return this.sqlMapClientTemplate.queryForList("getWProductByClassId", class_id);
	}
}
