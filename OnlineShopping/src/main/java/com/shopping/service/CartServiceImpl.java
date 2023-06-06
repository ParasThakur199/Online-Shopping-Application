package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Cart createCart() {
		Cart cart = new Cart();
		return cartRepository.save(cart);
	}

	@Override
	public Product selectProductFromCart(Integer cartId, Integer productId) {
		Cart cart = cartRepository.findById(cartId).orElse(null);
		if(cart != null) {
			for(Product prod : cart.getProduct()) {
				if(prod.getProductId().equals(productId)){
					return prod;
				}
			}
		}
		return null;
	}

	@Override
	public Integer totalAllProductsPrice(Integer cartId) {
		Integer totalPrice = 0;
		Optional<Cart> cartCheck = cartRepository.findById(cartId);
		if(cartCheck.isPresent()) {
			List<Product> cart = cartCheck.get().getProduct();
			for(Product c: cart) {
				totalPrice += c.getPrice() * c.getQuantity();
			}
		}else {
			throw new RuntimeException("Cart is Empty");
		}
		return totalPrice;
	}
			

}
