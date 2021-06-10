package com.projectGo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.projectGo.model.vo.Member;

public class MemberInfoView extends MainFrame {

   Member m;

   JPanel p = new JPanel();            // 판넬 - 공통 ( 회원 정보 텍스트박스, 이전 버튼 )
   JLabel l = new JLabel("회원 정보");
   JLabel l1 = new JLabel("닉네임");
   JLabel l2 = new JLabel("이메일");
   JLabel l3 = new JLabel("비밀번호");
   JLabel l4 = new JLabel("연락처");
   JLabel l5 = new JLabel("주소");
   JTextField t1 = new JTextField();         // 텍스트박스 - 닉네임
   JTextField t2 = new JTextField();         // 텍스트박스 - 이메일
   JPasswordField t3 = new JPasswordField();   // 텍스트박스 - 비밀번호
   JTextField t4 = new JTextField();         // 텍스트박스 - 연락처
   JTextArea t5 = new JTextArea();            // 텍스트박스 - 주소
   JButton b = new JButton("이전");            // 버튼 - 이전 페이지로 이동

   JPanel p1 = new JPanel(); // read      // 판넬 - 조회 ( 수정하기, 로그아웃, 탈퇴하기 버튼 )
   JButton b1 = new JButton("수정 하기");
   JLabel b3 = new JLabel("<html><u>로그아웃</u></html>");
   JLabel b4 = new JLabel("<html><u>탈퇴하기</u></html>");

   JPanel p2 = new JPanel(); // update      // 판넬 - 수정 ( 수정 완료, 중복 확인, 닉네임 초기화 버튼 )
   JButton b2 = new JButton("수정 완료");
   JButton b5 = new JButton("중복");
   JButton b6 = new JButton("초기화");
   
   boolean check, update = true, p1v = true, p2v;   // 중복확인 여부, 수정완료 여부, p1 판넬 & p2 판넬 visible 상태
   
   public MemberInfoView(int idx) {

      m = mbc.getMem(idx);

      createPanel(p);
      createPanel(p1);
      createPanel(p2);

      setButtonPrev(b, p);
      b.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if(p1v) {
               closePanel(p);
               closePanel(p1);
               closePanel(p2);
               MemberMyPageView np = new MemberMyPageView(idx);
            }
            else { // if(p2v) {
               if (!update)
                  if (JOptionPane.showConfirmDialog(p, "수정하지 않고 나가시겠습니까?", "", JOptionPane.YES_NO_OPTION) == 1) 
                     return;
               t1.setBounds(170, 180, 270, 35);
               t1.setEditable(false);  t2.setEditable(false);  t3.setEditable(false);  t4.setEditable(false);  t5.setEditable(false);
               t1.setText(m.getNick());
               t2.setText(m.getEmail());
               t3.setText(String.valueOf(m.getPwd()));
               t4.setText(m.getPhone());
               t5.setText(m.getAddress());
               p1.setVisible(true);
               p2.setVisible(false);
               p1v = true;
               p2v = false;
               update = true;
            }
         }
      });
      
      l.setBounds(210, 100, 150, 30);
      setFontTitle(l, p); // 레이블 마이페이지

      l1.setBounds(80, 180, 100, 35);
      setFontDefault(l1, p); // 레이블 닉네임

      l2.setBounds(80, 250, 100, 35);
      setFontDefault(l2, p); // 레이블 이메일

      l3.setBounds(80, 310, 100, 35);
      setFontDefault(l3, p); // 레이블 비밀번호

      l4.setBounds(80, 370, 100, 35);
      setFontDefault(l4, p); // 레이블 폰번호

      l5.setBounds(80, 420, 100, 35);
      setFontDefault(l5, p); // 레이블 주소
      
      t1.setBounds(170, 180, 270, 35);
      t1.setText(m.getNick());
      t1.setEditable(false);
      t1.setBackground(Color.white);
      setFontDefault(t1, p); // 텍스트박스 닉네임
      t1.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {}
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);  b5.setEnabled(true);  b6.setEnabled(true);
            check = false;
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {}
      });
      
      t2.setBounds(170, 250, 270, 35);
      t2.setText(m.getEmail());
      t2.setEditable(false);
      t2.setBackground(Color.white);
      setFontDefault(t2, p); // 텍스트박스 이메일
      t2.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {}
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {}
      });

      t3.setBounds(170, 310, 270, 35);
      t3.setText(String.valueOf(m.getPwd()));
      t3.setEditable(false);
      t3.setBackground(Color.white);
      setFontDefault(t3, p); // 텍스트박스 비밀번호
      t3.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {}
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {}
      });

      t4.setBounds(170, 370, 270, 35);
      t4.setText(m.getPhone());
      t4.setEditable(false);
      t4.setBackground(Color.white);
      setFontDefault(t4, p); // 텍스트박스 폰번호
      t4.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {}
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {}
      });

      t5.setBounds(170, 430, 270, 95);
      t5.setText(m.getAddress());
      t5.setLineWrap(true);
      t5.setEditable(false);
      t5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(184,207,229)));
      setFontDefault(t5, p); // 텍스트박스 주소
      t5.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {}
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {}
      });

      b1.setBounds(80, 610, 360, 45);
      setButton(b1, p1); // 버튼 수정하기
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            //System.out.println(mc.getMemList());
            t1.setBounds(170, 180, 130, 35);
            t5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
            t1.setEditable(true);  t2.setEditable(true);  t3.setEditable(true);  t4.setEditable(true);  t5.setEditable(true);
            b2.setEnabled(false);  b5.setEnabled(false);  b6.setEnabled(false);
            p1.setVisible(false);
            p2.setVisible(true);
            p1v = false;
            p2v = true;
            check = false;
         }
      });

      b3.setBounds(280, 550, 85, 35);
      b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      setFontDefault(b3, p1); // 버튼 로그아웃
      b3.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (JOptionPane.showConfirmDialog(p1, "로그아웃 하시겠습니까?", "", JOptionPane.YES_NO_OPTION) == 0) {
               closePanel(p);
               closePanel(p1);
               closePanel(p2);
               MemberSignInView np = new MemberSignInView();
            }
         }
         @Override
         public void mousePressed(MouseEvent e) {}
         @Override
         public void mouseReleased(MouseEvent e) {}
         @Override
         public void mouseEntered(MouseEvent e) {}
         @Override
         public void mouseExited(MouseEvent e) {}
      });

      b4.setBounds(370, 550, 85, 35);
      b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      b4.setForeground(Color.gray);
      setFontDefault(b4, p1); // 버튼 탈퇴하기
      b4.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (JOptionPane.showConfirmDialog(p1, "탈퇴 하시겠습니까?", "", JOptionPane.YES_NO_OPTION, 0) == 0) {
               mbc.deleteMem(idx);
               closePanel(p);
               closePanel(p1);
               closePanel(p2);
               MemberSignInView np = new MemberSignInView();
            }
         }
         @Override
         public void mousePressed(MouseEvent e) {}
         @Override
         public void mouseReleased(MouseEvent e) {}
         @Override
         public void mouseEntered(MouseEvent e) {}
         @Override
         public void mouseExited(MouseEvent e) {}
      });

      b2.setBounds(80, 610, 360, 45);
      b2.setEnabled(false);
      setButton(b2, p2); // 버튼 수정 완료
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String mem[] = new String[5];
            int s = mem.length; // 닉네임,이메일,비밀번호,휴대폰번호,주소
            mem[0] = t1.getText().trim();
            mem[1] = t2.getText().trim();
            mem[2] = String.valueOf(t3.getPassword());
            mem[3] = t4.getText().trim();
            mem[4] = t5.getText().trim();
            for (int i = 0; i < s; i++) {
               if (mem[i].equals("")) {
                  JOptionPane.showMessageDialog(null, "내용을 모두 입력하세요");
                  return;
               }
            }
            if (!check && !mem[0].equals(m.getNick())) {
               JOptionPane.showMessageDialog(null, "중복확인을 완료하세요");
               return;
            }
            m = new Member(idx, mem[0], mem[1], mem[2], mem[3], mem[4], m.getType());
            mbc.updateMem(idx, m);
            System.out.println(mbc.getMem(idx));
            JOptionPane.showMessageDialog(null, "수정이 완료되었습니다");
            t1.setBounds(170, 180, 270, 35);
            t5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(184,207,229)));
            t1.setEditable(false);  t2.setEditable(false);  t3.setEditable(false);  t4.setEditable(false);  t5.setEditable(false);
            p1.setVisible(true);
            p2.setVisible(false);
            p1v = true;
            p2v = false;
            update = true;
            check = false;
         }
      });

      b5.setBounds(310, 180, 52, 35);
      b5.setEnabled(false);
      setButton(b5, p2); // 버튼 중복 확인
      b5.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String nick = t1.getText();
            if (nick.equals("")) {
               JOptionPane.showMessageDialog(null, "닉네임을 입력하세요");
               return;
            }
            if (nick.equals(m.getNick()))
               return;
            ArrayList<Member> ls = mbc.getMemList();
            for (Member m : ls) {
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

      b6.setBounds(375, 180, 65, 35);
      b6.setEnabled(false);
      setButton(b6, p2); // 버튼 초기화
      b6.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            t1.setText(m.getNick());
         }
      });

   }

}