package com.projectGo.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.projectGo.model.vo.Basket;
import com.projectGo.model.vo.Member;

public class MemberDao {
	
	ArrayList<Member> list;
	private Member mem;
	
	public MemberDao() {
		
	}
	
	public void fileOutput(Member mem) {
	
		
		list.add(mem);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("member.txt"))) {
			
			
			
			for(int i = 0; i <list.size(); i++) {
				oos.writeObject(list.get(i));
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void fileInput() {
		
		list = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("member.txt"))) {
			
			while (true) {
				list.add((Member) ois.readObject());
			}

			
		}catch(EOFException e) {
			System.out.println("파일읽기 완료");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Member> getMemberList(){
		return list;
	}
	
}
