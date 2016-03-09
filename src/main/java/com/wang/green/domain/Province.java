/*
 * 2016/03/08 DX Creating
 *
 * (c) Copyright TIS Inc. All rights reserved.
 */
package com.wang.green.domain;

import java.io.Serializable;

/**
 * <p> Entity Class</p>
 *
 * @author wangjq
 * @version 1.00
 */
public class Province implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    /**  */
    private String provinceId;

    /**  */
    private String provinceName;

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

    

}
