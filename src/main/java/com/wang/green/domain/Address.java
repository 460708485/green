/*
 * 2016/03/10 DX Creating
 *
 * (c) Copyright TIS Inc. All rights reserved.
 */
package com.wang.green.domain;

import java.io.Serializable;

/**
 * <p> Entity Class</p>
 *
 * @author DX
 * @version 1.00
 */
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;

	/**  */
    private int id;

    /**  */
    private String address;

    /**  */
    private String detailAddress;

    /**  */
    private String zipcode;

    /**  */
    private int isdefault;

    /**  */
    private String userName;
    
    private String phone;
    
    private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	

    
}
