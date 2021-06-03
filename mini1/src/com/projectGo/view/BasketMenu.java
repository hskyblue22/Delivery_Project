package com.projectGo.view;

import java.util.Scanner;

import com.projectGo.controller.BasketController;

public class BasketMenu {
	
	private BasketController basCont = new BasketController();
	private Scanner sc = new Scanner(System.in);
	
	public BasketMenu() {}
	
	public void mainMenu() {
		
		System.out.println("======장바구니======");
		basCont.selectedMenu();
		System.out.println("1. 메뉴추가하기");
		System.out.println("2. 메뉴 삭제");
		System.out.println("3. 전체 삭제");
		System.out.println("4. 메뉴 수량 변경");
		System.out.println("5. 주문하기");
		System.out.println("6. 이전으로 돌아가기(홈)");
		
		System.out.print("메뉴 선택 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		case 1: System.out.println("");
		}
		
	}
	
}
