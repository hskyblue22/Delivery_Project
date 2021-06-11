package com.projectGo.controller;


import java.util.ArrayList;
import java.util.Collections;

import com.projectGo.model.comparator.DscAveStar;
import com.projectGo.model.vo.Store;


public class StoreSortController {
	
	public ArrayList<Store> recommendStore(ArrayList<Store> list) {
 
		ArrayList<ArrayList<Store>> temp = new ArrayList<ArrayList<Store>>();
		ArrayList<Store> recommendStoreList = new ArrayList<Store>();

		for (int i = 0; i < 10; i++) {

			temp.add(new ArrayList<Store>());
 
		}

		for (int i = 0; i < list.size(); i++) {
			temp.get(list.get(i).getCategory()).add(list.get(i));
		}

		for (int i = 1; i < 10; i++) {

			Collections.sort(temp.get(i), new DscAveStar());
			if (temp.get(i).size() > 0) {
				recommendStoreList.add(temp.get(i).get(0));
			}
		}
		return recommendStoreList;

	}
	
	public Store topStore(ArrayList<Store> list) {


		Collections.sort(list, new DscAveStar());
		return list.get(0);
		

	}

}
