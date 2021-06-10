package com.projectGo.view;

import java.awt.Color;

import javax.swing.JFrame;

import com.projectGo.controller.MemberController;

public class HomeFrame extends JFrame {
   
   private static MemberController mc = new MemberController();
   
   JFrame f = new JFrame();

   public HomeFrame(int idx, MemberController mc) {

      super("메인");
      super.setResizable(true);
      
      f.setBounds(1000, 80, 550, 800);
      f.getContentPane().setBackground(Color.WHITE);
      
      switch(mc.getMemList().get(idx).getType()) {
      case 1:
         HomeSellerPanel ps = new HomeSellerPanel(f, idx);
         break;
      case 2:
         HomeBuyerPanel pb = new HomeBuyerPanel(f, idx);
         break;
      }
      
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}