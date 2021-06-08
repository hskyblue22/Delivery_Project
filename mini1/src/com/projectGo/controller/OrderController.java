package com.projectGo.controller;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import com.projectGo.model.dao.OrderDao;
import com.projectGo.model.vo.Menu;

public class OrderController {

	private OrderDao ordDao = new OrderDao();
	
	
	//order객체에 주소리턴 
	public String getUserAddress() {
		
//		user객체 받아서 불러오기 getUser().getUserAddress
		
		return null;
	}
	
	//요청사항 저장
	public void setRequest(String request) {
		
		ordDao.setRequest(request);
		
	}
	
	//포인트 리턴
	public int getPoint() {
		/* user객체 받아서 불러오기 getUser().getUserPoint*/
		return 0;
	}
	
	
	//포인트 사용 후 포인트 금액 저장
	public void setPoint(int usePoint) {
		
		int point = getPoint() - usePoint;
		/* user객체 받아와서 .setUsedPoint(point)*/
	}

	
	//포인트 적립
	public void savePoint(int savePoint) {
		
		int point = getPoint() + savePoint;
		/* user객체 받아와서 .setUsedPoint(point)*/
	}
	

	//총 주문 금액 리턴
	public int getTotalCharge() {
		
		Set<Entry<String, Menu>> menuSet = ordDao.getMenuList().entrySet(); //NullPointerException
		Iterator<Entry<String, Menu>> iterMenu = menuSet.iterator();
		
		int totalCharge = 0;
		
		while(iterMenu.hasNext()) {
			Entry<String, Menu> entry = iterMenu.next();
			totalCharge += (entry.getValue().getMenuPrice() * entry.getValue().getQuantity());
		}
		
		return totalCharge;
	}

	
	//배달팁 리턴
	public int getDeliveryTip() {

		return ordDao.getDeliveryTip();
	}
	
	
	//총 결제 금액 저장
	public void setTotalPayment(int totalPayment) {
	
		ordDao.setPayment(totalPayment);
	}


	//order객체 저장 output
	public void orderOutPut() {
		
		ordDao.setUserAddress(getUserAddress()); //멤버 주소 저장
		ordDao.setDate();
		ordDao.orderOutput();
	}


}
