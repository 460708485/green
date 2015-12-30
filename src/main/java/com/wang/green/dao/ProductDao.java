package com.wang.green.dao;

import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.Product;
import com.wang.green.domain.WPinfo;

public interface ProductDao extends BaseDao<Product>{
	 /**
	  * 通过class_id获取产品信息
	  * @param class_id
	  * @return
	  */
	public List<Product> getProductByClassId(int class_id);
	/**
	 *通过产品id获取产品信息 
	 * @param id
	 * @return
	 */
	public Product getProductByProductId(int id);
	/**
	 * 
	 * @param class_id
	 * @return
	 */
	public List<WPinfo> getWProductByClassId(int class_id);
}
