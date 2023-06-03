package com.shopping.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	@Id
	@GeneratedValue
	private Integer cartId;
	private String name;
	private String description;
	private Integer quantity;
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	private List<Product> product;
}
