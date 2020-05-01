package com.cts.Academyportal.models;

public class FacultyLogin {

	private long UserId;
	private String password;
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "FacultyLogin [UserId=" + UserId + ", password=" + password + "]";
	}

}
