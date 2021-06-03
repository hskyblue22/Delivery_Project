package com.projectGo.view;

import com.projectGo.controller.OrderListController;

public class OrderListView {

	OrderListController olc = new OrderListController();
	
	public OrderListView() {
		// TODO Auto-generated constructor stub
	}
	
	//화면뜰때
	olc.printList();
	
	//주문취소- 삭제->리스트다시프린트
	olc.deleteList();
}
