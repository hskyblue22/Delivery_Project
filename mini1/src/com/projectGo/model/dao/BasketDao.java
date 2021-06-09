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
	
	public BasketDao() {}
	
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
//			System.out.println(basket.getMenuList());

			
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

	
}
