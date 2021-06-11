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

public class MenuModifyDetailView extends MainFrame{
	
	
	JFrame frame;
	
	SellerController sc = new SellerController();
	
	private String menuN;
	private String menuPic;
	private int menuPrice;
	private HashMap<String, Menu> menuList;
	private HashMap<String, Menu> otherMenu;
	
	
	public MenuModifyDetailView() {
		
	}
	
	
	







	public void MenuAddViewMain(String menuN, String menuPic, int menuPrice, HashMap<String, Menu> otherMenu) {

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
				new MenuModifyView();

			}
		});

		JLabel header = new JLabel("메뉴 수정");
		header.setBounds(225, 30, 200, 30);
		frame.getContentPane().add(header);

		// 메뉴명, 가격, 사진 TextField

		JLabel ml = new JLabel("메뉴 이름");
		JTextField mt = new JTextField();
		mt.setText(menuN);

		ml.setBounds(50, 100, 300, 30);
		mt.setBounds(50, 150, 150, 30);

		frame.getContentPane().add(ml);
		frame.getContentPane().add(mt);
		
		

		JLabel mpl = new JLabel("메뉴 사진 주소");
		JTextField mpt = new JTextField();
		mpt.setText(menuPic);

		mpl.setBounds(50, 200, 300, 30);
		mpt.setBounds(50, 250, 300, 30);

		frame.getContentPane().add(mpl);
		frame.getContentPane().add(mpt);

		JLabel mprl = new JLabel("메뉴 가격");
		JTextField mprt = new JTextField();
		mprt.setText(Integer.toString(menuPrice));

		mprl.setBounds(50, 300, 300, 30);
		mprt.setBounds(50, 350, 100, 30);

		frame.getContentPane().add(mprl);
		frame.getContentPane().add(mprt);

		JButton addBtn = new JButton("변경 완료");
		addBtn.setBounds(200, 400, 120, 40);
		addBtn.setBackground(Color.orange);
		addBtn.setForeground(Color.white);

		frame.getContentPane().add(addBtn);
		
		/*String menuName = mt.getText();
		String newMenuPic = mpt.getText();
		String getPrice = mprt.getText();
		int newMenuPrice = Integer.parseInt(getPrice);*/
		
		String a,b;
		int c;
		a = mt.getText();
		b = mpt.getText();
		c = Integer.parseInt(mprt.getText());

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				sc.editMenu(otherMenu, a, b, c);
				new SellerMain();

			}

		});

		

		frame.validate();
		frame.repaint();

	}
	
	

}
