package com.projectGo.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Store;

public class MenuModifyView {
	
	private Store store;
	private int count;
	private HashMap<String, Menu> menulist;
	private int quantity;
	private String menuPic;
	private int menuPrice;
	private Basket basket;
	private JFrame frame;
	private Image image;
	private int pre = 0;
	
	SellerController sc = new SellerController();
	
	
	
	public MenuModifyView() {
		
	}

	
	public void MenuModifyViewPre(Store store, String resultName, ArrayList<Store> printList, int kinds, int serchKinds, HashMap<String, Menu> menulist) {
	
		this.pre = 1;
		this.menulist = menulist;
		MenuModifyViewMain(store, resultName, printList, kinds, serchKinds);
	}
	

	public void MenuModifyViewMain(Store store, String resultName, ArrayList<Store> printList, int kinds,
			int serchKinds) {
		
		Store myStore = sc.myStoreLoad();
		
		HashMap<String, Menu> myMenu = myStore.getStoreMenu();
		
		this.store = store;
		this.printList = printList;
		this.resultName = resultName;
		this.kinds = kinds;
		this.serchKinds = serchKinds;
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		Set<String> menuName;
		String name;
		menuName = store.getStoreMenu().keySet();
		Iterator<String> it = menuName.iterator();
		if(pre == 0) {
			menulist = new HashMap<String, Menu>();
		}
		
		count = 0;

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		JPanel panel = new JPanel();

		panel.setLayout(gbl);
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 316, 535, 400);
		frame.getContentPane().add(scrollPane);
		while (it.hasNext()) {
			name = it.next();
			JPanel menuPanel = new JPanel();
			menuPanel.setBackground(Color.WHITE);
			GridBagLayout gbl_menuPanel = new GridBagLayout();
			gbl_menuPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0 };
			gbl_menuPanel.rowHeights = new int[] { 35, 35, 30 };
			gbl_menuPanel.columnWidths = new int[] { 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35 };

			menuPanel.setLayout(gbl_menuPanel);
			menuPanel.setBounds(-13, 130, 535, 96);
			frame.getContentPane().add(menuPanel);

			image = new ImageIcon(store.getStoreMenu().get(name).getMenuPic()).getImage().getScaledInstance(70, 70, 0);
			JLabel menuPicLabel = new JLabel(new ImageIcon(image));
			GridBagConstraints gbc_menuPicLabel = new GridBagConstraints();
			gbc_menuPicLabel.fill = GridBagConstraints.BOTH;
			gbc_menuPicLabel.gridheight = 2;
			gbc_menuPicLabel.gridwidth = 2;
			gbc_menuPicLabel.insets = new Insets(0, 0, 5, 5);
			gbc_menuPicLabel.gridx = 1;
			gbc_menuPicLabel.gridy = 0;
			menuPanel.add(menuPicLabel, gbc_menuPicLabel);
			menuPicLabel.setOpaque(true);
			menuPicLabel.setPreferredSize(new Dimension(70, 70));
			menuPicLabel.setBackground(Color.LIGHT_GRAY);

			JLabel menuNameLabel = new JLabel(name);
			GridBagConstraints gbc_menuNameLabel = new GridBagConstraints();
			gbc_menuNameLabel.fill = GridBagConstraints.BOTH;
			gbc_menuNameLabel.gridwidth = 5;
			gbc_menuNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_menuNameLabel.gridx = 3;
			gbc_menuNameLabel.gridy = 0;
			menuPanel.add(menuNameLabel, gbc_menuNameLabel);
			menuNameLabel.setOpaque(true);

			JLabel menuPriceLabel = new JLabel(store.getStoreMenu().get(name).getMenuPrice() + "");
			GridBagConstraints gbc_menuPriceLabel = new GridBagConstraints();
			gbc_menuPriceLabel.fill = GridBagConstraints.BOTH;
			gbc_menuPriceLabel.gridwidth = 5;
			gbc_menuPriceLabel.insets = new Insets(0, 0, 5, 5);
			gbc_menuPriceLabel.gridx = 3;
			gbc_menuPriceLabel.gridy = 1;
			menuPanel.add(menuPriceLabel, gbc_menuPriceLabel);
			menuPriceLabel.setOpaque(true);
			
			JButton basketButton_1 = new JButton("수정하기");
			basketButton_1.setBackground(Color.ORANGE);
			basketButton_1.setForeground(Color.white);
			GridBagConstraints gbc_basketButton_1 = new GridBagConstraints();
			gbc_basketButton_1.fill = GridBagConstraints.BOTH;
			gbc_basketButton_1.gridheight = 2;
			gbc_basketButton_1.gridwidth = 2;
			gbc_basketButton_1.insets = new Insets(0, 0, 5, 5);
			gbc_basketButton_1.gridx = 11;
			gbc_basketButton_1.gridy = 0;
			menuPanel.add(basketButton_1, gbc_basketButton_1);

			JLabel blinkLabel = new JLabel("");
			GridBagConstraints gbc_blinkLabel = new GridBagConstraints();
			gbc_blinkLabel.gridwidth = 14;
			gbc_blinkLabel.gridx = 0;
			gbc_blinkLabel.gridy = 2;
			menuPanel.add(blinkLabel, gbc_blinkLabel);

			basketButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					//메뉴 상세 수정 페이지로 이동
					
					
					menuPic = menuPicLabel.getText();
					menuPrice = Integer.parseInt(menuPriceLabel.getText());

					menulist.put(menuNameLabel.getText(), new Menu(menuPic, menuPrice, quantity));

					
				});
					
				
			
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = (count++ * 150) + 10;
			gbc.gridwidth = 530;
			gbc.gridheight = 150;
			gbl.setConstraints(menuPanel, gbc);
			panel.add(menuPanel);

			panel.updateUI();

		}

		for (int i = count; i < 5; i++) {

			JPanel menuPanel = new JPanel();
			menuPanel.setBackground(Color.WHITE);
			GridBagLayout gbl_menuPanel = new GridBagLayout();
			gbl_menuPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0 };
			gbl_menuPanel.rowHeights = new int[] { 15, 35, 15 };
			gbl_menuPanel.columnWidths = new int[] { 35, 0, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35 };

			menuPanel.setLayout(gbl_menuPanel);
			menuPanel.setBounds(0, 120, 535, 70);
			frame.getContentPane().add(menuPanel);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = (count++ * 150) + 10;
			gbc.gridwidth = 530;
			gbc.gridheight = 150;
			gbl.setConstraints(menuPanel, gbc);
			panel.add(menuPanel);

			panel.updateUI();

		}

		JLabel storeNameLabel = new JLabel(store.getStoreName());
		storeNameLabel.setOpaque(true);
		storeNameLabel.setBounds(150, 100, 250, 70);
		storeNameLabel.setHorizontalAlignment(JLabel.CENTER);
		storeNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		frame.getContentPane().add(storeNameLabel);

		JLabel lineLabel = new JLabel("");

		lineLabel.setOpaque(true);

		lineLabel.setBackground(Color.ORANGE);
		lineLabel.setBounds(0, 80, 535, 5);
		frame.getContentPane().add(lineLabel);

		JLabel headLabel = new JLabel("메뉴 수정");
		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		// lblNewLabel_2.setOpaque(true);
		headLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(headLabel);

		JLabel storeAddressLabel = new JLabel(store.getStoreAddress());
		storeAddressLabel.setOpaque(true);
		storeAddressLabel.setBounds(85, 240, 250, 30);
		frame.getContentPane().add(storeAddressLabel);

		JLabel deliveryTipLabel = new JLabel("배달팁 : " + store.getDeliveryTip() + "원");
		deliveryTipLabel.setOpaque(true);
		deliveryTipLabel.setBounds(371, 240, 94, 30);
		deliveryTipLabel.setHorizontalAlignment(JLabel.RIGHT);
		frame.getContentPane().add(deliveryTipLabel);

		JLabel storeIntroduceLabel = new JLabel(store.getStoreIntroduce());
		storeIntroduceLabel.setBounds(85, 180, 380, 50);
		frame.getContentPane().add(storeIntroduceLabel);
		storeIntroduceLabel.setOpaque(true);

		JButton basketMoveBtn = new JButton("수 정 완 료");
		basketMoveBtn.setBounds(0, 715, 535, 50);
		basketMoveBtn.setBackground(Color.ORANGE);
		basketMoveBtn.setForeground(Color.white);
		basketMoveBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		basketMoveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				basket = new Basket("userId", store.getStoreName(), store.getStoreAddress(), store.getDeliveryTip(),
						menulist);
				// 수정 완료 후 메인으로 이동
				

			}
		});
		frame.getContentPane().add(basketMoveBtn);

		JButton backBtn = new JButton("이  전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(Color.ORANGE);
		backBtn.setForeground(Color.white);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//메인으로 이동 

			}
		});
		frame.getContentPane().add(backBtn);

		JButton homeBtn = new JButton("홈으로");
		homeBtn.setBounds(440, 20, 80, 40);
		homeBtn.setBackground(Color.ORANGE);
		homeBtn.setForeground(Color.white);
		homeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HomeView();

			}
		});
		frame.getContentPane().add(homeBtn);
		frame.validate();
		frame.repaint();
	}
	
	

}
