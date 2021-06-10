package com.projectGo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewTemp extends MainFrame{
	private JFrame frame;
	public ViewTemp()  {
		MainFrame.loginUserId = "user01";
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		JButton backBtn_1 = new JButton("카테고리창 열기");
		backBtn_1.setBounds(148, 250, 100, 70);
		backBtn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CategoryChoiceView().categoryMain();
				
			}
		});
		frame.getContentPane().add(backBtn_1);
		
		JButton backBtn_2 = new JButton("검색 창 열기");
		backBtn_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SerchPageView().serchMain();
				
			}
		}); 
		backBtn_2.setBounds(314, 250, 100, 70);
		frame.getContentPane().add(backBtn_2);
		frame.validate();
		frame.repaint();
	}
	
	

}
