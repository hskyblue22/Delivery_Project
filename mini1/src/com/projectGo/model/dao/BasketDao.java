package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;


public class BasketDao {
	
	private Basket basket;
	
	public BasketDao() {
		
//		HashMap<String, Menu> m1 = new HashMap<String, Menu>();
//		m1.put("스테이크", new Menu("메뉴사진자리", 55000, 1));
//		m1.put("오일파스타", new Menu("메뉴사진자리", 20000, 2));
//		m1.put("투움바파스타", new Menu("메뉴사진자리", 15000, 1));
//		m1.put("치킨샐러드", new Menu("메뉴사진자리", 12000, 2));
//		
//		basket = new Basket("temp1", "아웃백","서울시 강남구",3000, m1);
		
	}
	
	// 장바구니 담기 하고 장바구니를 누르면 basket객체 전달
	public BasketDao(Basket basket) {
		this.basket = basket;
	}
	
	public void fileOutput() {
		
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("basket.txt"))) {
			
			oos.writeObject(basket);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void fileInput() {
		
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("basket.txt"))) {
			
			basket = (Basket)(ois.readObject());
			System.out.println(basket.getMenuList());

			
		}catch(EOFException e) {
			System.out.println("파일읽기 완료");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public Basket getBasket() {
		return basket;
	}
	

	public HashMap<String, Menu> getMenuList() {  //NullPointerException
		
		return basket.getMenuList();   
	}

	
	//삭제할 메뉴명 받아 삭제
	public void deleteBasketMenu(String menuName) {
		
		basket.getMenuList().remove(menuName);
		
	}

	
	//전체 삭제
	public void deleteAll() {
		
		basket.getMenuList().clear();
	}
	

	//메뉴명 받아 수량 변경
	public void modifyQuantity(String name, int modifyQuantity) {
		
		basket.getMenuList().get(name).setQuantity(modifyQuantity);
		
	}

	//주문 클릭하면 장바구니 객체 넘겨주기
	public void basketOrder() {
		
		new OrderDao(new Order(basket));
	}
	
	
	//주문 클릭하면 장바구니 객체 넘겨주기
//	public Order basketOrder() {
//
//		return new Order(basket);
//	}
	
}
