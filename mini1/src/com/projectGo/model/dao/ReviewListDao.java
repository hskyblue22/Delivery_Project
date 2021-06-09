package com.projectGo.model.dao;

import java.io.EOFException;
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
	
	private ArrayList<Review> totalReview = new ArrayList<Review>();
	private ArrayList<Review> userReview = new ArrayList<Review>();
	private ArrayList<Review> otherReview = new ArrayList<Review>();
	private Review review;

	public ReviewListDao(Review review) {
		// TODO Auto-generated constructor stub
	}


	public ReviewListDao() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("review_list.txt"))){
			
			totalReview.addAll((ArrayList<Review>)ois.readObject());  //주문내역담긴 파일 전체 orderlist에 담기

			String userID = MainFrame.loginUserId; 
			
			for(Review r : totalReview) {
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
			userReview = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e) {  //갑자기 nullpointerexception나서 추가함
			userReview = null;
		}
	}

	
	public void writeReview(Review review) {
		//전달받은 게시글을 list 에 추가 --> 후 파일에 저장되도록
		userReview.add(review);
		saveListFile();
	}
	
	public ArrayList<Review> userAllList(){
		//주문내역 list 를 전체 리턴
		return userReview;
	}
	
	public ArrayList<Review> totalAllList(){
		//주문내역 list 를 전체 리턴
		return totalReview;
	}
	
	//'주문내역'에서 리뷰작성할때 
	//리뷰파일과, 전달된 (날짜,유저명,식당명,menus)와
	//같은리뷰없으면 1(true) / 같은 리뷰있으면 리뷰인덱스 전달
	
	public int searchReview(String date, String userID, String storeName, String[] menus){
		
		if(userReview != null) {  //이전에 작성된 userReview가 있는경우 같은 내용있는지 확인
			
			for(int i=0; i<userReview.size(); i++) {
				if(userReview.get(i).getDate().equals(date) && userReview.get(i).getUserID().equals(userID) &&
						userReview.get(i).getStoreName().equals(storeName) && Arrays.equals(userReview.get(i).getMenus(), menus) ) {
					return i;
				}
			}
			return 1;				
		} else {  //이전에 작성된 userReview 없는 경우
			return 1;
		}
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
		saveListFile();
	}
	
	public void saveListFile() {
		//"order_list.txt" 저장하기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("review_list.txt"))) {
			
			//다시 저장
			oos.writeObject(userReview);  
			oos.writeObject(otherReview);
			
			
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
		userReview.set(index, review);		
	}
	
}
