package com.wang.green.service;

import com.wang.green.domain.Result;
import com.wang.green.domain.User;
/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */
public interface UserService {

	/**
	 * 获取用户信息
	 * 
	 * @param param
	 * @return
	 */
	public Result getUser();
	
	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param param
	 * @return
	 */
	public Result getUserByID(int id);
	
	/**
	 * 判断用户名和密码的匹配
	 * @param password
	 * @return
	 */
	public Result checkUserByName(String username,String password);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public Result addUser(User user);
	
	
	/**
	 * 根据条件查找
	 * @param password
	 * @return
	 */
	public Result findByCondition(String username);
}
