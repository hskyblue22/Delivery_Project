package com.projectGo.controller;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.projectGo.model.dao.OrderDao;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;

public class OrderController {

	private Order order;
	private OrderDao ordDao = new OrderDao();
	
	
	public OrderController(Order order) {
		this.order = order;
	}
	
	//이전으로 눌렸을 때 이전 데이터 전달
	public Basket getBasket() {
		
		return new Basket(order.getUserId(), order.getStoreName(), order.getStoreAddress(), order.getDeliveryTip(), order.getMenuList());
	}
	
	
	// 총 주문 금액 리턴
	public int getTotalCharge() {

		Set<Entry<String, Menu>> menuSet = order.getMenuList().entrySet(); // NullPointerException
		Iterator<Entry<String, Menu>> iterMenu = menuSet.iterator();

		int totalCharge = 0;

		while (iterMenu.hasNext()) {
			Entry<String, Menu> entry = iterMenu.next();
			totalCharge += (entry.getValue().getMenuPrice() * entry.getValue().getQuantity());
		}

		return totalCharge;
	}
	
	//order객체에 주소리턴 
	public String getUserAddress() {
		
//		user객체 받아서 불러오기 getUser().getUserAddress
		
		return null;
	}
	
	//요청사항 저장
	public void setRequest(String request) {
		
		order.setRequest(request);
		
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
		
		//적립 후 마이페이지에 조회시 변경된 포인트 보기
	}

	
	//배달팁 리턴
	public int getDeliveryTip() {

		return order.getDeliveryTip();
	}
	
	
	//총 결제 금액 저장
	public void setTotalPayment(int totalPayment) {
	
		order.setPayment(totalPayment);
	}


	//order객체 저장 output
	public void orderOutPut() {
		
		order.setUserAddress(getUserAddress()); //멤버 주소 저장
		order.setOrderedDate(Calendar.getInstance());
		ordDao.orderOutput(order);
	}


}
