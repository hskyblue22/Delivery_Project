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
		
		totalorderList = new ArrayList<Order>();  
		userOrderList = new ArrayList<Order>();
		otherOrderList = new ArrayList<Order>();
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))) {

			userID = MainFrame.loginUserId;

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
//			totalorderList.addAll((ArrayList<Order>)ois.readObject());  //주문내역담긴 파일 전체 orderlist에 담기
			
//			for(Order ol : totalorderList) {  //이렇게 포문돌리면 계속 들어가는 거니까 다음에는 잘 생각하자_06.10
//				if(ol.getBasket().getUserId().equals(userID)) {
//					userOrderList.add(ol);
//				}else {
//					otherOrderList.add(ol);
//				}
//			}

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

	
	public ArrayList<Order> displayAllList(){
		//주문내역 list 를 전체 리턴
		loadOrderList();  //생성자에서 로드하는거 삭제했으니까 파일불러줘야 함_06.10
		return userOrderList;
	}
	
	public ArrayList<Order> orderTotalList(){ 
		loadOrderList();
		return totalorderList;
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

	
	public void saveOrderState(ArrayList<Order> list) {
		//"order_list.txt" 저장하기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order_list.txt"))) {

			//객체로 변환해서 하나하나 저장해야한다.
			for(int i=0; i<list.size(); i++) {
				oos.writeObject(list.get(i));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
