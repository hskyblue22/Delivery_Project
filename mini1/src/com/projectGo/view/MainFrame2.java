package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.projectGo.controller.MemberController;
import com.projectGo.controller.MenuController;
import com.projectGo.controller.StoreController;
import com.projectGo.model.vo.Member;

public class MainFrame2 extends JFrame {

   public static JFrame mainFrame;
   
   public static MemberController mbc = new MemberController();
   public static MenuController mnc = new MenuController();
   public static StoreController sc = new StoreController();
   
   Color orange = new Color(243, 156, 18);
   Color lightgray = new Color(230, 230, 230);
   
   public void closePanel( JPanel p ) {
      p.setVisible(false);
      mainFrame.remove(p);
   }
   
   public void createPanel( JPanel p ) {
      p.setSize(550, 800);
      p.setVisible(true);
      p.setLayout(null);
      p.setOpaque(false);
      mainFrame.add(p);
   }
   
   public void setButton( JButton b, JPanel p ) {
      b.setMargin(new Insets(1,1,1,1));
      b.setForeground(Color.WHITE);
      b.setBackground(orange);
      b.setBorder(null);
      setFontDefault( b, p );
   }
   
   public void setButtonPrev( JButton b, JPanel p ) {
      b.setBounds(40, 40, 80, 35);
      b.setMargin(new Insets(1,1,1,1));
      b.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      b.setForeground(Color.GRAY);
      b.setBackground(lightgray);
      b.setBorder(null);
      p.add(b);
   }
   
   public void setFontDefault( JComponent l, JPanel p ) {
      l.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l);
   }
   
   public void setFontTitle( JComponent l, JPanel p ) {
      l.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      p.add(l);
   }

   static {
      mainFrame = new JFrame();
      mainFrame.getContentPane().setBackground(Color.white);
      mainFrame.setBounds(1000, 200, 550, 800);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //mainFrame.getContentPane().setLayout(null);
      //mainFrame.setVisible(true);
      
      ArrayList<Member> mls = mbc.getMemList();
      Member m1 = new Member(mls.size(), " abc", "abc12234@naver.com", "1234", "010-1234-5678", "서울 특별시 강남구 테헤란로 14길 6", 2, 250);
      Member m2 = new Member(mls.size(), "권민지", "kmj381912@naver.com", "1234", "010-1234-5678", "서울 특별시 강남구 테헤란로 14길 6", 2, 250);
      Member m3 = new Member(mls.size(), "김사장", "ceo1234@naver.com", "1234", "010-1234-5678", "서울 특별시 강남구 테헤란로 14길 6", 1);
      mls.add( m1 );
      mls.add( m2 );
      mls.add( m3 );
   }
}