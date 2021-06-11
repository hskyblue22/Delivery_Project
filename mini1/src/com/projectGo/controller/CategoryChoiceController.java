package com.projectGo.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.projectGo.model.comparator.AscDeliveryTip;
import com.projectGo.model.vo.Store;

public class CategoryChoiceController {


	public ArrayList<Store>  categorySelect(ArrayList<Store> list, int choiceNum) {
		ArrayList<Store> temp = new ArrayList<Store>();
		
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getCategory() == choiceNum) {

				temp.add(list.get(i));

			}
 
		}
		Collections.sort(temp, new AscDeliveryTip());
		
		return temp;
		

	}

}
