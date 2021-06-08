package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.projectGo.controller.ReviewListController;

public class ReviewListView {

	public JFrame frame;
	private JPanel contentPane;
	private JPanel panel;
	public JButton backBtn;
	private ReviewListController rlc = new ReviewListController();
//	private ArrayList<Order> userOrderList;	
	
	private String userID;
	private String storeName;
	private String date;
	private String[] menus;  //메뉴이름+가격
	private int score;
	private String contents;
	
	public ReviewListView() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		// 메인프레임
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		
		// title(제목, 이전버튼)
		JLabel headLabel = new JLabel("My 리뷰");
		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		headLabel.setBounds(140, 10, 250, 60);
		frame.getContentPane().add(headLabel);

		// 이전버튼
		backBtn = new JButton("이   전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(Color.orange);
		backBtn.setForeground(Color.white);
		frame.getContentPane().add(backBtn);

		// '이전'버튼 -> '홈으로' 변경
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new ViewTemp();
				//마이페이지 뷰로
			}
		});
		
		// 스크롤판, 전체패널
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 110, 512, 640);
		contentPane.add(scrollPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);	
		
		
//		 if(userOrderList == null) {  //주문내역 빈 경우
//		    	listEmpty();
//		    	
//		    }else {             //주문내역이 있는 경우
//		    	makeList();
//		    }
//			
//			frame.validate();
//			frame.repaint();	
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		new ReviewListView();
	}

	
}
