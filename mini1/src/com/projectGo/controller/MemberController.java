package com.projectGo.controller;

import java.util.ArrayList;

import com.projectGo.model.dao.MemberDao;
import com.projectGo.model.vo.Member;

public class MemberController {
	//개인정보관리
	//수정-->이름,이메일,휴대폰번호,주소
	//+탈퇴하기
	
	private MemberDao md=new MemberDao();
	private ArrayList<Member> list;
	
	public MemberController() {
		
	}
	
	
	public ArrayList<Member> getList(){
		
		md.fileInput();
		list =  md.getMemberList();
		return list;
	}
	
	
	// 추가 (회원가입)
	public void addMem(Member m) {
		addMem(m);
	}
	
	//삭제 (회원탈퇴)
	public void deleteMem(int idx) {
		deleteMem(idx);
	}
	
	//수정 (회원정보 수정)
	public void updateMem(int idx, Member m) {
		updateMem(idx, m);
	}
	
	
	//조회 (회원정보 조회)
	public Member getMem(int idx) {
		return getMem(idx);
	}
	
	//조회 (회원 리스트 조회)
	public ArrayList<Member> getMemList() {
		return getMemList();
	}
	
}
