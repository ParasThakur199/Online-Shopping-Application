package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.Order;
import com.shopping.model.User;
import com.shopping.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
