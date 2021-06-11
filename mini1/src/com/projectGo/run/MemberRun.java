package com.projectGo.run;

import com.projectGo.controller.MemberController;
import com.projectGo.model.vo.Member;
import com.projectGo.view.MemberMypageView;
import com.projectGo.view.MemberSignInView;

public class MemberRun {

   public static void main(String[] args) {
      
      
	  //MemberSignInView v=new MemberSignInView();
	  new MemberMypageView(1);
   }
}