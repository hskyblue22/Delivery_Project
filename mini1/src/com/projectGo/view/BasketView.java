package com.projectGo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import com.projectGo.controller.BasketController;
import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Menu;

public class BasketView extends MainFrame{
	
	private JFrame frame;
	
	BasketController basCont;
	private int quantity;
	private int menuPrice;
	
	
	public BasketView(Basket basket, StoreInfoView storeInfoView) {     //view로 전달받아 controller로 전달
		
		MainFrame.basket = basket;
		MainFrame.storeInfoView = storeInfoView;
		
		basCont = new BasketController(basket);
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		initialize();
	}

	
	
	private void initialize() {

		
		JLabel mainLabel = new JLabel("장바구니");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		mainLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(mainLabel);

		
		JButton homeButton = new JButton("홈으로");
		homeButton.setFont(new Font("굴림", Font.PLAIN, 15));
		homeButton.setBounds(15, 20, 80, 40);
		homeButton.setSize(80, 40);
		homeButton.setBackground(Color.orange);
		homeButton.setForeground(Color.white);
		homeButton.setBorderPainted(false); // 테두리 제거
		homeButton.setFocusPainted(false); // 텍스트 테두리 제거
		frame.getContentPane().add(homeButton);
		
		homeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//홈에서 다시 메뉴로 돌아왔을 때 데이터 유지
				new HomeView();
			}
		});

		
		try {
			if (basket.getMenuList() == null) {
				
				listEmpty();
				
			} else {

				notEmpty();

			}	
		} catch(NullPointerException e) {
			
			listEmpty();
		}

	}


	private void listEmpty() {

		JLabel emptyLab = new JLabel("텅텅 비었습니다.");
		emptyLab.setHorizontalAlignment(JLabel.CENTER);
		emptyLab.setFont(new Font("굴림",Font.PLAIN, 25));
		emptyLab.setBounds(150, 300, 250, 60);
		frame.getContentPane().add(emptyLab);
		
	}
	
	
	private void notEmpty() {
		
		JButton delBtn = new JButton("전체삭제");
		delBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		delBtn.setBounds(420, 20, 100, 40);
		delBtn.setBackground(Color.orange);
		delBtn.setForeground(Color.white);
		delBtn.setBorderPainted(false); //테두리 제거
		delBtn.setFocusPainted(false); //텍스트 테두리 제거
		frame.getContentPane().add(delBtn);
		
		//전체 삭제 버튼 누르면  메뉴 전체 삭제
		delBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				basCont.deleteAll();
				MainFrame.basket = null;
				
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				initialize();
				
			}
		});
		
			
		int count = basCont.getMenuListSize();
		
		//식당명
		JLabel storeName = new JLabel(basCont.getStoreName());
		storeName.setFont(new Font("굴림",Font.PLAIN, 25));
		storeName.setBounds(15, 80, 250, 60);
		frame.getContentPane().add(storeName);
		
		int height = 145;
		if(145*count > 471) {
			height = 471;
		}else {
			height = 145*count;
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 161, 535, height); //440
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setForeground(Color.WHITE);
		MenuPanel.setBackground(Color.WHITE);
		scrollPane.setViewportView(MenuPanel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 440, 10};
		gbl_panel.rowHeights = new int[count];
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[count]; 
		MenuPanel.setLayout(gbl_panel);
		
		
		JButton orderButton = new JButton("주문하기");
		orderButton.setFont(new Font("굴림", Font.BOLD,17));
		orderButton.setForeground(Color.WHITE);
		orderButton.setBackground(Color.ORANGE);
		orderButton.setBounds(-1, 690, 535, 60);
		orderButton.setBorderPainted(false); //테두리 제거
		orderButton.setFocusPainted(false); //텍스트 테두리 제거
		frame.getContentPane().add(orderButton);
		
		//주문하기	
		orderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//주문하기 화면을 넘기고 basket객체 넘기기
				basCont.order();
			}
		});
		
		
		// 메뉴 추가 버튼 누르면 음식점 상세 페이지로
		JButton addMenuButton = new JButton("메뉴 추가하기");
		addMenuButton.setFont(new Font("굴림", Font.BOLD, 17));
		addMenuButton.setBackground(Color.WHITE);
		addMenuButton.setBounds(0, 631, 535, 60);
		addMenuButton.setFocusPainted(false); //텍스트 테두리 제거
		frame.getContentPane().add(addMenuButton);
		
		addMenuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new StoreInfoView().storeInfoViewMainPre(storeInfoView.getStore(), storeInfoView.getResultName(), storeInfoView.getPrintList(), storeInfoView.getKinds(), storeInfoView.getSerchKinds(), storeInfoView.getMenulist());
				
			}
		});
		
		
		int i = 0;
		
		Iterator<Entry<String, Menu>> iter = basCont.selectedMenu();

		while(iter.hasNext()) {
		
			Entry<String, Menu> entry = iter.next();
			quantity = entry.getValue().getQuantity();
			menuPrice = entry.getValue().getMenuPrice();

			
			gbl_panel.rowHeights[i] = 145;
			gbl_panel.rowWeights[i] = 0.0;
			
			
			JPanel menu_1 = new JPanel();
			menu_1.setLayout(null);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 1;
			gbc_panel_1.gridy = i;
			MenuPanel.add(menu_1, gbc_panel_1);
			menu_1.setToolTipText(entry.getKey());
			
			
			//메뉴명
			JLabel nameLab = new JLabel(entry.getKey());
			nameLab.setBounds(39, 47, 120, 15);
			menu_1.add(nameLab);
			
			//가격
			JLabel priceLab = new JLabel(String.valueOf(menuPrice * quantity));
			priceLab.setBounds(39, 75, 100, 15);
			menu_1.add(priceLab);
			
			
			//수량
			
			JLabel quantLab = new JLabel(String.valueOf(quantity));
			quantLab.setBounds(247, 68, 49, 30);
			quantLab.setHorizontalAlignment(SwingConstants.CENTER);
			menu_1.add(quantLab);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(247, 68, 49, 30);
			menu_1.add(panel);
			
			
			JButton plusButton = new JButton("▲");
			plusButton.setForeground(Color.WHITE);
			plusButton.setBackground(Color.ORANGE);
			plusButton.setBounds(308, 67, 48, 30);
			plusButton.setBorderPainted(false); //테두리 제거
			plusButton.setFocusPainted(false); //텍스트 테두리 제거
			menu_1.add(plusButton);
			
			
			//+버튼 누를 경우 수량 +1
			
			
			plusButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String menu = menu_1.getToolTipText();
					
					int plusQuantity = basCont.getMenuQuantity(menu) + 1; //해당하는 메뉴의 수량  + 1

					basCont.modifyQuantity(menu, plusQuantity); //메뉴 수량 수정

					int calcPrice = basCont.getMenuPrice(menu) * plusQuantity; //가격 * 수정된 수량
					
					quantLab.setText(String.valueOf(plusQuantity));
					priceLab.setText(String.valueOf(calcPrice));
					
				}
			});
			
			
			JButton minusButton = new JButton("▼");
			minusButton.setBackground(Color.ORANGE);
			minusButton.setForeground(Color.WHITE);
			minusButton.setBounds(183, 67, 48, 30);
			minusButton.setBorderPainted(false); //테두리 제거
			minusButton.setFocusPainted(false); //텍스트 테두리 제거
			menu_1.add(minusButton);


			//-버튼 누를경우
			
			minusButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String menu = menu_1.getToolTipText();
					
					int minusQuantity = basCont.getMenuQuantity(menu) - 1;
					
					if(minusQuantity < 1) {  //최수 수량 1
						minusQuantity = 1;
					}
					
					basCont.modifyQuantity(menu, minusQuantity);
					
					int calcPrice = basCont.getMenuPrice(menu) * minusQuantity;

					quantLab.setText(String.valueOf(minusQuantity));
					priceLab.setText(String.valueOf(calcPrice));
					
				}
			});
			
			
			JButton deleteButton = new JButton("X");
			deleteButton.setBackground(Color.ORANGE);
			deleteButton.setForeground(Color.WHITE);
			deleteButton.setBounds(375, 10, 45, 30);
			deleteButton.setBorderPainted(false); //테두리 제거
			deleteButton.setFocusPainted(false); //텍스트 테두리 제거
			menu_1.add(deleteButton);
			
			
			//삭제 버튼 누를경우
			
			deleteButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					basCont.deleteBasketMenu(menu_1.getToolTipText());
					if(basCont.getMenuListSize() == 0) {
						MainFrame.basket = null;
					}
					
					frame.getContentPane().removeAll();
					frame.validate();
					frame.repaint();
					initialize();
					
				}
			});
			
			
			i++;
		}
		
		frame.validate();
		frame.repaint();
	}

}
