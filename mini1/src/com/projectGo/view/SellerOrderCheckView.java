package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.projectGo.controller.OrderListController;
import com.projectGo.controller.SellerController;
import com.projectGo.model.dao.ReviewListDao;
import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Order;

public class SellerOrderCheckView extends MouseAdapter {
	
	JFrame frame;
	
	private JPanel contentPane;
	private JPanel panel;
	public JButton backBtn;
	private ArrayList<Order> sellerOrderList;
	private OrderListController olc;
	private String userID;
	private String menuPic;
	private Image image;
	private int i;
	private String request;
	private String date;
	private String[] menus;  //메뉴이름+가격
	private String[][] totalmenus;  //menus index로 꺼내려고 만든 객체배열인데 다른방법으로 하는게 편하지 않을까?_06.11
	
	

		public SellerOrderCheckView() {
			//메인프레임
			frame = MainFrame.mainFrame;
			frame.getContentPane().removeAll();
			frame.validate();
			frame.repaint();
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setBackground(Color.white);
			frame.setContentPane(contentPane);
			contentPane.setLayout(null); 

			orderCheck();

		}
		
		public void orderCheck() {
			SellerController sc = new SellerController();
			sellerOrderList = sc.loadSellerOrder(); //내 아이디에 해당하는 주문 받아옴
			
			//title(제목, 이전버튼)
			JLabel headLabel = new JLabel("주 문 내 역");
			headLabel.setHorizontalAlignment(JLabel.CENTER);
			headLabel.setFont(new Font("굴림",Font.PLAIN, 30));
			headLabel.setBounds(140, 10, 250, 60);
			frame.getContentPane().add(headLabel);
			
			//이전버튼
			backBtn = new JButton("홈으로");
			backBtn.setBounds(15,20,80,40);
			backBtn.setBackground(Color.orange); 
			backBtn.setForeground(Color.white);  
		    frame.getContentPane().add(backBtn);  
		    
		    // 홈으로 이동
		    backBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new SellerMain();
				}
			});
		    
			// 스크롤판, 전체패널
			JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(12, 110, 512, 640);
			contentPane.add(scrollPane);

			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			scrollPane.setViewportView(panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
		  	
		    
		    if(sellerOrderList.size() == 0) {  //수정완료_06.11
		    	listEmpty();
		    	
		    }else {             //주문내역이 있는 경우
		    	makeList();
		    }
			
			frame.validate();
			frame.repaint();	
		}

		
		//주문내역 생성
		private void makeList() {
			
			totalmenus = new String[sellerOrderList.size()][];
			
			for( i=0; i<sellerOrderList.size() ; i++) { 
				
				//각 주문내역 패널
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = i;
				panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
				panel.add(panel_1, gbc_panel_1);
				
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[] { 97, 97, 97, 97, 97, 0 };
				gbl_panel_1.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 0 };
				gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				panel_1.setLayout(gbl_panel_1);
				
				//패널번호 --> 파일에서 삭제할 때 index로 넘기기
				panel_1.setToolTipText(String.valueOf(i)); //패널번호 = sellerOrderList인덱스
				int panelIndex = Integer.parseInt(panel_1.getToolTipText()); 
		    	
				//날짜, 요청사항, 총금액 초기화
				date = StringFromCalendar(sellerOrderList.get(i).getOrderedDate());
		    	request = sellerOrderList.get(i).getRequest();
		    	int totalPay = sellerOrderList.get(i).getPayment();
		    	
		    	//음식사진, 메뉴별 [이름 + 수량]
		    	HashMap<String, Menu> menuMap =sellerOrderList.get(i).getBasket().getMenuList();
		    	
		    	Set<String> menunames = menuMap.keySet();
		    	Iterator<String> mi = menunames.iterator();
		    	int menuIndex = 0;
		    	menus = new String[menunames.size()];
		    	
		    	while(mi.hasNext()) {
		    		
		    		String key = mi.next();
		    		
		    		menuPic = menuMap.get(key).getMenuPic();
		    		String menu = key +"    "+ menuMap.get(key).getQuantity()+"개";
		    		menus[menuIndex] = menu;
		    		
		    		JLabel lblNewLabel_3_1 = new JLabel(menu);
					GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
					gbc_lblNewLabel_3_1.gridwidth = 2;
					gbc_lblNewLabel_3_1.fill = GridBagConstraints.BOTH;
					gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_3_1.gridx = 1;
					gbc_lblNewLabel_3_1.gridy = 2 + (menuIndex++);
					panel_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		    	
		    	}
				
		    	totalmenus[panelIndex] = menus;
				
				//주문날짜
				JLabel lblNewLabel = new JLabel(date);
				lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				panel_1.add(lblNewLabel, gbc_lblNewLabel);

				//주문완료,배달완료
				String condition = "주문완료";
				if(sellerOrderList.get(panelIndex).isOrderState()) {  //나중에 바꿔야 함!!
					condition = "배달완료";
				}
				JLabel lblNewLabel_1 = new JLabel(condition);
				lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 2;
				gbc_lblNewLabel_1.gridy = 0;
				panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				//메뉴사진 - 마지막메뉴사진
				image = new ImageIcon(menuPic).getImage().getScaledInstance(50, 50, 0);
				JLabel lblNewLabel_2 = new JLabel(new ImageIcon(image));
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 1;
				panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

				//요청사항
				JLabel lblNewLabel_3 = new JLabel("요청사항 : " + request);
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 1;
				gbc_lblNewLabel_3.gridy = 1;
				panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

				//총 결제금액
				JLabel label_18 = new JLabel("총 결제금액 : "+totalPay +"원");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton.gridwidth = 2;
				gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton.gridx = 3;
				gbc_btnNewButton.gridy = 4;
				panel_1.add(label_18, gbc_btnNewButton);

				JButton btnNewButton_1 = new JButton("내역삭제"); // 내역 삭제
				GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
				gbc_btnNewButton1.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton1.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton1.gridx = 2;
				
				if(menunames.size() >= 5) {  //메뉴 많아지면 알아서 길이지도록 좌표수정_06.11
					gbc_btnNewButton1.gridy = menunames.size() + 2;
				}else {
					gbc_btnNewButton1.gridy = 6;
				}	
//				gbc_btnNewButton1.gridy = 6;
				btnNewButton_1.setBackground(Color.orange);
				btnNewButton_1.setForeground(Color.white);


				JButton btnNewButton = new JButton("주문취소");
				GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
				gbc_btnNewButton2.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton2.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton2.gridx = 3;
				
				if(menunames.size() >= 5) {  //메뉴 많아지면 알아서 길이지도록 좌표수정_06.11
					gbc_btnNewButton2.gridy = menunames.size() + 2;
				}else {
					gbc_btnNewButton2.gridy = 6;
				}			
//				gbc_btnNewButton2.gridy = 6;
				btnNewButton.setBackground(Color.orange);
				btnNewButton.setForeground(Color.white);
				panel_1.add(btnNewButton, gbc_btnNewButton2);
				
				
				btnNewButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(lblNewLabel_1.getText().equals("배달완료")) {
							int result = JOptionPane.showConfirmDialog(btnNewButton_1, "주문을 취소하시겠습니까?", "주문취소",
									JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.YES_OPTION) {
								// 화면 삭제
								remove();
								// 주문내역 삭제
								olc.deleteOrder(panelIndex);
								// 삭제된 주문내역 파일에 저장
								olc.saveListFile();
								// 화면 다시 만들기(새로 저장한 내역 다시 스크롤판에 나타내기)
								orderCheck();
							}
						} else {
							JOptionPane.showMessageDialog(btnNewButton_1,
									"배달이 완료되어 주문을 취소할 수 없습니다.","주의",JOptionPane.WARNING_MESSAGE);
							btnNewButton.setEnabled(false);
						}
					}
				});
				

				JButton btnNewButton_2 = new JButton("배달완료"); // static 변경
				GridBagConstraints gbc_btnNewButton3 = new GridBagConstraints();
				gbc_btnNewButton3.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton3.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton3.gridx = 4;
				
				if(menunames.size() >= 5) {  //메뉴 많아지면 알아서 길이지도록 좌표수정_06.11
					gbc_btnNewButton3.gridy = menunames.size() + 2;
				}else {
					gbc_btnNewButton3.gridy = 6;
				}
				
				btnNewButton_2.setBackground(Color.orange);
				btnNewButton_2.setForeground(Color.white);
				panel_1.add(btnNewButton_2, gbc_btnNewButton3);
				
				userID = MainFrame.loginUserId;	
				
				btnNewButton_2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						sellerOrderList.get(panelIndex).setOrderState(true);
						
					}
				});
					
				
			frame.validate();
			frame.repaint();
			
			}
			
		}
		
		public void listEmpty() {
			// TODO Auto-generated method stub
			JLabel empty = new JLabel("아직 받은 주문이 없습니다");
			empty.setFont(new Font("굴림", Font.PLAIN, 20));
			panel.add(empty);
		}
		
		public String StringFromCalendar(Calendar cal) {
			// 날짜를 통신용 문자열로 변경
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
			return formatter.format(cal.getTime());
		} 

		public void remove() {
			frame.getContentPane().removeAll();
			frame.validate();
			frame.repaint();
		}
		
		}