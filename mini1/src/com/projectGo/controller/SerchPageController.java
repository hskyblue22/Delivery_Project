package com.projectGo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import java.util.Set;

import com.projectGo.model.comparator.AscDeliveryTip;
import com.projectGo.model.vo.Store;

public class SerchPageController {

	

	public ArrayList<Store> serchStoreName(ArrayList<Store> list, String keyWord) {
		ArrayList<Store> temp = new ArrayList<Store>();
		
		
		for(int i = 0 ; i < list.size() ; i++) {
			
			
			
				if(list.get(i).getStoreName().contains(keyWord)) {
					
					temp.add(list.get(i));
				}
			
			
		}
		Collections.sort(temp, new AscDeliveryTip());
		
		return temp;
		
		
		
	}

	public ArrayList<Store> serchMenu(ArrayList<Store> list, String keyWord) {
		
		ArrayList<Store> temp = new ArrayList<Store>();
		Set<String> menuName;
		
		for(int i = 0 ; i < list.size() ; i++) {
			
			menuName = list.get(i).getStoreMenu().keySet();
			Iterator<String> it = menuName.iterator();
			while(it.hasNext()) {
				
				if(it.next().contains(keyWord)) {
					
					temp.add(list.get(i));
					
				}
				
			}
			
		}
		Collections.sort(temp, new AscDeliveryTip());
		
		return temp;
		
		
		
	}
}
