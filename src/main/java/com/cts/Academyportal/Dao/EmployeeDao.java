package com.cts.Academyportal.Dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.EmployeeReg;

@Repository
public interface EmployeeDao  extends CrudRepository<EmployeeReg, Long>{


	public EmployeeReg findById(long userId);

	public EmployeeReg findByContactNumber(String contactNumber);
	/*
	 * @Query("update employee_batches set nom_status=:nms where employee_reg_user_id=:eid and batches_batch_id=:bid"
	 * ) public void updateNaminationStatus(@Param("nms") String
	 * status,@Param("eid") long eid,@Param("bid") long bid);
	 */

}

	
	

