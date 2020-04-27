package com.cts.Academyportal.models;

public class EmployeeLogin {
	private long UserId;
	private String password;
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long UserId) {
		this.UserId = UserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeLogin [UserId=" + UserId + ", Password=" + password + "]";
	}
}
