package com.projectGo.view;

import java.util.ArrayList;

import com.projectGo.model.vo.Store;

public class ChoiceResult {
	
	ArrayList<Store> printList;
	
	public void choiceResultMain(String resultName, ArrayList<Store> printList) {
		
		System.out.println(resultName);
		
		for (Store s : printList) {

			System.out.println(s.getStoreName() + "     " + s.getStoreIntoduce() + "      " + s.getDeliveryTip());

		}
		
	}

}
