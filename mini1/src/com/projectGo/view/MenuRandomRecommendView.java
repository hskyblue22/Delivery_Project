package com.projectGo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.projectGo.model.vo.Member;

public class MenuRandomRecommendView extends MainFrame {

   Member m;
   
   JPanel p = new JPanel();
   
   JLabel l = new JLabel("랜덤 메뉴 추천");
   JButton b = new JButton("이전");         // 버튼 - 이전
   
   public MenuRandomRecommendView(int idx) {
      
      m = mbc.getMem(idx);
      
      createPanel(p);
      
      setButtonPrev( b, p );
      b.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            closePanel(p);
            HomeBuyerView np = new HomeBuyerView(idx);
            return;
         }
      });
      
      l.setBounds(190, 100, 250, 30);
      setFontTitle(l, p); // 레이블 랜덤 메뉴 추천

   }

}