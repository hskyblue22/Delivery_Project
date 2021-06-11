package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.projectGo.controller.MemberController;
import com.projectGo.model.dao.MemberDao;
import com.projectGo.model.vo.Member;

public class MemberSignInView extends MainFrame {
	MemberDao md = new MemberDao();
	ArrayList<Member> mls = new ArrayList<>();
	
	Color orange = new Color(243, 156, 18);
	Color lightgray = new Color(230, 230, 230);

	JFrame frame;
	JPanel p = new JPanel();

	JLabel i = new JLabel();
	JLabel l1 = new JLabel("아이디");
	JLabel l2 = new JLabel("비밀번호");
	JTextField t1 = new JTextField(""); // 텍스트박스 - 아이디
	JPasswordField t2 = new JPasswordField(""); // 텍스트박스 - 비밀번호
	JButton b1 = new JButton("로그인"); // 버튼 - 로그인
	JButton b2 = new JButton("회원가입"); // 버튼 - 회원가입

	public MemberSignInView() {
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		mls=md.fileInput();
		p.setSize(550, 800);
		p.setVisible(true);
		p.setLayout(null);
		p.setOpaque(false);
		frame.getContentPane().add(p);

		ImageIcon logo = new ImageIcon(
				new ImageIcon("images/hankkiGo.PNG")
						.getImage().getScaledInstance(137, 130, Image.SCALE_DEFAULT));
		i.setIcon(logo);
		i.setBounds(200, 160, 137, 130);
		p.add(i); // 레이블 로그인/로고

		l1.setBounds(100, 350, 100, 45);
		setFontDefault(l1, p); // 레이블 아이디

		l2.setBounds(100, 405, 100, 45);
		setFontDefault(l2, p); // 레이블 비밀번호

		t1.setBounds(190, 350, 220, 45);
		setFontDefault(t1, p); // 텍스트박스 아이디

		t2.setBounds(190, 405, 220, 45);
		setFontDefault(t2, p); // 텍스트박스 비밀번호

		b1.setBounds(100, 515, 160, 45);
		setButton(b1, p); // 버튼 로그인
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText().trim();
				String pw = String.valueOf(t2.getPassword());
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					return;
				}
				if (pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
					return;
				}
				System.out.println(mls); /******/
				int size = mls.size(), type, idx, i;
				Member m;
				for (i = 0; i < size; i++) {
					m = mls.get(i);
					if (m.getNick().equals(id)) {
						if (pw.equals(m.getPwd())) {
							t1.setText("");
							t2.setText("");
							idx = i;
							type = m.getType();
							SellerMain np1;
							HomeView np2;
							if (type == 1)
								np1 = new SellerMain();
							else if (type == 2)
								np2 = new HomeView();
							return;
						}
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
						t2.setText("");
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
				t1.setText("");
				t2.setText("");
				return;
			}
		});

		b2.setBounds(275, 515, 160, 45);
		setButton(b2, p); // 버튼 회원가입
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberSignUpView np = new MemberSignUpView();
			}
		});

		frame.validate();
		frame.repaint();
	}
	public void setFontDefault(JComponent l, JPanel p) {
		l.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		p.add(l);
	}

	public void setFontTitle(JComponent l, JPanel p) {
		l.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		p.add(l);
	}

	public void setButton(JButton b, JPanel p) {
		b.setMargin(new Insets(1, 1, 1, 1));
		b.setForeground(Color.WHITE);
		b.setBackground(orange);
		b.setBorder(null);
		setFontDefault(b, p);
	}
	

}