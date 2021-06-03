package com.projectGo.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OrderListDao {

private ArrayList<Order> orderList = new ArrayList<Order>();
	
	public OrderListDao() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order_list.txt"))) {
			
			orderList.addAll((ArrayList<Order>)ois.readObject());
	
		}

	public void writeOrder(Order order) {
		//전달받은 게시글을 list 에 추가
		orderList.add(order);
	}
	
	public ArrayList<order> displayAllList(){
		//주문내역 list 를 전체 리턴
		return orderList;
	}


	public void deleteOrder(int no) {
		//주문내역 삭제
		orderList.remove(no);
	}

	public void saveListFile() {
		//board_list.dat 파일 저장하기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order_list.txt"))) {
			
			oos.writeObject(orderList);
			System.out.println("order_list.txt 에 저장되었습니다.");

	}
}
