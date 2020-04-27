package com.cts.Academyportal.models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeReg {

	@Id
	@Column
	@SequenceGenerator(name="mysequence1",initialValue=303030,allocationSize=1,sequenceName="El_EMPLOYEE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysequence1")
	private long UserId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String DOB;
	@Column
	private String gender; 
	@Column
	private String contactNumber; 
	@Column
	private String Email;
	@Column
	private String password;
	@Column
	private String secretQuestion;
	@Column
	private String answer;
	@Column
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getUserId() {
		return UserId;
	}
	public long setUserId(long UserId) {
		return UserId = UserId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "EmployeeReg [UserId=" + UserId + ", firstName=" + firstName + ", lastName=" + lastName + ", DOB=" + DOB
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", Email=" + Email
				+ ", password=" + password + ", secretQuestion=" + secretQuestion + ", answer=" + answer + ", status="
				+ status + "]";
	}
	
		

}
