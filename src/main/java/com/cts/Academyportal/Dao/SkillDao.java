package com.cts.Academyportal.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.Academyportal.models.SkillsReg;

@Repository
	public interface SkillDao  extends CrudRepository<SkillsReg,Integer>{
	
	public SkillsReg findBySkillname(String skillname);

}
