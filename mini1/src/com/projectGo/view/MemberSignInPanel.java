package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.MemberController;
import model.vo.Member;

public class MemberSignInPanel extends JFrame {
   
   JPanel p = new JPanel();
   JTextField t1 = new JTextField("");
   JPasswordField t2 = new JPasswordField("");
   JButton bn1 = new JButton("로그인");
   JButton bn2 = new JButton("회원가입");
   JLabel l0 = new JLabel();
   JLabel l1 = new JLabel("아이디");
   JLabel l2 = new JLabel("비밀번호");
   
   Color orange = new Color(243, 156, 18);

   public MemberSignInPanel(JFrame f, MemberController mc) {

      super("로그인");
      super.setResizable(true);
      
      System.out.println(mc.getMemList());

      p.setVisible(true);
      p.setSize(550, 800);
      p.setLayout(null);
      p.setOpaque(false);
      f.add(p);

      ImageIcon icon = new ImageIcon("C:\\Users\\");//경로 복사하기
      Image im = icon.getImage(); 
      Image im2 = im.getScaledInstance(137, 130, Image.SCALE_DEFAULT);
      ImageIcon icon2 = new ImageIcon(im2);
      
      
      l0.setBounds(170, 140, 137, 130);
      l0.setIcon(icon2);
      p.add(l0); // 레이블 로그인/로고
           
      l1.setBounds(70, 320, 100, 45);
      l1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l1); // 레이블 아이디

      l2.setBounds(70, 380, 100, 45);
      l2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l2); // 레이블 비밀번호

      t1.setBounds(160, 320, 220, 45);
      t1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(t1); // 텍스트박스 아이디

      t2.setBounds(160, 380, 220, 45);
      t2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(t2); // 텍스트박스 비밀번호

      bn1.setBounds(70, 480, 160, 45);
      bn1.setMargin(new Insets(1,1,1,1));
      bn1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      bn1.setForeground(Color.white);
      bn1.setBackground(orange);
      bn1.setBorder(BorderFactory.createLineBorder(orange));
      p.add(bn1); // 버튼 로그인
      bn2.setBounds(245, 480, 160, 45);
      bn2.setMargin(new Insets(1,1,1,1));
      bn2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      bn2.setForeground(Color.white);
      bn2.setBackground(orange);
      bn2.setBorder(BorderFactory.createLineBorder(orange));
      p.add(bn2); // 버튼 회원가입

      bn1.addActionListener(new ActionListener() {

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
            
            ArrayList<Member> mls = mc.getMemList();
            int size = mls.size(), i; Member m;
            
            for ( i = 0; i < size; i++ ) {
               m = mls.get(i);
               if (m.getNick().equals(id)) {
                  if (pw.equals(m.getPwd())) {
                     //JOptionPane.showMessageDialog(null, "로그인하였습니다.");
                     t1.setText("");
                     t2.setText("");
                     HomeFrame nf = new HomeFrame(i, mc);
                     f.dispose();
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

      bn2.addActionListener(new ActionListener() {//회원가입 버튼 누르면

         @Override
         public void actionPerformed(ActionEvent e) {
            
            p.setVisible(false);
            f.remove(p);
            MemberSignUpPanel np = new MemberSignUpPanel(f, mc);
         }
      });

   }
   
//   /******/
//   public static void main(String[] args) {
//      
//      JFrame f = new JFrame();
//      
//      f.setBounds(1000, 200, 500, 750);
//      
//      MemberSignInPanel mp = new MemberSignInPanel(f, new MemberController());
//      
//      f.setVisible(true);
//      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//   }

}