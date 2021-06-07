package com.projectGo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.projectGo.controller.OrderListController;

public class WriteReview extends MouseAdapter {

	private JPanel contentPane;
	public JFrame frame;
	public JPanel backgroundPanel;
	public JButton backBtn;
	private String menuPic;
	private OrderListController olc;
	private String userID;
	
	public WriteReview() {
		//메인프레임
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		init();

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		new WriteReview();
	}
	
	public void init() {
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
		contentPane.add(backBtn);
		
		backBtn.addMouseListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("유저사진");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(15, 70, 86, 82);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("유저닉네임");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(129, 86, 182, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("식당명");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(25, 152, 213, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("메뉴이름");
		lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(25, 189, 213, 34);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("메뉴2이름");
		lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(25, 226, 213, 34);
		contentPane.add(lblNewLabel_3_2);

		JPanel panel = new JPanel();
		panel.setBounds(19, 297, 488, 38);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton jb1 = new JRadioButton("1점");
		jb1.setFont(new Font("굴림", Font.PLAIN, 16));
		JRadioButton jb2 = new JRadioButton("2점");
		jb2.setFont(new Font("굴림", Font.PLAIN, 16));
		JRadioButton jb3 = new JRadioButton("3점");
		jb3.setFont(new Font("굴림", Font.PLAIN, 16));
		JRadioButton jb4 = new JRadioButton("4점");
		jb4.setFont(new Font("굴림", Font.PLAIN, 16));
		JRadioButton jb5 = new JRadioButton("5점");
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
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("리뷰를 입력해주세요");
		textArea.setToolTipText("");
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setTabSize(10);
		textArea.setBackground(new Color(230, 230, 250));
		textArea.setBounds(19, 345, 488, 326);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_4 = new JLabel("10글자이상 100글자 미만으로 작성해주세요");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(19, 681, 308, 53);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("작성완료");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(395, 688, 107, 38);
		contentPane.add(btnNewButton_1);

		frame.validate();
		frame.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
	}
	
	
	
}
