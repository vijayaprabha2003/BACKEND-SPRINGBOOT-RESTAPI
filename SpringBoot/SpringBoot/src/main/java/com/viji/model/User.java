package com.viji.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	@Id
	private String username;
	private String yourname;
	private String mailId;
	private String password;
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getYourname() {
		return yourname;
	}
	public void setYourName(String yourname) {
		this.yourname = yourname;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserModel [userName=" + username + ", yourName=" + yourname + ", mailId=" + mailId + ", password=" + password
				+ "]";
	}
}
