package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.projectGo.model.vo.Member;

public class MemberSignUpView extends MainFrame {

   boolean check = false;                     // 닉네임 중복확인 여부
   int type = 0;                           // 멤버의 타입 ( 판매자/구매자 )

   JPanel p = new JPanel();
   
   JLabel l = new JLabel("회원 가입");            
   JLabel l1 = new JLabel("닉네임");
   JLabel l2 = new JLabel("이메일");
   JLabel l3 = new JLabel("비밀번호");
   JLabel l4 = new JLabel("비밀번호");
   JLabel l5 = new JLabel("폰번호");
   JLabel l6 = new JLabel("주소");
   JTextField t1 = new JTextField("");            // 텍스트박스 - 닉네임 ( 아이디 )
   JTextField t2 = new JTextField("");            // 텍스트박스 - 이메일
   JPasswordField t3p = new JPasswordField("");   // 텍스트박스 - 비밀번호
   JPasswordField t4p = new JPasswordField("");   // 텍스트박스 - 비밀번호 확인
   JTextField t5 = new JTextField("");            // 텍스트박스 - 폰번호
   JTextArea t6 = new JTextArea("");            // 텍스트박스 - 주소
   JButton b = new JButton("이전");               // 버튼 - 이전
   JButton b1 = new JButton("중복확인");            // 버튼 - 중복확인
   JButton b2 = new JButton("완료");               // 버튼 - 완료
   JRadioButton rb1 = new JRadioButton(" 구매자");   // 라디오 버튼 - 구매자
   JRadioButton rb2 = new JRadioButton(" 판매자");   // 라디오 버튼 - 판매자
   
   public MemberSignUpView() {
      
      ArrayList<Member> mls = mbc.getMemList();

      createPanel(p);

      l.setBounds(210, 100, 150, 30);
      setFontDefault(l, p);
      
      // 이전 버튼
      setButtonPrev(b, p);
      b.addActionListener(new ActionListener() {
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
            closePanel(p);
            MemberSignInView np = new MemberSignInView();
         }
      }); 

      // 텍스트필드+라벨
      t1.setBounds(155, 185, 180, 35);
      setFontDefault(t1, p);
      l1.setBounds(65, 185, 100, 35);
      setFontDefault(l1, p);

      t2.setBounds(155, 235, 290, 35);
      setFontDefault(t2, p);
      l2.setBounds(65, 235, 100, 35);
      setFontDefault(l2, p);

      t3p.setBounds(155, 285, 290, 35);
      setFontDefault(t3p, p);
      l3.setBounds(65, 285, 100, 35);
      setFontDefault(l3, p);

      t4p.setBounds(155, 335, 290, 35);
      setFontDefault(t4p, p);
      l4.setBounds(65, 335, 100, 35);
      setFontDefault(l4, p);

      t5.setBounds(155, 385, 290, 35);
      setFontDefault(t5, p);
      l5.setBounds(65, 385, 100, 35);
      setFontDefault(l5, p);

      t6.setBounds(155, 435, 290, 72);
      t6.setLineWrap(true);
      t6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
      setFontDefault(t6, p);
      l6.setBounds(65, 435, 100, 35);
      setFontDefault(l6, p);

      // 중복확인 버튼
      b1.setBounds(345, 185, 100, 35);
      setButton(b1, p);
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
      
      // 완료 버튼
      b2.setBounds(155, 605, 290, 45);
      setButton(b2, p);
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
            Member mb = new Member(mls.size(), mem[0], mem[1], mem[2], mem[4], mem[5], type);
            mbc.addMem(mb);
            System.out.println(mb);
            JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
            t1.setText("");
            t2.setText("");
            t3p.setText("");
            t4p.setText("");
            t5.setText("");
            t6.setText("");
            check = false;
            closePanel(p);
            MemberSignInView np = new MemberSignInView();
         }
      });
      
      // 판매자/구매자 라디오 버튼
      rb1.setBounds(155, 525, 100, 35);
      rb1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      rb1.setBackground(Color.white);
       rb1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            type = 2;
         }
      });
       rb2.setBounds(255, 525, 100, 35);
      rb2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      rb2.setBackground(Color.white);
       rb2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            type = 1;
         }
      });
       ButtonGroup group = new ButtonGroup();
       group.add(rb1);
       group.add(rb2);
       p.add(rb1);
       p.add(rb2);
      
   }

}