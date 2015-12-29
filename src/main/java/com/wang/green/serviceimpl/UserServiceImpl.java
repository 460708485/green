package com.wang.green.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.green.dao.UserDao;
import com.wang.green.domain.Result;
import com.wang.green.domain.User;
import com.wang.green.service.UserService;

/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public Result getUser() {
		return null;
	}

	public Result getUserByID(int id) {
		
		User user=userDao.getUserByID(id);
		Result result=new Result();
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(user);
		return result;
	}

	public Result checkUserByName(String username,String password) {
		String rightPwd=userDao.checkUser(username);
		Result result=new Result();
		if(rightPwd==null){
			result.setStatus(0);
			result.setMsg("用户名不存在！");
			return result;
		}
		if(!password.equals(rightPwd)){
			result.setStatus(0);
			result.setMsg("密码错误！");
			return result;
		}
		result.setStatus(1);
		result.setMsg("登录成功！");
		return result;
	}
	
	public Result addUser(User user){
		Result result =new Result();
		int num=userDao.addUser(user);
		if(num==1){
			result.setStatus(1);
			result.setMsg("注册成功！");
			return result;
		}
		result.setStatus(0);
		result.setMsg("注册失败！");
		return result;
	}
	
}
