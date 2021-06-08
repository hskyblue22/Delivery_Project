package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.HashMap;

public class Review implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7875004323390829502L;
	
	private String userID;
	private String date;
	private String storeName;
    private String[] menus;  //메뉴이름 + 메뉴가격
	private int score;
	private String contents;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	//리뷰작성완료 -> 객체저장
	public Review(String date, String userID, String storeName, String[] menus, int reviewScore,
			String reviewContents) {
		this.date =date;
		this.userID = userID;
		this.storeName = storeName;
		this.menus = menus;
		this.score = reviewScore;
		this.contents = reviewContents;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String[] getMenus() {
		return menus;
	}

	public void setMenus(String[] menus) {
		this.menus = menus;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
