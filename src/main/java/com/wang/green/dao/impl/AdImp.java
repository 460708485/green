package com.wang.green.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.AdDao;
import com.wang.green.domain.Ad;

/**
 * ad
 */
@Repository
public  class AdImp extends BaseDaoImpl<Ad> implements AdDao {

	public List<Ad> findNew(int status) {
		
		return this.sqlMapClientTemplate.queryForList("findNew", status);
	}
	
	
}