package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Cart;
import com.shopping.model.Product;
import com.shopping.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/carts/create")
	public ResponseEntity<Cart> createCartHandler(){
		Cart cart = cartService.createCart();
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@GetMapping("/carts/{cartId}/product/{productId}")
	public ResponseEntity<Product> selectProductFromCartHandler(@PathVariable Integer cartId,@PathVariable Integer productId){
		Product res = cartService.selectProductFromCart(cartId, productId);
		return new ResponseEntity<Product>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/carts/{cartId}")
	public ResponseEntity<Integer> getAllProductsTotalPrice(@PathVariable Integer cartId){
		Integer res = cartService.totalAllProductsPrice(cartId);
		return new ResponseEntity<Integer>(res,HttpStatus.FOUND);
	}
}
