package com.cts.Academyportal.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.Academyportal.models.BatchNominationRequest;

public interface BatchRequestDao extends JpaRepository<BatchNominationRequest, Integer> {

}
