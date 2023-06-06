package com.shopping.service;

import java.util.List;

import com.shopping.model.Product;

public interface ProductService {
	
	public Product addProductByAdmin(Product product,String username);
	
	public List<Product> getAllProductByCustomer(String username);
	
	public Boolean addProductToCart(Integer productId, Integer cartId);
	
}
