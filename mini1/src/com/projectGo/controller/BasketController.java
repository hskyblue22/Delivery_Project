package com.projectGo.controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.projectGo.model.dao.BasketDao;
import com.projectGo.model.vo.Menu;
import com.projectGo.view.OrderView;

public class BasketController {

	private BasketDao basDao = new BasketDao();
	
	public BasketController() {}
	
	
	//메뉴리스트 리턴
	public HashMap<String, Menu> getMenuList() {
		return basDao.getMenuList();              
	}
	
	
	// 장바구니메뉴조회
	public Iterator<Entry<String, Menu>> selectedMenu() {

		Set<Entry<String, Menu>> menuSet = basDao.getMenuList().entrySet();
		Iterator<Entry<String, Menu>> iterMenu = menuSet.iterator();

		return iterMenu;

	}

	// 삭제할 메뉴명 받아 삭제
	public void deleteBasketMenu(String menuName) {

		basDao.deleteBasketMenu(menuName);

	}

	// 전체 삭제
	public void deleteAll() {

		basDao.deleteAll();

	}

	// 메뉴명 받아 수량 변경
	public void modifyQuantity(String Menu, int modifyQuantity) {

		basDao.modifyQuantity(Menu, modifyQuantity);

	}

	// 주문버튼 누르면 오더페이지로 넘어가면서 객체 전달
	public void order() {
		
		basDao.basketOrder();
		new OrderView();
		
	}

	// 리스트 크기 반환
	public int getMenuListSize() {

		return basDao.getMenuList().size();

	}

	// 리스트가 비어있는지 확인
	public boolean listIsEmpty() {

		return basDao.getMenuList().isEmpty();

	}

	// 메뉴명에 해당하는 수량 리턴
	public int getMenuQuantity(String menu) {

		return basDao.getMenuList().get(menu).getQuantity();
	}

	// 메뉴 가격 리턴
	public int getMenuPrice(String menu) {

		return basDao.getMenuList().get(menu).getMenuPrice();
	}

	// 식당명 리턴
	public String getStoreName() {

		return basDao.getBasket().getStoreName();
	}

}
