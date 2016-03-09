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
public class District implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  */
    private String districtId;

    /**  */
    private String districtName;

    /**  */
    private String cityId;

    /**
     * <p>default constants</p>
     */
    public District() {

    }

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

   
}
