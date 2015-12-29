package com.wang.green.dao;


import com.wang.green.base.BaseDao;
import com.wang.green.domain.User;

/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */
public interface UserDao extends BaseDao<User>{

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param param
	 * @return
	 */
	public User getUserByID(int id);
	
	/**
	 * 检查用户密码是否匹配
	 * @param password
	 * @return
	 */
	public String checkUser(String username);
	
	/**
	 * 添加用户
	 * @param user
	 * @return 整数
	 */
	public int addUser(User user);
	
	
}
