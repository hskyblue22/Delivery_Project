package com.projectGo.model.dao;

import java.util.ArrayList;

import com.projectGo.model.vo.Member;

public class MemberDao {
	
	ArrayList<Member> list = new ArrayList<>();
	
	// 추가 (회원가입)
	public void addMem(Member m) {
		list.add(m);
	}
	
	//삭제 (회원탈퇴)
	public void deleteMem(int idx) {
		list.remove(idx);
	}
	//수정 (회원정보 수정)
	public void updateMem(int idx, Member m) {
		list.set(idx, m);
	}
	//조회 (회원정보 조회)
	public Member getMem(int idx) {
		return list.get(idx);
	}
	//조회 (회원 리스트 조회)
	public ArrayList<Member> getMemList() {
		return list;
	}
			
}
