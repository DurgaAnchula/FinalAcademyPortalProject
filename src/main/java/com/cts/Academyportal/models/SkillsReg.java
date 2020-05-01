package com.cts.Academyportal.models;

import java.util.List;

import javax.annotation.Generated;
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
import javax.servlet.SessionTrackingMode;

@Entity
@Table(name="skills")
public class SkillsReg {

	
	@Id
	@SequenceGenerator(name="skillSequence",initialValue =501,allocationSize = 1,sequenceName = "SKILL_SEQUENCE" )
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "skillSequence")
	private int skillid;
	
	@Column
	private String skillfamily;
	
	@Column
	private String skillname;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "MODULE_SKILL", joinColumns = {
			    @JoinColumn(name = "skillid", referencedColumnName = "skillid") },
		       inverseJoinColumns = {
			     @JoinColumn(name = "mid", referencedColumnName = "mid") })

	private List<ModuleReg> modules;
	
	
	
	public List<ModuleReg> getModules() {
		return modules;
	}
	public void setModules(List<ModuleReg> modules) {
		this.modules = modules;
	}
	public String getSkillfamily() {
		return skillfamily;
	}
	public void setSkillfamily(String skillfamily) {
		this.skillfamily = skillfamily;
	}
	
	public int getSkillid() {
		return skillid;
	}
	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	@Override
	public String toString() {
		return "SkillsReg [skillfamily=" + skillfamily + ", proficiencylevel=" + ", skillid="
				+ skillid + ", skillname=" + skillname + "]";
	}
	





}
