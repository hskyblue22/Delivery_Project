package com.projectGo.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderListView extends MouseAdapter{

//	OrderListController olc = new OrderListController();
	
	public OrderListView() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("한끼고");

		frame.setBackground(Color.white);  //안됨
		frame.setLayout(null);
		
		//orderlist 패널 -> panel1
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		
		frame.add(panel);
		panel.setBounds(10, 10, 300, 50);
		
		
		JButton bt = new JButton("이전");
		JLabel label = new JLabel("주문내역");
		
		
		panel.add(bt);
		panel.add(label);
		
		bt.addMouseListener(this);
		
		label.setBounds(100, 0, 200, 200);
		bt.setLocation(0, 20);
		frame.setResizable(false);
		frame.setSize(550, 800);
		frame.setLocationRelativeTo(null);  //중앙에서 창 뜨도록
		
		frame.setVisible(true);
//		frame.dispose();  //프레임만 종료됨 프로그램은 계속 진행 -> 버튼눌러서 호출하면 적어주기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //나중에 지우기
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//이전버튼 클릭 -> 프레임닫히게
//		frame.dispose();  //왜 안되는거지...? 확인-1
	}
	
	//화면뜰때
	//사용자id확인한 orderlist(arraylist)들고와야함
	//
	olc.printList();
	
	//주문취소- 삭제->리스트다시프린트
	olc.deleteList();
}
