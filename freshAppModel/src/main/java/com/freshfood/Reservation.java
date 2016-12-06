package com.freshfood;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private User owner;
	private int numberOfPeople;
	private Date dateTime;
	private List<Order> order;
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "Reservation [owner=" + owner + ", numberOfPeople=" + numberOfPeople + ", dateTime=" + dateTime + "]";
	}

}
