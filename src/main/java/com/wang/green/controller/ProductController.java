package com.wang.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.green.domain.Result;
import com.wang.green.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping("getProductByClassId")
	public Result getProduct(int class_id){
		
		return productService.getProductByClassId(class_id);
		
	} 
	
	
}