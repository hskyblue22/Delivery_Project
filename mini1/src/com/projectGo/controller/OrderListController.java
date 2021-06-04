package com.projectGo.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.projectGo.model.dao.OrderListDao;
import com.projectGo.model.vo.Order;

public class OrderListController {

//	public static boolean orderCheck = false;  //주문취소 확인변수
	private OrderListDao old = new OrderListDao();	
	
	public OrderListController() {
		// TODO Auto-generated constructor stub
	}
	
	public void displayAllList(){
		
		ArrayList<Order> olist = old.displayAllList();
		
		Iterator it = olist.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void printList() {
		ArrayList<Order> olist = old.displayAllList();
		for(int i=0; i<olist.size(); i++) {
			System.out.println(olist.get(i));
		}
	}

	public void deleteOrder() {

		int deletenum = 1;  //클릭이벤트
		
		Order order = old.displayAllList(deletenum);
		
		if(order != null) {
			
			//삭제메시지	
			old.deleteList(deletenum);
			System.out.println("삭제되었습니다.");
		}
	}


	public void saveListFile() {
		// BoardDao의 saveListFile()의 메소드 호출
		old.saveListFile();
	}
	
}
