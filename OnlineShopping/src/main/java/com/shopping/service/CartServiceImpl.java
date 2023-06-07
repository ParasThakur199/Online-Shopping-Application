package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.model.Cart;
import com.shopping.model.Product;
import com.shopping.repository.CartRepository;
import com.shopping.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public double calculateTotalPrice(Cart cart) {
		return cart.getTotalPrice();
	}

	@Override
	public Cart getCartById(Integer cartId) {
		return cartRepository.findById(cartId).orElseThrow(()->new IllegalArgumentException("Cart not found with ID: " + cartId));
	}

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart); 
	}


	@Override
	public Boolean setProductToCart(Integer cartId, Integer productId) {
		Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not present"));

		Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new RuntimeException("Cart not present"));

		product.setCart(cart);
		productRepository.save(product);
		return true;
	}


			

}
