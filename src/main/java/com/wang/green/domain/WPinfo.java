package com.wang.green.domain;

import java.io.Serializable;
/**
 * 商品和种植户之间的联系表类
 * @author wangjq
 *
 */
public class WPinfo implements Serializable{

	private static final long serialVersionUID = 1000008L;
	private Integer id;
	private String wholesale_name;
	private Integer product_id;
	private String product_name;//产品名
	private String picture;//产品图片
	private int prodNum;//数量
	private double product_price;//商家定价
	private double promote_price;//促销价
	private int status;//状态 0为不促销，1为促销
	private int sale_volume;//销量
	private int left_time;//促销剩余时间
                                           
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWholesale_name() {
		return wholesale_name;
	}
	public void setWholesale_name(String wholesale_name) {
		this.wholesale_name = wholesale_name;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public int getProdNum() {
		return prodNum;
	}
	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}
	@Override
	public String toString() {
		return "WPinfo [wholesale_name=" + wholesale_name + ", product_id=" + product_id + ", product_price="
				+ product_price + ", promote_price=" + promote_price + ", status=" + status + ", sale_volume="
				+ sale_volume + ", left_time=" + left_time + "]";
	}
	
	
	
	
	
}
