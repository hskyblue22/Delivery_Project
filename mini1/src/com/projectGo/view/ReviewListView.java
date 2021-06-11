package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.projectGo.controller.ReviewListController;
import com.projectGo.model.vo.Review;

public class ReviewListView {

	public JFrame frame;
	private JPanel contentPane;
	private JPanel panel;
	public JButton backBtn;
	private ReviewListController rlc = new ReviewListController();
	private ArrayList<Review> userReview;
	private int i;

	private String userID;
	private String storeName;
	private String date;
	private String[] menus; // 메뉴이름+가격
	private int score;
	private String contents;

	public ReviewListView() {
		
		

		init();
	}

	private void init() {

		userReview = rlc.userAllList();
		System.out.println();
		
		// 메인프레임
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		// title(제목, 이전버튼)
		JLabel headLabel = new JLabel("My 리뷰");
		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		headLabel.setBounds(140, 10, 250, 60);
		frame.getContentPane().add(headLabel);

		// 이전버튼
		backBtn = new JButton("이   전");
		backBtn.setBounds(15, 20, 80, 40);
		backBtn.setBackground(Color.orange);
		backBtn.setForeground(Color.white);
		frame.getContentPane().add(backBtn);

		// '이전'버튼
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 마이페이지 뷰로
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

		if (userReview.size() == 0) { // 리뷰파일이 빈 경우
			listEmpty();

		} else { // 리뷰파일에 내용있는 경우

			for (i = 0; i < userReview.size(); i++) {

				date = userReview.get(i).getDate();
				score = userReview.get(i).getScore();
				storeName = userReview.get(i).getStoreName();
				menus = userReview.get(i).getMenus();
				contents = userReview.get(i).getContents();
				userID = userReview.get(i).getUserID();

				// 각 리뷰작성된 패널
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = i;
				panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
				panel.add(panel_1, gbc_panel_1);

				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[] { 97, 97, 97, 97, 97, 0 };
				gbl_panel_1.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 0 };
				gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				panel_1.setLayout(gbl_panel_1);

				// 패널번호 --> 파일에서 삭제할 때 index로 넘기기
				panel_1.setToolTipText(String.valueOf(i)); // 패널번호 = userOrderList인덱스
				int panelIndex = Integer.parseInt(panel_1.getToolTipText());
				System.out.println("i : " + i);
				System.out.println("panelIndex : " + panelIndex);

				// 주문날짜 "2021.06.01"
				JLabel lblNewLabel = new JLabel(date);
				lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				panel_1.add(lblNewLabel, gbc_lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("평점 : " + score);
				lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 0;
				panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

				// 식당이름
				JLabel lblNewLabel_3 = new JLabel(storeName);
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 1;
				panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

				
				// "메뉴이름 메뉴가격"
				for (int k = 0; k < menus.length; k++) {
					JLabel lblNewLabel_3_1 = new JLabel(menus[k]);
					GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
					gbc_lblNewLabel_3_1.gridwidth = 2;
					gbc_lblNewLabel_3_1.fill = GridBagConstraints.BOTH;
					gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_3_1.gridx = 0;
					gbc_lblNewLabel_3_1.gridy = 2 + k;
					panel_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
				}

				JTextArea area = new JTextArea(contents);
				GridBagConstraints gbc_lblNewLabel_3_4 = new GridBagConstraints();
				gbc_lblNewLabel_3_4.gridwidth = 5;
				gbc_lblNewLabel_3_4.gridheight = 3;
				gbc_lblNewLabel_3_4.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_3_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3_4.gridx = 0;
				
				if(menus.length >= 4) {  //메뉴 많아지면 알아서 길이지도록 좌표수정_06.11
					gbc_lblNewLabel_3_4.gridy = menus.length + 2;
				}else {
					gbc_lblNewLabel_3_4.gridy = 5;
				}
				
//				gbc_lblNewLabel_3_4.gridy = 5;
				area.setLineWrap(true);
				area.setBackground(new Color(230, 230, 250));
				area.setFont(new Font("굴림", Font.PLAIN, 15));
				panel_1.add(area, gbc_lblNewLabel_3_4);

				JButton btnNewButton = new JButton("리뷰수정");
				GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
				gbc_btnNewButton2.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton2.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton2.gridx = 3;
				
				if(menus.length >= 4) {  //메뉴 많아지면 알아서 길이지도록 좌표수정_06.11
					gbc_btnNewButton2.gridy = menus.length + 6;
				}else {
					gbc_btnNewButton2.gridy = 8;
				}
				
//				gbc_btnNewButton2.gridy = 8;
				btnNewButton.setBackground(Color.orange);
				btnNewButton.setForeground(Color.white);
				panel_1.add(btnNewButton, gbc_btnNewButton2);
				// 리뷰작성창 띄우기
				// 작성완료 ==> 해당리뷰 삭제하고 다시 저장
				btnNewButton.addActionListener(new ActionListener() {
					
					String date1 = userReview.get(panelIndex).getDate();
					int score1 = userReview.get(panelIndex).getScore();
					String storeName1 = userReview.get(panelIndex).getStoreName();
					String[] menus1 = userReview.get(panelIndex).getMenus();
					String contents1 = userReview.get(panelIndex).getContents();
					String userID1 = userReview.get(panelIndex).getUserID();

					@Override
					public void actionPerformed(ActionEvent e) {

						int result = JOptionPane.showConfirmDialog(null, "리뷰를 수정하시겠습니까?", "리뷰내역 삭제",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							new WriteReview(date1, storeName1, menus1, userID1, contents1, score1);
						}
					}
				});

				JButton btnNewButton_2 = new JButton("리뷰삭제"); // 리뷰 뷰 띄우기, 리뷰 객체 전달
				GridBagConstraints gbc_btnNewButton3 = new GridBagConstraints();
				gbc_btnNewButton3.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton3.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton3.gridx = 4;
				
				if(menus.length >= 4) {  //메뉴 많아지면 알아서 길이지도록 좌표수정_06.11
					gbc_btnNewButton3.gridy = menus.length + 6;
				}else {
					gbc_btnNewButton3.gridy = 8;
				}
				
//				gbc_btnNewButton3.gridy = 8;
				btnNewButton_2.setBackground(Color.orange);
				btnNewButton_2.setForeground(Color.white);
				panel_1.add(btnNewButton_2, gbc_btnNewButton3);

				btnNewButton_2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						int result = JOptionPane.showConfirmDialog(null, "리뷰를 삭제하시겠습니까?", "리뷰내역 삭제",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							// 리뷰 삭제 & 리뷰파일에 다시 저장
//								System.out.println(i);  //1
//								System.out.println(panelIndex);  //0
							rlc.deleteReview(panelIndex /* i */);
							// 화면 다시 만들기(새로 저장한 내역 다시 스크롤판에 나타내기)
							init();
						}

					}

				});
			}
		}

		frame.validate();
		frame.repaint();
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		new ReviewListView();
	}

	private void listEmpty() {
		// TODO Auto-generated method stub
		JLabel empty = new JLabel("작성한 리뷰가 없습니다.");
		empty.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(empty);
	}

}
