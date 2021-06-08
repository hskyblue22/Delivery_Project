package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.projectGo.controller.MemberController;

public class MemberSignUpPanel extends JFrame {

   //ArrayList<Member> mls;

   boolean check = false; //아이디 중복확인 관련
   int type = 0;

   JPanel p = new JPanel();
   JTextField t1 = new JTextField("");
   JTextField t2 = new JTextField("");
   JPasswordField t3p = new JPasswordField("");
   JPasswordField t4p = new JPasswordField("");
   JTextField t5 = new JTextField("");
   JTextArea t6 = new JTextArea("");
   JButton b0 = new JButton("이전");
   JButton b1 = new JButton("중복확인");
   JButton b2 = new JButton("완료");
   JLabel l0 = new JLabel("회원가입");
   JLabel l1 = new JLabel("닉네임");
   JLabel l2 = new JLabel("이메일");
   JLabel l3 = new JLabel("비밀번호");
   JLabel l4 = new JLabel("비밀번호");
   JLabel l5 = new JLabel("폰번호");
   JLabel l6 = new JLabel("주소");
   JRadioButton rb1 = new JRadioButton(" 구매자");
   JRadioButton rb2 = new JRadioButton(" 판매자");
   
   Color orange = new Color(243, 156, 18);
   
   public MemberSignUpPanel(JFrame f, MemberController mc) {

      super("회원가입");
      super.setResizable(true);
      
      ArrayList<Member> mls = mc.getMemList();

      p.setVisible(true);
      p.setLayout(null);
      p.setOpaque(false);
      f.add(p);

      l0.setBounds(190, 80, 150, 30);
      l0.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      p.add(l0);
      
      b0.setBounds(35, 35, 75, 30);
      b0.setMargin(new Insets(1, 1, 1, 1));
      b0.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      b0.setForeground(Color.white);
      b0.setBackground(orange);
      b0.setBorder(BorderFactory.createLineBorder(orange));
      b0.addActionListener(new ActionListener() {//"이전"버튼
         @Override
         public void actionPerformed(ActionEvent e) {
            String mem[] = new String[6];
            int s = mem.length, i; // 닉네임,이메일,생년월일,휴대폰번호,주소
            mem[0] = t1.getText().trim();
            mem[1] = t2.getText().trim();
            mem[2] = String.valueOf(t3p.getPassword());
            mem[3] = String.valueOf(t4p.getPassword());
            mem[4] = t5.getText().trim();
            mem[5] = t6.getText().trim();
            for(i = 0; i < s; i++)
               if( !mem[i].equals("") )
                  if (JOptionPane.showConfirmDialog(p, "가입하지 않고 나가시겠습니까?", "", JOptionPane.YES_NO_OPTION) == 0) 
                     break;
            p.setVisible(false);
            f.remove(p);
            MemberSignInPanel np = new MemberSignInPanel(f, mc);
         }
      });
      p.add(b0); // 버튼 이전
                
      // 텍스트필드+라벨
      t1.setBounds(130, 160, 180, 35);
      t1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(t1);
      l1.setBounds(40, 160, 100, 35);
      l1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l1);

      t2.setBounds(130, 205, 290, 35);
      t2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(t2);
      l2.setBounds(40, 205, 100, 35);
      l2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l2);

      t3p.setBounds(130, 250, 290, 35);
      t3p.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(t3p);
      l3.setBounds(40, 250, 100, 35);
      l3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l3);

      t4p.setBounds(130, 295, 290, 35);
      t4p.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(t4p);
      l4.setBounds(40, 295, 100, 35);
      l4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l4);

      t5.setBounds(130, 340, 290, 35);
      t5.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(t5);
      l5.setBounds(40, 340, 100, 35);
      l5.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l5);

      t6.setBounds(130, 385, 290, 72);
      t6.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      t6.setLineWrap(true);
      t6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
      p.add(t6);
      l6.setBounds(40, 385, 100, 35);
      l6.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p.add(l6);

      // 버튼
      b1.setBounds(320, 160, 100, 35);
      b1.setMargin(new Insets(1,1,1,1));
      b1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      b1.setForeground(Color.white);
      b1.setBackground(orange);
      b1.setBorder(BorderFactory.createLineBorder(orange));
      p.add(b1);
      b2.setBounds(130, 550, 290, 45);
      b2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      b2.setForeground(Color.white);
      b2.setBackground(orange);
      b2.setBorder(BorderFactory.createLineBorder(orange));
      p.add(b2);

      // 완료(회원가입 완료되는 과정)
      b2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            
            if( type == 0 ) {
               JOptionPane.showMessageDialog(null, "구매자 또는 판매자를 선택해주세요");
               return;
            }

            String mem[] = new String[6];
            int s = mem.length; // 닉네임,이메일,생년월일,휴대폰번호,주소

            mem[0] = t1.getText().trim();
            mem[1] = t2.getText().trim();
            mem[2] = String.valueOf(t3p.getPassword());
            mem[3] = String.valueOf(t4p.getPassword());
            mem[4] = t5.getText().trim();
            mem[5] = t6.getText().trim();

            for (int i = 0; i < s; i++) {
               if (mem[i].equals("")) {
                  JOptionPane.showMessageDialog(null, "정보를 모두 입력하세요");
                  return;
               }
            }

            if (!check) {
               JOptionPane.showMessageDialog(null, "중복확인을 완료하세요");
               return;
            }

            if (!mem[2].equals(mem[3])) {
               JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
               return;
            }

            Member mb = new Member(mls.size(), mem[0], mem[1], mem[2], mem[4], mem[5], 0, type);
            mc.addMem(mb);
            System.out.println(mb);

            JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");

            t1.setText("");
            t2.setText("");
            t3p.setText("");
            t4p.setText("");
            t5.setText("");
            t6.setText("");
            check = false;

            p.setVisible(false);
            f.remove(p);
            MemberSignInPanel np = new MemberSignInPanel(f, mc);
         }
      });

      // 중복확인
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String nick = t1.getText();
            if (nick.equals("")) {
               JOptionPane.showMessageDialog(null, "닉네임을 입력하세요");
               return;
            }
            for (Member m : mls) {
               if (nick.equals(m.getNick())) {
                  t1.setText("");
                  JOptionPane.showMessageDialog(null, "이미 등록된 닉네임 입니다");
                  return;
               }
            }
            JOptionPane.showMessageDialog(null, "사용할 수 있는 닉네임 입니다");
            check = true;
         }
      });
      
      rb1.setBounds(130, 470, 100, 35);
      rb1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      rb1.setBackground(Color.white);
      
      rb2.setBounds(230, 470, 100, 35);
      rb2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      rb2.setBackground(Color.white);
      
      ButtonGroup group = new ButtonGroup();
       group.add(rb1);
       group.add(rb2);
       
       p.add(rb1);
       p.add(rb2);
       
       rb1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            type = 2;
         }
      });
       rb2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            type = 1;
         }
      });
      
   }

}