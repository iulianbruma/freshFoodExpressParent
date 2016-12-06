package com.freshfood;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Product product;
	private int quantity;
	
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Order [product=" + product + ", quantity=" + quantity + "]";
	}
	
}

