package com.wang.green.common;

/**
 * 
 * 业务异常
 * web层异常的封装
 * @author wangjq
 *
 */
public class CommonException extends Exception {

	private static final long serialVersionUID = 11214561321L;
	
	private CommonErrorEnum  errorEnum;
	
	public CommonException() {
		
	}

	public CommonException(String message) {
		super(message);
	}

	public CommonException(Throwable t) {
		super(t);
	}

	public CommonException(CommonErrorEnum errorEnum) {
		super(errorEnum.getCode()+""+errorEnum.getMessage());
		this.errorEnum = errorEnum;
	}

	public CommonException(CommonErrorEnum errorEnum,Throwable t) {
		super(errorEnum.getCode()+""+errorEnum.getMessage());
		this.errorEnum = errorEnum;
	}
	
	public CommonErrorEnum getErrorEnum() {
		return errorEnum;
	}

	public void setErrorEnum(CommonErrorEnum errorEnum) {
		this.errorEnum = errorEnum;
	}
	
	
	
	
	
	
}
