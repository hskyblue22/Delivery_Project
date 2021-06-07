package com.projectGo.model.vo;

public class Member { //회원 정보
	private int idx;
	private String nick, pwd, birth, phone, address, email;

	public Member() {	
	}
	
	public Member(int idx, String nick, String email, String pwd, String birth, String phone, String address) {
		this.idx = idx;
		this.nick = nick;
		this.email = email;
		this.pwd = pwd;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getIdx() {
		return idx;
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
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", nick=" + nick + ", pwd=" + pwd + ", birth=" + birth + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + "]";
	}
	
	
		
}
