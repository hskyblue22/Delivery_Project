package com.projectGo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBounds(0, 0, 550, 800);
		
		
		JButton backbtn = new JButton("이 전");
		backbtn.setBounds(15, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		panel.add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SellerMain();
				
			}
		});
		
		JButton nextbtn = new JButton("다 음");
		backbtn.setBounds(455, 20, 80, 40);
		backbtn.setBackground(Color.orange);
		backbtn.setForeground(Color.white);
		panel.add(nextbtn);
		nextbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuAddView();
				
			}
		});
		
		
		JLabel header = new JLabel("가게등록");
		header.setHorizontalAlignment(JLabel.CENTER);
		panel.add(header);
		
		
	
		
	
		//textfield + combobox (카테고리)
		
		
		JLabel snl = new JLabel("가게 이름");
		JTextField snt = new JTextField();
		

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
		
		
		JLabel dtl = new JLabel("예정 배달 소요 시간");
		JTextField dtt = new JTextField();
		
		JLabel dtipl = new JLabel("배달 팁");
		JTextField dtipt = new JTextField();
		
		JLabel sil = new JLabel("가게 소개");
		JTextField sit = new JTextField();
		
		
		
		
		sc.StoreCreator(storeName, storeIntroduce, category, deliveryTip, deliveryTime);
		
		
				
		
		
		
	}
	

}
