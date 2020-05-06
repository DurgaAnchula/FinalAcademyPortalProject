package com.cts.Academyportal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="brnominations")
public class BatchNominationRequest {
	@SequenceGenerator(name="nomSeq",initialValue = 7001,allocationSize = 1,sequenceName = "NOM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private int nominationid;
	@Column
	private int batchid;
	@Column
	private long empid;
	@Column
	private String status;
	public int getNominationid() {
		return nominationid;
	}
	public void setNominationid(int nominationid) {
		this.nominationid = nominationid;
	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
