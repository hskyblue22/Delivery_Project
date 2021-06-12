package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.projectGo.model.vo.Member;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;
import com.projectGo.model.vo.Store;
import com.projectGo.view.MainFrame;

public class StoreDao {

	ArrayList<Store> storeList;
	
	
	public Member sellerInfo() {
		ArrayList<Member> memList;
		MemberDao md = new MemberDao();
		memList = md.fileInput();
		for(Member m : memList) {
			
			if(m.getNick().equals(MainFrame.loginUserId)) {
				
				return m;
				
			}
			
		}
		return null;
		
	}

	public void addStore(Store store) {

		loadStore();

		storeList.add(store);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store.txt"))) {

			for (int i = 0; i < storeList.size(); i++) {
				oos.writeObject(storeList.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadStore() {

		storeList = new ArrayList<Store>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("store.txt"))) {

			while (true) {
				storeList.add((Store) ois.readObject());
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
		}

	}

	public ArrayList<Store> load() {
		loadStore();
		return storeList;
	}

	public void saveAveStar(String storeName, int reviewScore) {
		int aveStarNum;
		ArrayList<Store> list;
		loadStore();
		double aveStar, dScore, dTemp, result;
		list = load();
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getStoreName().equals(storeName)) {

				aveStarNum = list.get(i).getAveStarNum();
				aveStar = list.get(i).getAveStar();

				dScore = reviewScore * 1.0;
				dTemp = ((aveStar * aveStarNum) + dScore) / (aveStarNum + 1);
				result = Double.valueOf(String.format("%.1f", dTemp));
				list.get(i).setAveStar(result);
				list.get(i).setAveStarNum(aveStarNum + 1);
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store.txt"))) {

					for (int j = 0; j < list.size(); j++) {

						oos.writeObject(list.get(j));

					}

				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}

				return;

			}

		}

	}

	public void deleteStore() {

		ArrayList<Store> storeList = new ArrayList<Store>();
		loadStore();

		load();

		for (int i = 0; i < storeList.size(); i++) {

			if (storeList.get(i).getUserId().equals(MainFrame.loginUserId)) {

				storeList.remove(i);
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store.txt"))) {

			for (int i = 0; i < storeList.size(); i++) {
				oos.writeObject(storeList.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public void putMenu(HashMap<String, Menu> otherMenu) {
		
		loadStore();

		load();
		
		
		
		
		
	}
}

