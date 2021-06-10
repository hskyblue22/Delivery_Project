package com.projectGo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.projectGo.model.dao.OrderListDao;
import com.projectGo.model.dao.StoreDao;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;
import com.projectGo.model.vo.Store;
import com.projectGo.view.MainFrame;

public class SellerController {

	List<Store> storeList = new ArrayList<Store>();
	HashMap<String, Menu> menuList = new HashMap<String, Menu>();
	StoreDao sd = new StoreDao();
	HashMap<String, Menu> newMenu = new HashMap<String, Menu>();

	public void menuCreator(String menuName, String menuPic, int menuPrice) {
		

		Store beforeStore = null;

		for (int i = 0; i < sd.loadStore().size(); i++) {

			if (MainFrame.loginUserId.equals(sd.loadStore().get(i).getUserId())) {
				beforeStore = sd.loadStore().get(i);

			}
		} // 내 아이디에 해당되는 가게 정보불러오기

		String storeName = beforeStore.getStoreName();
		String storeIntroduce = beforeStore.getStoreIntroduce();
		double aveStar = beforeStore.getAveStar();
		int category = beforeStore.getCategory();
		int deliveryTip = beforeStore.getDeliveryTip();
		int deliveryTime = beforeStore.getDeliveryTime();
		int aveStarNum = beforeStore.getAveStarNum();
		HashMap newMenuList = beforeStore.getStoreMenu();
		
		newMenuList.put(menuName, new Menu(menuPic, menuPrice)); // 메뉴 리스트에 메뉴 객체 담기

		Store newStore = new Store(storeName, storeIntroduce, newMenuList, aveStar, category, deliveryTip, deliveryTime,
				MainFrame.loginUserId, aveStarNum);
		sd.addStore(newStore);

	}

	public void StoreCreator(String storeName, String storeIntroduce, int category, int deliveryTip, int deliveryTime) {

		Store store = new Store(storeName, storeIntroduce, category, deliveryTip, deliveryTime, menuList,
				MainFrame.loginUserId); // 새 스토어 객체 생성
		storeList.add(store); // ArrayList에 추가

		sd.addStore(store);
		// dao로 이동

	}

	public ArrayList<Order> loadSellerOrder() {

		String myStore = null;
		ArrayList sellerOrder = new ArrayList();

		// 가게 목록에서 내 가게 호출
		for (int i = 0; i < sd.loadStore().size(); i++) {
			if (sd.loadStore().get(i).getUserId().equals(MainFrame.loginUserId)) {
				myStore = sd.loadStore().get(i).getStoreName();
			}

		}

		// 주문 목록에서 가게 이름과 대조 , 해당하는 주문만 불러옴

		OrderListDao old = new OrderListDao();

		for (int i = 0; i < old.totalOrderList().size(); i++) {
			if (myStore.equals(old.totalOrderList().get(i).getStoreName())) {

				sellerOrder.add(old.totalOrderList().get(i));
			}

		}

		return sellerOrder;

	}

	public boolean checkStore() {

		boolean check = false;

		for (int i = 0; i < sd.loadStore().size(); i++) {

			if (MainFrame.loginUserId.equals(sd.loadStore().get(i).getUserId())) {
				check = true;

			}
		}
		return check;
	}

	public Store myStoreLoad() {

		Store myStore = null;

		for (int i = 0; i < sd.loadStore().size(); i++) {

			if (MainFrame.loginUserId.equals(sd.loadStore().get(i).getUserId())) {
				myStore = sd.loadStore().get(i);

			}
		}

		return myStore;

	}

	public void storeModify(String storeName, String storeIntroduce, int category, int deliveryTip, int deliveryTime) {

		Store beforeStore = null;

		for (int i = 0; i < sd.loadStore().size(); i++) {

			if (MainFrame.loginUserId.equals(sd.loadStore().get(i).getUserId())) {
				beforeStore = sd.loadStore().get(i);

			}
		} // 내 아이디에 해당되는 가게 정보불러오기

		HashMap<String, Menu> menu = beforeStore.getStoreMenu(); // 해당 가게 메뉴 리스트 옮겨 담기
		double aveStar = beforeStore.getAveStar();
		int aveStarNum = beforeStore.getAveStarNum();

		sd.deleteStore();// 기존 가게 정보 파일에서 삭제

		Store newStore = new Store(storeName, storeIntroduce, menu, aveStar, category, deliveryTip, deliveryTime,
				MainFrame.loginUserId, aveStarNum);
		// 기존 메뉴 + 별점 넣은 스토어 객체 생성
		storeList.add(newStore);

		sd.addStore(newStore); // 새로운 가게 dao로 옮겨 파일에 담기

	}

	public void menuModify(String menuName, String menuPic, int menuPrice) {

		newMenu.put(menuName, new Menu(menuPic, menuPrice));

		// newMenu HashMap에 객체 넣기

	}

	public void menuFileModify() {

		Store beforeStore = null;

		for (int i = 0; i < sd.loadStore().size(); i++) {

			if (MainFrame.loginUserId.equals(sd.loadStore().get(i).getUserId())) {
				beforeStore = sd.loadStore().get(i);

			}
		} // 내 아이디에 해당되는 가게 정보불러오기

		String storeName = beforeStore.getStoreName();
		String storeIntroduce = beforeStore.getStoreIntroduce();
		double aveStar = beforeStore.getAveStar();
		int category = beforeStore.getCategory();
		int deliveryTip = beforeStore.getDeliveryTip();
		int deliveryTime = beforeStore.getDeliveryTime();
		int aveStarNum = beforeStore.getAveStarNum();

		Store newStore = new Store(storeName, storeIntroduce, newMenu, aveStar, category, deliveryTip, deliveryTime,
				MainFrame.loginUserId, aveStarNum);
		sd.addStore(newStore);

	}

	public int categorySelect(String c1) {

		int num = 0;

		if (c1.equals("한식")) {
			num = 1;
		} else if (c1.equals("중식")) {
			num = 2;
		} else if (c1.equals("일식")) {
			num = 3;
		} else if (c1.equals("양식")) {
			num = 4;
		} else if (c1.equals("식")) {
			num = 5;
		} else if (c1.equals("디저트")) {
			num = 6;
		} else if (c1.equals("치킨")) {
			num = 7;
		} else if (c1.equals("피자")) {
			num = 8;
		} else if (c1.equals("패스트푸드")) {
			num = 9;
		}

		return num;

	}

}
