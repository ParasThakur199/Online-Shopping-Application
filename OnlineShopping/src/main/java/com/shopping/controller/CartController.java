package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Cart;
import com.shopping.model.Product;
import com.shopping.repository.CartRepository;
import com.shopping.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Cart> createCartHandler(){
		Cart cart = new Cart();
		Cart res = cartService.createCart(cart);
		return new ResponseEntity<Cart>(res,HttpStatus.CREATED);
	}
	
	@GetMapping("/{cartId}/totalprice")
	public ResponseEntity<Double> calculateTotalPrice(@PathVariable Integer cartId){
		Cart cart = cartService.getCartById(cartId);
		Double res = cartService.calculateTotalPrice(cart);
		return new ResponseEntity<>(res,HttpStatus.FOUND); 
	}
	
	@PostMapping("/{cartId}/products/{productId}")
	public ResponseEntity<Boolean> setProductToCartHandler(@PathVariable Integer cartId, @PathVariable Integer productId){
		Boolean res = cartService.setProductToCart(cartId, productId);
		return new ResponseEntity<Boolean>(res,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{cartId}/remove/products/{productId}")
	public ResponseEntity<String> removeSpecificProductFromCart(@PathVariable Integer cartId, @PathVariable Integer productId){
		String res = cartService.removeProductFromCart(cartId, productId);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
}
