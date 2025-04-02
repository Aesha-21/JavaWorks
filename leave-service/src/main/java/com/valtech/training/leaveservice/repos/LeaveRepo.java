package com.valtech.training.leaveservice.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.leaveservice.entities.Leave;

public interface LeaveRepo extends JpaRepository<Leave,Long>{

	List<Leave> findAllByEmployeeId(long emp);

}
