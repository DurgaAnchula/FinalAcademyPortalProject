package com.cts.Academyportal.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.SkillsReg;

@Repository
	public interface AdminDao  extends CrudRepository<AdminReg,Long>{
	public AdminReg findByUserId(long userId);
	public AdminReg findByContactNumber(String contactNumber);
	
}
