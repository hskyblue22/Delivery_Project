package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.projectGo.model.vo.Member;
import com.projectGo.model.vo.Order;


public class OrderDao {
	
	
	private ArrayList<Order> ordList = new ArrayList<Order>();
	private ArrayList<Member> memList = new ArrayList<Member>();  //전체 멤버리스트
	
	public OrderDao() {}
	
	
	//order객체 ArrayList에 담기
	public void orderInput() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))) {
			
			while(true) {
				ordList.add((Order)ois.readObject());
			}
			
		} catch (EOFException e) {
				return;
		} catch (FileNotFoundException e) {
			
			
//			//파일이 없을경우 파일 생성 , 맨 첫 주문일 경우
//			try {
//				new File("order_list.txt").createNewFile();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} 
			System.out.println("파일 생성");
			return;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public  ArrayList<Order> getOrderList() {
		return ordList;
	}
	
	
	//추가된 order객체 ArrayList에 담아서 output
	public void orderOutput(Order order) {
		int sNum = (int)(Math.random() * 100000000);
		order.setsNum(sNum);
		orderInput();
		ordList.add(order);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order_list.txt"))) {

			for(int i = 0; i < ordList.size(); i++) {
				oos.writeObject(ordList.get(i));
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//이부분 memberDao랑 공유가능?*************************************************************
	
	// 유저파일 오픈
	public void memInput() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".txt"))) {

			while (true) {
				memList.add((Member) ois.readObject());
			}

		} catch (EOFException e) {
			return;
		} catch (FileNotFoundException e) {
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
	
	
	// 유저리스트 저장
	public void memOutput(ArrayList<Member> memList) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".txt"))) {

			for (int i = 0; i < memList.size(); i++) {
				oos.writeObject(memList.get(i));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public ArrayList<Member> getMemList() {
		
		return memList;
	}
	
}
