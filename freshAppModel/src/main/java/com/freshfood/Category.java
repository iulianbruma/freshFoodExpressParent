package com.freshfood;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private List<Subcategory> subcategories;

	public Category() {
		
	}
	
	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
