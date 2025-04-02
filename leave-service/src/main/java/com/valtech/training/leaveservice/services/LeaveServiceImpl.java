package com.valtech.training.leaveservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.leaveservice.comans.LeaveStatus;
import com.valtech.training.leaveservice.comans.LeaveType;
import com.valtech.training.leaveservice.entities.Leave;
import com.valtech.training.leaveservice.entities.LeaveMaster;
import com.valtech.training.leaveservice.repos.LeaveMasterRepo;
import com.valtech.training.leaveservice.repos.LeaveRepo;
import com.valtech.training.leaveservice.vos.ApproveLeaveVO;
import com.valtech.training.leaveservice.vos.EmployeeVO;
import com.valtech.training.leaveservice.vos.LeaveMasterVO;
import com.valtech.training.leaveservice.vos.LeaveVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveMasterRepo leaveMasterRepo;
	@Autowired
	private LeaveRepo leaveRepo;

	@Autowired
	EmployeeClient employeeClient;

	@Override
	public List<LeaveVO> getLeavesByEmployee(long emp) {
//		List<Leave> leaves = leaveRepo.findAllByEmployeeId(emp);
		return LeaveVO.to(leaveRepo.findAllByEmployeeId(emp));
	}

	
	/*
	 * getting the leave by the leaveid
	 * from the leave i get the employeeid using the employeeclient get his ,manager
	 * check if manager is invalid
	 * - add the comment and send back the request
	 *  valid
	 *  - update the leave master 
	 *  - set the leave status approved
	 *  - update the leave and return
	 * 
	 * */
	
	@Override
	public LeaveVO approveLeave(ApproveLeaveVO vo) {
		Leave leave = leaveRepo.getReferenceById(vo.leveId());
		
		// here if we call employee so we call here employeemicroservice.
		
		long manager = employeeClient.getEmployeeAsManager(leave.getEmployeeId()).managerId();
		if (manager == vo.manager()) {
			LeaveMaster lm = leaveMasterRepo.findByEmployeeId(leave.getEmployeeId());
			lm.takeLeaves(leave);
			leaveMasterRepo.save(lm);
			leave.approveLeave(leaveMasterRepo.findByEmployeeId(leave.getEmployeeId()), manager);
		} else {
			leave.updateLeave("You are not the manager to approve the leavs...");
		}
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);

	}

	@Override
	public LeaveVO applyLeave(LeaveVO vo) {
		Leave leave = vo.to();
		leave.setLeaveStatus(LeaveStatus.APPLIED);
		leave.checkLeaveApplicationAndUpdateStatus(leaveMasterRepo.findByEmployeeId(vo.employeeId()));
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}

	@Override
	public LeaveVO saveOrUpdateLeave(LeaveVO vo) {
		Leave leave = vo.to();
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}

	@Override
	public LeaveVO getLeave(long id) {
		return LeaveVO.from(leaveRepo.getReferenceById(id));
	}

	@Override
	public List<LeaveVO> getAllLeaves() {
		return leaveRepo.findAll().stream().map(l -> LeaveVO.from(l)).collect(Collectors.toList());
	}

	@Override
	public List<LeaveMasterVO> getAllLeaveMaster() {
		return leaveMasterRepo.findAll().stream().map(lm -> LeaveMasterVO.from(lm)).collect(Collectors.toList());
	}

	@Override
	public LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo) {
		LeaveMaster lm = vo.to();
		lm = leaveMasterRepo.save(lm);
		return LeaveMasterVO.from(lm);
	}

	@Override
	public LeaveMasterVO getLeaveMaster(long employeeId) {
		LeaveMaster lm = leaveMasterRepo.findByEmployeeId(employeeId);
		return LeaveMasterVO.from(lm);

	}

	@Override
	public LeaveVO update(long id, LeaveVO vo) {
		Leave leave = leaveRepo.getReferenceById(id);
		vo.updateTo(leave);
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}


	@Override
	public EmployeeVO getmanager(long employeeId) {
		
		return employeeClient.getEmployeeAsManager(employeeId);
	}

}
