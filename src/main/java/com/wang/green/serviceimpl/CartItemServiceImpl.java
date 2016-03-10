package com.wang.green.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.green.dao.CartItemDao;
import com.wang.green.domain.CartItem;
import com.wang.green.domain.Result;
import com.wang.green.domain.WPinfo;
import com.wang.green.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	@Resource
	private CartItemDao cartItemDao;
	
	public Result getById(int id) {
		Result result=new Result();
		List<WPinfo> cartItem=cartItemDao.getById(id);
		
		result.setData(cartItem);
		return result;
	}

	public Result update(CartItem cartItem) {
		Result result=new Result();
		int num=cartItemDao.update(cartItem);
		if(1!=num){
			result.setStatus(0);
			result.setMsg("更新失败");
		}
		result.setStatus(1);
		result.setMsg("更新成功");
		return result;
	}

	public Result delete(int id) {
		Result result=new Result();
		int num=cartItemDao.delete(id);
		if(0==num){
			result.setStatus(0);
			result.setMsg("0条记录删除");
		}
		result.setStatus(1);
		result.setMsg("删除成功！");
		return result;
	}

	public Result insert(CartItem CartItem) {
		Result result =new Result();
		try{
		cartItemDao.insert(CartItem);
		result.setStatus(1);
		result.setMsg("添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
}
