package com.projectGo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.projectGo.controller.SerchPage;
import com.projectGo.controller.StoreSort;
import com.projectGo.model.dao.DaoTemp;
import com.projectGo.model.dao.StoreLoad;
import com.projectGo.model.vo.Member;
import com.projectGo.model.vo.Store;

public class SerchPageView extends MainFrame {

	

	Member member;
	ArrayList<String> preSerchNum;
	ArrayList<String> preSerchList;
	ArrayList<Store> mainList, recommendList;
	Scanner sc = new Scanner(System.in);
	JFrame frame;
	String resultName;
	DaoTemp dt;

	public void serchMain() {
		String userName = "user02";
		dt = new DaoTemp();
		member = dt.memberLoad(userName);
		preSerchList = member.getPreSerchList();
		preSerchNum = member.getPreSerchNum();
		resultName = "";
		mainList = new StoreLoad().storeLoad();
		recommendList = new StoreSort().recommendStore(mainList);

		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		JPanel panel = new JPanel();

		panel.setLayout(gbl);
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 293, 535, 442);
		frame.getContentPane().add(scrollPane);

		for (int i = 0; i < recommendList.size(); i++) {

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

			JLabel hiddenLabel = new JLabel(i + "");
			JLabel storeNameLabel = new JLabel(recommendList.get(i).getStoreName());
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
					int num = Integer.parseInt(hiddenLabel.getText());
					new StoreInfoView(recommendList.get(num), resultName, recommendList, 1, 0);

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					storeNameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

			});

			JLabel storeIntroduceLabel = new JLabel(recommendList.get(i).getStoreIntroduce());
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
					int num = Integer.parseInt(hiddenLabel.getText());
					new StoreInfoView(recommendList.get(num), resultName, recommendList, 1, 0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					storeIntroduceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

			});

			JLabel deliveryTipLabel = new JLabel("<HTML>배달팁<br>" + recommendList.get(i).getDeliveryTip() + "원</HTML>");
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
		for (int i = recommendList.size(); i < 7; i++) {

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
			gbc.gridy = (i * 150) + 10;
			gbc.gridwidth = 530;
			gbc.gridheight = 150;
			gbl.setConstraints(menuPanel, gbc);
			panel.add(menuPanel);
			panel.updateUI();

		}

		JLabel recommendLabel = new JLabel("카테고리별 추천 음식점");

		recommendLabel.setHorizontalAlignment(JLabel.CENTER);
		recommendLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		recommendLabel.setBackground(Color.WHITE);
		recommendLabel.setOpaque(true);
		recommendLabel.setBounds(150, 235, 250, 50);
		frame.getContentPane().add(recommendLabel);

		JLabel lineLabel = new JLabel("");

		lineLabel.setOpaque(true);

		lineLabel.setBackground(Color.ORANGE);
		lineLabel.setBounds(0, 80, 535, 5);
		frame.getContentPane().add(lineLabel);

		JLabel headLabel = new JLabel("메뉴, 음식점 검색");

		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		// lblNewLabel_2.setOpaque(true);
		headLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(headLabel);

		JButton backBtn = new JButton("이  전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(new Color(255, 128, 0));
		backBtn.setForeground(Color.white);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewTemp();

			}
		});
		frame.getContentPane().add(backBtn);

		String[] serchKind = { "검색선택", "메뉴", "음식점" };
		JComboBox serchChoiceBox = new JComboBox(serchKind);
		serchChoiceBox.setBounds(15, 110, 80, 30);
		frame.getContentPane().add(serchChoiceBox);

		JTextField textField = new JTextField();
		textField.setBounds(105, 105, 330, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton serchBtn = new JButton("검  색");
		serchBtn.setBounds(450, 105, 70, 40);
		serchBtn.setBackground(new Color(255, 128, 0));
		serchBtn.setForeground(Color.white);
		serchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (serchChoiceBox.getSelectedIndex() == 0) {

					return;

				} else if (serchChoiceBox.getSelectedIndex() == 1) {
					ArrayList<String> temp1 = new ArrayList<String>();
					ArrayList<String> temp2 = new ArrayList<String>();
					preSerchNum.add(0, "1");
					preSerchList.add(0, textField.getText());
					if (preSerchNum.size() > 5) {

						temp1.addAll(preSerchNum.subList(0, 5));
						preSerchNum = temp1;
						temp2.addAll(preSerchList.subList(0, 5));
						preSerchList = temp2;

					}

					dt.memberSave(preSerchList, preSerchNum);
					new ChoiceResult().choiceResultMain("'" + textField.getText() + "' 검색결과",
							new SerchPage().serchMenu(mainList, textField.getText()), 1);

				} else {
					preSerchNum.add(0, "2");
					preSerchList.add(0, textField.getText());
					if (preSerchNum.size() > 5) {

						ArrayList<String> temp1 = new ArrayList<String>();
						ArrayList<String> temp2 = new ArrayList<String>();
						temp1.addAll(preSerchNum.subList(0, 5));
						preSerchNum = temp1;
						temp2.addAll(preSerchList.subList(0, 5));
						preSerchList = temp2;

					}
					dt.memberSave(preSerchList, preSerchNum);
					new ChoiceResult().choiceResultMain("'" + textField.getText() + "' 검색결과",
							new SerchPage().serchStoreName(mainList, textField.getText()), 1);
				}

			}
		});
		frame.getContentPane().add(serchBtn);

		JPanel preSerchPanel = new JPanel();

		preSerchPanel.setBounds(15, 155, 505, 40);
		preSerchPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(preSerchPanel);
		preSerchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel preNameLabel = new JLabel("이전 검색어 : ");
		preNameLabel.setBackground(Color.WHITE);
		preNameLabel.setOpaque(true);
		preNameLabel.setPreferredSize(new Dimension(80, 40));
		preSerchPanel.add(preNameLabel);
		if(preSerchList == null) {
			
			preSerchList = new ArrayList<String>();
			preSerchNum = new ArrayList<String>();
		}
		for (int i = 0; i < preSerchList.size(); i++) {

			JLabel preSerchLabel = new JLabel("[" + preSerchList.get(i) + "]");
			JLabel hiddenLbel2 = new JLabel(i + "");
			preSerchLabel.setBackground(Color.WHITE);
			preSerchLabel.setOpaque(true);
			preSerchLabel.setPreferredSize(new Dimension(70, 40));
			preSerchPanel.add(preSerchLabel);
			preSerchLabel.addMouseListener(new MouseAdapter() {
				int num = Integer.parseInt(hiddenLbel2.getText());

				@Override
				public void mousePressed(MouseEvent e) {
					if (Integer.parseInt(preSerchNum.get(num)) == 1) {
						new ChoiceResult().choiceResultMain("'" + preSerchList.get(num) + "' 검색결과",
								new SerchPage().serchMenu(mainList, preSerchList.get(num)), 1);

					} else {
						new ChoiceResult().choiceResultMain("'" + preSerchList.get(num) + "' 검색결과",
								new SerchPage().serchStoreName(mainList, preSerchList.get(num)), 1);
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					preSerchLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

			});

			if (i < 4) {
				JLabel preBlankLabel = new JLabel();
				preBlankLabel.setBackground(Color.WHITE);
				preBlankLabel.setOpaque(true);
				preBlankLabel.setPreferredSize(new Dimension(5, 40));
				preSerchPanel.add(preBlankLabel);

			}
		}

		frame.validate();
		frame.repaint();
	}

}
