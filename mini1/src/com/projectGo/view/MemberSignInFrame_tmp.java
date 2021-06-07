package com.projectGo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.projectGo.controller.MemberController;
import com.projectGo.model.vo.Member;

public class MemberSignInFrame extends JFrame {
	
	private MemberController mc=new MemberController();
	
	JFrame jframe=new JFrame();
	JPanel jpanel=new JPanel();
	JTextField t1=new JTextField("");
	JPasswordField t2=new JPasswordField("");
	JButton bn1=new JButton("로그인");
	JButton bn2=new JButton("회원가입");
	JLabel l0=new JLabel("로그인");
	JLabel l1=new JLabel("아이디");
	JLabel l2=new JLabel("비밀번호");
	
	public MemberSignInFrame() {
		super("로그인");
		super.setResizable(true);
		jframe.setBounds(100,100,350,480);
		jpanel.setLayout(null);
		jframe.add(jpanel);
		
		l0.setFont(new Font("Godic",Font.BOLD,20));
		l0.setBounds(130,80,150,30);
		jpanel.add(l0); // 레이블 로그인
		
		l1.setFont(new Font("Godic",Font.BOLD,15));
		l1.setBounds(30,150,150,30);
		jpanel.add(l1); // 레이블 아이디
		
		l2.setFont(new Font("Godic",Font.BOLD,15));
		l2.setBounds(30,200,150,30);
		jpanel.add(l2); // 레이블 비밀번호
		
		t1.setBounds(100,150,185,30);
		jpanel.add(t1); // 텍스트박스 아이디
		
		t2.setBounds(100,200,185,30);
		jpanel.add(t2); // 텍스트박스 비밀번호
		
		bn1.setBounds(100,260,80,30);
		jpanel.add(bn1); // 버튼 로그인
		bn2.setBounds(195,260,90,30);
		jpanel.add(bn2); // 버튼 회원가입
		
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id=t1.getText().trim();
				char[] pw=t2.getPassword(); int pwl = pw.length, i;
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					return;
				}
				if(pwl == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
					return;
				}
				
				ArrayList<Member> list = mc.getMemList();
				//ArrayList<Member> list = new ArrayList<>();
				//list.add( new Member(0, "권민지","ㅇㅇㅇㅇ", "1234","ㅇㅇㅇㅇ","ㅇㅇㅇㅇ","ㅇㅇㅇㅇ") );
				
				char[] mpw;
				for( Member m : list ) {
					if( m.getNick().equals(id) ) {
						mpw = m.getPwd().toCharArray();
						if( pwl != mpw.length ) {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
							return;
						}
						for( i = 0; i < pwl; i++ ) {
							if( pw[i] != mpw[i] ) {
								JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
								return;
							}
						}
						JOptionPane.showMessageDialog(null, "로그인하였습니다.");
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
				return;
			}
		});
		
		bn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberSignUpFrame rf=new MemberSignUpFrame();
			}
			
		});
		
	}
	
}



















