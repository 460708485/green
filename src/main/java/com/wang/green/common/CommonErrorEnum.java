package com.wang.green.common;

public enum CommonErrorEnum {

	COMMON_ERROR_1(1,"通用错误"),
	
	COMMON_ERROR_2(2,"数据库异常"),
	
	COMMON_ERROR_3(3,"不支持请求参数"),
	
	COMMON_ERROR_4(4,"资源不存在");
	
	private Integer code;
	
	private String message;
	
	private CommonErrorEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
