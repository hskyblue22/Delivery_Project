package com.projectGo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		
		
		
		JLabel header = new JLabel("가게 등록");
		header.setBounds(225, 30, 200, 30);
		//header.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(header);
		
		
	
		
	
		//textfield + combobox (카테고리)
		
		
		JLabel snl = new JLabel("가게 이름");
		JTextField snt = new JTextField();
		snl.setBounds(50, 100, 300, 30);
		snt.setBounds(50, 150, 150, 30);
		frame.getContentPane().add(snl);
		frame.getContentPane().add(snt);
		

		JLabel cl = new JLabel("카테고리");
		String categorySelect [] = {"한식", "중식", "일식", "양식", "분식", "디저트", "피자", "치킨", "패스트푸드" };
		
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
		frame.getContentPane().add(dtl);
		frame.getContentPane().add(dtt);
		
		
		JLabel dtipl = new JLabel("배달 팁");
		JTextField dtipt = new JTextField();
		
		dtipl.setBounds(50, 400, 300, 30);
		dtipt.setBounds(50, 450, 100, 30);
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
