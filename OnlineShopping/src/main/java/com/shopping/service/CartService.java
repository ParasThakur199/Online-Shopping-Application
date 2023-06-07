package com.shopping.service;

import com.shopping.model.Cart;

public interface CartService {
	
	public Cart createCart(Cart cart);
	
	public Boolean setProductToCart(Integer cartId, Integer productId);
	
	public double calculateTotalPrice(Cart cart);
	
	public Cart getCartById(Integer cartId);
	
	
}
