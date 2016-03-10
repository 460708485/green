package com.wang.green.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.AddressDao;
import com.wang.green.domain.Address;
@Repository
public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao{

	public List<Address> findAll() {
		
		return this.sqlMapClientTemplate.queryForList("address.findAll");
	}
	@Override
	public void insert(Address po) {
		this.sqlMapClientTemplate.insert("address.add",po);
	}
	
	@Override
	public int update(Address po) {
		return this.sqlMapClientTemplate.update("address.update", po);
	}
	
	public List<Address> findByUserId(int userId) {
		return this.sqlMapClientTemplate.queryForList("address.findByUserId", userId);
	}
}
