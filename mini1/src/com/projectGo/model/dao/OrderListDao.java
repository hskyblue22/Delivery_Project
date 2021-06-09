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
	private Member m;
	
	
	public OrderListDao() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))){
			
			totalorderList.addAll((ArrayList<Order>)ois.readObject());  //주문내역담긴 파일 전체 orderlist에 담기

			String userID = MainFrame.loginUserId;
			
			for(Order ol : totalorderList) {
				if(ol.getUserId().equals(userID)) {  //userid와 orderList에 있는 userid비교
					userOrderList.add(ol);  //아이디 같으면 새로운 orderList에 담기
				}else {
					otherOrderList.add(ol);
				}
			}
			
			
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
	
	
	public ArrayList<Order> getOrderList() {
		return userOrderList;
	}



	public void setOrderList(ArrayList<Order> orderList) {
		this.userOrderList = userOrderList;
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
			
			//다시 저장
			oos.writeObject(userOrderList);  
			oos.writeObject(otherOrderList);
			
			
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
