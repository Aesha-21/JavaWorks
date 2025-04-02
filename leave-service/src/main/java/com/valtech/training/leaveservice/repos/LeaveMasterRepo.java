package com.valtech.training.leaveservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.leaveservice.entities.LeaveMaster;

@Repository
public interface LeaveMasterRepo extends JpaRepository<LeaveMaster, Long>{

	LeaveMaster findByEmployeeId(long employeeId);

}
