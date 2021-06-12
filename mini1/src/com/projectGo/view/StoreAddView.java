package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.projectGo.controller.SellerController;

public class StoreAddView extends MainFrame {
	
	JFrame frame;
	SellerController sc = new SellerController();
	String storeName = null;
	String storeIntroduce =null;
	int category = 0;
	int deliveryTip = 0;
	int deliveryTime = 0;
	
	public StoreAddView() {
		
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();


		
		
		JButton backbtn = new JButton("이 전");
		backbtn.setBounds(15, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		frame.add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SellerMain();
				
			}
		});
		
		
		
		JLabel lineLabel = new JLabel("");

		lineLabel.setOpaque(true);

		lineLabel.setBackground(Color.ORANGE);
		lineLabel.setBounds(0, 80, 535, 5);
		frame.getContentPane().add(lineLabel);

		JLabel headLabel = new JLabel("가게 등록");
		headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		// lblNewLabel_2.setOpaque(true);
		headLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(headLabel);
		
	
		
	
		//textfield + combobox (카테고리)
		
		
		JLabel snl = new JLabel("가게 이름");
		JTextField snt = new JTextField();
		snl.setBounds(50, 100, 300, 30);
		snt.setBounds(50, 150, 150, 30);
		frame.getContentPane().add(snl);
		frame.getContentPane().add(snt);
		

		JLabel cl = new JLabel("카테고리");
		String categorySelect [] = {"선택","한식", "중식", "일식", "양식", "분식", "디저트", "피자", "치킨", "패스트푸드" };
		
		JComboBox<String> combo = new JComboBox<String>(categorySelect);
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String c1 = combo.getSelectedItem().toString();
				category = sc.categorySelect(c1);
				
			}
		});
		
		cl.setBounds(50, 200, 300, 30);
		frame.getContentPane().add(cl);
		combo.setBounds(50, 250, 100, 30);
		frame.getContentPane().add(combo);
		
		
		JLabel dtl = new JLabel("예정 배달 소요 시간");
		JTextField dtt = new JTextField();
		
		dtl.setBounds(50, 300, 300, 30);
		dtt.setBounds(50, 350, 100, 30);
		dtt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				
				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || c == '')) {
					JOptionPane.showMessageDialog(dtt, "숫자만 입력해 주세요.");
					dtt.setText("");
					return;
				}
				
				

			}

		});
		frame.getContentPane().add(dtl);
		frame.getContentPane().add(dtt);
		
		
		JLabel dtipl = new JLabel("배달 팁");
		JTextField dtipt = new JTextField();
		
		dtipl.setBounds(50, 400, 300, 30);
		dtipt.setBounds(50, 450, 100, 30);
		dtipt.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				
				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || c == '')) {
					JOptionPane.showMessageDialog(dtipt, "숫자만 입력해 주세요.");
					dtipt.setText("");
					return;
				}
				
				

			}

		});
		frame.getContentPane().add(dtipl);
		frame.getContentPane().add(dtipt);
		
		
		JLabel sil = new JLabel("가게 소개");
		JTextArea sit = new JTextArea();
		sit.setBackground(Color.lightGray);
		sil.setBounds(50, 500, 300, 30);
		sit.setBounds(50, 550, 300, 120);
		frame.getContentPane().add(sil);
		frame.getContentPane().add(sit);
		
		
		JButton nextbtn = new JButton("다 음");
		nextbtn.setBounds(435, 20, 80, 40);
		nextbtn.setBackground(Color.orange);
		nextbtn.setForeground(Color.white);
		frame.getContentPane().add(nextbtn);
		nextbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(combo.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(dtl, "카테고리를 선택하세요");
					return;
					
					
				}
				if (snt.getText().equals("") || dtipt.getText().equals("") || dtt.getText().equals("")
						|| sit.getText().equals("")) {

					JOptionPane.showMessageDialog(dtl, "내용을 입력하세요");
					return;

				}
				storeName = snt.getText();
				String dt = dtt.getText();
				deliveryTime = Integer.parseInt(dt);
				String dttt = dtipt.getText();
				deliveryTip = Integer.parseInt(dttt);
				storeIntroduce = sit.getText();
				sc.StoreCreator(storeName, storeIntroduce, category, deliveryTip, deliveryTime);
				
				new MenuAddView().MenuAddViewMain();
			}
		});
		
	
		
		
		frame.validate();
		frame.repaint();		
		
		
		
	}
	

}
