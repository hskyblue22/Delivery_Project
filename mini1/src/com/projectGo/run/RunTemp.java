package com.projectGo.run;

import java.util.HashMap;

import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.view.BasketView;

public class RunTemp {
  
  	public static void main(String[] args) {
      
//	    	System.out.println("TEST");
  		
//  		BasketDao bd = new BasketDao();
//  		bd.fileInput();
//	 		bd.fileOutput();
  		
  		
  		HashMap<String, Menu> m2 = new HashMap<String, Menu>();
		m2.put("스테이크", new Menu("메뉴사진자리1", 55000, 1));
		m2.put("오일파스타", new Menu("메뉴사진자리2", 20000, 2));
		m2.put("투움바파스타", new Menu("메뉴사진자리3", 15000, 1));
		m2.put("치킨샐러드", new Menu("메뉴사진자리4", 12000, 2));
		
		Basket basket = new Basket("temp1", "아웃백","서울시 강남구",3000, m2);

		
		new BasketView(basket); 

    }

    
}