package com.wang.green.domain;

import java.io.Serializable;
/**
 * 蔬菜类别类
 * @author wangjq
 *
 */
public class VClass implements Serializable{

	private static final long serialVersionUID = 100006L;
	
	private Integer class_id;
	private String type;
	
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "VClass [class_id=" + class_id + ", type=" + type + "]";
	}
	
	
	

}
