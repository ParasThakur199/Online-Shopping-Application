package com.shopping.service;

import java.util.List;
import java.util.Optional;

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
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Integer orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if(order.isPresent()) {
			return order.get();
		}else {
			throw new RuntimeException("Order not found");
		}
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		return orderRepository.findByUser(user);
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
	    Optional<Order> OrderCheck = orderRepository.findById(order.getOrderId());
	    if (OrderCheck.isPresent()) {
	        Order completeOrder = OrderCheck.get();
	        
	        completeOrder.setOrder_date(order.getOrder_date());
	        completeOrder.setQuantity(order.getQuantity());
	        completeOrder.setOrderStatus(order.getOrderStatus());
	        completeOrder.setUser(order.getUser());
	        
	        return orderRepository.save(completeOrder);
	    } else {
	        throw new RuntimeException("Order not found");
	    }
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
