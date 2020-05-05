package com.cts.Academyportal.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.Faculty;


public interface FacultyDao  extends CrudRepository<Faculty, Long> {
	public Faculty findById(long userId);
	public Faculty findByContactNumber(String contactNumber);
	public List<Faculty> findByfirstName(String firstname);
	public List<Faculty> findBylastName(String lasttname);


}
