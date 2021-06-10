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
import com.projectGo.view.MainFrame;

public class OrderListDao {
	
	private ArrayList<Order> totalorderList;
	private ArrayList<Order> userOrderList;
	private ArrayList<Order> otherOrderList;
	private String userID;
	
	public OrderListDao() {
		
	}
	
	public void loadOrderList() {
		
		totalorderList = new ArrayList<Order>();  //위에 해놓으면 부를때마다 생성하기때문에 불러올때 생성해주자
		userOrderList = new ArrayList<Order>();
		otherOrderList = new ArrayList<Order>();
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))) {

			// userID = MainFrame.loginID;
			userID = "temp1";
//			totalorderList.addAll((ArrayList<Order>)ois.readObject());  //주문내역담긴 파일 전체 orderlist에 담기

			while (true) {

				Order o;
				while ((o = (Order) ois.readObject()) != null) {
					totalorderList.add(o);

					if (o.getBasket().getUserId().equals(userID)) {  //여기서 for문 안된다!!
						userOrderList.add(o);
					} else
						otherOrderList.add(o);
				}

			}


		} catch (EOFException e) {
			return;
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) { // 갑자기 nullpointerexception나서 추가함
			return;
		}
	}
	
	
	public ArrayList<Order> getOrderList() {
		return userOrderList;
	}


	public void writeOrder(Order order) {
		//전달받은 게시글을 list 에 추가
		userOrderList.add(order);
	}
	
	public ArrayList<Order> displayAllList(){
		//주문내역 list 를 전체 리턴
		loadOrderList();
		return userOrderList;
	}
	
	public void deleteList(int no) {
		//주문내역 삭제
		userOrderList.remove(no);
	}
	
	public void saveListFile() {
		//"order_list.txt" 저장하기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order_list.txt"))) {

			//객체로 변환해서 하나하나 저장해야한다.
			for(int i=0; i<userOrderList.size(); i++) {
				oos.writeObject(userOrderList.get(i));
			}
			for(int i=0; i<otherOrderList.size(); i++) {
				oos.writeObject(otherOrderList.get(i));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<Order> totalOrderList() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))){
		totalorderList.addAll((ArrayList<Order>)ois.readObject()); 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return totalorderList;
	}
	
}
