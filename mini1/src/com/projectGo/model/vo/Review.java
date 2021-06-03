package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.HashMap;

public class Review implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7875004323390829502L;
	private String userName;
	private String userImage;
	private HashMap<String,Object> menu = new HashMap<>();  //object->메뉴,수량
	private int score;
	private String contents;
	
	
	
	
	
	
}
