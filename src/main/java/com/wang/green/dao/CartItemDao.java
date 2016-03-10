package com.wang.green.dao;
import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.CartItem;
import com.wang.green.domain.WPinfo;


/**
 * CartItem
 */
public interface CartItemDao extends BaseDao<CartItem> {
	/**
	 * 根据用户id查询(唯一)
	 */
	public List<WPinfo> getById(int id); 
	
	public int update(CartItem CartItem);
	
	public int delete(int id);
	
	public void insert(CartItem CartItem);
}