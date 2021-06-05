package com.projectGo.model.dao;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.model.dao.Iterator;
import com.kh.project.model.dao.Member;

public class MemDao implements MemMgr {
	
	//회원 정보를 저장하는 리스트
	//로그인할때 필요
	ArrayList<Member> list=new ArrayList<>();
	
	public MemDao() {
		
		load("Mem.dat");
	}
	
	
	
	
	
	
	
	//filename에서 객체를 읽어들이는 메소드
	
}
