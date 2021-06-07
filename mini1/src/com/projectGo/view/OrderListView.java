package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.projectGo.controller.OrderListController;
import com.projectGo.model.vo.Order;

public class OrderListView extends MouseAdapter {
	public JFrame frame;
	public JPanel backgroundPanel;
	public JButton backBtn;
	private String menuPic;
	private OrderListController olc;
	private String userID;
	private GridBagLayout gbag;
	private JPanel panel;
	private JPanel orderPanel;
	private JPanel contentPane;
	
	public OrderListView() throws FileNotFoundException {
		//메인프레임
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		olc = new OrderListController();
		

		init();

	}
	
	public void init() {
		
		ArrayList<Order> olist = olc.displayAllList();
		
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
	    
	    
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 110, 512, 640);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		for(int i=0; i<=4; i++) { //나중에 olist길이만큼 반복으로 바꾸기
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = i;
			panel.add(panel_1, gbc_panel_1);
			
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{91, 91, 91, 91, 91, 0};
			gbl_panel_1.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			JLabel lblNewLabel = new JLabel("2021.06.01");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel_1.add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 0;
			panel_1.add(label, gbc_label);
			
			JLabel lblNewLabel_1 = new JLabel("배달완료");
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 0;
			panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			JLabel label_1 = new JLabel("");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.fill = GridBagConstraints.BOTH;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 3;
			gbc_label_1.gridy = 0;
			panel_1.add(label_1, gbc_label_1);
			
			JLabel label_2 = new JLabel("");
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.fill = GridBagConstraints.BOTH;
			gbc_label_2.insets = new Insets(0, 0, 5, 0);
			gbc_label_2.gridx = 4;
			gbc_label_2.gridy = 0;
			panel_1.add(label_2, gbc_label_2);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 1;
			panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("New label");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 1;
			panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
			
			JLabel label_3 = new JLabel("");
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.fill = GridBagConstraints.BOTH;
			gbc_label_3.insets = new Insets(0, 0, 5, 5);
			gbc_label_3.gridx = 2;
			gbc_label_3.gridy = 1;
			panel_1.add(label_3, gbc_label_3);
			
			JLabel label_4 = new JLabel("");
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.fill = GridBagConstraints.BOTH;
			gbc_label_4.insets = new Insets(0, 0, 5, 5);
			gbc_label_4.gridx = 3;
			gbc_label_4.gridy = 1;
			panel_1.add(label_4, gbc_label_4);
			
			JLabel label_5 = new JLabel("");
			GridBagConstraints gbc_label_5 = new GridBagConstraints();
			gbc_label_5.fill = GridBagConstraints.BOTH;
			gbc_label_5.insets = new Insets(0, 0, 5, 0);
			gbc_label_5.gridx = 4;
			gbc_label_5.gridy = 1;
			panel_1.add(label_5, gbc_label_5);
			
			JLabel label_6 = new JLabel("");
			GridBagConstraints gbc_label_6 = new GridBagConstraints();
			gbc_label_6.fill = GridBagConstraints.BOTH;
			gbc_label_6.insets = new Insets(0, 0, 5, 5);
			gbc_label_6.gridx = 0;
			gbc_label_6.gridy = 2;
			panel_1.add(label_6, gbc_label_6);
			
			JLabel lblNewLabel_3_1 = new JLabel("New label");
			GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
			gbc_lblNewLabel_3_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3_1.gridx = 1;
			gbc_lblNewLabel_3_1.gridy = 2;
			panel_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
			
			JLabel label_7 = new JLabel("");
			GridBagConstraints gbc_label_7 = new GridBagConstraints();
			gbc_label_7.fill = GridBagConstraints.BOTH;
			gbc_label_7.insets = new Insets(0, 0, 5, 5);
			gbc_label_7.gridx = 2;
			gbc_label_7.gridy = 2;
			panel_1.add(label_7, gbc_label_7);
			
			JLabel label_8 = new JLabel("");
			GridBagConstraints gbc_label_8 = new GridBagConstraints();
			gbc_label_8.fill = GridBagConstraints.BOTH;
			gbc_label_8.insets = new Insets(0, 0, 5, 5);
			gbc_label_8.gridx = 3;
			gbc_label_8.gridy = 2;
			panel_1.add(label_8, gbc_label_8);
			
			JLabel label_9 = new JLabel("");
			GridBagConstraints gbc_label_9 = new GridBagConstraints();
			gbc_label_9.fill = GridBagConstraints.BOTH;
			gbc_label_9.insets = new Insets(0, 0, 5, 0);
			gbc_label_9.gridx = 4;
			gbc_label_9.gridy = 2;
			panel_1.add(label_9, gbc_label_9);
			
			JLabel label_12 = new JLabel("");
			GridBagConstraints gbc_label_12 = new GridBagConstraints();
			gbc_label_12.fill = GridBagConstraints.BOTH;
			gbc_label_12.insets = new Insets(0, 0, 5, 5);
			gbc_label_12.gridx = 0;
			gbc_label_12.gridy = 3;
			panel_1.add(label_12, gbc_label_12);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("New label");
			GridBagConstraints gbc_lblNewLabel_3_1_1 = new GridBagConstraints();
			gbc_lblNewLabel_3_1_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_3_1_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3_1_1.gridx = 1;
			gbc_lblNewLabel_3_1_1.gridy = 3;
			panel_1.add(lblNewLabel_3_1_1, gbc_lblNewLabel_3_1_1);
			
			JLabel label_10 = new JLabel("");
			GridBagConstraints gbc_label_10 = new GridBagConstraints();
			gbc_label_10.fill = GridBagConstraints.BOTH;
			gbc_label_10.insets = new Insets(0, 0, 5, 5);
			gbc_label_10.gridx = 2;
			gbc_label_10.gridy = 3;
			panel_1.add(label_10, gbc_label_10);
			
			JLabel label_11 = new JLabel("");
			GridBagConstraints gbc_label_11 = new GridBagConstraints();
			gbc_label_11.fill = GridBagConstraints.BOTH;
			gbc_label_11.insets = new Insets(0, 0, 5, 5);
			gbc_label_11.gridx = 3;
			gbc_label_11.gridy = 3;
			panel_1.add(label_11, gbc_label_11);
			
			JLabel label_13 = new JLabel("");
			GridBagConstraints gbc_label_13 = new GridBagConstraints();
			gbc_label_13.fill = GridBagConstraints.BOTH;
			gbc_label_13.insets = new Insets(0, 0, 5, 0);
			gbc_label_13.gridx = 4;
			gbc_label_13.gridy = 3;
			panel_1.add(label_13, gbc_label_13);
			
			JLabel label_14 = new JLabel("");
			GridBagConstraints gbc_label_14 = new GridBagConstraints();
			gbc_label_14.fill = GridBagConstraints.BOTH;
			gbc_label_14.insets = new Insets(0, 0, 5, 5);
			gbc_label_14.gridx = 0;
			gbc_label_14.gridy = 4;
			panel_1.add(label_14, gbc_label_14);
			
			JLabel label_15 = new JLabel("");
			GridBagConstraints gbc_label_15 = new GridBagConstraints();
			gbc_label_15.fill = GridBagConstraints.BOTH;
			gbc_label_15.insets = new Insets(0, 0, 5, 5);
			gbc_label_15.gridx = 1;
			gbc_label_15.gridy = 4;
			panel_1.add(label_15, gbc_label_15);
			
			JButton btnNewButton_1 = new JButton("New button");
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton_1.gridx = 2;
			gbc_btnNewButton_1.gridy = 4;
			panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
			
			JButton btnNewButton = new JButton("New button");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 3;
			gbc_btnNewButton.gridy = 4;
			panel_1.add(btnNewButton, gbc_btnNewButton);
			
			JButton btnNewButton_2 = new JButton("New button");
			GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
			gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton_2.gridx = 4;
			gbc_btnNewButton_2.gridy = 4;
			panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
			
			JLabel label_16 = new JLabel("");
			GridBagConstraints gbc_label_16 = new GridBagConstraints();
			gbc_label_16.fill = GridBagConstraints.BOTH;
			gbc_label_16.insets = new Insets(0, 0, 0, 5);
			gbc_label_16.gridx = 0;
			gbc_label_16.gridy = 5;
			panel_1.add(label_16, gbc_label_16);
		}
		
		frame.validate();
		frame.repaint();
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
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
