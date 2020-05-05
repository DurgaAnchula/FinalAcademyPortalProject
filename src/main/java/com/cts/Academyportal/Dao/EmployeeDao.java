package com.cts.Academyportal.Dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.EmployeeReg;

@Repository
public interface EmployeeDao  extends CrudRepository<EmployeeReg, Long>{


	public EmployeeReg findById(long userId);

	public EmployeeReg findByContactNumber(String contactNumber);



}

	
	

