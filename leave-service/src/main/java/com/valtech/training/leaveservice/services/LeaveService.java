package com.valtech.training.leaveservice.services;

import java.util.List;

import com.valtech.training.leaveservice.vos.ApproveLeaveVO;
import com.valtech.training.leaveservice.vos.EmployeeVO;
import com.valtech.training.leaveservice.vos.LeaveMasterVO;
import com.valtech.training.leaveservice.vos.LeaveVO;

public interface LeaveService {

	LeaveVO update(long id, LeaveVO vo);

	LeaveMasterVO getLeaveMaster(long employeeId);

	LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo);

	List<LeaveMasterVO> getAllLeaveMaster();

	List<LeaveVO> getAllLeaves();

	LeaveVO getLeave(long id);

	LeaveVO saveOrUpdateLeave(LeaveVO vo);

	LeaveVO applyLeave(LeaveVO vo);

	LeaveVO approveLeave(ApproveLeaveVO vo);

	List<LeaveVO> getLeavesByEmployee(long emp);

	EmployeeVO getmanager(long employeeId);





}