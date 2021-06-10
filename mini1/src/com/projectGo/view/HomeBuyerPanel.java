package com.projectGo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.projectGo.controller.MemberController;

public class HomeBuyerPanel extends JFrame {
   
   private static MemberController mc = new MemberController();

   JPanel p = new JPanel();

   JButton bn = new JButton("마이페이지");

   public HomeBuyerPanel(JFrame f, int idx) {

      super("메인");
      super.setResizable(true);

      p.setVisible(true);
      p.setLayout(null);
      f.add(p);

      bn.setBounds(120, 100, 100, 30);
      p.add(bn);

      bn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            f.remove(p);
            MemberMypagePanel np = new MemberMypagePanel(f, idx,mc);
         }
      });
      
   }
}