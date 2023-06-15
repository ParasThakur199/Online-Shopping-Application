package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Category;
import com.shopping.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/{username}")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category,@PathVariable String username){
		Category res = categoryService.addCategory(category, username);
		return new ResponseEntity<Category>(res,HttpStatus.CREATED);
	}
}
