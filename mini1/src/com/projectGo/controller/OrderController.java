package com.projectGo.controller;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import com.projectGo.model.dao.OrderDao;
import com.projectGo.model.vo.Menu;

public class OrderController {

	private OrderDao ordDao = new OrderDao();
	
	
	public void setUserAddress() {
		
//		ordDao.getOrder().setUserAddress(/* user객체 받아서 불러오기 getUser().getUserAddress*/);
		
	}
	
	
	public void setRequest(String request) {
	
		ordDao.setRequest(request);
		
	}
	
	
	public int getPoint() {
		/* user객체 받아서 불러오기 getUser().getUserPoint*/
		return 0;
	}


	public void usePoint(int point) {
		ordDao.usePoint(point);
		
	}
	

	public int getTotalCharge() {
		
		Set<Entry<String, Menu>> menuSet = ordDao.getMenuList().entrySet();
		Iterator<Entry<String, Menu>> iterMenu = menuSet.iterator();
		
//		Entry<String, Menu> entry = null;
		
		int totalCharge = 0;
		
		while(iterMenu.hasNext()) {
			Entry<String, Menu> entry = iterMenu.next();
			totalCharge += entry.getValue().getMenuPrice();
		}
		
		return totalCharge;
	}


	public int getDeliveryTip() {

		return ordDao.getDeliveryTip();
	}


	public void setTotalPayment(int totalPayment) {
	
		ordDao.setPayment(totalPayment);
	}


	public void orderOutPut() {
		
		ordDao.orderOutput();
	}


}
