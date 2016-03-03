package com.wang.green.dao;
import java.util.*;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.CartItem;


/**
 * CartItem
 */
public interface CartItemDao extends BaseDao<CartItem> {
	/**
	 * 根据主键查询(唯一)
	 */
	public CartItem getById(int id); 
	
	public int update(CartItem CartItem);
	
	public int delete(int id);
	
	public void insert(CartItem CartItem);
}