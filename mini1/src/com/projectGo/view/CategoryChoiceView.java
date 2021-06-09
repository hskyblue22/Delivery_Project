package com.projectGo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.projectGo.controller.CategoryChoiceController;
import com.projectGo.controller.StoreSortController;
import com.projectGo.model.dao.StoreDao;
import com.projectGo.model.vo.Store;

public class CategoryChoiceView extends MainFrame{

	private ArrayList<Store> mainList;
	private ArrayList<Store> printList;
	private JFrame frame;
	private Image image;
	private Store topStore;
	
	public CategoryChoiceView() {
		
	}

	public void categoryMain() {

		mainList = new StoreDao().loadStore();
		topStore = new StoreSortController().topStore(mainList);
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.WHITE);
		GridBagLayout gbl_menuPanel = new GridBagLayout();
		gbl_menuPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0 };
		gbl_menuPanel.rowHeights = new int[] { 15, 35, 15 };
		gbl_menuPanel.columnWidths = new int[] { 35, 0, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35 };

		menuPanel.setLayout(gbl_menuPanel);
		menuPanel.setBounds(0, 681, 535, 70);
		frame.getContentPane().add(menuPanel);

		JLabel storeNameLabel = new JLabel(topStore.getStoreName());
		storeNameLabel.setHorizontalAlignment(JLabel.CENTER);
		GridBagConstraints gbc_storeNameLabel = new GridBagConstraints();
		gbc_storeNameLabel.fill = GridBagConstraints.BOTH;
		gbc_storeNameLabel.gridwidth = 2;
		gbc_storeNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_storeNameLabel.gridx = 1;
		gbc_storeNameLabel.gridy = 1; 
		menuPanel.add(storeNameLabel, gbc_storeNameLabel);
		storeNameLabel.setOpaque(true);
		storeNameLabel.setPreferredSize(new Dimension(70, 30));
		storeNameLabel.setBackground(Color.LIGHT_GRAY);
		storeNameLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new StoreInfoView().storeInfoViewMain(topStore, "", null, 2, 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				storeNameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});

		JLabel storeIntroduceLabel = new JLabel(topStore.getStoreIntroduce());
		GridBagConstraints gbc_storeIntroduceLabel = new GridBagConstraints();
		gbc_storeIntroduceLabel.fill = GridBagConstraints.BOTH;
		gbc_storeIntroduceLabel.gridwidth = 9;
		gbc_storeIntroduceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_storeIntroduceLabel.gridx = 3;
		gbc_storeIntroduceLabel.gridy = 1;
		storeIntroduceLabel.setPreferredSize(new Dimension(270, 30));
		menuPanel.add(storeIntroduceLabel, gbc_storeIntroduceLabel);
		storeIntroduceLabel.setOpaque(true);
		storeIntroduceLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new StoreInfoView().storeInfoViewMain(topStore, "", null, 2, 0);;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				storeIntroduceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});

		JLabel deliveryTipLabel = new JLabel("<HTML>배달팁<br>"+topStore.getDeliveryTip()+ "원</HTML>");
		deliveryTipLabel.setHorizontalAlignment(JLabel.CENTER);
		GridBagConstraints gbc_deliveryTipLabel = new GridBagConstraints();
		gbc_deliveryTipLabel.fill = GridBagConstraints.BOTH;
		gbc_deliveryTipLabel.gridwidth = 2;
		gbc_deliveryTipLabel.insets = new Insets(0, 0, 5, 5);
		gbc_deliveryTipLabel.gridx = 12;
		gbc_deliveryTipLabel.gridy = 1;
		deliveryTipLabel.setPreferredSize(new Dimension(50, 30));
		menuPanel.add(deliveryTipLabel, gbc_deliveryTipLabel);
		deliveryTipLabel.setOpaque(true);

		JLabel blinkLabel = new JLabel("");
		GridBagConstraints gbc_blinkLabel = new GridBagConstraints();
		gbc_blinkLabel.gridwidth = 15;
		gbc_blinkLabel.gridx = 0;
		gbc_blinkLabel.gridy = 3;
		menuPanel.add(blinkLabel, gbc_blinkLabel);

		JLabel recommendLabel = new JLabel("오늘의 한끼GO BEST!");
		
		recommendLabel.setHorizontalAlignment(JLabel.CENTER);
		recommendLabel.setFont(new Font("굴림", Font.BOLD, 20));
		recommendLabel.setBackground(Color.WHITE);
		recommendLabel.setOpaque(true);
		recommendLabel.setBounds(150, 640, 250, 49);
		frame.getContentPane().add(recommendLabel);

		JLabel lineLabel = new JLabel("");

		lineLabel.setOpaque(true);

		lineLabel.setBackground(Color.ORANGE);
		lineLabel.setBounds(0, 80, 535, 5);
		frame.getContentPane().add(lineLabel);

		JLabel headLabel = new JLabel("음식 카테고리");

		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		headLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(headLabel);

		JButton backBtn = new JButton("이  전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(Color.ORANGE);
		backBtn.setForeground(Color.white);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomeView();
				
			}
		});
		frame.getContentPane().add(backBtn);
		
		image = new ImageIcon("images/KoreanFood.png").getImage().getScaledInstance(100, 100, 0);
		JLabel koreanFoodLabel = new JLabel(new ImageIcon(image));
		koreanFoodLabel.setOpaque(true);
		koreanFoodLabel.setBounds(50, 130, 100, 100);
		koreanFoodLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 1);
				new ChoiceResultView().choiceResultViewMain("한    식", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				koreanFoodLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(koreanFoodLabel);
		
		image = new ImageIcon("images/ChineseFood.png").getImage().getScaledInstance(100, 100, 0);
		JLabel chineseFoodLabel = new JLabel(new ImageIcon(image));
		chineseFoodLabel.setOpaque(true);
		chineseFoodLabel.setBounds(380, 130, 100, 100);
		chineseFoodLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 3);
				new ChoiceResultView().choiceResultViewMain("중    식", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				chineseFoodLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(chineseFoodLabel);
		
		image = new ImageIcon("images/JapaneseFood.png").getImage().getScaledInstance(100, 100, 0);
		JLabel japaneseFoodLabel = new JLabel(new ImageIcon(image));
		japaneseFoodLabel.setOpaque(true);
		japaneseFoodLabel.setBounds(215, 130, 100, 100);
		japaneseFoodLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 2);
				new ChoiceResultView().choiceResultViewMain("일    식", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				japaneseFoodLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(japaneseFoodLabel);
		
		image = new ImageIcon("images/Chicken.png").getImage().getScaledInstance(100, 100, 0);
		JLabel chickenLabel = new JLabel(new ImageIcon(image));
		chickenLabel.setOpaque(true);
		chickenLabel.setBounds(50, 450, 100, 100);
		chickenLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 7);
				new ChoiceResultView().choiceResultViewMain("치    킨", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				chickenLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(chickenLabel);
		
		image = new ImageIcon("images/Dessert.png").getImage().getScaledInstance(100, 100, 0);
		JLabel dessertLabel = new JLabel(new ImageIcon(image));
		dessertLabel.setOpaque(true);
		dessertLabel.setBounds(215, 450, 100, 100);
		dessertLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 8);
				new ChoiceResultView().choiceResultViewMain("디 저 트", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				dessertLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(dessertLabel);
		



		image = new ImageIcon("images/FastFood.png").getImage().getScaledInstance(100, 100, 0);
		JLabel fastFoodLabel = new JLabel(new ImageIcon(image));
		fastFoodLabel.setOpaque(true);
		fastFoodLabel.setBounds(380, 450, 100, 100);
		fastFoodLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 9);
				new ChoiceResultView().choiceResultViewMain("패스트푸드", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fastFoodLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(fastFoodLabel);
		
		image = new ImageIcon("images/Steak.png").getImage().getScaledInstance(100, 100, 0);
		JLabel steakLabel = new JLabel(new ImageIcon(image));
		steakLabel.setOpaque(true);
		steakLabel.setBounds(50, 295, 100, 100);
		steakLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 4);
				new ChoiceResultView().choiceResultViewMain("양    식", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				steakLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(steakLabel);
		
		image = new ImageIcon("images/SnackBar.png").getImage().getScaledInstance(100, 100, 0);
		JLabel snackBarLabel = new JLabel(new ImageIcon(image));
		snackBarLabel.setOpaque(true);
		snackBarLabel.setBounds(215, 295, 100, 100);
		snackBarLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 5);
				new ChoiceResultView().choiceResultViewMain("분    식", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				snackBarLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(snackBarLabel);
		
		image = new ImageIcon("images/Pizza.png").getImage().getScaledInstance(100, 100, 0);
		JLabel pizzaLabel = new JLabel(new ImageIcon(image));
		pizzaLabel.setOpaque(true);
		pizzaLabel.setBounds(380, 295, 100, 100);
		pizzaLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				printList = new CategoryChoiceController().categorySelect(mainList, 6);
				new ChoiceResultView().choiceResultViewMain("피    자", printList, 2);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pizzaLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

		});
		frame.getContentPane().add(pizzaLabel);
	
		
		
		JLabel koreanFoodNameLabel = new JLabel("한  식");
		koreanFoodNameLabel.setBounds(50, 229, 100, 24);
		koreanFoodNameLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(koreanFoodNameLabel);
		
		JLabel japaneseFoodNameLabel = new JLabel("일  식");
		japaneseFoodNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		japaneseFoodNameLabel.setBounds(215, 229, 100, 24);
		frame.getContentPane().add(japaneseFoodNameLabel);
		
		JLabel chineseFoodNameLabel = new JLabel("중  식");
		chineseFoodNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chineseFoodNameLabel.setBounds(380, 229, 100, 24);
		frame.getContentPane().add(chineseFoodNameLabel);
		
		JLabel steakNameLabel = new JLabel("양  식");
		steakNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		steakNameLabel.setBounds(50, 393, 100, 24);
		frame.getContentPane().add(steakNameLabel);
		
		JLabel snackBarNameLabel = new JLabel("분  식");
		snackBarNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		snackBarNameLabel.setBounds(215, 393, 100, 24);
		frame.getContentPane().add(snackBarNameLabel);
		
		JLabel pizzaNameLabel = new JLabel("피  자");
		pizzaNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaNameLabel.setBounds(380, 393, 100, 24);
		frame.getContentPane().add(pizzaNameLabel);
		
		JLabel chickenNameLabel = new JLabel("치  킨");
		chickenNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chickenNameLabel.setBounds(50, 549, 100, 24);
		frame.getContentPane().add(chickenNameLabel);
		
		JLabel dessertNameLabel = new JLabel("디저트");
		dessertNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dessertNameLabel.setBounds(215, 549, 100, 24);
		frame.getContentPane().add(dessertNameLabel);
		
		JLabel fastFoodNameLabel = new JLabel("패스트푸드");
		fastFoodNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fastFoodNameLabel.setBounds(380, 549, 100, 24);
		frame.getContentPane().add(fastFoodNameLabel);
		frame.validate();
		frame.repaint();

	}

}
