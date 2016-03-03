package com.wang.green.dao;
import java.util.*;

import com.wang.green.base.BaseDao;
import com.wang.green.domain.Ad;

/**
 * ad
 */
public interface AdDao extends BaseDao<Ad>{
	
	public List<Ad> findNew(int status);

}