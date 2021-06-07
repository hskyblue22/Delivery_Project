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

public class DaoTemp {

	private ArrayList<Member> memberList = new ArrayList<Member>();
	Member member;
	String userName;

	public Member memberLoad(String userName) {
		this.userName = userName;
		member = new Member();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("member.txt"))) {
			while (true) {  
				memberList.add((Member) ois.readObject());

			}

		} catch (EOFException e) {
			System.out.println("읽기 완료.");
			// TODO: handle exception
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < memberList.size(); i++) {

			if (memberList.get(i).getNick().equals(userName)) {

				member = memberList.get(i);

			}

		}

		return member;

	}

	public void memberSave(ArrayList<String> preSerchList, ArrayList<String> preSerchNum) {

		for (int i = 0; i < memberList.size(); i++) {

			if (memberList.get(i).getNick().equals(userName)) {

				memberList.get(i).setPreSerchList(preSerchList);;
				memberList.get(i).setPreSerchNum(preSerchNum);

			}

		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.txt"))) {

			for (int i = 0; i < memberList.size(); i++) {

				oos.writeObject(memberList.get(i));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
