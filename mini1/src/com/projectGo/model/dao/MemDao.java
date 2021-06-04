package com.projectGo.model.dao;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.model.dao.Iterator;
import com.kh.project.model.dao.Member;

public class MemDao {
	ArrayList<Member> list=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	
	public MemDao() {
		
	}
	public void run() {
		int key=0;
		while((key=menu())!=0) {
			switch(key) {
			case 1:
				Login();
				break;
			case 2:
				MemberJoin();
				break;
			case 3:
				selectMember();
			}
		}
	}
	
	private void SelectMember() {
		Iterator<Member> iter=list.Iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next()+" ");
		}
	}
	
	private void MemberJoin() {
		sc.nextLine();
		
		if(idCheck(id)) {
			System.out.println("중복된 id입니다.");
		}else if(pw.equals(pw2)) {
			list.add(new Member(id,pw,name) );
			System.out.println(id+"님 가입을 축하드립니다.");
		}else {
			System.out.println("");
		}
	}
	private boolean idCheck(String id) {
		boolean check=true;
		Member mem=FirdById(id);
		if(mem==null) {
			check=false;
		}
	}
	
	private void Login() {
		sc.nextLine();
		Member mem=FindById(id);
		if(member==null) {
			System.out.println("등록되지 않은 id입니다.");
		}else if(mem.getPw().equals(pw)) {
			System.out.println(mem.getId()+"님이 로그인하였습니다.");
		}else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	private Member FindById(String id) {
		for(Member m:mem) {
			if(mem.getId().equals(id)) {
				return mem;
			}
			return null;
			//return null;
		}
	}
	
}
