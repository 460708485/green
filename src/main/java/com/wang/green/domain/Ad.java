package com.wang.green.domain;

import java.io.Serializable;
/**
 * ad
 */
public class Ad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	public int id;
	/**
	 * ad_picture
	 */
	public String ad_picture;
	/**
	 * ad_message
	 */
	public String ad_message;
	/**
	 * ad_status
	 */
	public int ad_status;
	
	public Ad() {
		super();
	}
	
	public Ad(int id, String ad_picture, String ad_message, int ad_status) {
		super();
		this.id = id; 
		this.ad_picture = ad_picture; 
		this.ad_message = ad_message; 
		this.ad_status = ad_status; 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	public void changeIdWith(int id){
		this.id += id;
	}
	
	public void changeIdWithMin(int id,int min){
		this.id += id;
		this.id = this.id < min ? min : this.id;
	}
	
	public void changeIdWithMax(int id,int max){
		this.id += id;
		this.id = this.id > max ? max : this.id;
	}
	
	public void changeIdWithMaxMin(int id,int max,int min){
		this.id += id;
		this.id = this.id < min ? min : this.id;
		this.id = this.id > max ? max : this.id;
	}	
	public String getAd_picture() {
		return ad_picture;
	}

	public void setAd_picture(String ad_picture) {
		this.ad_picture = ad_picture;
	} 
	
	public String getAd_message() {
		return ad_message;
	}

	public void setAd_message(String ad_message) {
		this.ad_message = ad_message;
	} 
	
	public int getAd_status() {
		return ad_status;
	}

	public void setAd_status(int ad_status) {
		this.ad_status = ad_status;
	} 
	
	public void changeAd_statusWith(int ad_status){
		this.ad_status += ad_status;
	}
	
	public void changeAd_statusWithMin(int ad_status,int min){
		this.ad_status += ad_status;
		this.ad_status = this.ad_status < min ? min : this.ad_status;
	}
	
	public void changeAd_statusWithMax(int ad_status,int max){
		this.ad_status += ad_status;
		this.ad_status = this.ad_status > max ? max : this.ad_status;
	}
	
	public void changeAd_statusWithMaxMin(int ad_status,int max,int min){
		this.ad_status += ad_status;
		this.ad_status = this.ad_status < min ? min : this.ad_status;
		this.ad_status = this.ad_status > max ? max : this.ad_status;
	}	
	
	
}
