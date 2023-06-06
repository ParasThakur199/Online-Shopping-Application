package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.UnauthorizedAccessException;
import com.shopping.model.Cart;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.CartRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public CartRepository cartRepository;
	
	@Override
	public Product addProductByAdmin(Product product,String username) {
		User admin = userRepository.findByEmailId(username);
		if(admin != null && admin.getRole().toString().equalsIgnoreCase("ADMIN")) {
			return productRepository.save(product);
		}else {
			throw new UnauthorizedAccessException("Only Admin can add Products");
		}
	}

	@Override
	public List<Product> getAllProductByCustomer(String username) {
		User cust = userRepository.findByEmailId(username);
		if(cust != null && cust.getRole().toString().equalsIgnoreCase("CUSTOMER")) {
			return productRepository.findAll();
		}else {
			throw new UnauthorizedAccessException("Only Customers can access all Products");
		}
	}

	@Override
	public Boolean addProductToCart(Integer productId, Integer cartId) {
		Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Invalid Product Id"));
		
		Cart cart = cartRepository.findById(cartId).orElseThrow(()->new RuntimeException("Invalid Cart Id"));
		
		product.setCart(cart);
		
		productRepository.save(product);
		return true;
	}
	
	

}
