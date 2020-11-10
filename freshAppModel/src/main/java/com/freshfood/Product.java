package com.freshfood;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private float price;
	private int categoryId;
	private String categoryName;
	private int subcategoryId;
	private String subcategoryName;
	private String description;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", subcategoryId=" + subcategoryId + ", subcategoryName=" + subcategoryName + "]";
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.categoryId)
				.append(this.categoryName)
				.append(this.subcategoryId)
				.append(this.subcategoryName)
				.append(this.price)
				.append(this.name)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product == false) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		final Product otherObject = (Product) obj;
		
		return new EqualsBuilder()
				.append(this.categoryId, otherObject.categoryId)
				.append(this.categoryName, otherObject.categoryName)
				.append(this.subcategoryId, otherObject.subcategoryId)
				.append(this.subcategoryName, otherObject.subcategoryName)
				.append(this.price, otherObject.price)
				.append(this.name, otherObject.name)
				.isEquals();
	}
}
