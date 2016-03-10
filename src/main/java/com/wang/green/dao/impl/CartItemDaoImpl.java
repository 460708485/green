package com.wang.green.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.CartItemDao;
import com.wang.green.domain.CartItem;
import com.wang.green.domain.WPinfo;
@Repository
public class CartItemDaoImpl extends BaseDaoImpl<CartItem> implements CartItemDao{

	public List<WPinfo> getById(int id) {
		return  this.sqlMapClientTemplate.queryForList("Cartitem.getById", id);
	}

	public int delete(int id) {
		return this.sqlMapClientTemplate.delete("Cartitem.deleteCart", id);
	}
	public int update(CartItem cartItem){
		return   this.sqlMapClientTemplate.update("Cartitem.updateCart", cartItem);
	};
	
	public void insert(CartItem cartItem){
		 this.sqlMapClientTemplate.insert("Cartitem.addCart", cartItem);
	};
	

}
