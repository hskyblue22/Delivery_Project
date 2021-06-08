package com.projectGo.model.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.HashMap;

import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;


public class OrderDao {
	
	private Order order;
//	private HashMap<String, Menu> menuList;
	
//	private BasketDao basDao = new BasketDao();
	
	/*
	private int payment;
	private String request;
	private Calendar orderedDate;
	private String userAddress; */
	
	public OrderDao() {
	}

//	public OrderDao() {
//		this.order = basDao.basketOrder();
//	}
	
	public OrderDao(Order order) {
		this.order = order;
	}

	
	public Order getOrder() {
		return order;
	}
	
	
	public HashMap<String, Menu> getMenuList() {
		return order.getMenuList();              //NullPointerException
	}

	
	//요청사항 저장
	public void setRequest(String request) {
		
		order.setRequest(request);
		
	}

	//배달팁 반환
	public int getDeliveryTip() {
		
		return order.getDeliveryTip();
	}

	//결제금액 저장
	public void setPayment(int totalPayment) {

		order.setPayment(totalPayment);
		
	}
	
	//날짜 저장
	public void setDate() {
		
		order.setOrderedDate(Calendar.getInstance());
		
	}
	
	//주소 저장
	public void setUserAddress(String userAddress) {
		order.setUserAddress(userAddress);
	}

	//order객체 저장 output
	public void orderOutput() {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order_list.txt", true))) {
			
			oos.writeObject(order);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
