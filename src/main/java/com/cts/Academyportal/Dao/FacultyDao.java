package com.cts.Academyportal.Dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.Academyportal.models.Faculty;


public interface FacultyDao  extends CrudRepository<Faculty, Long> {
	public Faculty findById(long userId);

}
