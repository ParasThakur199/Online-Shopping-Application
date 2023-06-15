package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Order;
import com.shopping.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	public List<Order> findByUser(User user);

}
