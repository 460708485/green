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
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cityId;

    /**  */
    private String cityName;

    /**  */
    private String zipcode;

    /**  */
    private String provinceId;

    /**
     * <p>default constants</p>
     */
    public City() {

    }

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

  
}
