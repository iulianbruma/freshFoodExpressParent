package com.freshfood.ui;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProductView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private int quantity;
	private float price;
	private String categoryName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "ProductView [name=" + name + ", description=" + description + ", quantity=" + quantity + ", price="
				+ price + ", categoryName=" + categoryName + "]";
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.categoryName)
				.append(this.price)
				.append(this.name)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProductView == false) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		final ProductView otherObject = (ProductView) obj;
		
		return new EqualsBuilder()
				.append(this.categoryName, otherObject.categoryName)
				.append(this.price, otherObject.price)
				.append(this.name, otherObject.name)
				.isEquals();
	}
}
