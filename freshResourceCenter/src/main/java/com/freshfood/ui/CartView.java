package com.freshfood.ui;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int totalQuantity;
	private BigDecimal totalPrice;
	
	public CartView(int totalQuantity, BigDecimal totalPrice) {
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
