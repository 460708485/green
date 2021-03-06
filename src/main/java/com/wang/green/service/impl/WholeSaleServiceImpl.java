package com.wang.green.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.green.dao.WholeSaleDao;
import com.wang.green.domain.Result;
import com.wang.green.domain.WPinfo;
import com.wang.green.domain.WholeSale;
import com.wang.green.service.WholeSaleService;

@Service
public class WholeSaleServiceImpl implements WholeSaleService{

	@Autowired
	private WholeSaleDao wholeSaleDao;
	
	public Result getUsers() {
		Result result =new Result();
		List<WholeSale> wholesales=wholeSaleDao.getWholeSales();
		System.out.println(wholesales);
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wholesales);
		return result;
	}

	public Result getUserGoodsById(int id) {
		Result result=new Result();
		List<WPinfo> wpinfos=wholeSaleDao.getWholeSaleGoodsByID(id);
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wpinfos);
		return result;
	}

	public Result getGoodUsers() {
		Result result =new Result();
		List<WholeSale> wholesales=wholeSaleDao.getGoodWholeSales();
		System.out.println(wholesales);
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wholesales);
		return result;
	}
 
	public Result getUserGoods() {
		Result result=new Result();
		List<WPinfo> wpinfos=wholeSaleDao.getWholeSaleGoods();
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wpinfos);
		return result;
	}

	public Result getUserGoodsByName(String name) {
		Result result=new Result();
		List<WPinfo> wpinfos=wholeSaleDao.getWholeSaleGoodsByName(name);
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wpinfos);
		return result;
	}

	public Result getUserGoodsByAddress(String address) {
		Result result=new Result();
		List<WPinfo> wpinfos=wholeSaleDao.getWholeSaleGoodsByAddress(address);
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wpinfos);
		return result;
	}

	public Result getUserGoodsByWPId(int wpinfo_id) {
		
		Result result=new Result();
		WPinfo wpinfo=wholeSaleDao.getWholeSaleGoodsByWPId(wpinfo_id);
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wpinfo);
		return result;
	}

}
