package com.projectGo.view;

import java.awt.Color;

import javax.swing.JFrame;

import controller.MemberController;

public class MemberFrame extends JFrame {
   
   JFrame f = new JFrame();

   public MemberFrame(MemberController mc) {

      super.setResizable(true);

      f.setBounds(1000, 200, 500, 750);
      f.getContentPane().setBackground(Color.WHITE);
      
      MemberSignInPanel p = new MemberSignInPanel(f,mc);
      
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}