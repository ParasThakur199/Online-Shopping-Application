package com.shopping.service;

import java.util.List;

import com.shopping.model.Order;
import com.shopping.model.User;

public interface OrderService {
	
	public List<Order> getAllOrders();
	    
	public Order getOrderById(Integer orderId);
	    
	public List<Order> getOrdersByUser(User user);
	    
	public Order createOrder(Order order);
	    
	public Order updateOrder(Order order);
	    
	public String deleteOrder(Integer orderId);
	    
	public String cancelOrder(Order order);
	    
	public String processOrder(Order order);
	    
	public String completeOrder(Order order);
}
