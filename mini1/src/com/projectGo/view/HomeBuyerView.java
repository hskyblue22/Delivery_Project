package com.projectGo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeBuyerView extends MainFrame {

   JPanel p = new JPanel();

   JButton b1 = new JButton("마이페이지");
   
   JButton b2 = new JButton("랜덤 메뉴 추천");

   public HomeBuyerView(int idx) {
      
      createPanel(p);

      b1.setBounds(120, 100, 250, 50);
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            closePanel(p);
            MemberMyPageView np = new MemberMyPageView(idx);
         }
      });
      p.add(b1);
      
      b2.setBounds(120, 200, 250, 50);
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            closePanel(p);
            MenuRandomRecommendView np = new MenuRandomRecommendView(idx);
         }
      });
      p.add(b2);
      
   }

}