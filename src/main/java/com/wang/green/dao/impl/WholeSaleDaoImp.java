package com.wang.green.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.WholeSaleDao;
import com.wang.green.domain.WPinfo;
import com.wang.green.domain.WholeSale;

@Repository
public class WholeSaleDaoImp extends BaseDaoImpl<WholeSale> implements WholeSaleDao{
	
	@SuppressWarnings("unchecked")
	public List<WholeSale> getWholeSales() {
		return this.sqlMapClientTemplate.queryForList("getWholeSales");
		
	}

	@SuppressWarnings("unchecked")
	public List<WPinfo> getWholeSaleGoodsByID(int id) {
	
		return  this.sqlMapClientTemplate.queryForList("getWholeSaleGoodsByID", id);
	}

	public int addWholeSale(WholeSale wholesale) {
		
		return (Integer)this.sqlMapClientTemplate.insert("addWholeSale", wholesale);
	}

	@SuppressWarnings("unchecked")
	public List<WholeSale> getGoodWholeSales() {
		return this.sqlMapClientTemplate.queryForList("getGoodWholeSales");
	}

	

}
