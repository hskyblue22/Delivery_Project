package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.projectGo.model.vo.Member;

public class MemberMyPageView extends MainFrame {

   Member m;
   
   JPanel p = new JPanel();
   
   JLabel l = new JLabel("마이 페이지");
   JLabel i = new JLabel();            // 레이블 - 프로필 아이콘
   JButton b = new JButton("이전");         // 버튼 - 이전
   JButton b1 = new JButton();            // 버튼 - 회원정보 조회/수정 페이지
   JButton b2 = new JButton("포인트");      // 버튼 - 포인트 확인 창
   JButton b3 = new JButton("주문 내역");      // 버튼 - 주문 내역 페이지
   JButton b4 = new JButton("리뷰 관리");      // 버튼 - 리뷰 관리 페이지
   
   public MemberMyPageView(int idx) {
      
      m = mbc.getMem(idx);
      
      createPanel(p);
      
      Image im = new ImageIcon(getClass().getResource("user.jpg")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
      ImageIcon icon = new ImageIcon(im);
      i.setBounds(100, 190, 70, 70);
      i.setIcon(icon);
      p.add(i);
      
      setButtonPrev( b, p );
      b.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            closePanel(p);
            HomeBuyerView np = new HomeBuyerView(idx);
            return;
         }
      });
      
      l.setBounds(210, 100, 150, 30);
      setFontTitle(l, p); // 마이페이지 레이블
      
      b1.setText(m.getNick()+" 님        >");
      b1.setBounds(170, 200, 280, 50);
      b1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      b1.setForeground(Color.black);
      b1.setBackground(lightgray);
      b1.setBorder(null);
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            closePanel(p);
            MemberInfoView np = new MemberInfoView(idx);
            return;
         }
      });
      p.add(b1); // 회원 정보 조회 버튼

      b2.setBounds(100, 320, 350, 50);
      setButton(b2, p); // 포인트 버튼
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "현재 포인트는 " + m.getPoint()+ "p 입니다.");
            return;
         }
      });
      
      b3.setBounds(100, 410, 350, 50);
      setButton(b3, p); // 주문 내역 버튼
      b3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // 주문내역 OrderListView
            return;
         }
      });
      
      b4.setBounds(100, 500, 350, 50);
      setButton(b4, p); // 리뷰 관리 버튼
      b4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // 리뷰관리 WriteReview
            return;
         }
      });

   }

}