package com.wang.green.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.green.dao.ProductDao;
import com.wang.green.domain.Product;
import com.wang.green.domain.Result;
import com.wang.green.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	public Result getProductByClassId(int class_id) {
		
		Result result=new Result();
		result.setStatus(1);
		result.setMsg("查询成功");
		List<Product> products=productDao.getProductByClassId(class_id);
		result.setData(products);
		return result;
	}
	

}
