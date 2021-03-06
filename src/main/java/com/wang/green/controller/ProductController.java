package com.wang.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.green.domain.Result;
import com.wang.green.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping("getProductByClassId")
	public Result getProduct(Integer class_id){
		
		return productService.getProductByClassId(class_id);
		
	} 
	
	@ResponseBody
	@RequestMapping("getProductById")
	public Result getProductById(int product_id){
		
		return productService.getProductById(product_id);
		
	} 
	
	@ResponseBody
	@RequestMapping("getWProductByClassId")
	public Result getWProductByClassId(int class_id){
		return productService.getWProductByClassId(class_id);
	}
	
}
