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
	
	private ErrorInter  errorEnum;
	
	public CommonException() {
		
	}

	public CommonException(String message) {
		super(message);
	}

	public CommonException(Throwable t) {
		super(t);
	}

	public CommonException(ErrorInter errorEnum) {
		super(errorEnum.getCode()+""+errorEnum.getDescription());
		this.errorEnum = errorEnum;
	}

	public CommonException(ErrorInter errorEnum,Throwable t) {
		super(errorEnum.getCode()+""+errorEnum.getDescription());
		this.errorEnum = errorEnum;
	}
	
	public ErrorInter getErrorEnum() {
		return errorEnum;
	}

	public void setErrorEnum(ErrorInter errorEnum) {
		this.errorEnum = errorEnum;
	}
	
	
	
	
	
	
}
