package com.cts.Academyportal.models;

public class AdminLogin {
	private long userId;
	private String password;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLogin [userId=" + userId + ", password=" + password + "]";
	}
	
}
