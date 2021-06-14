package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.projectGo.model.vo.Member;
import com.projectGo.view.MainFrame;

public class MemberDao {

	private ArrayList<Member> list;

	public MemberDao() {

	}

	// 추가 (회원가입)
//	public void addMem(Member m) {
//		fileOutput();
//	}

	// 삭제 (회원탈퇴)
	public void deleteMem(Member m) {
		list = fileInput();
		for (int i = 0 ; i < list.size() ; i++) {

			if (list.get(i).getNick().equals(m.getNick())) {

				list.remove(i);
			}

		}
		fileOutput(list);
	}

	// 수정 (회원정보 수정)
	public void updateMem(Member m) {
		list = fileInput();
		for (int i = 0 ; i < list.size() ; i++) {

			if (list.get(i).getNick().equals(MainFrame.loginUserId)) {

				list.set(i, m);
			}

		}
		fileOutput(list);
		
	}

	// 조회 (회원정보 조회)
	public Member getMem(int idx) {
		fileInput();
		return list.get(idx);
	}

	// 조회 (회원 리스트 조회)
	public ArrayList<Member> getMemList() {
		return list;
	}

	public ArrayList<Member> fileInput() {

		list = new ArrayList<>();

		System.out.println("------------------------input");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("member.txt"))) {
			while (true) {

				list.add((Member) ois.readObject());
			}
		} catch (EOFException e) {
			System.out.println(list);
			return list;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void fileOutput(ArrayList<Member> mls) {

		fileInput();
		list = mls;

		System.out.println("------------------------output");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.txt"))) {
			int size = list.size(), i;
			System.out.println("회원수 : " + size);
			for (i = 0; i < size; i++)
				oos.writeObject(list.get(i));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
