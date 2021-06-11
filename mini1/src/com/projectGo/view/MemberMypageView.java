package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.projectGo.controller.MemberController;
import com.projectGo.model.vo.Member;

public class MemberMypageView extends MainFrame {

	JFrame frame;

	MemberController mbc = new MemberController();
	Member m;

//	JPanel p = new JPanel();s

	JLabel l = new JLabel("마이 페이지");
	JLabel i = new JLabel(); // 레이블 - 프로필 아이콘
	JButton b = new JButton("이전"); // 버튼 - 이전
	JButton b1 = new JButton(); // 버튼 - 회원정보 조회/수정 페이지
	JButton b2 = new JButton("포인트"); // 버튼 - 포인트 확인 창
	JButton b3 = new JButton("리뷰 관리"); // 버튼 - 리뷰 관리 페이지

	public MemberMypageView(int idx) {

		m = mbc.getMem(idx);
		
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();

		//createPanel(p);
		
		Image im = new ImageIcon("images/user.png").getImage().getScaledInstance(70,70,0);

//		Image im = new ImageIcon(getClass().getResource("images/user.jpg")).getImage().getScaledInstance(70, 70,
//				Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(im);
		i.setBounds(100, 190, 70, 70);
		i.setIcon(icon);
//		p.add(i);
		frame.add(i);

		setButton(b, frame);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//closePanel(p);
				HomeView np = new HomeView();
				return;
			}
		});

		l.setBounds(210, 100, 150, 30);
		setFontTitle(l, frame); // 마이페이지 레이블
		
		
		l.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				
				new MemberInfoView(idx);

			}


		});
			

		b1.setText(m.getNick() + " 님        >");
		b1.setBounds(170, 200, 280, 50);
		b1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		b1.setForeground(Color.black);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setBorder(null);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//closePanel(p);
				MemberInfoView np = new MemberInfoView(idx);
				return;
			}
		});
		frame.add(b1); // 회원 정보 조회 버튼

		b2.setBounds(100, 320, 350, 50);
		setButton(b2, frame); // 포인트 버튼
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "현재 포인트는 " + m.getPoint() + "p 입니다.");
				return;
			}
		});

		b3.setBounds(100, 410, 350, 50);
		setButton(b3, frame); // 리뷰 관리 버튼
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReviewListView v = new ReviewListView();
				return;
			}
		});
		
		frame.validate();
		frame.repaint();

	}
	public void setFontDefault(JComponent l, JFrame f) {
		l.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		frame.add(l);
	}

	public void setFontTitle(JComponent l, JFrame f) {
		l.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		frame.add(l);
	}

	public void setButton(JButton b, JFrame f) {
		b.setMargin(new Insets(1, 1, 1, 1));
		b.setForeground(Color.WHITE);
		b.setBackground(Color.orange);
		b.setBorder(null);
		setFontDefault(b, f);
	}

}
