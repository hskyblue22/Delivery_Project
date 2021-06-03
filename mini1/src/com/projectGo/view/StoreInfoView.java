package com.projectGo.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.projectGo.controller.StoreSort;
import com.projectGo.model.dao.StoreLoad;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Store;

public class StoreInfoView {
	
	Store store;
	
	public void storeInfoViewMain() {
		store = new StoreSort().topStore(new StoreLoad().storeLoad());
		HashMap<String, Menu> menu;
		menu = store.getStoreMenu();
		Set<String> menuName;
		String name;
		
		System.out.println(store.getStoreName());
		System.out.println(store.getStoreIntoduce());
		System.out.println(store.getStoreAddress() + "       배달팁 : " + store.getDeliveryTip() + "원");
		System.out.println();
		System.out.println();
		
		menuName = menu.keySet();
		Iterator<String> it = menuName.iterator();
		
		while(it.hasNext()) {
			
			name = it.next();
			
			System.out.println(name);
			System.out.println(menu.get(name).getMenuPic() + "       " + menu.get(name).getMenuPrice());
			System.out.println();
			
			
			
		}
		
		
		
	}

}
