package com.projectGo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.projectGo.controller.CategoryChoiceController;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;

public class HomeView extends MainFrame {

	private JFrame frame;
	public HomeView() {
 
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		Image rogo = new ImageIcon("images/hankkiGo.png").getImage().getScaledInstance(200, 200, 0);
		JLabel label1 = new JLabel(new ImageIcon(rogo));
		label1.setBounds(167, 122, 200, 200);
		frame.getContentPane().add(label1);

		Image logout = new ImageIcon("images/logout.PNG").getImage().getScaledInstance(50, 50, 0);
		JLabel lable2 = new JLabel(new ImageIcon(logout));
		lable2.setBounds(452, 22, 50, 50);
		lable2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int choice;

				choice = JOptionPane.showConfirmDialog(label1, "정말 로그아웃 하시겠습니까?", "로그아웃",
						JOptionPane.YES_NO_OPTION);
				
				if (choice == JOptionPane.YES_OPTION) {
					new MemberSignInView();

				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lable2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(lable2);

		JButton categoryButton = new JButton("카테고리 조회");
		categoryButton.setFont(new Font("굴림", Font.BOLD, 15));
		categoryButton.setForeground(Color.WHITE);
		categoryButton.setBackground(Color.ORANGE);
		categoryButton.setBounds(77, 376, 160, 60);
		categoryButton.setBorderPainted(false); // 테두리 제거
		categoryButton.setFocusPainted(false); // 텍스트 테두리 제거
		categoryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CategoryChoiceView().categoryMain();

			}
		});
		frame.getContentPane().add(categoryButton);
 
		JButton searchButton = new JButton("검색");
		searchButton.setFont(new Font("굴림", Font.BOLD, 15));
		searchButton.setForeground(Color.WHITE);
		searchButton.setBackground(Color.ORANGE);
		searchButton.setBounds(299, 376, 160, 60);
		searchButton.setBorderPainted(false);
		searchButton.setFocusPainted(false);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SerchPageView().serchMain();
				
			}
		}); 
		frame.getContentPane().add(searchButton);

		JButton basketButton = new JButton("장바구니");
		basketButton.setFont(new Font("굴림", Font.BOLD, 15));
		basketButton.setForeground(Color.WHITE);
		basketButton.setBackground(Color.ORANGE);
		basketButton.setBounds(77, 480, 160, 60);
		basketButton.setBorderPainted(false);
		basketButton.setFocusPainted(false);
		frame.getContentPane().add(basketButton);

		basketButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BasketView(MainFrame.basket, MainFrame.storeInfoView);
			}
		});

		JButton orderListButton = new JButton("주문내역");
		orderListButton.setFont(new Font("굴림", Font.BOLD, 15));
		orderListButton.setForeground(Color.WHITE);
		orderListButton.setBackground(Color.ORANGE);
		orderListButton.setBounds(299, 480, 160, 60);
		orderListButton.setBorderPainted(false);
		orderListButton.setFocusPainted(false);
		frame.getContentPane().add(orderListButton);
		
		orderListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderListView();
			}
		});

		JButton myPageButton = new JButton("마이페이지");
		myPageButton.setFont(new Font("굴림", Font.BOLD, 15));
		myPageButton.setForeground(Color.WHITE);
		myPageButton.setBackground(Color.ORANGE);
		myPageButton.setBounds(192, 587, 160, 60);
		myPageButton.setBorderPainted(false);
		myPageButton.setFocusPainted(false);
		myPageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberMypageView();
			}
		});
		frame.getContentPane().add(myPageButton);

		
		
		JButton logoutButton = new JButton("로그아웃");
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBounds(433, 73, 87, 23);
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice;

				choice = JOptionPane.showConfirmDialog(label1, "정말 로그아웃 하시겠습니까?", "로그아웃",
						JOptionPane.YES_NO_OPTION);
				
				if (choice == JOptionPane.YES_OPTION) {
					new MemberSignInView();

				}
				
				
			}
		});
		frame.getContentPane().add(logoutButton);

		frame.validate();
		frame.repaint();
	}

}
