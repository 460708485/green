package com.wang.green.common;

/**
 * 支持Excel格式的序列化和反序列
 * @author yinjy
 *
 */
public interface ExcelSerializeable { 
	/**
	 * 获取Excel头部标题
	 * @return
	 */
	String[] excelHeaders();
	
	/**
	 * 序列化为Excel模型
	 * @return
	 */
	String[] serializeable();
	
	/**
	 * 反序列化Excel模型为javabean模型
	 * @param objArray
	 */
	void deserializeable(String[] objArray);

}
