package com.projectGo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.projectGo.model.dao.OrderListDao;
import com.projectGo.model.dao.StoreDao;
import com.projectGo.model.vo.Member;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Store;

public class SellerController{

		List<Store> storeList = new ArrayList<Store>();
		HashMap<String, Menu> menuList = new HashMap<String, Menu>();
		StoreDao sd = new StoreDao();
		Member m = new Member();
		String userId = m.getNick(); // member에서 아이디 받기 

	
	public void menuCreator(String menuName, String menuPic, int menuPrice) {
		menuList.put(menuName, new Menu(menuPic, menuPrice)); //메뉴 리스트에 메뉴 객체 담기 
		
		
		
		
		
	}
	
	public void StoreCreator(String storeName, String storeIntroduce, int category, int deliveryTip, int deliveryTime) {
		
	
		Store store = new Store(storeName, storeIntroduce, category, deliveryTip, deliveryTime, menuList, userId); //새 스토어 객체 생성 
		storeList.add(store); //ArrayList에 추가 
		
		sd.addStore(store);
		//dao로 이동 
		
		
		
	}
	
	public ArrayList<Store> loadSellerOrder() {
		
		String myStore;
		ArrayList<Store> sellerOrder = new ArrayList();
		
		// 가게 목록에서 내 가게 호출
		for (int i = 0; i < sd.loadStore().size(); i++) {
		 if(sd.loadStore().get(i).getUserId().equalsIgnoreCase(userId)) {
			 myStore = sd.loadStore().get(i).getStoreName();
		 }
		 
		} 
		
		// 주문 목록에서 가게 이름과 대조 , 해당하는 주문만 불러옴
		
		OrderListDao old = new OrderListDao();
		
		for (int i = 0; i < old.totalOrderlist.size(); i++  ) {
			if(myStore.equals(old.totalOrderList.get(i).getStorename())) {
				sellerOrder.add(old.totalOrderList.get(i));
			}
					
		}
		
		
		
		
		
		
		
		return sellerOrder;
		
		
		
	}


	



}
