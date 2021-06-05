package com.projectGo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.projectGo.model.vo.Store;

public class ChoiceResult extends MainFrame {
	private JFrame frame;
	private ArrayList<Store> printList;
	private int kinds;
	
	
	

	public ChoiceResult() {
		super();
	}








	public void choiceResultMain(String resultName, ArrayList<Store> printList, int kinds) {

		frame = MainFrame.mainFrame;

		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		this.kinds = kinds;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;
		JPanel panel = new JPanel();

		panel.setLayout(gbl);
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 225, 535, 510);
		frame.getContentPane().add(scrollPane);

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

			JLabel hiddenLabel = new JLabel(i + "");
			JLabel storeNameLabel = new JLabel(printList.get(i).getStoreName());
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
					new StoreInfoView(printList.get(num), resultName, printList, 3, kinds);

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					storeNameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

			});

			JLabel storeIntroduceLabel = new JLabel(printList.get(i).getStoreIntroduce());
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
					new StoreInfoView(printList.get(num), resultName, printList, 3, kinds);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					storeIntroduceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

			});

			JLabel deliveryTipLabel = new JLabel("<HTML>배달팁<br>" + printList.get(i).getDeliveryTip() + "원</HTML>");
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

		JLabel choiceKeywordLabel = new JLabel(resultName);

		choiceKeywordLabel.setOpaque(true);
		choiceKeywordLabel.setBounds(150, 130, 250, 70);
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
		headLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(headLabel);

		JButton backBtn = new JButton("이  전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(new Color(255, 128, 0));
		backBtn.setForeground(Color.white);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(kinds == 1) {
					
					new SerchPageView().serchMain();
					
				}else {
					
					new CategoryChoiceView().categoryMain();
					
				}
				
			}
		});
		frame.getContentPane().add(backBtn);

		JButton homeBtn = new JButton("홈으로");
		homeBtn.setBounds(440, 20, 80, 40);
		homeBtn.setBackground(new Color(255, 128, 0));
		homeBtn.setForeground(Color.white);
		homeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewTemp();
				
			}
		});
		frame.getContentPane().add(homeBtn);
		frame.validate();
		frame.repaint();
		
		
	}

}
