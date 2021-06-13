package com.projectGo.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Member;

public class MainFrame extends JFrame {
 
	public static JFrame mainFrame;
	public static String loginUserId;
	public static String loginPW;
	public static ImageIcon img = new ImageIcon("images/hankkiGo.png");
	public static StoreInfoView storeInfoView;
	public static Basket basket;

	

	static {
		mainFrame = new JFrame("한끼고!");
		mainFrame.getContentPane().setBackground(Color.WHITE);
		mainFrame.setSize(550, 800);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setIconImage(img.getImage());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setVisible(true);
		storeInfoView = new StoreInfoView();
		basket = new Basket();
		loginUserId = "user01";

	}

}
 