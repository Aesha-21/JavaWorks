package com.valtech.training.leaveservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.leaveservice.comans.LeaveStatus;
import com.valtech.training.leaveservice.comans.LeaveType;
import com.valtech.training.leaveservice.entities.Leave;

public record LeaveVO(long id,String fromDate,String toDate,
		String leaveType,String leaveStatus,String reason,
		String comments,long employeeId) {
	
	
	public static List<LeaveVO> to(List<Leave> leaves){
	
		return leaves.stream().map(l -> from(l)).collect(Collectors.toList());
	}
	
	public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public void updateTo(Leave leave) {
		LocalDate fromDateAsDate = LocalDate.parse(fromDate,FORMATTER);
		LocalDate toDateAsDate = LocalDate.parse(toDate,FORMATTER);
		LeaveType ltype = LeaveType.valueOf(leaveStatus);
		LeaveStatus lstatus = LeaveStatus.valueOf(leaveStatus);
		leave.setFormDate(fromDateAsDate);
		leave.setToDate(toDateAsDate);
		leave.setLeaveType(ltype);
		leave.setLeaveStatus(lstatus);
		leave.setReason(reason);
		leave.setComments(comments);
		
	}
	
	public Leave to() {
		LocalDate fromDateAsDate = LocalDate.parse(fromDate,FORMATTER);
		LocalDate toDateAsDate = LocalDate.parse(toDate,FORMATTER);
		LeaveType ltype = LeaveType.valueOf(leaveType);
		LeaveStatus lstatus = LeaveStatus.valueOf(leaveStatus);
		return new Leave(id, fromDateAsDate, toDateAsDate, ltype, lstatus, reason, comments, employeeId);
	}
	
	public static LeaveVO from(Leave leave) {
		String from = leave.getFormDate().format(FORMATTER);
		String to = leave.getToDate().format(FORMATTER);
		String ltype = leave.getLeaveType().name();
		String lstatus = leave.getLeaveStatus().name();
		
		return new LeaveVO(leave.getId(),from,to,ltype,lstatus,leave.getReason(),leave.getComments(),leave.getEmployeeId());
	}

}
