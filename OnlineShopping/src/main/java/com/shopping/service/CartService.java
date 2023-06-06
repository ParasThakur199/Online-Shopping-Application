package com.shopping.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.shopping.model.Cart;
import com.shopping.model.Product;

public interface CartService {
	
	public Cart createCart();
	
	public Integer totalAllProductsPrice(Integer cartId);
	
	public Product selectProductFromCart(Integer cartId,Integer productId);
}
