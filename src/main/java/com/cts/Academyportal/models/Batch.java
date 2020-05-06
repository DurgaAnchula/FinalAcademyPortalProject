package com.cts.Academyportal.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {

	
	/*batchID
    2. Skill ID
    3. Module ID
    4. Technology
    5. Faculty ID
    6. Batch Start Date
    7. Batch End Date
    8. Batch Capacity
    9. Classroom Name*/
	@Id
	@Column
	@SequenceGenerator(name="mysequence5",initialValue=1,allocationSize=1,sequenceName="El_BATCH_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysequence5")
	private int batchId;
	@Column
	private int skillId;
	@Column
	private int moduleId;
	@Column
	private String technology;
	@Column
	private Long facultyId;
	@Column
	private Date batchStartDate;
	@Column
	private Date batchEndDate;
	@Column
	private int batchCapacity;
	@Column
	private String classroom;
	@Column
	private String status;
	@Column
	private int currentBatchCapacity;
	

	
	
	public int getCurrentBatchCapacity() {
		return currentBatchCapacity;
	}
	public void setCurrentBatchCapacity(int currentBatchCapacity) {
		this.currentBatchCapacity = currentBatchCapacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public Long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	public Date getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(Date batchStartDate) {
		
		
		
		this.batchStartDate =batchStartDate ;
	}
	public Date getBatchEndDate() {
		return batchEndDate;
	}
	public void setBatchEndDate(Date batchEndDate) {
		
		this.batchEndDate = batchEndDate;

	}
	public int getBatchCapacity() {
		return batchCapacity;
	}
	public void setBatchCapacity(int batchCapacity) {
		this.batchCapacity = batchCapacity;
	}
	
	
	
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", skillId=" + skillId + ", moduleId=" + moduleId + ", technology="
				+ technology + ", facultyId=" + facultyId + ", batchStartDate=" + batchStartDate + ", batchEndDate="
				+ batchEndDate + ", batchCapacity=" + batchCapacity + ", classroomName=" + classroom + ", status="
				+ status + "]";
	}
	
}