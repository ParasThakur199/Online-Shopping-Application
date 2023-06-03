package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Product;
import com.shopping.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products/{emailId}")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product product,@PathVariable String emailId) {
		Product res = productService.addProductByAdmin(product, emailId);
		return new ResponseEntity<Product>(res,HttpStatus.CREATED);
	}
}
