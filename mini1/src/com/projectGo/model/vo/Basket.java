package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.HashMap;

public class Basket implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String storeName;
	private String storeAddress;
	private int deliveryTip;
	private HashMap<String, Menu> menuList;

	
	public Basket() {}
	
	public Basket(String userId, String storeName, String storeAddress, int deliveryTip, HashMap<String, Menu> menuList) {
		super();
		this.userId = userId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.deliveryTip = deliveryTip;
		this.menuList = menuList;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public int getDeliveryTip() {
		return deliveryTip;
	}

	public void setDeliveryTip(int deliveryTip) {
		this.deliveryTip = deliveryTip;
	}
	

	public HashMap<String, Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(HashMap<String, Menu> menuList) {
		this.menuList = menuList;
	}

	
	@Override
	public String toString() {
		return "Basket [userId=" + userId + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", deliveryTip=" + deliveryTip + ", menuList=" + menuList + "]";
	}
	
	
}
