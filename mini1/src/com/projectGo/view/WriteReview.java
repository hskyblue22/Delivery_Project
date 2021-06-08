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

import com.projectGo.controller.OrderListController;
import com.projectGo.model.dao.ReviewListDao;
import com.projectGo.model.vo.Review;

public class WriteReview implements ActionListener {

	private JPanel contentPane;
	public JFrame frame;
	public JButton backBtn;
	private OrderListController olc;
	private Image image;
	
	private String userID;
	private String date;
	private String storeName = "식당이름**";
	private String[] menus;
	
	private int reviewScore = 0;
	private String reviewContents;
	
	private Review review;
	
	private JRadioButton jb1;
	private JRadioButton jb2;
	private JRadioButton jb3;
	private JRadioButton jb4;
	private JRadioButton jb5;
	
	public WriteReview() {
		init();
	}
	
	public WriteReview(String date, String storeName, String[] menus, String userID) {
		this.date = date;
		this.storeName = storeName;
		this.menus = menus;
		this.userID = userID;
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
		JLabel lblNewLabel = new JLabel("리 뷰 작 성");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 10, 250, 60);
		contentPane.add(lblNewLabel);
		
		backBtn = new JButton("이   전");
		backBtn.setForeground(Color.WHITE);
		backBtn.setBackground(Color.ORANGE);
		backBtn.setBounds(15, 20, 80, 40);
		contentPane.add(backBtn);
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new OrderListView();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		image = new ImageIcon("사진주소").getImage().getScaledInstance(50,50,0);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(image));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(15, 70, 86, 82);
		contentPane.add(lblNewLabel_1);
		
		//userID = MainFrame.loginUserID;
		JLabel lblNewLabel_2 = new JLabel(userID);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(129, 86, 182, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(storeName);
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(25, 152, 213, 34);
		contentPane.add(lblNewLabel_3);
		

//		for(int i=0; i< menus.length; i++) {
//			JLabel lblNewLabel_3_1 = new JLabel(menus[i]);
//			lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 16));
//			lblNewLabel_3_1.setBounds(25, 189+i*33 , 213, 34);
//			contentPane.add(lblNewLabel_3_1);
//		}
		
		JLabel lblNewLabel_3_2 = new JLabel("메뉴2이름");
		lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(25, 222, 213, 34);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("메뉴3이름");
		lblNewLabel_3_3.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(25, 255, 213, 34);
		contentPane.add(lblNewLabel_3_3);
		

		JPanel panel = new JPanel();
		panel.setBounds(19, 297, 488, 38);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		ButtonGroup bg = new ButtonGroup();
		jb1 = new JRadioButton("1점");
		jb1.setFont(new Font("굴림", Font.PLAIN, 16));
		jb2 = new JRadioButton("2점");
		jb2.setFont(new Font("굴림", Font.PLAIN, 16));
		jb3 = new JRadioButton("3점");
		jb3.setFont(new Font("굴림", Font.PLAIN, 16));
		jb4 = new JRadioButton("4점");
		jb4.setFont(new Font("굴림", Font.PLAIN, 16));
		jb5 = new JRadioButton("5점");
		jb5.setSelected(true);
		jb5.setFont(new Font("굴림", Font.PLAIN, 16));
		
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
		reviewContArea.setText("리뷰를 입력해주세요");
		reviewContArea.setToolTipText("");
		reviewContArea.setLineWrap(true);
		reviewContArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		reviewContArea.setTabSize(10);
		reviewContArea.setBackground(new Color(230, 230, 250));
		reviewContArea.setBounds(19, 345, 488, 326);
		contentPane.add(reviewContArea);
		
		JLabel lblNewLabel_4 = new JLabel("10글자이상 100글자 미만으로 작성해주세요");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(19, 681, 308, 53);
		contentPane.add(lblNewLabel_4);
		
		//작성완료 버튼
		JButton btnNewButton_1 = new JButton("작성완료");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(395, 688, 107, 38);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(reviewScore);

				reviewContents = reviewContArea.getText();
			    int reviewContentsL = reviewContents.length();
			    System.out.println(reviewContentsL);
				
				if(reviewScore == 0 || reviewContentsL >= 100) {
					if(reviewScore == 0 && reviewContentsL >= 100) {
						warningMessage("리뷰점수 및 리뷰글자수를 확인하세요");						
					}else if(reviewContentsL >= 100) {
						warningMessage("리뷰는 100자 미만으로 작성하세요");
					}else {
						warningMessage("리뷰점수를 선택해주세요");
					}
					
				} else {
					//홈으로
//					new StoreDao().saveAveStar(storeName, reviewScore);  ==> 리뷰평점 업뎃
					review = new Review(date, userID, storeName, menus, reviewScore, reviewContents);
					new ReviewListDao(review);  //리뷰 파일에 저장
					JOptionPane.showMessageDialog(null,"리뷰가 등록되었습니다!\n홈으로 돌아갑니다");
					new ViewTemp();
				}
			}
		});

		frame.validate();
		frame.repaint();
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		new WriteReview();
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
		JOptionPane.showMessageDialog(null,
				cont,"주의",JOptionPane.WARNING_MESSAGE);
	}
	
}
