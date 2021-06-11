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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Store;

public class MenuModifyView extends MainFrame {
	
	private Store store;
	private int count;
	private HashMap<String, Menu> menulist;
	private String menuPic;
	private int menuPrice;
	private Menu menu;
	private JFrame frame;
	private Image image;
	private int pre = 0;
	private ArrayList<Store> printList;
	private String resultName;
	private int kinds;
	private int serchKinds;
	private HashMap<String, Menu> otherMenu;
	
	SellerController sc = new SellerController();
	MenuModifyDetailView mmdv = new MenuModifyDetailView();
	
	
	// 기본 생성자
	public MenuModifyView() {
		
	}

	
	public void MenuModifyViewMain(Store store, String resultName, ArrayList<Store> printList, int kinds,
			int serchKinds) {
		
		//myStore에 내 아이디에 해당하는 가게 호출
		Store myStore = sc.myStoreLoad();
		
		menulist = myStore.getStoreMenu();
		
		this.store = store;
		this.printList = printList;
		this.resultName = resultName;
		this.kinds = kinds;
		this.serchKinds = serchKinds;
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		String name;
		Set<String> menuName = myStore.getStoreMenu().keySet();
		Iterator<String> it = menuName.iterator();
		if(pre == 0) {
			menulist = new HashMap<String, Menu>();
		}
		
		count = 0;
		
		
		//스크롤판
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		JPanel panel = new JPanel();

		panel.setLayout(gbl);
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 316, 535, 400);
		frame.getContentPane().add(scrollPane);
		
		
		//반복문 
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
			
			
			//메뉴 사진
			image = new ImageIcon(myStore.getStoreMenu().get(name).getMenuPic()).getImage().getScaledInstance(70, 70, 0);
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
			
			// 메뉴 이름
			JLabel menuNameLabel = new JLabel(name);
			GridBagConstraints gbc_menuNameLabel = new GridBagConstraints();
			gbc_menuNameLabel.fill = GridBagConstraints.BOTH;
			gbc_menuNameLabel.gridwidth = 5;
			gbc_menuNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_menuNameLabel.gridx = 3;
			gbc_menuNameLabel.gridy = 0;
			menuPanel.add(menuNameLabel, gbc_menuNameLabel);
			menuNameLabel.setOpaque(true);
			
			//메뉴 가격
			JLabel menuPriceLabel = new JLabel(myStore.getStoreMenu().get(name).getMenuPrice() + "");
			GridBagConstraints gbc_menuPriceLabel = new GridBagConstraints();
			gbc_menuPriceLabel.fill = GridBagConstraints.BOTH;
			gbc_menuPriceLabel.gridwidth = 5;
			gbc_menuPriceLabel.insets = new Insets(0, 0, 5, 5);
			gbc_menuPriceLabel.gridx = 3;
			gbc_menuPriceLabel.gridy = 1;
			menuPanel.add(menuPriceLabel, gbc_menuPriceLabel);
			menuPriceLabel.setOpaque(true);
			
			JButton editBtn = new JButton("수정하기");
			editBtn.setBackground(Color.ORANGE);
			editBtn.setForeground(Color.white);
			GridBagConstraints gbc_editBtn = new GridBagConstraints();
			gbc_editBtn.fill = GridBagConstraints.BOTH;
			gbc_editBtn.gridheight = 2;
			gbc_editBtn.gridwidth = 2;
			gbc_editBtn.insets = new Insets(0, 0, 5, 5);
			gbc_editBtn.gridx = 11;
			gbc_editBtn.gridy = 0;
			menuPanel.add(editBtn, gbc_editBtn);

			JLabel blinkLabel = new JLabel("");
			GridBagConstraints gbc_blinkLabel = new GridBagConstraints();
			gbc_blinkLabel.gridwidth = 14;
			gbc_blinkLabel.gridx = 0;
			gbc_blinkLabel.gridy = 2;
			menuPanel.add(blinkLabel, gbc_blinkLabel);
			
			otherMenu = myStore.getStoreMenu();
			otherMenu.remove(menuName);
			String menuN = menuNameLabel.getText();
			menuPic = myStore.getStoreMenu().get(menuN).getMenuPic();
			menuPrice = Integer.parseInt(menuPriceLabel.getText());
			
			
			editBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					mmdv.MenuAddViewMain(menuN, menuPic, menuPrice, otherMenu);
					
					
				}
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
		
		//menuPanel 추가를 위한 for문

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

		/*JButton completeBtn = new JButton("메 뉴 수 정 완 료");
		completeBtn.setBounds(0, 715, 535, 50);
		completeBtn.setBackground(Color.ORANGE);
		completeBtn.setForeground(Color.white);
		completeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new SellerMain();
				// 수정 완료 후 메인으로 이동
				

			}
		});
		frame.getContentPane().add(completeBtn);*/

		JButton backBtn = new JButton("이  전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(Color.ORANGE);
		backBtn.setForeground(Color.white);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new SellerMain();

			}
		});
		frame.getContentPane().add(backBtn);

	
		frame.validate();
		frame.repaint();
	}
	
	

}
