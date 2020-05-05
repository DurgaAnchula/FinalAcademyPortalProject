package com.cts.Academyportal.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="help")
public class Help {

	@Id
	@SequenceGenerator(name="helpseq", initialValue=201,sequenceName="HELP_SEQUENCE", allocationSize=1)
	@GeneratedValue(generator="helpseq", strategy=GenerationType.SEQUENCE)
   @Column
   private	int requestId;
   @Column
   private Date  dateOfticket;
   @Column
   private String issue;
   @Column 
   private String description;
   @Column
   private String contactNumber;
   @ManyToOne
   private EmployeeReg employee;
   @Column
   private String resolution;
public int getRequestId() {
	return requestId;
}
public void setRequestId(int requestId) {
	this.requestId = requestId;
}
public Date getDateOfticket() {
	return dateOfticket;
}
public void setDateOfticket(Date dateOfticket) {
	this.dateOfticket = dateOfticket;
}
public String getIssue() {
	return issue;
}
public void setIssue(String issue) {
	this.issue = issue;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public EmployeeReg getEmployee() {
	return employee;
}
public void setEmployee(EmployeeReg employee) {
	this.employee = employee;
}
public String getResolution() {
	return resolution;
}
public void setResolution(String resolution) {
	this.resolution = resolution;
}
@Override
public String toString() {
	return "Help [requestId=" + requestId + ", dateOfticket=" + dateOfticket + ", issue=" + issue + ", description="
			+ description + ", contactNumber=" + contactNumber + ", employee=" + employee + ", resolution=" + resolution
			+ "]";
}

   
}
