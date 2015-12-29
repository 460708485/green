package com.wang.green.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.green.dao.WholeSaleDao;
import com.wang.green.domain.Result;
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

	public Result getUserById(int id) {
		Result result=new Result();
		WholeSale wholeSale=wholeSaleDao.getWholeSaleByID(id);
		result.setStatus(1);
		result.setMsg("查询成功！");
		result.setData(wholeSale);
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

}
