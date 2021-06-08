package com.projectGo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SellerMain extends MainFrame {

	public SellerMain() {
		/*
		 * this.setLayout(new GridLayout(550, 800)); 
		 * JPanel p1 = new JPanel(); JButton
		 * bt1 = new JButton("가게 등록"); JButton bt2 = new JButton("주문 조회"); JButton bt3 =
		 * new JButton("회원 정보");
		 * 
		 * p1.add(bt1); p1.add(bt2); p1.add(bt3);
		 * 
		 * this.add(p1);
		 */

		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);

		JButton btnNewButton_1 = new JButton("가게 등록");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton = new JButton("주문 조회");
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("개인정보 조회");
		panel.add(btnNewButton_2);
		
		this.add(panel);

		this.validate();
		this.repaint();

	}

}
