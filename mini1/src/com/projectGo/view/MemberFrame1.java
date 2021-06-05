package com.projectGo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.projectGo.model.vo.Member;

public class MemberFrame1 extends JFrame{
	private MemberController mc=new MemberController();
	
	
	
	JFrame jframe=new JFrame();
	JPanel jpanel=new JPanel();
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextArea ta=mew JTextArea();
	JButton bn1=new JButton();
	JButton bn2=new JButton();
	JButton bn3=new JButton();
	JButton bn4=new JButton();
	JButton bn5=new JButton();
	JLabel l1=new JLabel("내용을 입력해주세요:");
	JLabel l2=new JLabel("내용을 입력해주세요:");
	JLabel l3=new JLabel("내용을 입력해주세요:");
	JLabel l4=new JLabel("내용을 입력해주세요:");
	JLabel l5=new JLabel("내용을 입력해주세요:");
	
	public MemberFrame1() {
		super("회원가입");
		super.setResizable(true);
		jframe.setBounds(100,100,480,450);
		jpanel.setLayout(null);
		jframe.add(jpanel)
		
		//텍스트필드+라벨
		t1.setBounds(75,25,70,25);
		jpanel.add(t1);
		l1.setBounds(37,21,70,30);
		jpanel.add(l1);
		
		t2.setBounds(75,25,70,25);
		jpanel.add(t1);
		l2.setBounds(37,21,70,30);
		jpanel.add(l1);
		
		t3.setBounds(75,25,70,25);
		jpanel.add(t1);
		l3.setBounds(37,21,70,30);
		jpanel.add(l1);
		
		t4.setBounds(75,25,70,25);
		jpanel.add(t1);
		l4.setBounds(37,21,70,30);
		jpanel.add(l1);
		
		t5.setBounds(75,25,70,25);
		jpanel.add(t1);
		l5.setBounds(37,21,70,30);
		jpanel.add(l1);
		
		JScrollPane sp=new JScrollPane(ta);
		sp.setBounds(25,145,420,250);
		jpanel.add(sp);
		
		//버튼
		jpanel.add(bn1=new JButton("중복확인"));
		bn1.setBounds(40,60,80,30);
		jpanel.add(bn2=new JButton("완료"));
		bn2.setBounds(145,60,80,30);
		jpanel.add(bn3=new JButton("<prev"));
		bn3.setBounds(250,60,80,30);
		jpanel.add(bn4=new JButton("next>"));
		bn4.setBounds(350,60,80,30);
		
		
		
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//완료(회원가입 완료되는 과정)
		bn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.setText("");
				
				//닉네임,이메일,패스워드,생년월일,휴대폰번호
				String nick=t1.getText();
				String email=t2.getText();
				String pwd=t3.getText();
				String registration=t4.getText();
				String phone=t5.getText();
				
				mc.insertMember(new Member(nick,email,pwd,registration,phone));
				
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				
			}
			
		});
		
		//회원목록출력(나중에 시간 있으면!!!)
		
		
		
		
		
		
		
	}

	
	
}



















