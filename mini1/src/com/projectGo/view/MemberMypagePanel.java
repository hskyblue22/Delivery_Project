package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.projectGo.controller.MemberController;
import com.projectGo.model.vo.Member;

public class MemberMypagePanel extends JFrame {
   
   //MemberController mc = new MemberController();
   Member m;
   
   JPanel p = new JPanel();
   
   JLabel l0 = new JLabel("마이 페이지");
   
   JButton b0 = new JButton("이전");
   
   JButton b1 = new JButton();
   JButton b2 = new JButton("포인트");
   JButton b3 = new JButton("주문 내역");
   JButton b4 = new JButton("리뷰 관리");
   
   Color orange = new Color(243, 156, 18);
   Color lightgray = new Color(230, 230, 230);
   
   public MemberMypagePanel(JFrame f, int idx, MemberController mc) {
      
      super("마이 페이지");
      super.setResizable(true);
      
      m = mc.getMem(idx);
      
      p.setLayout(null);
      p.setBounds(0, 0, 550, 800);
      p.setOpaque(false);
      p.setVisible(true);
      f.add(p);
      
      b0.setBounds(40, 40, 80, 35);
      b0.setMargin(new Insets(1,1,1,1));
      b0.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      b0.setForeground(Color.white);
      b0.setBackground(orange);
      b0.setBorder(BorderFactory.createLineBorder(orange));
      p.add(b0); // 버튼 이전
      
      l0.setBounds(210, 100, 150, 30);
      l0.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      p.add(l0); // 레이블 마이페이지
      
      b1.setText(m.getNick()+" 님              >");
      b1.setBounds(120, 200, 300, 50);
      b1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      b1.setForeground(Color.gray);
      b1.setBackground(lightgray);
      b1.setBorder(BorderFactory.createLineBorder(lightgray));
      p.add(b1); // 버튼 회원 정보 조회

      b2.setBounds(100, 320, 350, 50);
      b2.setMargin(new Insets(1,1,1,1));
      b2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      b2.setForeground(Color.white);
      b2.setBackground(orange);
      b2.setBorder(BorderFactory.createLineBorder(orange));
      p.add(b2); // 버튼 포인트
      
      b3.setBounds(100, 410, 350, 50);
      b3.setMargin(new Insets(1,1,1,1));
      b3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      b3.setForeground(Color.white);
      b3.setBackground(orange);
      b3.setBorder(BorderFactory.createLineBorder(orange));
      p.add(b3); // 버튼 주문 내역
      
      b4.setBounds(100, 500, 350, 50);
      b4.setMargin(new Insets(1,1,1,1));
      b4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      b4.setForeground(Color.white);
      b4.setBackground(orange);
      b4.setBorder(BorderFactory.createLineBorder(orange));
      p.add(b4); // 버튼 리뷰 관리

      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            MemberInfoPanel np = new MemberInfoPanel(f, idx, mc);
            return;
         }
      });
      
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "현재 포인트는 " + m.getPoint()+ "p 입니다.");
            return;
         }
      });
      
      b3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // 주문내역 OrderListView
            return;
         }
      });
      
      b4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // 리뷰관리 WriteReview
            return;
         }
      });
      
      b0.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            f.remove(p);
            HomeBuyerPanel np = new HomeBuyerPanel(f, idx);
            return;
         }
      });

   }

}