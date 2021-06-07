package com.projectGo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.projectGo.model.dao.StoreDao;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Store;

public class SellerController{

		List<Store> storeList = new ArrayList<Store>();
		HashMap<String, Menu> menuList = new HashMap<String, Menu>();
		StoreDao sd = new StoreDao();


	
	public void menuCreator(String menuName, String menuPic, int menuPrice) {
		menuList.put(menuName, new Menu(menuPic, menuPrice)); //메뉴 리스트에 메뉴 객체 담기 
		
		
		
		
		
	}
	
	public void StoreCreator(String storeName, String storeIntroduce, int category, int deliveryTip, int deliveryTime) {
		
		Store store = new Store(storeName, storeIntroduce, category, deliveryTip, deliveryTime, menuList); //새 스토어 객체 생성 
		storeList.add(store); //ArrayList에 추가 
		
		sd.addStore(store);
		//dao로 이동 
		
		
		
	}


	



}
