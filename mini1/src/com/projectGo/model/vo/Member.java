package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable { // 회원 정보

   private static final long serialVersionUID = 1L;

   private int idx, type, point;                  // 인덱스, 타입 (판매자=1/구매자=2), 포인트 (구매자)
   private String nick, email, pwd, phone, address;   // 닉네임(=아이디), 이메일, 비밀번호, 폰번호, 주소
   private ArrayList<String> preSerchList, preSerchNum;

   public Member() {}

   public Member(int idx, String nick, String email, String pwd, String phone, String address, int type) {
      this.idx = idx; 
      this.nick = nick;
      this.email = email;
      this.pwd = pwd;
      this.phone = phone;
      this.address = address;
      this.type = type;
      point = 0;
      preSerchNum = new ArrayList<>();
      preSerchList = new ArrayList<>();
   }
   
   public Member(int idx, String nick, String email, String pwd, String phone, String address, int type, int point, ArrayList<String> preSerchList, ArrayList<String> preSerchNum) {
      this.idx = idx;
      this.nick = nick;
      this.email = email;
      this.pwd = pwd;
      this.phone = phone;
      this.address = address;
      this.type = type;
      this.point = point;
      this.preSerchNum = preSerchNum;
      this.preSerchList = preSerchList;
   }

   public int getIdx() { return idx; }
   public void setIdx(int idx) { this.idx = idx; }

   public String getNick() { return nick; }
   public void setNick(String nick) { this.nick = nick; }

   public String getEmail() { return email; }
   public void setEmail(String email) { this.email = email; }

   public String getPwd() { return pwd; }
   public void setPwd(String pwd) { this.pwd = pwd; }

   public String getPhone() { return phone; }
   public void setPhone(String phone) { this.phone = phone; }

   public String getAddress() { return address; }
   public void setAddress(String address) { this.address = address; }

   public int getPoint() { return point; }
   public void SetPoint(int point) { this.point = point; }

   public int getType() { return type; }
   public void setType(int type) { this.type = type; }

   public ArrayList<String> getPreSerchNum() { return preSerchNum; }
   public void setPreSerchNum(ArrayList<String> preSerchNum) { this.preSerchNum = preSerchNum; }

   public ArrayList<String> getPreSerchList() { return preSerchList; }
   public void setPreSerchList(ArrayList<String> preSerchList) { this.preSerchList = preSerchList; }

   @Override
   public String toString() {
      return "Member [idx=" + idx + ", point=" + point + ", type=" + type + ", nick=" + nick + ", pwd=" + pwd
            + ", phone=" + phone + ", address=" + address + ", email=" + email + ", preSerchNum=" + preSerchNum
            + ", preSerchList=" + preSerchList + "]";
   }
}