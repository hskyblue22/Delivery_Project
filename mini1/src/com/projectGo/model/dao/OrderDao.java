package com.projectGo.model.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.HashMap;

import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;


public class OrderDao {
	
	private Order order;
	
	public OrderDao() {}


	//order객체 저장 output
	public void orderOutput(Order order) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order_list.txt", true))) {
			
			oos.writeObject(order);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
