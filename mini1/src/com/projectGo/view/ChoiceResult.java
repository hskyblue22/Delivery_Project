package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.projectGo.model.vo.Store;

public class ChoiceResult {
	private JFrame frame;
	private ArrayList<Store> printList;

	public void choiceResultMain(String resultName, ArrayList<Store> printList) {

		System.out.println(resultName);

		for (Store s : printList) {

			System.out.println(s.getStoreName() + "     " + s.getStoreIntroduce() + "      " + s.getDeliveryTip());

		}

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 550, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		JPanel panel = new JPanel();

		panel.setLayout(gbl);
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 225, 535, 510);
		frame.getContentPane().add(scrollPane);

//		JPanel menuPanel = new JPanel();
//		menuPanel.setBackground(Color.WHITE);
//		GridBagLayout gbl_menuPanel = new GridBagLayout();
//		gbl_menuPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//				0.0 };
//		gbl_menuPanel.rowHeights = new int[] { 15, 35, 15};
//		gbl_menuPanel.columnWidths = new int[] { 35, 0, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35 };
//
//		menuPanel.setLayout(gbl_menuPanel);
//		menuPanel.setBounds(0, 120, 535, 70);
//		frame.getContentPane().add(menuPanel);
//						
//								JLabel menuPicLabel_1 = new JLabel("New label");
//								GridBagConstraints gbc_menuPicLabel_1 = new GridBagConstraints();
//								gbc_menuPicLabel_1.fill = GridBagConstraints.BOTH;
//								gbc_menuPicLabel_1.gridwidth = 2;
//								gbc_menuPicLabel_1.insets = new Insets(0, 0, 5, 5);
//								gbc_menuPicLabel_1.gridx = 1;
//								gbc_menuPicLabel_1.gridy = 1;
//								menuPanel.add(menuPicLabel_1, gbc_menuPicLabel_1);
//								menuPicLabel_1.setOpaque(true);
//								menuPicLabel_1.setBackground(Color.LIGHT_GRAY);
//				
//						JLabel menuNameLabel_1 = new JLabel("New label");
//						GridBagConstraints gbc_menuNameLabel_1 = new GridBagConstraints();
//						gbc_menuNameLabel_1.fill = GridBagConstraints.BOTH;
//						gbc_menuNameLabel_1.gridwidth = 9;
//						gbc_menuNameLabel_1.insets = new Insets(0, 0, 5, 5);
//						gbc_menuNameLabel_1.gridx = 3;
//						gbc_menuNameLabel_1.gridy = 1;
//						menuPanel.add(menuNameLabel_1, gbc_menuNameLabel_1);
//						menuNameLabel_1.setOpaque(true);
//		
//				JLabel menuPriceLabel_1 = new JLabel("New label");
//				GridBagConstraints gbc_menuPriceLabel_1 = new GridBagConstraints();
//				gbc_menuPriceLabel_1.fill = GridBagConstraints.BOTH;
//				gbc_menuPriceLabel_1.gridwidth = 2;
//				gbc_menuPriceLabel_1.insets = new Insets(0, 0, 5, 5);
//				gbc_menuPriceLabel_1.gridx = 12;
//				gbc_menuPriceLabel_1.gridy = 1;
//				menuPanel.add(menuPriceLabel_1, gbc_menuPriceLabel_1);
//				menuPriceLabel_1.setOpaque(true);
//		
//		JLabel blinkLabel = new JLabel("");
//		GridBagConstraints gbc_blinkLabel = new GridBagConstraints();
//		gbc_blinkLabel.gridwidth = 15;
//		gbc_blinkLabel.gridx = 0;
//		gbc_blinkLabel.gridy = 3;
//		menuPanel.add(blinkLabel, gbc_blinkLabel);

		for (int i = 0; i < printList.size(); i++) {

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

			JLabel menuPicLabel_1 = new JLabel("New l11111l");
			GridBagConstraints gbc_menuPicLabel_1 = new GridBagConstraints();
			gbc_menuPicLabel_1.fill = GridBagConstraints.BOTH;
			gbc_menuPicLabel_1.gridwidth = 2;
			gbc_menuPicLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_menuPicLabel_1.gridx = 1;
			gbc_menuPicLabel_1.gridy = 1;
			menuPanel.add(menuPicLabel_1, gbc_menuPicLabel_1);
			menuPicLabel_1.setOpaque(true);
			menuPicLabel_1.setBackground(Color.LIGHT_GRAY);

			JLabel menuNameLabel_1 = new JLabel("New label");
			GridBagConstraints gbc_menuNameLabel_1 = new GridBagConstraints();
			gbc_menuNameLabel_1.fill = GridBagConstraints.BOTH;
			gbc_menuNameLabel_1.gridwidth = 9;
			gbc_menuNameLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_menuNameLabel_1.gridx = 3;
			gbc_menuNameLabel_1.gridy = 1;
			menuPanel.add(menuNameLabel_1, gbc_menuNameLabel_1);
			menuNameLabel_1.setOpaque(true);

			JLabel menuPriceLabel_1 = new JLabel("New label");
			GridBagConstraints gbc_menuPriceLabel_1 = new GridBagConstraints();
			gbc_menuPriceLabel_1.fill = GridBagConstraints.BOTH;
			gbc_menuPriceLabel_1.gridwidth = 2;
			gbc_menuPriceLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_menuPriceLabel_1.gridx = 12;
			gbc_menuPriceLabel_1.gridy = 1;
			menuPanel.add(menuPriceLabel_1, gbc_menuPriceLabel_1);
			menuPriceLabel_1.setOpaque(true);

			JLabel blinkLabel = new JLabel("");
			GridBagConstraints gbc_blinkLabel = new GridBagConstraints();
			gbc_blinkLabel.gridwidth = 15;
			gbc_blinkLabel.gridx = 0;
			gbc_blinkLabel.gridy = 3;
			menuPanel.add(blinkLabel, gbc_blinkLabel);

			gbc = new GridBagConstraints();

			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = (i * 150) + 10;
			gbc.gridwidth = 530;
			gbc.gridheight = 150;
			gbl.setConstraints(menuPanel, gbc);
			panel.add(menuPanel);

			panel.updateUI();

		}
		for (int i = printList.size(); i < 8; i++) {

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

//			JLabel menuPicLabel_1 = new JLabel("New laasdadbel");
//			GridBagConstraints gbc_menuPicLabel_1 = new GridBagConstraints();
//			gbc_menuPicLabel_1.fill = GridBagConstraints.BOTH;
//			gbc_menuPicLabel_1.gridwidth = 2;
//			gbc_menuPicLabel_1.insets = new Insets(0, 0, 5, 5);
//			gbc_menuPicLabel_1.gridx = 1;
//			gbc_menuPicLabel_1.gridy = 1;
//			menuPanel.add(menuPicLabel_1, gbc_menuPicLabel_1);
//			menuPicLabel_1.setOpaque(true);
//			menuPicLabel_1.setBackground(Color.LIGHT_GRAY);
//
//			JLabel menuNameLabel_1 = new JLabel("New label");
//			GridBagConstraints gbc_menuNameLabel_1 = new GridBagConstraints();
//			gbc_menuNameLabel_1.fill = GridBagConstraints.BOTH;
//			gbc_menuNameLabel_1.gridwidth = 9;
//			gbc_menuNameLabel_1.insets = new Insets(0, 0, 5, 5);
//			gbc_menuNameLabel_1.gridx = 3;
//			gbc_menuNameLabel_1.gridy = 1;
//			menuPanel.add(menuNameLabel_1, gbc_menuNameLabel_1);
//			menuNameLabel_1.setOpaque(true);
//
//			JLabel menuPriceLabel_1 = new JLabel("New asfasf");
//			GridBagConstraints gbc_menuPriceLabel_1 = new GridBagConstraints();
//			gbc_menuPriceLabel_1.fill = GridBagConstraints.BOTH;
//			gbc_menuPriceLabel_1.gridwidth = 2;
//			gbc_menuPriceLabel_1.insets = new Insets(0, 0, 5, 5);
//			gbc_menuPriceLabel_1.gridx = 12;
//			gbc_menuPriceLabel_1.gridy = 1;
//			menuPanel.add(menuPriceLabel_1, gbc_menuPriceLabel_1);
//			menuPriceLabel_1.setOpaque(true);
//
//			JLabel blinkLabel = new JLabel("");
//			GridBagConstraints gbc_blinkLabel = new GridBagConstraints();
//			gbc_blinkLabel.gridwidth = 15;
//			gbc_blinkLabel.gridx = 0;
//			gbc_blinkLabel.gridy = 3;
//			menuPanel.add(blinkLabel, gbc_blinkLabel);

			gbc = new GridBagConstraints();

			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = (i * 150) + 10;
			gbc.gridwidth = 530;
			gbc.gridheight = 150;
			gbl.setConstraints(menuPanel, gbc);
			panel.add(menuPanel);
			System.out.println("asfasf");
			panel.updateUI();

		}

		JLabel choiceKeywordLabel = new JLabel("New label");

		choiceKeywordLabel.setOpaque(true);
		choiceKeywordLabel.setBounds(150, 100, 250, 70);
		choiceKeywordLabel.setHorizontalAlignment(JLabel.CENTER);
		choiceKeywordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		frame.getContentPane().add(choiceKeywordLabel);

		JLabel lineLabel = new JLabel("");

		lineLabel.setOpaque(true);

		lineLabel.setBackground(Color.ORANGE);
		lineLabel.setBounds(0, 80, 535, 5);
		frame.getContentPane().add(lineLabel);

		JLabel headLabel = new JLabel("검색, 조회 결과");

		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		// lblNewLabel_2.setOpaque(true);
		headLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(headLabel);

		JButton backBtn = new JButton("이  전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(new Color(255, 128, 0));
		backBtn.setForeground(Color.white);
		frame.getContentPane().add(backBtn);

		JButton homeBtn = new JButton("홈으로");
		homeBtn.setBounds(440, 20, 80, 40);
		homeBtn.setBackground(new Color(255, 128, 0));
		homeBtn.setForeground(Color.white);
		frame.getContentPane().add(homeBtn);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
