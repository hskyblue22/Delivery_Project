package com.projectGo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Menu;


public class MenuAddView extends MainFrame {

	JFrame frame;
	String menuName;
	String menuPic;
	int menuPrice;
	SellerController sc = new SellerController();

	HashMap<String, Menu> menuList;

	public MenuAddView() {
		
		MenuAddViewMain();

	}

	public MenuAddView(HashMap<String, Menu> menuList2) {

		
		new MenuAddView();

	}

	public void MenuAddViewMain() {

		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		JButton backbtn = new JButton("이 전");
		backbtn.setBounds(15, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		frame.getContentPane().add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SellerMain();

			}
		});

		JLabel header = new JLabel("메뉴 등록");
		header.setBounds(225, 30, 200, 30);
		frame.getContentPane().add(header);

		// 메뉴명, 가격, 사진 TextField

		JLabel ml = new JLabel("메뉴 이름");
		JTextField mt = new JTextField();

		ml.setBounds(50, 100, 300, 30);
		mt.setBounds(50, 150, 150, 30);

		frame.getContentPane().add(ml);
		frame.getContentPane().add(mt);

		JLabel mpl = new JLabel("메뉴 사진 주소");
		JTextField mpt = new JTextField();

		mpl.setBounds(50, 200, 300, 30);
		mpt.setBounds(50, 250, 300, 30);

		frame.getContentPane().add(mpl);
		frame.getContentPane().add(mpt);

		JLabel mprl = new JLabel("메뉴 가격");
		JTextField mprt = new JTextField();

		mprl.setBounds(50, 300, 300, 30);
		mprt.setBounds(50, 350, 100, 30);

		frame.getContentPane().add(mprl);
		frame.getContentPane().add(mprt);

		JButton addBtn = new JButton("메뉴 추가");
		addBtn.setBounds(200, 400, 120, 40);
		addBtn.setBackground(Color.orange);
		addBtn.setForeground(Color.white);

		frame.getContentPane().add(addBtn);

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(mprl.getText());
				System.out.println(mprt.getText());
				menuName = mt.getText();
				menuPic = mpt.getText();
				String getPrice = mprt.getText();
				menuPrice = Integer.parseInt(getPrice);
				if (menuList == null) {
					menuList = new HashMap<String, Menu>();
				}

				menuList = sc.addMenu(menuList, menuName, new Menu(menuPic, menuPrice));
				MenuAddViewMain(menuList);

			}

		});

		JButton nextbtn = new JButton("완 료");
		nextbtn.setBounds(435, 20, 80, 40);
		nextbtn.setBackground(Color.orange);
		nextbtn.setForeground(Color.white);
		frame.getContentPane().add(nextbtn);
		nextbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(mprl.getText());
				System.out.println(mprt.getText());
				menuName = mt.getText();
				menuPic = mpt.getText();
				String getPrice = mprt.getText();
				System.out.println(getPrice);
				menuPrice = Integer.parseInt(getPrice);
				System.out.println(menuList);
				menuList = sc.addMenu(menuList, menuName, new Menu(menuPic, menuPrice));

				sc.menuCreator(menuList);

				new SellerMain();

			}
		});

		frame.validate();
		frame.repaint();

	}

	protected void MenuAddViewMain(HashMap<String, Menu> menuList2) {
		
		this.menuList = menuList2;
		MenuAddViewMain();
		
	}

}
