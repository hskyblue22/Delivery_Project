package com.projectGo.model.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.projectGo.model.vo.Basket;

public class BasketDao {
	
	private Basket basket;
	private HashMap<String, Object> menuList;  //병합하고 Object -> Menu로 변경

	public BasketDao() {}
	
	//장바구니 담기 하고 장바구니를 누르면 basket객체 전달
	public BasketDao(Basket basket) {
		this.basket = basket;
		this.menuList = basket.getMenuList();
	}

	public Basket getBasket() {
		return basket;
	}

	public HashMap<String, Object> getMenuList() {
		return menuList;
	}

	
	
	

	
	
	
	
	

}
