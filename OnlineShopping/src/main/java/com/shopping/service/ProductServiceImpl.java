package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.UnauthorizedAccessException;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public Product addProductByAdmin(Product product,String username) {
		User admin = userRepository.findByEmailId(username);
		if(admin != null && admin.getRole().toString().equalsIgnoreCase("ADMIN")) {
			return productRepository.save(product);
		}else {
			throw new UnauthorizedAccessException("Only Admin can add Products");
		}
	}

}
