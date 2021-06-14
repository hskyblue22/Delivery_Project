package com.projectGo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.projectGo.controller.ReviewListController;
import com.projectGo.model.dao.ReviewListDao;
import com.projectGo.model.dao.StoreDao;
import com.projectGo.model.vo.Review;

public class WriteReview implements ActionListener {

	private JPanel contentPane;
	public JFrame frame;
	public JButton backBtn;
	private ReviewListController rlc;
	private Image image;
	
	private String userID;
	private String date;
	private String storeName;
	private String[] menus;
	
	private int reviewScore = -1;
	private String reviewContents = "리뷰를 입력해주세요:)";
	
	private Review review;
	
	private JRadioButton jb1;
	private JRadioButton jb2;
	private JRadioButton jb3;
	private JRadioButton jb4;
	private JRadioButton jb5;
	
	public WriteReview() {
		init();
	}

	public WriteReview(String date2, String storeName2, String[] menus2, String userID2) {
		this.date = date2;
		this.storeName = storeName2;
		this.menus = menus2;
		this.userID = userID2;
		
		init();
	}
	
	public WriteReview(String date, String storeName, String[] menus, String userID, String contents, int score) {
		this.date = date;
		this.storeName = storeName;
		this.menus = menus;
		this.userID = userID;
		this.reviewContents = contents;
		this.reviewScore = score;
		
		init();
	}
	

	public void init() {
		
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//title(제목, 이전버튼)
		JLabel lblNewLabel = new JLabel("리뷰작성");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 10, 250, 60);
		contentPane.add(lblNewLabel);
		
		backBtn = new JButton("이   전");
		backBtn.setForeground(Color.WHITE);
		backBtn.setBackground(Color.ORANGE);
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBorderPainted(false); 
		backBtn.setFocusPainted(false); 
		contentPane.add(backBtn);
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderListView();
			}
		});
		image = new ImageIcon("images/user.png").getImage().getScaledInstance(70,70,0);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(image));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(15, 70, 86, 82);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(userID);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(129, 86, 182, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(storeName);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblNewLabel_3.setBounds(25, 152, 213, 34);
		contentPane.add(lblNewLabel_3);
				
		if(menus.length >= 4) {  //메뉴 4개 이상일 경우 3개까지 나오고 외~~건으로 나오게!
			for(int i=0; i < 3; i++) {
				JLabel lblNewLabel_3_1 = new JLabel(menus[i]);
				lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
				lblNewLabel_3_1.setBounds(25, 189+i*33 , 213, 34);
				contentPane.add(lblNewLabel_3_1);
			}	
			
			JLabel extraLabel = new JLabel("외 " + (menus.length-3) + "건");
			extraLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			extraLabel.setBounds(200, 255 , 213, 34);
			contentPane.add(extraLabel);
		} else {
			for(int i=0; i < menus.length; i++) {
				JLabel lblNewLabel_3_1 = new JLabel(menus[i]);
				lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
				lblNewLabel_3_1.setBounds(25, 189+i*33 , 213, 34);
				contentPane.add(lblNewLabel_3_1);
			}	
		}

		JPanel panel = new JPanel();
		panel.setBounds(19, 297, 488, 38);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		ButtonGroup bg = new ButtonGroup();
		jb1 = new JRadioButton("1점");
		jb1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		jb2 = new JRadioButton("2점");
		jb2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		jb3 = new JRadioButton("3점");
		jb3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		jb4 = new JRadioButton("4점");
		jb4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		jb5 = new JRadioButton("5점");
		jb5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		bg.add(jb1);
		bg.add(jb2);
		bg.add(jb3);
		bg.add(jb4);
		bg.add(jb5);

		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb4);
		panel.add(jb5);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		
		
		JTextArea reviewContArea = new JTextArea();
		reviewContArea.setWrapStyleWord(true);
		reviewContArea.setText(reviewContents);
		reviewContArea.setToolTipText("");
		reviewContArea.setLineWrap(true);
		reviewContArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		reviewContArea.setTabSize(10);
		reviewContArea.setBackground(new Color(230, 230, 250));
		reviewContArea.setBounds(19, 345, 488, 326);
		contentPane.add(reviewContArea);
		
		JLabel lblNewLabel_4 = new JLabel("10글자이상 100글자 미만으로 작성해주세요");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(19, 681, 308, 53);
		contentPane.add(lblNewLabel_4);
		
		//작성완료 버튼
		JButton btnNewButton_1 = new JButton("작성완료");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(395, 688, 107, 38);
		btnNewButton_1.setBorderPainted(false); 
		btnNewButton_1.setFocusPainted(false); 
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(reviewScore);

				reviewContents = reviewContArea.getText();
			    int reviewContentsL = reviewContents.length();
				
				if(reviewScore == -1 || reviewContentsL >= 100 || reviewContentsL < 10) {
					if(reviewScore == -1 && ( reviewContentsL >= 100 || reviewContentsL < 10)) {
						warningMessage("리뷰점수 및 리뷰글자수를 확인하세요");						
					}else if(reviewContentsL >= 100 || reviewContentsL < 10) {
						warningMessage("리뷰는 10자 이상 100자 미만으로 작성하세요");
					}else {
						warningMessage("리뷰점수를 선택해주세요");
					}
					
				} else {
					new StoreDao().saveAveStar(storeName, reviewScore);  //==> 리뷰평점 업뎃
					
					//같은 리뷰가 있다면 ==> 인덱스/ 같은리뷰없으면 -1 (1은 인덱스로도 나올 수 있으니 안돼!)
					int index = new ReviewListDao().searchReview(date, userID, storeName, menus);
					review = new Review(date, userID, storeName, menus, reviewScore, reviewContents);
					
					rlc = new ReviewListController();
					
					if(index== -1) {  //1. 리뷰 처음 작성	
//						if(rlc.userAllList() == null) {
//							System.out.println("널이지롱");
//						}else {
//							System.out.println(rlc.userAllList().size());
//							System.out.println(rlc.totalAllList().size());
//						}
						rlc.writeReview(review);
						JOptionPane.showMessageDialog(jb3,"리뷰가 등록되었습니다!\n홈으로 돌아갑니다");
						new HomeView();	
					} else {  //2. 리뷰 수정
						rlc.modifyReview(review, index);
						JOptionPane.showMessageDialog(jb3,"리뷰가 수정되었습니다!\n홈으로 돌아갑니다");
						new HomeView();
					}
				}
			}
		});

		frame.validate();
		frame.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb1) {
			reviewScore = 1;
		} else if(e.getSource() == jb2) {
			reviewScore = 2;
		} else if(e.getSource() == jb3) {
			reviewScore = 3;
		} else if(e.getSource() == jb4) {
			reviewScore = 4;
		} else {
			reviewScore = 5;
		}		
	}
	
	public void warningMessage(String cont) {
		JOptionPane.showMessageDialog(jb3,
				cont,"주의",JOptionPane.WARNING_MESSAGE);
	}
	
}
