package com.cts.Academyportal.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.Academyportal.models.SkillsReg;

@Repository
	public interface SkillDao  extends CrudRepository<SkillsReg,Integer>{
	
	public SkillsReg findBySkillname(String skillname);
	@Query("select skillname from SkillsReg s where s.skillfamily=:sf")
	public List<String> getSkillNamesBySkillFamily(@Param("sf") String skillfamily);
	
	public List<SkillsReg> findBySkillfamily(String skillname);
	@Query("from SkillsReg s where s.skillname=:sn")
	public List<SkillsReg> getAllskillsByName(@Param("sn")String name);
	
	//public SkillsReg findByModule_Skill(String skillname);

}
