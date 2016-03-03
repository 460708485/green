package com.wang.green.dao.impl;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.CartItemDao;
import com.wang.green.domain.CartItem;
@Repository
public class CartItemDaoImpl extends BaseDaoImpl<CartItem> implements CartItemDao{

	public CartItem getById(int id) {
		return (CartItem) this.sqlMapClientTemplate.queryForObject("getById", id);
	}

	public int delete(int id) {
		return this.sqlMapClientTemplate.delete("deleteCart", id);
	}
	public int update(CartItem cartItem){
		return   this.sqlMapClientTemplate.update("updateCart", cartItem);
	};
	
	public void insert(CartItem cartItem){
		 this.sqlMapClientTemplate.insert("addCart", cartItem);
	};
	

}
