package com.cts.Academyportal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class SkillsReg {

	@Column
	private String skillfamily;
	@Column
	private String proficiencylevel;
	@Id
	@Column
	private int skillId;
	@Column
	private String skillname;
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
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	@Override
	public String toString() {
		return "SkillsReg [skillfamily=" + skillfamily + ", proficiencylevel=" + proficiencylevel + ", skillId="
				+ skillId + ", skillname=" + skillname + "]";
	}
	





}
