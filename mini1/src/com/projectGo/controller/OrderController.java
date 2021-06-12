package com.projectGo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.projectGo.model.dao.MemberDao;
import com.projectGo.model.dao.OrderDao;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Member;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;
import com.projectGo.view.MainFrame;

public class OrderController {

	private Order order;
	private OrderDao ordDao = new OrderDao();
	private MemberDao md = new MemberDao();
	private Member member;
	private int memIndex;
	private ArrayList<Member> memList;
	
	
	public OrderController(Order order) {
		memList = md.fileInput();
		for(Member m : memList) {
			
			if(m.getNick().equals(MainFrame.loginUserId)) {
				
				this.member = m;
				
			}
			
		}
		
		this.order = order;
//		ordDao.memInput();
//		loginUser(ordDao.getMemList());
	}
	
	
//	//로그인된 유저
//	public void loginUser(ArrayList<Member> memList) {
//		
//		this.memList = memList;
//		for(int i = 0; i < memList.size(); i++) {
//			
//			if(MainFrame.loginUserId.equals(memList.get(i).getNick())) {
//				this.member = memList.get(i);
//				this.memIndex = i;
//				
//			}
//		}
//	}

	
	// 총 주문 금액 리턴
	public int getTotalCharge() {

		Set<Entry<String, Menu>> menuSet = order.getBasket().getMenuList().entrySet(); // NullPointerException
		Iterator<Entry<String, Menu>> iterMenu = menuSet.iterator();

		int totalCharge = 0;

		while (iterMenu.hasNext()) {
			Entry<String, Menu> entry = iterMenu.next();
			totalCharge += (entry.getValue().getMenuPrice() * entry.getValue().getQuantity());
		}

		return totalCharge;
	}
	
	
	//유저 주소리턴 
	public String getUserAddress() {
		
		return member.getAddress();
		
	}
	
	//유저 폰넘버
	public String getUserPhone() {
		
		return member.getPhone();
	}
	
	// 배달팁 리턴
	public int getDeliveryTip() {

		return order.getBasket().getDeliveryTip();

	}
	
	
	//포인트 리턴
	public int getPoint() {
		
		return member.getPoint();
	}
	
	
	//포인트 사용 후 포인트 금액 저장
	public void setPoint(int usePoint) {
		
//		member.setPoint(getPoint() - usePoint);
		
	}

	
	//결제 시 포인트 적립 -> 적립한 포인트로 member 정보 저장하고 outPut
	//적립 후 마이페이지에 조회시 변경된 포인트 보기
	public void savePoint(int savePoint) {
		
//		member.setPoint(getPoint() + savePoint);
//		memList.set(memIndex,member);
//		ordDao.memOutput(memList);
		
	}
	

	// 요청사항 저장
	public void setRequest(String request) {

		order.setRequest(request);

	}

	
	//총 결제 금액 저장
	public void setTotalPayment(int totalPayment) {
	
		order.setPayment(totalPayment);
	}

	
	//이전으로 눌렸을 때 이전 데이터 전달
	public Basket getBasket() {
		
		return new Basket(order.getBasket().getUserId(), order.getBasket().getStoreName(), order.getBasket().getStoreAddress(), order.getBasket().getDeliveryTip(), order.getBasket().getMenuList());
	
	}

	
	//결제하기 누르면 order객체 저장 output
	public void orderOutPut() {
		
		order.setUserAddress(getUserAddress());  //멤버 주소 저장
		order.setOrderedDate(Calendar.getInstance());
		ordDao.orderOutput(order);
	
	}

}
