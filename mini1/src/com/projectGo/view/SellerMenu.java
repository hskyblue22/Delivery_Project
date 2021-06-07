package com.projectGo.view;

import java.util.Scanner;

import com.projectGo.controller.MenuController;
import com.projectGo.controller.SellerController;

public class SellerMenu {
	
	Scanner sc = new Scanner(System.in);
	SellerController stc = new SellerController();
	MenuController mc = new MenuController();
	
	public void SellerMain() {
		
		while(true) {
			
			
			
			System.out.println("메인메뉴");
			System.out.println("1. 가게 등록");
			System.out.println("2. 주문 확인");
			System.out.println("3. 개인정보조회");
			
			int num = sc.nextInt();
			
			switch (num) {
			case 1 : 
				addStore();
				break;
			case 2: 
				checkOrder();
				break;
			case 3 : 
				//개인정보조회
				break;
				
					
			
			}
			
			
			
			
			
		}
		
		
	}

	private void checkOrder() {
		 
		
		
	}

	private void addStore() {
		
		System.out.println("가게 이름: ");
		sc.nextLine();
		String storeName = sc.nextLine();
		
		System.out.println("가게 소개: ");
		String storeIntroduce = sc.nextLine();
		
		System.out.println("카테고리: ");
		int category = sc.nextInt();
		
		System.out.println("배달팁: ");
		int deliveryTip = sc.nextInt();
		sc.nextLine();
		
		System.out.println("배달 시간: ");
		int deliveryTime = sc.nextInt();
		sc.nextLine();
		
		stc.StoreCreator(storeName, storeIntroduce, category, deliveryTip, deliveryTime);
		
		
		
		System.out.println("===등록완료, 메뉴등록===");
		
		
		while(true) {
		System.out.println("메뉴 이름: ");
		String menuName = sc.nextLine();
		
		System.out.println("메뉴 사진: ");
		String menuPic = sc.nextLine();
		
		System.out.println("메뉴 가격: ");
		int menuPrice = sc.nextInt();
		sc.nextLine();
		
		stc.menuCreator(menuName, menuPic, menuPrice);
		
		System.out.println(" 계속 등록? ");
		char check = sc.nextLine().charAt(0);
		
		if(check == 'n') {
			break;
		}
		
		
		
		//변수들 controller로 넘겨서 객체화 
		
		
		}
		
	}

}
