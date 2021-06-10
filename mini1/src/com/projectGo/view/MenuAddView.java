package com.projectGo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuAddView extends MainFrame {

	JFrame frame;

	public MenuAddView() {

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

		JButton nextbtn = new JButton("완 료");
		backbtn.setBounds(455, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		panel.add(nextbtn);
		nextbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SellerMain();

			}
		});

		JLabel header = new JLabel("메뉴 등록");
		header.setHorizontalAlignment(JLabel.CENTER);
		panel.add(panel);

		// scroll

		JPanel panel2 = new JPanel();
		panel2.setBounds(x, y, 450, 60);
		// 메뉴명, 가격, 사진 TextField
		
		JButton addBtn = new JButton("메뉴 추가");

		

		
		panel2.add(addBtn);

	}

}
