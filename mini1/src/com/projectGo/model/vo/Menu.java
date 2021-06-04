package com.projectGo.model.vo;

import java.io.Serializable;

public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5964507749319240947L;
	private String menuName;
	private String menuPic;
	private int menuPrice;
	private int quantity;
	
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public Menu(String menuPic, int menuPrice, int quantity) {
	      super();
	      this.menuPic = menuPic;
	      this.menuPrice = menuPrice;
	      this.quantity = quantity;
	   }

	
	
	   public Menu(String menuPic, int menuPrice) {
		      super();
		      this.menuPic = menuPic;
		      this.menuPrice = menuPrice;
		   }
	   
	   

	public Menu(String menuName, String menuPic, int menuPrice, int quantity) {
		super();
		this.menuName = menuName;
		this.menuPic = menuPic;
		this.menuPrice = menuPrice;
		this.quantity = quantity;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuPic() {
		return menuPic;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}