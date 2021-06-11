package com.projectGo.controller;


import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;
import com.projectGo.view.OrderView;

public class BasketController {
	
	private Basket basket;
	
	
	public BasketController() {}
	
	
	// 장바구니 담기 하고 장바구니를 누르면 basket객체 전달
	public BasketController(Basket basket) {
		this.basket = basket;
		
	}
	
	public Basket getBasket() {
		return basket;
	}
		
	
	
	// 리스트 크기 반환
	public int getMenuListSize() {
		
		return basket.getMenuList().size();
	
	}

	// 리스트가 비어있는지 확인
	public boolean listIsEmpty() {
		
		return basket.getMenuList().isEmpty();	

	}
	
	
	// 장바구니메뉴조회
	public Iterator<Entry<String, Menu>> selectedMenu() {

		Set<Entry<String, Menu>> menuSet = basket.getMenuList().entrySet();
		Iterator<Entry<String, Menu>> iterMenu = menuSet.iterator();

		return iterMenu;

	}

	
	// 삭제할 메뉴명 받아 삭제
	public void deleteBasketMenu(String menuName) {

		basket.getMenuList().remove(menuName);

	}
	

	// 전체 삭제
	public void deleteAll() {

		basket.getMenuList().clear();

	}

	
	// 메뉴명 받아 수량 변경
	public void modifyQuantity(String Menu, int modifyQuantity) {

		basket.getMenuList().get(Menu).setQuantity(modifyQuantity);
		
	}

	
	// 메뉴명에 해당하는 수량 리턴
	public int getMenuQuantity(String menu) {

		return basket.getMenuList().get(menu).getQuantity();
	}

	
	// 메뉴 가격 리턴
	public int getMenuPrice(String menu) {

		return basket.getMenuList().get(menu).getMenuPrice();
	}

	
	// 식당명 리턴
	public String getStoreName() {

		return basket.getStoreName();
	}
	
	
	// 주문버튼 누르면 오더페이지로 넘어가면서 객체 전달
	public void order() {
		
		new OrderView(new Order(basket));
		
	}

}
