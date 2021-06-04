package com.projectGo.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.projectGo.controller.CategoryChoice;
import com.projectGo.controller.StoreSort;
import com.projectGo.model.dao.StoreLoad;
import com.projectGo.model.vo.Store;

public class CategoryChoiceView {

	ArrayList<Store> mainList;

	public void categoryMain() {
		int choiceNum;
		String categoryName;

		ArrayList<Store> printList;
		mainList = new StoreLoad().storeLoad();
		Store topStore = new StoreSort().topStore(mainList);
		Scanner sc = new Scanner(System.in);

		System.out.println(
				topStore.getStoreName() + "     " + topStore.getStoreIntroduce() + "      " + topStore.getDeliveryTip());

		System.out.println();
		System.out.println("===카테고리 선택===");
		System.out.println();
		System.out.println("1. 카테고리1");
		System.out.println("2. 카테고리2");
		System.out.println("3. 카테고리3");
		System.out.println("4. 카테고리4");
		System.out.println("5. 카테고리5");
		System.out.println("6. 카테고리6");
		System.out.println("7. 카테고리7");
		System.out.println("8. 카테고리8");
		System.out.println("9. 카테고리9");
		System.out.println();
		System.out.println("메뉴 번호 : ");
		choiceNum = sc.nextInt();
		sc.nextLine();
		categoryName = choiceNum + " 카테고리이름";
		printList = new CategoryChoice().categorySelect(mainList, choiceNum);

		new ChoiceResult().choiceResultMain(categoryName, printList);

	}

}
