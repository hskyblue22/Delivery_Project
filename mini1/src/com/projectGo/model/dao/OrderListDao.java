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
	
	
	private ArrayList<Order> totalorderList = new ArrayList<Order>();
	private ArrayList<Order> userOrderList = new ArrayList<Order>();
	private ArrayList<Order> otherOrderList = new ArrayList<Order>();
	private String userID;
	
	public OrderListDao() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))){
			
			userID = MainFrame.loginUserId;
//			totalorderList.addAll((ArrayList<Order>)ois.readObject());  //주문내역담긴 파일 전체 orderlist에 담기
			
			while(true) {
				
				Order o;
				while( (o = (Order)ois.readObject()) != null ) {
					totalorderList.add(o);
					
					for(Order ol : totalorderList) {
						if(ol.getBasket().getUserId().equals(userID)) {
							userOrderList.add(ol);
						}else {
							otherOrderList.add(ol);
						}
					}
				}
				
				//totalorderList.add((Order)ois.readObject());

			}
			
//			while (true) {
//	            
//	            totalorderList.add((Order) ois.readObject());
//	            
////	            
//	            for(Order ol : totalorderList) {
//	               if(ol.getBasket().getUserId().equals(userID)) {  //userid와 orderList에 있는 userid비교
//	                  userOrderList.add(ol);  //아이디 같으면 새로운 orderList에 담기
//	               }else {
//	                  //otherOrderList.add(ol);
//	                  userOrderList.add(ol);
//	               }
//	            }
//	            
//	         }
			
		}catch(EOFException e) {
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			userOrderList = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e) {  //갑자기 nullpointerexception나서 추가함
			userOrderList = null;
		}
	}
	
//	public void userOtherList() {
//
//		for(Order ol : totalorderList) {
//			System.out.println(ol.toString());
//			System.out.println(ol.getBasket().getUserId());
//		}
//	}
	
	public ArrayList<Order> getOrderList() {
		return userOrderList;
	}


	public void writeOrder(Order order) {
		//전달받은 게시글을 list 에 추가
		userOrderList.add(order);
	}
	
	public ArrayList<Order> displayAllList(){
		//주문내역 list 를 전체 리턴
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
