package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Order extends Basket implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private int totalCharge;  //보류
	private int payment;
	private String request;
	private Date orderedDate;
	private String userAddress;
	
	public Order() {}
	
}
