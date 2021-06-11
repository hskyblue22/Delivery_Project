package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Store;

public class SellerMain extends MainFrame {
	JFrame frame;
	SellerController sc = new SellerController();
	MenuModifyView mmv = new MenuModifyView();
	SellerOrderCheckView socv= new SellerOrderCheckView();

	public SellerMain() {

		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		
		Image rogo = new ImageIcon("images/hankkiGo.PNG").getImage().getScaledInstance(150, 150, 0);
		JLabel label1 = new JLabel(new ImageIcon(rogo));
		label1.setBounds(200, 60, 150, 150);
		frame.getContentPane().add(label1);

		JButton bt1 = new JButton("가게 등록");
		JButton bt2 = new JButton("주문 조회");
		JButton bt3 = new JButton("회원 정보");

		JButton bt4 = new JButton("가게 수정");
		JButton bt5 = new JButton("메뉴 수정");

		bt1.setBounds(100, 260, 150, 100);
		bt2.setBounds(300, 260, 150, 100);
		bt3.setBounds(300, 400, 150, 100);
		bt4.setBounds(100, 260, 150, 100);
		bt5.setBounds(100, 400, 150, 100);

		bt1.setBackground(Color.orange);
		bt2.setBackground(Color.orange);
		bt3.setBackground(Color.orange);
		bt4.setBackground(Color.orange);
		bt5.setBackground(Color.orange);

		bt1.setForeground(Color.white);
		bt2.setForeground(Color.white);
		bt3.setForeground(Color.white);
		bt4.setForeground(Color.white);
		bt5.setForeground(Color.white);

		bt1.setFont(new Font("굴림", Font.BOLD, 15));
		bt2.setFont(new Font("굴림", Font.BOLD, 15));
		bt3.setFont(new Font("굴림", Font.BOLD, 15));
		bt4.setFont(new Font("굴림", Font.BOLD, 15));
		bt5.setFont(new Font("굴림", Font.BOLD, 15));

		bt1.setBorderPainted(false);
		bt1.setFocusPainted(false);
		bt2.setBorderPainted(false);
		bt2.setFocusPainted(false);
		bt3.setBorderPainted(false);
		bt3.setFocusPainted(false);
		bt4.setBorderPainted(false);
		bt4.setFocusPainted(false);
		bt5.setBorderPainted(false);
		bt5.setFocusPainted(false);

		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreAddView();

			}
		});

		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					new SellerOrderCheckView();
				} catch (NullPointerException i) {
					socv.listEmpty();
				}
			}
		});

		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoFrame();

			}
		});

		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreModifyView();

			}
		});

		bt5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Store store = sc.myStoreLoad();

				mmv.MenuModifyViewMain(store, "", null, 0, 0);

			}
		});

		if (sc.checkStore() == true) {
			frame.add(bt4);
			frame.add(bt5);
		} else {
			frame.add(bt1);
		}

		frame.add(bt2);
		frame.add(bt3);

		frame.validate();
		frame.repaint();

	}

}
