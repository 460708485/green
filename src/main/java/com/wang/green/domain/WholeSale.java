package com.wang.green.domain;

import java.io.Serializable;
/**
 * 种植户
 * @author wangjq
 */
public class WholeSale implements Serializable{
	
	private static final long serialVersionUID=1000001L;
	
	private Integer wholesale_id;
	private String wholesale_name;
	private Integer credit;
	private String detail;
	private String address;
	private String w_picture;
	public Integer getWholesale_id() {
		return wholesale_id;
	}
	public void setWholesale_id(Integer wholesale_id) {
		this.wholesale_id = wholesale_id;
	}
	public String getWholesale_name() {
		return wholesale_name;
	}
	public void setWholesale_name(String wholesale_name) {
		this.wholesale_name = wholesale_name;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getW_picture() {
		return w_picture;
	}
	public void setW_picture(String w_picture) {
		this.w_picture = w_picture;
	}
	@Override
	public String toString() {
		return "WholeSale [wholesale_id=" + wholesale_id + ", wholesale_name=" + wholesale_name + ", credit=" + credit
				+ ", detail=" + detail + ", address=" + address + ", w_picture=" + w_picture + "]";
	}
	
	

	
	
}
