package com.projectGo.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable { // 회원 정보

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private int idx, point, type;
   private String nick, pwd, phone, address, email;
   private ArrayList<String> preSerchNum;
   private ArrayList<String> preSerchList;

   public Member() {
   }

   public Member(int idx, String nick, String email, String pwd, String phone, String address, int point, int type) {
      this.idx = idx;
      this.nick = nick;
      this.email = email;
      this.pwd = pwd;
      this.phone = phone;
      this.address = address;
      this.point = point;
      this.type = type;
      preSerchNum = new ArrayList<>();
      preSerchList = new ArrayList<>();
   }

   public int getIdx() {
      return idx;
   }

   public void setIdx(int idx) {
      this.idx = idx;
   }

   public String getNick() {
      return nick;
   }

   public void setNick(String nick) {
      this.nick = nick;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPwd() {
      return pwd.toString();
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public int getPoint() {
      return point;
   }

   public int getType() {
      return type;
   }

   public void setType(int type) {
      this.type = type;
   }

   public ArrayList<String> getPreSerchNum() {
      return preSerchNum;
   }

   public void setPreSerchNum(ArrayList<String> preSerchNum) {
      this.preSerchNum = preSerchNum;
   }

   public ArrayList<String> getPreSerchList() {
      return preSerchList;
   }

   public void setPreSerchList(ArrayList<String> preSerchList) {
      this.preSerchList = preSerchList;
   }

   @Override
   public String toString() {
      return "Member [idx=" + idx + ", point=" + point + ", type=" + type + ", nick=" + nick + ", pwd=" + pwd
            + ", phone=" + phone + ", address=" + address + ", email=" + email + ", preSerchNum=" + preSerchNum
            + ", preSerchList=" + preSerchList + "]";
   }
}