package com.projectGo.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.projectGo.model.dao.OrderListDao;
import com.projectGo.model.vo.Order;

public class OrderListController {

//	public static boolean orderCheck = false;  //주문취소 확인변수
	private OrderListDao old = new OrderListDao();
	private ArrayList<Order> olist;
	
	public OrderListController() {
		
	}
	
	public ArrayList<Order> displayAllList(){
		
		olist = old.displayAllList();
		return olist;
		
	}


	public void deleteOrder(int index) {

		old.deleteList(index);	
	}


	public void saveListFile() {
		// BoardDao의 saveListFile()의 메소드 호출
		old.saveListFile();
	}
	
}
