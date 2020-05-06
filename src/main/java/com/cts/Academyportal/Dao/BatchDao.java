package com.cts.Academyportal.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.Batch;
import com.cts.Academyportal.models.Faculty;

public interface BatchDao extends CrudRepository<Batch,Integer>{

	public List<Batch> findByFacultyId(long facultyId);
	public Batch findById(int batchId);
	//public List<Batch> findByEmployeeId(long employeeId);

	public List<Batch> findByBatchStartDate(Date  batchStartDate);
	public List<Batch> findByBatchEndDate(Date  batchEndDate);


}
