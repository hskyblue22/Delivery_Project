package com.projectGo.model.vo;

public class Member {//회원 정보
	private String nick;
	private String email;
	private String pwd;
	private String registration;
	private String phone;
	
	public Member() {
		
	}

	public Member(String nick, String email, String pwd, String registration, String phone) {
		super();
		this.nick = nick;
		this.email = email;
		this.pwd = pwd;
		this.registration = registration;
		this.phone = phone;
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

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
