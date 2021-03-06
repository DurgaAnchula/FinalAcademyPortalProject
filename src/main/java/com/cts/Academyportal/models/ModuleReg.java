package com.cts.Academyportal.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="modules")
public class ModuleReg {

	@Id
	@SequenceGenerator(name="moduleSequence",initialValue = 4001, allocationSize = 1,sequenceName = "MODULE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "moduleSequence")
	private int mid;
	
	@Column
	public String technology;
	@Column
	public String proficiencylevel;
	@Column
	public String executiontype;
	@Column
	public String certificationtype;
	@Column
	public String certificationname;
	
	
	
	
	
	
	
	
	
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	
	public String getProficiencylevel() {
		return proficiencylevel;
	}
	public void setProficiencylevel(String proficiencylevel) {
		this.proficiencylevel = proficiencylevel;
	}
	
	
	public String getExecutiontype() {
		return executiontype;
	}
	public void setExecutiontype(String executiontype) {
		this.executiontype = executiontype;
	}
	public String getCertificationtype() {
		return certificationtype;
	}
	public void setCertificationtype(String certificationtype) {
		this.certificationtype = certificationtype;
	}
	public String getCertificationname() {
		return certificationname;
	}
	public void setCertificationname(String certificationname) {
		this.certificationname = certificationname;
	}
	@Override
	public String toString() {
		return "ModuleReg [Technology=" + technology + ", Proficiencylevel=" + proficiencylevel + ", Executiontype="
				+ executiontype + ", certificationtype=" + certificationtype + ", certificationname="
				+ certificationname + "]";
	}
	



}
