package com.shopping.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue
	private Integer orderId;
	private String order_date;
	private Integer quantity;
	private OrderStatus orderStatus;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
}
