package com.wang.green.dao.impl;

import org.springframework.stereotype.Repository;

import com.wang.green.base.BaseDaoImpl;
import com.wang.green.dao.UserDao;
import com.wang.green.domain.User;

/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User getUserByID(int id) {
		return (User)this.sqlMapClientTemplate.queryForObject("getUserByID", id);
	}

	public int addUser(User user) {
		return (Integer)this.sqlMapClientTemplate.insert("addUser", user);
	}

	public User checkUser(String username) {
		
		return (User)this.sqlMapClientTemplate.queryForObject("checkUser", username);
	}


}
