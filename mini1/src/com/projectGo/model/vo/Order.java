package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

public class Order implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Basket basket;
	private int payment;
	private String request;
	private Calendar orderedDate;
	private String userAddress;
	private boolean orderState;
	private int sNum;
	
	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public Order() {}

	public Order(Basket basket) {
		this.basket = basket;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Calendar getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Calendar orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public boolean isOrderState() {
		return orderState;
	}

	public void setOrderState(boolean orderState) {
		this.orderState = orderState;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	@Override
	public String toString() {
		return "Order [basket=" + basket + ", payment=" + payment + ", request=" + request + ", orderedDate="
				+ orderedDate + ", userAddress=" + userAddress + ", orderState=" + orderState + "]";
	}

	
}
