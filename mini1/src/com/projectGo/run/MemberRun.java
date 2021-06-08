package com.projectGo.run;

import javax.swing.JFrame;

import controller.MemberController;
import model.vo.Member;
import view.MemberFrame;

public class MemberRun extends JFrame {

   public static void main(String[] args) {
      
      MemberController mc = new MemberController();
      
      /******/
      mc.getMemList().add( new Member(mc.getMemList().size(), "권민지", "kmj381912@naver.com", "1234", "010-1234-5678", "서울 특별시 강남구 테헤란로 14길 6", 250, 2) );
      mc.getMemList().add( new Member(mc.getMemList().size(), "abc", "abc1234@naver.com", "1234", "010-1234-5678", "서울 특별시 강남구 테헤란로 14길 6", 250, 2) );
      
      MemberFrame f = new MemberFrame(mc);
   }
}