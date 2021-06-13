package com.projectGo.model.dao;

import java.io.EOFException;
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 멤버리스트 저장
	public void memOutput(ArrayList<Member> memList) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.txt"))) {

			for (int i = 0; i < memList.size(); i++) {
				oos.writeObject(memList.get(i));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
