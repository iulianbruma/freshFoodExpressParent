package com.freshfood;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Map<Product,Integer>  products;

	public Order() {
		products = new HashMap<Product,Integer>();
	}
	
	public void addProduct(Product p,int quantity) {
		products.put(p, quantity);
	}
	
	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		String order = "";
		for (Entry<Product, Integer> entry : products.entrySet())
		{
			order+=entry.getKey().getName() + "-" + entry.getValue().intValue();
		}
		return order;
	}
	
		
}

