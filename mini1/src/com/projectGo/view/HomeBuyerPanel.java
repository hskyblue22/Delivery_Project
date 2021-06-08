package com.projectGo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MemberController;

public class HomeBuyerPanel extends JFrame {
   
   private static MemberController mc = new MemberController();
   
   JPanel p = new JPanel();

   JButton bn = new JButton("마이페이지");

   public HomeBuyerPanel(JFrame f, int idx, MemberController mc) {

      super("메인");
      super.setResizable(true);

      p.setVisible(true);
      p.setLayout(null);
      p.setOpaque(false);
      f.add(p);

      bn.setBounds(120, 100, 100, 30);
      p.add(bn);

      bn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            f.remove(p);
            MemberMyPagePanel np = new MemberMyPagePanel(f, idx, mc);
         }
      });
      
   }
   
//   public static void main(String[] args) {
//      
//      JFrame f = new JFrame();
//      f.setBounds(500, 200, 350, 480);
//         
//      int idx = 0; /******/
//      MainFrame p = new MainFrame(idx);
//         
//      f.setVisible(true);
//      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
//   }

}