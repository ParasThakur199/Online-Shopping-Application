package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.UnauthorizedAccessException;
import com.shopping.model.Category;
import com.shopping.model.User;
import com.shopping.repository.CategoryRepository;
import com.shopping.repository.UserRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public Category addCategory(Category category, String username) {
		User admin = userRepository.findByEmailId(username);
		if(admin != null && admin.getRole().toString().equalsIgnoreCase("ADMIN")) {
			return categoryRepository.save(category);
		}else {
			throw new UnauthorizedAccessException("Only Admin can add category");
		}
			
	}

}
