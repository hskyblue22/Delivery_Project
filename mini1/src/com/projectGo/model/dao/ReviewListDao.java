package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.projectGo.model.vo.Order;
import com.projectGo.model.vo.Review;
import com.projectGo.view.MainFrame;

public class ReviewListDao {
	
	private ArrayList<Review> totalReview;
	private ArrayList<Review> userReview;
	private ArrayList<Review> otherReview;
	private Review review;
	String userID; 

	public ReviewListDao(Review review) {
		// TODO Auto-generated constructor stub
	}

	public ReviewListDao() {
		
	}

	public void loadReviewList() {
		totalReview = new ArrayList<Review>();
		userReview = new ArrayList<Review>();
		otherReview = new ArrayList<Review>();

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("review_list.txt"))){
			
//			totalReview.addAll((ArrayList<Review>)ois.readObject());  //주문내역담긴 파일 전체 orderlist에 담기
//			userID = MainFrame.loginUserId;
			userID = "temp1";
			
			Review r;
			while((r = (Review)ois.readObject()) != null) {
				
				totalReview.add(r);  //객체로 arraylist에 하나씩 담아줘야 함

				//여기 포문돌리면 안된다...나중에 또 봐서 실수하지 말자!
				if(r.getUserID().equals(userID)) {  //userid와 orderList에 있는 userid비교
					userReview.add(r);  //아이디 같으면 새로운 orderList에 담기
				}else {
					otherReview.add(r);
				}
				
			}
	
		}catch(EOFException e) {
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//userReview = null;  ==> 이렇게 해줄 필요없음
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e) {  //갑자기 nullpointerexception나서 추가함
			return;
		}
	}
 	
	public void writeReview(Review review) {
		//전달받은 게시글을 list 에 추가 --> 후 파일에 저장되도록

		if(userReview == null) {
			try {
				new File("review_list.txt").createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			loadReviewList();
			userReview.add(review);
			saveListFile(userReview);
			
		} else {
			userReview.add(review);
			saveListFile(userReview);
		}
		
	}
	
	public ArrayList<Review> userAllList(){
		//주문내역 list 를 전체 리턴
		loadReviewList();
		return userReview;
	}
	
	public ArrayList<Review> totalAllList(){
		//주문내역 list 를 전체 리턴
		return totalReview;
	}
	
	//'주문내역'에서 리뷰작성할때 
	//리뷰파일과, 전달된 (날짜,유저명,식당명,menus)와
	//같은리뷰없으면 -1(true) / 같은 리뷰있으면 리뷰인덱스 전달
	
	public int searchReview(String date, String userID, String storeName, String[] menus){
		loadReviewList();
		if(userReview.size() != 0) {
			for(int i=0; i<userReview.size(); i++) {
				if(userReview.get(i).getDate().equals(date) && userReview.get(i).getUserID().equals(userID) &&
						userReview.get(i).getStoreName().equals(storeName) && Arrays.equals(userReview.get(i).getMenus(), menus) ) {
					return i;  //작성된 리뷰 있는 경우 인덱스 반환
				}
			}
			return -1;  //유저리뷰가 있긴하지만 해당 리뷰 작성안된 경우
		}else {
			return -1;
		}
		
//		if(userReview != null) {  //이전에 작성된 userReview가 있는경우 같은 내용있는지 확인
//			
//			for(int i=0; i<userReview.size(); i++) {
//				if(userReview.get(i).getDate().equals(date) && userReview.get(i).getUserID().equals(userID) &&
//						userReview.get(i).getStoreName().equals(storeName) && Arrays.equals(userReview.get(i).getMenus(), menus) ) {
//					return i;
//				}
//			}
//			return 1;				
//		} else {  //이전에 작성된 userReview 없는 경우
//			return 1;
//		}
	}

//	public boolean searchReview(String date, String userID, String storeName, String[] menus){
//		
//		if(userReview != null) {  //이전에 작성된 userReview가 있는경우 같은 내용있는지 확인
//			for(Review r : userReview) {
//				if( r.getDate().equals(date) && r.getUserID().equals(userID) && 
//						r.getStoreName().equals(storeName) && Arrays.equals(r.getMenus(), menus)) {
//					return false;  //같은 거 발견하면 바로 false
//				}
//			}
//			return true;  //같은 리뷰 없었으므로 true(리뷰작성가능)
//				
//		} else {  //이전에 작성된 userReview 없는 경우
//			return true;
//		}
//	}
	
	
	
	public void deleteList(int no) {
		//주문내역 삭제 --> 후 파일에 저장되도록
		userReview.remove(no);
		saveListFile(userReview);
	}
	
	public void saveListFile(ArrayList<Review> userReview) {
		//"order_list.txt" 저장하기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("review_list.txt"))) {
			
			for(int i=0; i<userReview.size(); i++) {
				oos.writeObject(userReview.get(i));
			}
			for(int i=0; i<otherReview.size(); i++) {
				System.out.println(otherReview.size());  //왜 size가 1인거지?
				System.out.println(otherReview == null);
				oos.writeObject(otherReview.get(i));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//리뷰 수정
	public void modifyReview(Review review, int index) {
		loadReviewList();
		userReview.set(index, review);	
		saveListFile(userReview);
	}
	
}
