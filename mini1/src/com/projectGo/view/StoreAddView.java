package com.projectGo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.projectGo.controller.SellerController;

public class StoreAddView extends MainFrame {
	
	JFrame frame;
	SellerController sc = new SellerController();
	
	public StoreAddView() {
		
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
		
		JButton nextbtn = new JButton("다 음");
		backbtn.setBounds(455, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		panel.add(nextbtn);
		nextbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuAddView();
				
			}
		});
		
		
		JLabel header = new JLabel("가게등록");
		header.setHorizontalAlignment(JLabel.CENTER);
		panel.add(header);
		
		
		String storeName = null;
		String storeIntroduce =null;
		int category = 0;
		int deliveryTip = 0;
		int deliveryTime = 0;
		
	
		//textfield + combobox (카테고리)
		
		
		
		sc.StoreCreator(storeName, storeIntroduce, category, deliveryTip, deliveryTime);
		
		
				
		
		
		
	}
	

}
