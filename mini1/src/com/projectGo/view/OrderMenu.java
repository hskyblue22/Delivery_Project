package com.projectGo.view;

import java.util.Scanner;

import com.projectGo.controller.OrderController;

public class OrderMenu {

	private Scanner sc = new Scanner(System.in);
	private OrderController ordCont = new OrderController();
	private int totalPayment;
	
	public void mainMenu() {
		
		System.out.println("======주문하기======");
		
		//배달 정보(주문자 주소 및 연락처)
		System.out.println(/* user객체 받아서 불러오기 .getUser().getUserAddress*/);
		System.out.println(/* user객체 받아서 불러오기 .getUser().getUserPhonNum*/);
		
		ordCont.setUserAddress(/*.getUser().getUserPhonNum*/);


		//요청사항 입력 부분
		System.out.println("요청사항 입력: ");
		String request = sc.nextLine();
		ordCont.setRequest(request);
		
		
		//포인트 사용 부분
		int point = ordCont.getPoint();
		System.out.println("포인트 : " + point);
		System.out.print("사용 포인트 : " );
		int usePoint = sc.nextInt();
		ordCont.usePoint(usePoint);
		
		
		//결제 금액부분 
		
		//주문금액
		System.out.println("주문금액 : " + ordCont.getTotalCharge());
		
		//배달팁
		System.out.println("배달팁 : " + ordCont.getDeliveryTip());
		
		//사용포인트 포입트 이력시 바로 금액 반영
		System.out.println("사용포인트: " + "-" + usePoint); 
		
		//총 결제 금액
		totalPayment = ordCont.getTotalCharge() + ordCont.getDeliveryTip() - usePoint;
		System.out.println(totalPayment);
		ordCont.setTotalPayment(totalPayment);
		
		
		System.out.print("결제하기(ok): ");
		String payment = sc.nextLine();
		
		if(payment.equals("ok")) {
			completeOrder();
			ordCont.orderOutPut();
		}
		
		
	}

	//주문 완료 페이지
	private void completeOrder() {
		
		System.out.println("주문이 완료되었습니다.");
		
		//결제금액, 적립 포인트 
		System.out.println("결제금액 : " + totalPayment);
		
//		int savePoint = totalPayment * (/*user객체 받아서 불러오기 getUser().getPointRatio*/);
		
		//포인트 적립
		/*user객체 받아서 불러오기 getUser().setPoint(getUser().getPoint() + savePoint)*/
		
//		System.out.println("적립 포인트 : " + savePoint);
		
		
		//주문내역 확인 버튼 누르면
		new OrderListView();
		
		/*홈으로 돌아가기
		Home home = new Home();
		home.mainMenu(); */
		
	}

}
