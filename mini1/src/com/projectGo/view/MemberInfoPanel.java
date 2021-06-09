package com.projectGo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MemberController;
import model.vo.Member;

public class MemberInfoPanel extends JFrame {

   //static MemberController mc = new MemberController();
   static Member m;

   JPanel p0 = new JPanel();

   JButton b0 = new JButton("이전");
   JLabel l0 = new JLabel("회원 정보");
   JLabel l1 = new JLabel("닉네임");
   JLabel l2 = new JLabel("이메일");
   JLabel l3 = new JLabel("비밀번호");
   JLabel l4 = new JLabel("연락처");
   JLabel l5 = new JLabel("주소");
   JTextField t1 = new JTextField();
   JTextField t2 = new JTextField();
   JPasswordField t3 = new JPasswordField();
   JTextField t4 = new JTextField();
   JTextArea t5 = new JTextArea();//주소

   JPanel p1 = new JPanel(); // read

   JButton b1 = new JButton("수정 하기");
   
   JLabel b3 = new JLabel("<html><u>로그아웃</u></html>");
   JLabel b4 = new JLabel("<html><u>탈퇴하기</u></html>");
 
   JPanel p2 = new JPanel(); // update

   JButton b2 = new JButton("수정 완료");
   JButton b5 = new JButton("중복");//수정할 때도 중복확인 해야됨
   JButton b6 = new JButton("초기화");
   
   Color orange = new Color(243, 156, 18);
   Color lightgray = new Color(230, 230, 230);
   //=========================================================
   
   boolean check, update = true, p1v = true, p2v;
   
   public MemberInfoPanel(JFrame f, int idx, MemberController mc) {

      super("회원 정보");
      super.setResizable(true);

      m = mc.getMem(idx);

      p0.setLayout(null);
      p0.setOpaque(false);
      p0.setBounds(0, 0, 550, 800);
      p0.setVisible(true);
      f.add(p0);

      b0.setBounds(40, 40, 80, 35);
      b0.setMargin(new Insets(1, 1, 1, 1));
      b0.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      b0.setForeground(Color.white);
      b0.setBackground(orange);
      b0.setBorder(BorderFactory.createLineBorder(orange));
      b0.addActionListener(new ActionListener() {//이전
         @Override
         public void actionPerformed(ActionEvent e) {
            if(p1v) {
               p0.setVisible(false);
               p1.setVisible(false);
               p2.setVisible(false);
               f.remove(p0);
               f.remove(p1);
               f.remove(p2);
               MemberMyPagePanel np = new MemberMyPagePanel(f, idx, mc);
            }
            else { // if(p2v) {
               if (!update)
                  if (JOptionPane.showConfirmDialog(p0, "수정하지 않고 나가시겠습니까?", "", JOptionPane.YES_NO_OPTION) == 1) 
                     return;
               t1.setBounds(170, 180, 270, 35);
               t1.setEditable(false);
               t2.setEditable(false);
               t3.setEditable(false);
               t4.setEditable(false);
               t5.setEditable(false);
               
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
      p0.add(b0); // 버튼 이전
      //==========================================================================
      
      l0.setBounds(210, 100, 150, 30);
      l0.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      p0.add(l0); // 레이블 마이페이지

      l1.setBounds(80, 180, 100, 35);
      l1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p0.add(l1); // 레이블 닉네임

      l2.setBounds(80, 250, 100, 35);
      l2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p0.add(l2); // 레이블 이메일

      l3.setBounds(80, 310, 100, 35);
      l3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p0.add(l3); // 레이블 비밀번호

      l4.setBounds(80, 370, 100, 35);
      l4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p0.add(l4); // 레이블 폰번호

      l5.setBounds(80, 420, 100, 35);
      l5.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      p0.add(l5); // 레이블 주소
      //===
      
      t1.setBounds(170, 180, 270, 35);
      t1.setText(m.getNick());
      t1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      t1.setEditable(false);
      t1.setBackground(Color.white);
      t1.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            check = false;
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {
         }
      });
      p0.add(t1); // 텍스트박스 닉네임
      
      t2.setBounds(170, 250, 270, 35);
      t2.setText(m.getEmail());
      t2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      t2.setEditable(false);
      t2.setBackground(Color.white);
      t2.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {
         }
      });
      p0.add(t2); // 텍스트박스 이메일

      t3.setBounds(170, 310, 270, 35);
      t3.setText(String.valueOf(m.getPwd()));
      t3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      t3.setEditable(false);
      t3.setBackground(Color.white);
      t3.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {
         }
      });
      p0.add(t3); // 텍스트박스 비밀번호

      t4.setBounds(170, 370, 270, 35);
      t4.setText(m.getPhone());
      t4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      t4.setEditable(false);
      t4.setBackground(Color.white);
      t4.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {
         }
      });
      p0.add(t4); // 텍스트박스 폰번호

      t5.setBounds(170, 430, 270, 95);
      t5.setText(m.getAddress());
      t5.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      t5.setLineWrap(true);
      t5.setEditable(false);
      t5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
      t5.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }
         @Override
         public void keyPressed(KeyEvent e) {
            b2.setEnabled(true);
            update = false;
         }
         @Override
         public void keyReleased(KeyEvent e) {
         }
      });
      p0.add(t5); // 텍스트박스 주소

      p1.setLayout(null);
      p1.setOpaque(false);
      p1.setBounds(0, 0, 550, 800);
      p1.setVisible(true);
      f.add(p1);
      //=========================================================================

      b1.setBounds(80, 610, 360, 45);//수정하기
      b1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      b1.setForeground(Color.white);
      b1.setBackground(orange);
      b1.setBorder(BorderFactory.createLineBorder(orange));
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println(mc.getMemList());
            t1.setBounds(170, 180, 130, 35);
            t1.setEditable(true);
            t2.setEditable(true);
            t3.setEditable(true);
            t4.setEditable(true);
            t5.setEditable(true);
            
            b2.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            
            p1.setVisible(false);
            p2.setVisible(true);
            
            p1v = false;
            p2v = true;///////////////////
            check = false;
            //update = false;
         }
      });
      p1.add(b1); // 버튼 수정하기

      b3.setBounds(280, 550, 85, 35);
      b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      b3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      b3.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (JOptionPane.showConfirmDialog(p2, "로그아웃 하시겠습니까?", "", JOptionPane.YES_NO_OPTION) == 0) {
               f.dispose();
               MemberSignInPanel np = new MemberSignInPanel(new MemberFrame(mc), mc);
            }
         }
         @Override
         public void mousePressed(MouseEvent e) {
         }
         @Override
         public void mouseReleased(MouseEvent e) {
         }
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
         }
      });
      p1.add(b3); // 버튼 로그아웃

      b4.setBounds(370, 550, 85, 35);
      b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      b4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
      b4.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (JOptionPane.showConfirmDialog(p2, "탈퇴 하시겠습니까?", "", JOptionPane.YES_NO_OPTION, 0) == 0) {
               mc.deleteMem(idx);
               f.dispose();
               MemberSignInPanel np = new MemberSignInPanel(new MemberFrame(mc), mc);
            }
         }
         @Override
         public void mousePressed(MouseEvent e) {
         }
         @Override
         public void mouseReleased(MouseEvent e) {
         }
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
         }
      });
      p1.add(b4); // 버튼 탈퇴하기

      p2.setLayout(null);
      p2.setOpaque(false);
      p2.setBounds(0, 0, 550, 800);
      p2.setVisible(false);
      f.add(p2);

      b2.setBounds(80, 610, 360, 45);
      b2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      b2.setEnabled(false);
      b2.setForeground(Color.white);
      b2.setBackground(orange);
      b2.setBorder(BorderFactory.createLineBorder(orange));
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
            m = new Member(idx, mem[0], mem[1], mem[2], mem[3], mem[4], m.getPoint(), m.getType());
            mc.updateMem(idx, m);
            System.out.println(mc.getMem(idx));
            JOptionPane.showMessageDialog(null, "수정이 완료되었습니다");
            t1.setBounds(170, 180, 270, 35);
            t1.setEditable(false);
            t2.setEditable(false);
            t3.setEditable(false);
            t4.setEditable(false);
            t5.setEditable(false);
            p1.setVisible(true);
            p2.setVisible(false);
            p1v = true;
            p2v = false;
            update = true;
            check = false;
         }
      });
      p2.add(b2); // 버튼 수정 완료

      b5.setBounds(310, 180, 52, 35);
      b5.setMargin(new Insets(1, 1, 1, 1)); // b5.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 0 , 0));
      b5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      b5.setEnabled(false);
      b5.setForeground(Color.white);
      b5.setBackground(orange);
      b5.setBorder(BorderFactory.createLineBorder(orange));
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
            ArrayList<Member> ls = mc.getMemList();
            System.out.println(ls); /******/
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
      p2.add(b5); // 버튼 중복 확인

      b6.setBounds(375, 180, 65, 35);
      b6.setMargin(new Insets(1, 1, 0, 0));
      b6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      b6.setEnabled(false);
      b6.setForeground(Color.white);
      b6.setBackground(orange);
      b6.setBorder(BorderFactory.createLineBorder(orange));
      b6.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            t1.setText(m.getNick());
         }
      });
      p2.add(b6); // 버튼 초기화

   }

}