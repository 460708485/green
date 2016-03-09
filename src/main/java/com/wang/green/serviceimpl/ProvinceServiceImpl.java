package com.wang.green.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.green.dao.ProvinceDao;
import com.wang.green.domain.Province;
import com.wang.green.domain.Result;
import com.wang.green.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService{
	@Resource
	private ProvinceDao provinceDao;
	
	public Result getById(int id) {
		Result result=new Result();
		Province province=provinceDao.getById(id);
		if(null!=province){
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(province);
			return result;
			
		}
		result.setStatus(0);
		result.setMsg("查询失败");
		
		return result;
	}

	public Result getAll() {
		Result result=new Result();
		result.setData(provinceDao.getAll());
		return result;
	}
	

}
