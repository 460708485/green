package com.wang.green.domain;

import java.io.Serializable;



/**
 * 用于处理业务逻辑的类
 * 包含一些业务逻辑处理后的状态及数据
 * @author wangjq
 *
 */
public class Result implements Serializable{

	private static final long serialVersionUID = 1000002L;
	
	private Integer status;
	private String msg;
	private Object data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
}
