package com.wang.green.domain;

import java.io.Serializable;
/**
 * 商品和种植户之间的联系表类
 * @author wangjq
 *
 */
public class WPinfo implements Serializable{

	private static final long serialVersionUID = 1000008L;
	private Integer wholesale_id;
	private Integer product_id;
	private double product_price;//商家定价
	private double promote_price;//促销价
	private int sale_volume;//销量
	private int left_time;//促销剩余时间
	public Integer getWholesale_id() {
		return wholesale_id;
	}
	public void setWholesale_id(Integer wholesale_id) {
		this.wholesale_id = wholesale_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public double getPromote_price() {
		return promote_price;
	}
	public void setPromote_price(double promote_price) {
		this.promote_price = promote_price;
	}
	public int getSale_volume() {
		return sale_volume;
	}
	public void setSale_volume(int sale_volume) {
		this.sale_volume = sale_volume;
	}
	
	public int getLeft_time() {
		return left_time;
	}
	public void setLeft_time(int left_time) {
		this.left_time = left_time;
	}
	@Override
	public String toString() {
		return "WPinfo [wholesale_id=" + wholesale_id + ", product_id=" + product_id + ", product_price="
				+ product_price + ", promote_price=" + promote_price + ", sale_volume=" + sale_volume + ", left_time=" + left_time + "]";
	}
	
	
	
	
	
	
}
