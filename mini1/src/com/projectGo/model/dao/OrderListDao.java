package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.projectGo.model.vo.Order;

public class OrderListDao {
	
	private ArrayList<Order> orderList = new ArrayList<Order>();
	
	public OrderListDao() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))){
			
			orderList.addAll((ArrayList<Order>)ois.readObject());  //주문내역담긴 파일 전체 orderlist에 담기
			
			String userID = orderList.get(orderList.size()-1).getUserId();  //마지막으로 담긴 유저ID추출
			
			for(Order ol : orderList) {
				if(!ol.getUserId().equals(userID)) {  //마지막으로 담긴 userid와 orderList에 있는 userid비교
					orderList.remove(ol);  //아이디 다르면 orderList에서 삭제하기
				}
			}
			
			
		}catch(EOFException e) {
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
	
	public void writeOrder(Order order) {
		//전달받은 게시글을 list 에 추가
		orderList.add(order);
	}
	
	public ArrayList<Order> displayAllList(){
		//주문내역 list 를 전체 리턴
		return orderList;
	}
	
	public void deleteList(int no) {
		//주문내역 삭제
		orderList.remove(no);
	}
	
	public void saveListFile() {
		//"order_list.txt" 저장하기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order_list.txt"))) {
			oos.writeObject(orderList);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
