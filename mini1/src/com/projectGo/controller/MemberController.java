package com.projectGo.controller;

import java.util.ArrayList;

import com.projectGo.model.dao.MemberDao;
import com.projectGo.model.vo.Member;

public class MemberController {
	//개인정보관리
	//수정-->이름,이메일,휴대폰번호,주소
	//+탈퇴하기
	MemberDao dao = new MemberDao();
	
	// 추가 (회원가입)
//	public void addMem(Member m) {
//		dao.addMem(m);
//	}
	
	//삭제 (회원탈퇴)
	public void deleteMem(Member m) {
		dao.deleteMem(m);
	}
	
	//수정 (회원정보 수정)
	public void updateMem(Member m) {
		dao.updateMem(m);
	}
	
	//조회 (회원정보 조회)
	public Member getMem(int idx) {
		return dao.getMem(idx);
	}
	
	//조회 (회원 리스트 조회)
	public ArrayList<Member> getMemList() {
		return dao.getMemList();
	}
	
}
