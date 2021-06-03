package com.projectGo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.projectGo.controller.SerchPage;
import com.projectGo.controller.StoreSort;
import com.projectGo.model.dao.StoreLoad;
import com.projectGo.model.vo.Store;

public class SerchPageView {

	ArrayList<String> temp = new ArrayList<String>();
	{
		temp.add("짬뽕");
		temp.add("햄버거");
		temp.add("bbq 명동");
		temp.add("엽떡");
		temp.add("황금 올리브");

	}

	ArrayList<String> preSerchList;
	ArrayList<Store> mainList;
	Scanner sc = new Scanner(System.in);

	public void serchMain() {
		String keyWord;
		int choiceNum;
		preSerchList = temp;
		mainList = new StoreLoad().storeLoad();
		ArrayList<Store> printList;
		for (Store s : new StoreSort().recommendStore(mainList)) {

			System.out.println(s.getStoreName() + "     " + s.getStoreIntoduce() + "      " + s.getDeliveryTip());

		}

		System.out.println("이전 검색어");
		for (String str : preSerchList) {

			System.out.print(str + "           ");

		}
		System.out.println();
		System.out.println("검색할 종류 선택 1. 메뉴 2. 음식점이름");
		choiceNum = sc.nextInt();
		sc.nextLine();

		System.out.println("검색할 키워드를 입력하세요 : ");
		keyWord = sc.nextLine();
		
		preSerchList.add(0, keyWord);
		if (preSerchList.size() > 5) {
			ArrayList<String> tempList;
			tempList = new ArrayList<String>(preSerchList.subList(0, 5));
			preSerchList = tempList;
		}

		System.out.println(preSerchList);

		if (choiceNum == 1) {

			printList = new SerchPage().serchMenu(mainList, keyWord);
			
			new ChoiceResult().choiceResultMain("'" + keyWord +"' 검색결과", printList);

			
		} else {

			printList = new SerchPage().serchStoreName(mainList, keyWord);
			
			new ChoiceResult().choiceResultMain("'" + keyWord +"' 검색결과", printList);

			

		}

	

	}

}
