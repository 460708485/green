package com.wang.green.common;

public enum CommonStatusEnum {
	
	FAIL(0,"失败"),
	
	SUCCESS(1,"成功");
	
	private CommonStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private Integer code;
	
	private String desc;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	

}
