package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.HashMap;

public class Store implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5058103148712969047L;
	/**
	 * 
	 */
	
	private String storeName;
	private String storeIntroduce;
	private HashMap<String, Menu> storeMenu;
	private double aveStar;
	private int category;
	private int deliveryTip;
	private int deliveryTime;
	private String userId;
	private int aveStarNum;
		
	

	public Store(String storeName, String storeIntroduce, double aveStar, int category, int deliveryTip, HashMap<String, Menu> storeMenu) {
	      super();
	      this.storeName = storeName;
	      this.storeIntroduce = storeIntroduce;
	      this.aveStar = aveStar;
	      this.category = category;
	      this.deliveryTip = deliveryTip;
	      this.storeMenu = storeMenu;
	      
	   }
	
	



	public Store(String storeName, String storeIntroduce, HashMap<String, Menu> storeMenu, double aveStar, int category,
			int deliveryTip, int deliveryTime, String userId, int aveStarNum) {
		super();
		this.storeName = storeName;
		this.storeIntroduce = storeIntroduce;
		this.storeMenu = storeMenu;
		this.aveStar = aveStar;
		this.category = category;
		this.deliveryTip = deliveryTip;
		this.deliveryTime = deliveryTime;
		this.userId = userId;
		this.aveStarNum = aveStarNum;
	}





	public Store(String storeName, String storeIntroduce, int category, int deliveryTip,
			int deliveryTime, HashMap<String, Menu> storeMenu, String userId) {
		super();
		this.storeName = storeName;
		this.storeIntroduce = storeIntroduce;
		this.category = category;
		this.deliveryTip = deliveryTip;
		this.deliveryTime = deliveryTime;
		this.storeMenu = storeMenu;
		this.userId = userId;
		
	}





	public HashMap<String, Menu> getStoreMenu() {
		return storeMenu;
	}





	public void setStoreMenu(HashMap<String, Menu> storeMenu) {
		this.storeMenu = storeMenu;
	}



	private String storeAddress;
	
	
	
	public Store() {
		// TODO Auto-generated constructor stub
	}





	public Store(String storeName, String storeIntroduce, double aveStar, int category, int deliveryTip,
			int deliveryTime) {
		super();
		this.storeName = storeName;
		this.storeIntroduce = storeIntroduce;
		this.aveStar = aveStar;
		this.category = category;
		this.deliveryTip = deliveryTip;
		this.deliveryTime = deliveryTime;
	}







	public String getStoreName() {
		return storeName;
	}



	public String getStoreIntroduce() {
		return storeIntroduce;
	}



	public double getAveStar() {
		return aveStar;
	}



	public int getCategory() {
		return category;
	}



	public int getDeliveryTip() {
		return deliveryTip;
	}



	public int getDeliveryTime() {
		return deliveryTime;
	}



	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}



	public void setStoreIntroduce(String storeIntroduce) {
		this.storeIntroduce = storeIntroduce;
	}



	public void setAveStar(double aveStar) {
		this.aveStar = aveStar;
	}



	public void setCategory(int category) {
		this.category = category;
	}



	public void setDeliveryTip(int deliveryTip) {
		this.deliveryTip = deliveryTip;
	}



	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	


	public String getStoreAddress() {
		return storeAddress;
	}



	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}





	public String getUserId() {
		return userId;
	}





	public int getAveStarNum() {
		return aveStarNum;
	}





	public void setAveStarNum(int aveStarNum) {
		this.aveStarNum = aveStarNum;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	

}
