package com.wang.green.dao;

import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.WPinfo;
import com.wang.green.domain.WholeSale;

public interface WholeSaleDao extends BaseDao<WholeSale>{
	/**
	 * 获取所有种植户信息
	 * @return
	 */
	public List<WholeSale> getWholeSales();
	/**
	 * 获取种植户评分等于5的所有
	 * @return
	 */
	public List<WholeSale> getGoodWholeSales();
	/**
	 * 根据种植户id获取信息
	 * @param id
	 * @return
	 */
	public List<WPinfo> getWholeSaleGoodsByID(int id);
	/**
	 * 根据种植户name模糊搜索信息
	 * @param id
	 * @return
	 */
	public List<WPinfo> getWholeSaleGoodsByName(String name);
	
	/**
	 * 根据种植户address模糊搜索信息
	 * @param id
	 * @return
	 */

	public List<WPinfo> getWholeSaleGoodsByAddress(String address);
	/**
	 * 获取所有产品信息
	 * @param id
	 * @return
	 */
	public List<WPinfo> getWholeSaleGoods();
	/**
	 * 根据id获取产品信息
	 * @param id
	 * @return
	 */
	public WPinfo getWholeSaleGoodsByWPId(int id);
}
