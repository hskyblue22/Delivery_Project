package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.projectGo.controller.OrderListController;

public class WriteReview extends MouseAdapter {

	public JFrame frame;
	public JPanel backgroundPanel;
	public JButton backBtn;
	private String menuPic;
	private OrderListController olc;
	private String userID;
	
	public WriteReview() {
		//메인프레임
//		frame = MainFrame.mainFrame;
//		frame.getContentPane().removeAll();
//		frame.validate();
//		frame.repaint();

		init();

	}
	
	public void init() {
		//title(제목, 이전버튼)
		JLabel headLabel = new JLabel("리뷰작성");
		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림",Font.PLAIN, 30));
		headLabel.setBounds(140, 10, 250, 60);
		frame.getContentPane().add(headLabel);
		
		//이전버튼
		backBtn = new JButton("이  전");
		backBtn.setBounds(15,20,80,40);
		backBtn.setBackground(Color.orange); 
		backBtn.setForeground(Color.white);  
	    frame.getContentPane().add(backBtn);  
	    
	    backBtn.addMouseListener(this);
	    
	    
	    
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
	}
	
	
	
}
