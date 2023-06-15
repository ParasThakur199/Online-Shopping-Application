package com.shopping.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	private List<Product> product = new ArrayList<>();

	public double getTotalPrice() {
		double totalPrice = 0;
		for(Product prod : product) {
			totalPrice += prod.getPrice() * prod.getQuantity();
		}
		return totalPrice;
	}
	
    public void setProducts(List<Product> product) {
        this.product = product;
    }
	
}
