package com.projectGo.view;

import java.awt.Color;

import javax.swing.JFrame;

import com.projectGo.model.vo.Member;

public class MainFrame extends JFrame {

	public static JFrame mainFrame;
	public static String loginUserId;
	public static Member member;

	static {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setBackground(Color.WHITE);
		mainFrame.setSize(550, 800);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setVisible(true);
		loginUserId = "user01";

	}

}
 