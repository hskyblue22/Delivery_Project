package com.projectGo.model.dao;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.projectGo.model.vo.Store;


public class StoreLoad {
	
	public ArrayList<Store> storeLoad() {

		ArrayList<Store> list = new ArrayList<Store>();


		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("store.txt"))) {
			while (true) {
				list.add((Store) ois.readObject());

			}

		} catch (EOFException e) {
			System.out.println("읽기 완료.");
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
		return list;

	}

}
