package com.freshfood;

import java.io.Serializable;

public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private int numberOfPeople;
	private String dateTime;
	private Order order;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Reservation [username=" + username + ", numberOfPeople=" + numberOfPeople + ", dateTime=" + dateTime
				+ ", order=" + order + "]";
	}
	
}
