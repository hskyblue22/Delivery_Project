package com.projectGo.controller;


import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import com.projectGo.model.dao.BasketDao;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;
import com.projectGo.view.OrderMenu;

public class BasketController {

	private BasketDao basDao = new BasketDao();
	private OrderMenu ordMenu = new OrderMenu();
	
	public BasketController() {}
	
	
	//장바구니메뉴조회
	public Entry<String, Menu> selectedMenu() {
		
		Set<Entry<String, Menu>> menuSet = basDao.getMenuList().entrySet();
		Iterator<Entry<String, Menu>> iterMenu = menuSet.iterator();
		
		Entry<String, Menu> entry = null;
		
		while(iterMenu.hasNext()) {
			entry = iterMenu.next();
		}
		
		return entry;
		
	}

	//삭제할 메뉴명 받아 삭제
	public void deleteBasketMenu(String menuName) {
		
		basDao.deleteBasketMenu(menuName);
		
	}

	//전체 삭제
	public void deleteAll() {
		
		basDao.deleteAll();
		
	}

	//메뉴명 받아 수량 변경
	public void modifyQuantity(String Menu, int modifyQuantity) {
		
		basDao.modifyQuantity(Menu, modifyQuantity);
		
	}

	//주문버튼 누르면 오더페이지로 넘어가면서 객체 전달
	public Order order() {

		ordMenu.mainMenu();
		
		return basDao.basketOrder();
	}
	
	

}
