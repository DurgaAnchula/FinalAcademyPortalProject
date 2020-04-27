package com.cts.Academyportal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modules")
public class ModuleReg {

	@Id
	@Column
	public String Technology;
	@Column
	public String Proficiencylevel;
	@Column
	public String Executiontype;
	@Column
	public String certificationtype;
	@Column
	public String certificationname;
	public String getTechnology() {
		return Technology;
	}
	public void setTechnology(String technology) {
		Technology = technology;
	}
	public String getProficiencylevel() {
		return Proficiencylevel;
	}
	public void setProficiencylevel(String proficiencylevel) {
		Proficiencylevel = proficiencylevel;
	}
	public String getExecutiontype() {
		return Executiontype;
	}
	public void setExecutiontype(String executiontype) {
		Executiontype = executiontype;
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
		return "ModuleReg [Technology=" + Technology + ", Proficiencylevel=" + Proficiencylevel + ", Executiontype="
				+ Executiontype + ", certificationtype=" + certificationtype + ", certificationname="
				+ certificationname + "]";
	}
	



}
