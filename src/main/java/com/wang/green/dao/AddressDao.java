package com.wang.green.dao;

import java.util.List;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.Address;

public interface AddressDao extends BaseDao<Address>{
	
	
	public List<Address> findAll();
	
	public void insert(Address address);
	
	public int update(Address adddress);
	
	public List<Address> findByUserId(int userId);
}
