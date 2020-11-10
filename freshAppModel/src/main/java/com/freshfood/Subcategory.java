package com.freshfood;

import java.io.Serializable;
import java.util.List;

public class Subcategory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private List<Product> products;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Subcategory [name=" + name + "]";
	}

}
