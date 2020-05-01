package com.cts.Academyportal.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


	@Entity
	@Table(name="faculty")
	public class Faculty {
		@Id
		@Column
		@SequenceGenerator(name="mysequence2",initialValue=404040,allocationSize=1,sequenceName="El_FACULTY_SEQUENCE")
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysequence2")
		private long userId;
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
		private String skillfamily;
		@Column
		private String proficiencylevel;
		@Column
		private int skillid;
		@ElementCollection
		private List<String> skillname;
		@Column
		private int teachingtime;
		@Column
		private String secretquestion1;
		@Column
		private String answer1;
		@Column
		private String secretquestion2;
		@Column
		private String answer2;
		@Column
		private String secretquestion3;
		@Column
		private String answer3;

		@Column
		private String status;
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public long getUserId() {
			return userId;
		}
		public void setUserId(long userId) {
			this.userId = userId;
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
		public List<String> getSkillname() {
			return skillname;
		}
		public void setSkillname(List<String> skillname) {
			this.skillname = skillname;
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
		public String getSkillfamily() {
			return skillfamily;
		}
		public void setSkillfamily(String skillfamily) {
			this.skillfamily = skillfamily;
		}
		public String getProficiencylevel() {
			return proficiencylevel;
		}
		public void setProficiencylevel(String proficiencylevel) {
			this.proficiencylevel = proficiencylevel;
		}
		
		public String getSecretquestion1() {
			return secretquestion1;
		}
		public void setSecretquestion1(String secretquestion1) {
			this.secretquestion1 = secretquestion1;
		}
		public String getAnswer1() {
			return answer1;
		}
		public void setAnswer1(String answer1) {
			this.answer1 = answer1;
		}
		public String getSecretquestion2() {
			return secretquestion2;
		}
		public void setSecretquestion2(String secretquestion2) {
			this.secretquestion2 = secretquestion2;
		}
		public String getAnswer2() {
			return answer2;
		}
		public void setAnswer2(String answer2) {
			this.answer2 = answer2;
		}
		public String getSecretquestion3() {
			return secretquestion3;
		}
		public void setSecretquestion3(String secretquestion3) {
			this.secretquestion3 = secretquestion3;
		}
		public String getAnswer3() {
			return answer3;
		}
		public void setAnswer3(String answer3) {
			this.answer3 = answer3;
		}
		public int getSkillid() {
			return skillid;
		}
		public void setSkillid(int skillid) {
			this.skillid = skillid;
		}
		public int getTeachingtime() {
			return teachingtime;
		}
		public void setTeachingtime(int teachingtime) {
			this.teachingtime = teachingtime;
		}
		@Override
		public String toString() {
			return "Faculty [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", DOB=" + DOB
					+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", Email=" + Email + ", password="
					+ password + ", skillfamily=" + skillfamily + ", proficiencylevel=" + proficiencylevel
					+ ", skillid=" + skillid + ", skillname=" + skillname + ", teachingtime=" + teachingtime
					+ ", secretquestion1=" + secretquestion1 + ", answer1=" + answer1 + ", secretquestion2="
					+ secretquestion2 + ", answer2=" + answer2 + ", secretquestion3=" + secretquestion3 + ", answer3="
					+ answer3 + ", status=" + status + "]";
		}
		
}