package com.projectGo.controller;

import java.util.ArrayList;

import com.projectGo.model.dao.ReviewListDao;
import com.projectGo.model.vo.Review;

public class ReviewListController {

	private ReviewListDao redao = new ReviewListDao();

	
	public ReviewListController() {
		// TODO Auto-generated constructor stub
	}
		
	public ArrayList<Review> userAllList(){
		
		return redao.userAllList();		
	}
	
	
	public ArrayList<Review> totalAllList(){
		
		return redao.userAllList();		
	}

	public void writeReview(Review review) {
		
		redao.writeReview(review);
		
//		if( redao.userAllList() == null) {
//			
//			redao.firstWriteReview(review);
//		}else {
//			redao.writeReview(review);
//		}
	}
	
	public void deleteReview(int index) {

		redao.deleteList(index);

	}

	
//
//	public void saveListFile() {
//		// BoardDao의 saveListFile()의 메소드 호출
//		redao.saveListFile();
//	}


	public void modifyReview(Review review, int index) {
		redao.modifyReview(review, index);
		
	}
	
}
