package com.projectGo.view;

import java.awt.Color;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.projectGo.controller.BasketController;
import com.projectGo.model.dao.BasketDao;
import com.projectGo.model.vo.Menu;

public class BasketView {
	
	private BasketController basCont = new BasketController();
	private Scanner sc = new Scanner(System.in);
	
	public BasketView() {
//		super("장바구니");
//		
//		this.setResizable(false);
//		this.setSize(550, 800);
//		this.setLocationRelativeTo(null); 
//		
//		BasketDao basDao = new BasketDao();
//		
//		if(basDao.getBasket() == null) { 
//			
//			JPanel panel1 = new JPanel();
//			panel1.setBackground(Color.white);
//			
//			
//			JLabel lable1 = new JLabel("장바구니");
//			
//			
//			JButton preButton = new JButton("이전");
//			preButton.setBounds(15, 20, 80, 40);
//			preButton.setSize(80, 40);
//			preButton.setBackground(Color.orange);
//			preButton.setForeground(Color.white);
//			
//			this.add(preButton);
//			this.add(lable1);
//			this.add(panel1);
//			
//			
//		}else {
//		
//			
//		}
//		
//		this.setVisible(true);
//		//this.dispose();  다른 화면 호출시 닫기 
		
	}
	
	public void mainMenu() {
		
		
		System.out.println("======장바구니======");
		
		Entry<String, Menu> entry = basCont.selectedMenu();
		System.out.println("메뉴명 : " + entry.getKey() + "\n가격 : " + entry.getValue().getMenuPrice());
		System.out.println(entry.getValue().getQuantity());
		
		
		System.out.println("1. 메뉴추가하기");
		
		StoreInfoView stoInfoView = new StoreInfoView();
		stoInfoView.start();
		
		System.out.println("2. 메뉴 삭제");
		System.out.println("3. 전체 삭제");
		System.out.println("4. 메뉴 수량 변경");
		System.out.println("5. 주문하기");
		System.out.println("6. 이전으로 돌아가기(홈)");
		
		System.out.print("메뉴 선택 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		case 1: /*메뉴상세페이지();*/ break;
		case 2: basCont.deleteBasketMenu(deleteMenu()); break;
		case 3: basCont.deleteAll(); break;
		case 4: modifyQuantity(); break;
		case 5: basCont.order(); break;
		case 6: /*homeView();*/ break;
		default: System.out.println("다시 입력하세요."); break;
		}
		
	}


	private String deleteMenu() {
		System.out.print("메뉴명 : ");
		String inputMenu = sc.nextLine();
		
		return inputMenu;
	}
	
	
	private void modifyQuantity() {
		
		System.out.print("메뉴명 : ");
		String inputMenu = sc.nextLine();
		
		System.out.println("변경 수량 : ");
		int quantity = sc.nextInt();
		
		basCont.modifyQuantity(inputMenu, quantity);
		
	}
	
	
}
