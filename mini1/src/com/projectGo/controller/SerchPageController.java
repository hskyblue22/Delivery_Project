package com.projectGo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import java.util.Set;

import com.projectGo.model.comparator.AscDeliveryTip;
import com.projectGo.model.dao.DaoTemp;
import com.projectGo.model.vo.Member;
import com.projectGo.model.vo.Store;
import com.projectGo.view.MainFrame;

public class SerchPageController {

	public ArrayList<Store> serchStoreName(ArrayList<Store> list, String keyWord) {
		ArrayList<Store> temp = new ArrayList<Store>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getStoreName().contains(keyWord)) {

				temp.add(list.get(i));
			}

		}
		Collections.sort(temp, new AscDeliveryTip());

		return temp;
 
	}

	public ArrayList<Store> serchMenu(ArrayList<Store> list, String keyWord) {

		ArrayList<Store> temp = new ArrayList<Store>();
		Set<String> menuName;

		for (int i = 0; i < list.size(); i++) {

			menuName = list.get(i).getStoreMenu().keySet();
			Iterator<String> it = menuName.iterator();
			while (it.hasNext()) {

				if (it.next().contains(keyWord)) {

					temp.add(list.get(i));

				}

			}

		}
		Collections.sort(temp, new AscDeliveryTip());

		return temp;

	}

	public void serchKeywordSave(Member member, String serchList, String serchNum) {
		Member tempMember;
		DaoTemp dt = new DaoTemp();
		ArrayList<String> preSerchNum, preSerchList;
		ArrayList<String> temp1, temp2;
		temp1 = new ArrayList<String>();
		temp2 = new ArrayList<String>();
		tempMember = member;
		preSerchNum = tempMember.getPreSerchNum();
		preSerchList = tempMember.getPreSerchList();
		preSerchNum.add(0, serchNum);
		preSerchList.add(0, serchList);
		if (preSerchNum.size() > 5) {

			temp1.addAll(preSerchNum.subList(0, 5));
			preSerchNum = temp1;
			temp2.addAll(preSerchList.subList(0, 5));
			preSerchList = temp2;

		}
		dt.memberSave(preSerchList, preSerchNum);

	}
}
