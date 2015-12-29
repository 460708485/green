package com.wang.green.domain;

import java.io.Serializable;
/**
 * 商品信息类
 * @author wangjq
 *
 */
public class Product implements Serializable{

	private static final long serialVersionUID = 1000007L;
	
	private Integer product_id;
	private Integer class_id;
	private String product_name;
	private double marketprice;
	private String picture;
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", class_id=" + class_id + ", product_name=" + product_name
				+ ", marketprice=" + marketprice + ", picture=" + picture + "]";
	}
	
	

}
