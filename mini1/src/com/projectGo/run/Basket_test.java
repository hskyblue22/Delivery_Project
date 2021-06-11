package com.projectGo.run;

import java.util.HashMap;

import com.projectGo.model.dao.OrderDao;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.view.BasketView;

public class Basket_test {

	public static void main(String[] args) {

		HashMap<String, Menu> m1 = new HashMap<String, Menu>();
		m1.put("스테이크", new Menu("스테이크","메뉴사진자리", 55000, 1));
		m1.put("오일파스타", new Menu("오일파스타","메뉴사진자리", 20000, 2));
		m1.put("투움바파스타", new Menu("투움바파스타","메뉴사진자리", 15000, 1));
		m1.put("치킨샐러드", new Menu("치킨샐러드","메뉴사진자리", 12000, 2));
		
		Basket basket = new Basket("temp1", "아웃백","서울시 강남구",3000, m1);
		
		new BasketView(basket);
		
//		OrderDao ord = new OrderDao();
//		ord.orderInput();
//		System.out.println(ord.getOrderList());
//		System.out.println(ord.getOrderList().size());
		
	}

}
