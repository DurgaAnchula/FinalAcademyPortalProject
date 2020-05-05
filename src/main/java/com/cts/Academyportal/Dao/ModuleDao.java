package com.cts.Academyportal.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.Academyportal.models.ModuleReg;

@Repository
public interface ModuleDao  extends CrudRepository<ModuleReg,Integer>{
	
	public List<ModuleReg> findByProficiencylevel(String proficiencylevel);
	
	
}
