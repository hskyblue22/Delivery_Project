package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Store;

public class MenuAddView extends MainFrame {

	private JFrame frame;
	private String menuName;
	private String menuPic;
	private int menuPrice;
	private Store store;

	SellerController sc = new SellerController();

	HashMap<String, Menu> menuList;

	public MenuAddView() {

		MenuAddViewMain();

	}

	public MenuAddView(HashMap<String, Menu> menuList2) {

		new MenuAddView();

	}

	public void MenuAddViewMain() {
		store = sc.myStoreLoad();
		if (menuList == null) {

			menuList = store.getStoreMenu();
		}
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		JButton backbtn = new JButton("이 전");
		backbtn.setBounds(15, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		frame.getContentPane().add(backbtn);

		JLabel lineLabel = new JLabel("");

		lineLabel.setOpaque(true);

		lineLabel.setBackground(Color.ORANGE);
		lineLabel.setBounds(0, 80, 535, 5);
		frame.getContentPane().add(lineLabel);

		JLabel headLabel = new JLabel("메뉴 등록");
		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		// lblNewLabel_2.setOpaque(true);
		headLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(headLabel);

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
		mprt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || c == '')) {
					JOptionPane.showMessageDialog(mprt, "숫자만 입력해 주세요.");
					mprt.setText("");
					return;
				}

			}

		});

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
				if (mt.getText().equals("") || mpt.getText().equals("") || mprt.getText().equals("")) {

					JOptionPane.showMessageDialog(mpt, "내용을 입력하세요");
					return;

				}
				menuName = mt.getText();
				menuPic = mpt.getText();
				String getPrice = mprt.getText();
				menuPrice = Integer.parseInt(getPrice);

				// menuList = new HashMap<String, Menu>();

				if (menuList == null) {
					menuList = new HashMap<String, Menu>();
				}

				menuList = sc.addMenu(menuList, menuName, new Menu(menuPic, menuPrice));
				MenuAddViewMain(menuList);

			}

		});

		backbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice;
				choice = JOptionPane.showConfirmDialog(addBtn, "메뉴를 등록하지 않고 돌아가시겠습니까?", "이전으로",
						JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					new SellerMain();

				}

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
				if (mt.getText().equals("") || mpt.getText().equals("") || mprt.getText().equals("")) {

					JOptionPane.showMessageDialog(mpt, "내용을 입력하세요");
					return;

				}
				menuName = mt.getText();
				menuPic = mpt.getText();
				String getPrice = mprt.getText();
				menuPrice = Integer.parseInt(getPrice);
//				menuList = new HashMap<String, Menu>();
				if (menuList == null) {
					menuList = new HashMap<String, Menu>();
				}

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
