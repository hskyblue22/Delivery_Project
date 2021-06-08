package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

public class Order extends Basket implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int payment;
	private String request;
	private Calendar orderedDate;
	private String userAddress;
	private boolean orderState;
	
	public Order() {}

	public Order(Basket basket) {
		super(basket.getUserId(), basket.getStoreName(), basket.getStoreAddress(), basket.getDeliveryTip(), basket.getMenuList());
	}
	
	public Order(String userId, String storeName, String storeAddress, int deliveryTip, HashMap<String, Menu> menuList) {
		super(userId, storeName, storeAddress, deliveryTip, menuList);
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

	@Override
	public String toString() {
		return "Order [payment=" + payment + ", request=" + request + ", orderedDate=" + orderedDate + ", userAddress="
				+ userAddress + ", orderState=" + orderState + "]";
	}
	
	
}
