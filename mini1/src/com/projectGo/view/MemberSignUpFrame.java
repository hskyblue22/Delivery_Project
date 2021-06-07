package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class MemberSignUpFrame extends JFrame{
	
	static MemberController mc=new MemberController();
	
	boolean check = false;
	
	JFrame jframe=new JFrame();
	JPanel jpanel=new JPanel();
	JTextField t1=new JTextField("");
	JTextField t2=new JTextField("");
	//JTextField t3=new JTextField("");
	JPasswordField t3p=new JPasswordField("");
	JTextField t4=new JTextField("");
	JTextField t5=new JTextField("");
	JTextField t6=new JTextField("");
	JButton bn1=new JButton();
	JButton bn2=new JButton();
	JLabel l0=new JLabel("회원가입");
	JLabel l1=new JLabel("닉네임");
	JLabel l2=new JLabel("이메일");
	JLabel l3=new JLabel("비밀번호");
	JLabel l4=new JLabel("생년월일");
	JLabel l5=new JLabel("폰번호");
	JLabel l6=new JLabel("주소");
	
	public MemberSignUpFrame() {
		super("회원가입");
		super.setResizable(true);
		jframe.setBounds(100,100,350,480);
		jpanel.setLayout(null);
		jframe.add(jpanel);
		
		l0.setFont(new Font("Godic",Font.BOLD,20));
		l0.setBounds(130,25,150,30);
		jpanel.add(l0);
		
		//텍스트필드+라벨
		t1.setBounds(75,80,150,30);
		//t1.setText("닉네임을 입력하세요");
		//t1.setForeground(Color.LIGHT_GRAY);
//		t1.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if( t1.getText().equals("닉네임을 입력하세요") ) {
//					t1.setText("");
//					t1.setForeground(Color.BLACK);
//				}
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if( t1.getText().equals("") ) {
//					t1.setText("닉네임을 입력하세요");
//					t1.setForeground(Color.LIGHT_GRAY);
//				}
//			}
//		});
		jpanel.add(t1);
		l1.setBounds(20,80,150,30);
		jpanel.add(l1);
		
		t2.setBounds(75,125,150,30);
//		t2.setText("이메일을 입력하세요");
//		t2.setForeground(Color.LIGHT_GRAY);
//		t2.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if( t2.getText().equals("이메일을 입력하세요") ) {
//					t2.setText("");
//					t2.setForeground(Color.BLACK);
//				}
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if( t2.getText().equals("") ) {
//					t2.setText("이메일을 입력하세요");
//					t2.setForeground(Color.LIGHT_GRAY);
//				}
//			}
//		});
		jpanel.add(t2);
		l2.setBounds(20,125,150,30);
		jpanel.add(l2);
	
		t3p.setBounds(75,170,150,30);
//		t3.setBounds(75,170,150,30);
//		t3.setText("비밀번호를 입력하세요");
//		t3p.setText("");
//		t3.setForeground(Color.LIGHT_GRAY);
//		t3.setVisible(true);
//		t3p.setVisible(false);
//		t3.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				t3.setVisible(false);
//				t3p.setVisible(true);
//				//t3p.transferFocus();
//				t3p.requestFocus();
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//			}
//		});
//		t3p.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				t3.setVisible(false);
//				t3p.setVisible(true);
//				//t3p.transferFocus();
//				t3p.requestFocus();
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				t3p.requestFocus();
//				//t3p.transferFocus();
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if( t3p.getPassword().length == 0 ) {
//					t3.setVisible(true);
//					t3p.setVisible(false);
//				}
//			}
//		});
//		jpanel.add(t3);
		jpanel.add(t3p);
		
		l3.setBounds(20,170,150,30);
		jpanel.add(l3);
		
		t4.setBounds(75,215,150,30);
//		t4.setText("생년월일을 입력하세요");
//		t4.setForeground(Color.LIGHT_GRAY);
//		t4.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if( t4.getText().equals("생년월일을 입력하세요") ) {
//					t4.setText("");
//					t4.setForeground(Color.BLACK);
//				}
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if( t4.getText().equals("") ) {
//					t4.setText("생년월일을 입력하세요");
//					t4.setForeground(Color.LIGHT_GRAY);
//				}
//			}
//		});
		jpanel.add(t4);
		l4.setBounds(20,215,150,30);
		jpanel.add(l4);
		
		t5.setBounds(75,260,150,30);
//		t5.setText("폰번호를 입력하세요");
//		t5.setForeground(Color.LIGHT_GRAY);
//		t5.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if( t5.getText().equals("폰번호를 입력하세요") ) {
//					t5.setText("");
//					t5.setForeground(Color.BLACK);
//				}
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if( t5.getText().equals("") ) {
//					t5.setText("폰번호를 입력하세요");
//					t5.setForeground(Color.LIGHT_GRAY);
//				}
//			}
//		});
		jpanel.add(t5);
		l5.setBounds(20,260,150,30);
		jpanel.add(l5);
		
		t6.setBounds(75,305,150,30);
//		t6.setText("주소를 입력하세요");
//		t6.setForeground(Color.LIGHT_GRAY);
//		t6.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if( t6.getText().equals("주소를 입력하세요") ) {
//					t6.setText("");
//					t6.setForeground(Color.BLACK);
//				}
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if( t6.getText().equals("") ) {
//					t6.setText("주소를 입력하세요");
//					t6.setForeground(Color.LIGHT_GRAY);
//				}
//			}
//		});
		jpanel.add(t6);
		l6.setBounds(20,305,150,30);
		jpanel.add(l6);
		
		//JScrollPane sp=new JScrollPane(ta);
		//sp.setBounds(25,145,420,250);
		//jpanel.add(sp);
		
		//버튼
		jpanel.add(bn1=new JButton("중복확인"));
		bn1.setBounds(230,80,90,30);
		jpanel.add(bn2=new JButton("완료"));
		bn2.setBounds(75,355,100,30);
		
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//완료(회원가입 완료되는 과정)
		bn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String mem[] = new String[6];
				//닉네임,이메일,패스워드,생년월일,휴대폰번호,주소
				mem[0]=t1.getText().trim(); 
				mem[1]=t2.getText().trim();
				//mem[2]=t3.getText().trim();
				mem[3]=t4.getText().trim();
				mem[4]=t5.getText().trim();
				mem[5]=t6.getText().trim();
				
				for( int i = 0; i < 6; i++ ) {
					if( mem[i].equals("") ) {
						JOptionPane.showMessageDialog(null, "내용을 모두 입력하세요");
						return;
					}
				}
				
				if( !check ) {
					JOptionPane.showMessageDialog(null, "중복확인을 완료하세요");
					return;
				}
				
				Member mb = new Member(mc.getMemList().size(), mem[0], mem[1], mem[2], mem[3], mem[4], mem[5]);
				mc.addMem(mb);
				System.out.println(mb);
				
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				check = false;
				
				jframe.dispose(); // ok 누르면 창닫기
			}
			
		});
		
		//중복확인
		bn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nick = t1.getText();
				
				if( nick.equals("") ) {
					JOptionPane.showMessageDialog(null, "닉네임을 입력하세요");
					return;
				}
				
				ArrayList<Member> ls = mc.getMemList();
				
				for( Member m : ls ) {
					if( nick.equals(m.getNick()) ) {
						JOptionPane.showMessageDialog(null, "이미 등록된 닉네임 입니다");
						return;
					}
				}
				
				JOptionPane.showMessageDialog(null, "사용할 수 있는 닉네임 입니다");
				check = true;
				
			}
			
		});
	}

	public static void main(String[] args) {
		
		System.out.println(mc.getMemList());
		
		MemberSignUpFrame f = new MemberSignUpFrame();
		
		
	}
	
}



















