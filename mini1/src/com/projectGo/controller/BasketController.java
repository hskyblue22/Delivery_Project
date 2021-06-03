package com.projectGo.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.projectGo.model.dao.BasketDao;

public class BasketController {

	private BasketDao basDao = new BasketDao();
	
	
	public BasketController() {}
	
	
	public void selectedMenu() {
		
		HashMap menuList = basDao.getMenuList();
		
		Set<Entry<String, Object>> mSet = menuList.entrySet();
		Iterator<Entry<String, Object>> iter = mSet.iterator();
		
		while(iter.hasNext()) {
			Entry<String, Object> entry = iter.next();
//			System.out.println("메뉴명 : " + entry.getKey() + "\n가격 : " + entry.getValue().price() + entry.getValue().quantity);
		}
	}

}
