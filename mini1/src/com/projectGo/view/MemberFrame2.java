package com.projectGo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MemberFrame2 extends JFrame {
	private MemController mc=new MemController();
	
	public MemberFrame2() {
		super("로그인");
		super.setResizable(true);
		setSize(350,400);
		setLocationRelativeTo(null);
		
		JPanel IPanel=new JPanel();
		IPanel.setLayout(new BorderLayout());
		setContentPane(IPanel);
		
		JLabel ILogin=new JLabel("로그인");
		ILogin.setFont(new Font("Serif",Font.BOLD,50));
		ILogin.setHorizontalAlignment(SwingConstants.CENTER);
		ILogin.setPreferredSize(new Dimension(120,120));
		IPanel.add(ILogin,BorderLayout.NORTH);
		
		
		JPanel Main=new JPanel(new GridLayout(2,2,15,15));
		
		JLabel  IId=new JLabel("아이디");
		IId.setFont(new Font("Serif",Font.BOLD,15));
		IId.setHorizontalAlignment(SwingConstants.CENTER);
		Main.add(IId);
		
		JTextField tId=new JTextField();
		tId.setColumns(10);
		Main.add(tId);
		
		JLabel  IId=new JLabel("비밀번호");
		IId.setFont(new Font("Serif",Font.BOLD,15));
		IId.setHorizontalAlignment(SwingConstants.CENTER);
		Main.add(IId);//나중에 수정//
		
		JTextField tPassword=new JTextField();
		tPassword.setColumns(10);
		Main.add(tId);
		
		IPanel.add(Main,BorderLayout.WEST);
		
		JPanel btnMain=new JPanel(new FlowLayout(FlowLayout.CENTER,40,60));
		
		JButton login=new JButton("로그인");
		btnMain.add(login);
		JButton register=new JButton("회원가입");
		btnMain.add(register);
		IPanel.add(btnMain,BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=tId.getText();
				String password=tPassword.getText();
				
				int result=mc.idPassword(id,password); //컨트롤러에서 메소드 호출해오기
				if(result==1) {
					JOptionPane.showMessageDialog(null, "로그인하였습니다.");
					ListFrame lf=new ListFrame();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
				}
			}
			
		});
		
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RegisterFrame rf=new RegisterFrame();
			}
			
		});
		
		
		
	}
}



















