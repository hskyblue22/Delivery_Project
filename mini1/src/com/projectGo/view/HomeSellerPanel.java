package com.projectGo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.projectGo.controller.MemberController;

public class HomeSellerPanel extends JFrame {
   
   private static MemberController mc = new MemberController();

   JPanel p = new JPanel();

   public HomeSellerPanel(JFrame f, int idx) {

      super("메인");
      super.setResizable(true);

      p.setVisible(true);
      p.setLayout(null);
      f.add(p);
      
      
   
   }
}