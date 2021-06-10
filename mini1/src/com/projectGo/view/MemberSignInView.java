package com.projectGo.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.projectGo.model.vo.Member;

public class MemberSignInView extends MainFrame {
   
   JPanel p = new JPanel();
   
   JLabel i = new JLabel();
   JLabel l1 = new JLabel("아이디");
   JLabel l2 = new JLabel("비밀번호");
   JTextField t1 = new JTextField("");         // 텍스트박스 - 아이디
   JPasswordField t2 = new JPasswordField("");   // 텍스트박스 - 비밀번호
   JButton b1 = new JButton("로그인");         // 버튼 - 로그인
   JButton b2 = new JButton("회원가입");         // 버튼 - 회원가입

   public MemberSignInView() {

      createPanel(p);

      ImageIcon logo = new ImageIcon(new ImageIcon("C:\\Users\\joyhj\\eclipse-workspace\\Ex\\src\\logo.jpg").getImage().getScaledInstance(137, 130, Image.SCALE_DEFAULT));
      i.setIcon(logo);
      i.setBounds(200, 160, 137, 130);
      p.add(i); // 레이블 로그인/로고
      
      l1.setBounds(100, 350, 100, 45);
      setFontDefault(l1, p);  // 레이블 아이디

      l2.setBounds(100, 405, 100, 45);
      setFontDefault(l2, p); // 레이블 비밀번호

      t1.setBounds(190, 350, 220, 45);
      setFontDefault(t1, p); // 텍스트박스 아이디

      t2.setBounds(190, 405, 220, 45);
      setFontDefault(t2, p); // 텍스트박스 비밀번호

      b1.setBounds(100, 515, 160, 45);
      setButton(b1, p);  // 버튼 로그인
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
            ArrayList<Member> mls = mbc.getMemList();
            System.out.println(mls); /******/
            int size = mls.size(), type, idx, i; Member m;
            for ( i = 0; i < size; i++ ) {
               m = mls.get(i);
               if (m.getNick().equals(id)) {
                  if (pw.equals(m.getPwd())) {
                     t1.setText("");
                     t2.setText("");
                     p.setVisible(false);
                     mainFrame.remove(p);
                     idx = i;
                     type = m.getType();
                     HomeSellerView np1;
                     HomeBuyerView np2;
                     if( type == 1 )
                        np1 = new HomeSellerView(idx);
                     else if( type == 2 )
                        np2 = new HomeBuyerView(idx);
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
      setButton(b2, p);  // 버튼 회원가입
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            mainFrame.remove(p);
            MemberSignUpView np = new MemberSignUpView();
         }
      });
      
      mainFrame.setVisible(true);
   }

}