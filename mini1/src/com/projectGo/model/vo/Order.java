package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.Calendar;

public class Order extends Basket implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalCharge;  //보류
	private int payment;
	private String request;
	private Calendar orderedDate;
	private String userAddress;
	
	public Order() {}

	public Order(Basket basket) {
		super(basket.getUserId(), basket.getStoreName(), basket.getStoreAddress(), basket.getDeliveryTip(), basket.getMenuList());
	}

	public int getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(int totalCharge) {
		this.totalCharge = totalCharge;
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

	@Override
	public String toString() {
		return super.toString() + "Order [totalCharge=" + totalCharge + ", payment=" + payment + ", request=" + request + ", orderedDate="
				+ orderedDate + ", userAddress=" + userAddress + "]";
	}
	
	
}
