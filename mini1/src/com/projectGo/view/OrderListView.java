package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.projectGo.controller.OrderListController;

public class OrderListView extends MouseAdapter {
	public JFrame frame;
	public JPanel backgroundPanel;
	public JButton backBtn;
	private String menuPic;
	private OrderListController olc;
	private String userID;
	
	public OrderListView() {
		//메인프레임
//		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		init();

	}
	
	public void init() {
		
		//title(제목, 이전버튼)
		JLabel headLabel = new JLabel("주문내역");
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
	    
		//전체 패널:panel -> gridbaglayout
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(gbl);
		
		//scrollpane -> panel포함
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 80, 530, 675);
		frame.getContentPane().add(scrollPane);
		
		//주문목록 패널 : orderPanel
		JPanel orderPanel = new JPanel();
		GridBagLayout gbl_orderPanel = new GridBagLayout();
		
		orderPanel.setLayout(gbl_orderPanel);
		orderPanel.setBackground(Color.white);

		
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 530;
		c.gridheight = 150;
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(orderPanel, c);
		panel.add(orderPanel);
		


		frame.validate();
		frame.repaint();

	}
	

	//이전 버튼 클릭 -> 프레임 이벤트
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
	}
	
	
	//화면뜰때
	//사용자id확인한 orderlist(arraylist)들고와야함
	//
//	olc.printList();
//	
//	//주문취소- 삭제->리스트다시프린트
//	olc.deleteList();
}
