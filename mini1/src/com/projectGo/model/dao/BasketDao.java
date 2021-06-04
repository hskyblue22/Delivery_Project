package com.projectGo.model.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;


public class BasketDao {
	
	private Basket basket;
	private HashMap<String, Menu> menuList;
	
	public BasketDao() {
//		HashMap<String, Menu> m1 = new HashMap<String, Menu>();
//		m1.put("스테이크", new Menu("메뉴사진자리", 55000, 1));
//		m1.put("오일파스타", new Menu("메뉴사진자리", 22000, 2));
//		m1.put("투움바파스타", new Menu("메뉴사진자리", 18000, 3));
//		
//		this.basket = new Basket("temp1", "아웃백","서울시 강남구",3000, m1);
//		this.menuList = m1;
	}
	
	//장바구니 담기 하고 장바구니를 누르면 basket객체 전달
	public BasketDao(Basket basket) {
		this.basket = basket;
		this.menuList = basket.getMenuList();
	}

	public Basket getBasket() {
		return basket;
	}

	public HashMap<String, Menu> getMenuList() {
		return menuList;
	}

	
	//삭제할 메뉴명 받아 삭제
	public void deleteBasketMenu(String menuName) {
		
		menuList.remove(menuName);
		
	}

	//전체 삭제
	public void deleteAll() {
		
		menuList.clear();
	}

	//메뉴명 받아 수량 변경
	public void modifyQuantity(String name, int modifyQuantity) {
		
		Menu val = menuList.get(name);
		val.setQuantity(modifyQuantity);
		
	}

	//주문 클릭하면 장바구니 객체 넘겨주기
	public Order basketOrder() {
		
		return new Order(basket);
	}
	
	
}
