package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.projectGo.model.vo.Store;

public class StoreDao {
	

	public void addStore(Store store) {
		
		try { //ObjectOutputStream을 통해 전달받은 store 객체를 store.txt에 추가 
			ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("store.txt", true));
			oos.writeObject(store);
			

			
			oos.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Store> loadStore() {
		
		ArrayList<Store> store = new ArrayList<Store>();


		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("store.txt"))) {
			while (true) {
				store.add((Store) ois.readObject());

			}

		} catch (EOFException e) {
			// TODO: handle exception
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return store;

		
		
		
		
	}

}
