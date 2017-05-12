package com.wang.green.common;

import java.util.List;

public class ResponseVO<T> {

	private String token;
	
	private Integer code;
	
	private String message;
	
	private List<CommonError> errors;

	//默认失败
	public ResponseVO() {
		setResponseStatus(CommonStatusEnum.FAIL);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public List<CommonError> getErrors() {
		return errors;
	}

	public void setErrors(List<CommonError> errors) {
		this.errors = errors;
	}
	
	public void addError(CommonErrorEnum errorEnum){
		
		
	}
	
	public void setResponseStatus(CommonStatusEnum statusEnum){
		this.setCode(statusEnum.getCode());
		this.setMessage(statusEnum.getDesc());
		
	}
	
	
	
	
	
	
}
