package com.wang.green.domain;

import java.io.Serializable;

/**
 * cartitem
 */
public class CartItem implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	

	private int product_id;
	/**
	 * wpinfo_id
	 */
	private int wpinfo_id;
	/**
	 * prodNum
	 */
	private int prodNum;

	private double price;
	
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getWpinfo_id() {
		return wpinfo_id;
	}

	public void setWpinfo_id(int wpinfo_id) {
		this.wpinfo_id = wpinfo_id;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	


}
