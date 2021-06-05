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
	private HashMap<String, Menu> menuList;
	
	private BasketDao basDao = new BasketDao();
	
	public OrderDao() {
		this.order = basDao.basketOrder();
		this.menuList = order.getMenuList();
	}

	
	public Order getOrder() {
		return order;
	}
	
	
	public HashMap<String, Menu> getMenuList() {
		return menuList;
	}


	public void setRequest(String request) {
		
		order.setRequest(request);
		
	}

	public void usePoint(int point) {
		
		/* user객체 받아서 불러오기 int getPoint = getUser().getUserPoint();
		 * getUser().setUserPoint(getPoint - point);
		 * */ 
		
	}


	public int getDeliveryTip() {
		
		return order.getDeliveryTip();
	}


	public void setPayment(int totalPayment) {

		order.setPayment(totalPayment);
		
	}
	
	
	public void setDate() {
		
		order.setOrderedDate(Calendar.getInstance());
		
	}


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
