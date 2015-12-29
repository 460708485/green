package com.wang.green.domain;

import java.io.Serializable;

/**
 * 登录用户的信息
 * @version 1.0
 * @author wangjq
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1000000L;

	private String username;

	private String password;

	private String phone;

	private String email;
	
	private Integer status;//status为0时，为普通用户，status为1时，为会员用户

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", status=" + status + "]";
	}
	

	
	
}
