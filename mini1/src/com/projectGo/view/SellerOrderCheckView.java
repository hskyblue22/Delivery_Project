package com.projectGo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Order;

public class SellerOrderCheckView extends MainFrame{
	
	JFrame frame;
	
	public SellerOrderCheckView() {

		SellerController sc = new SellerController();
		
		ArrayList<Order> sellerOrder = new ArrayList<Order>();
		sellerOrder = sc.loadSellerOrder();
		
		
		
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBounds(0, 0, 550, 800);
		
		
		JButton backbtn = new JButton("이 전");
		backbtn.setBounds(15, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		panel.add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SellerMain();
				
			}
		});
		
		
		JPanel orderPanel1 = new JPanel();
		
		
		
		
	}
	
	
	
	

}
