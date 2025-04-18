package com.valtech.training.leaveservice.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.valtech.training.leaveservice.comans.LeaveStatus;
import com.valtech.training.leaveservice.comans.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leav_seq")
	@SequenceGenerator(name = "leav_seq", sequenceName = "leav_seq", allocationSize = 1)
	private long id;
	private LocalDate formDate;
	private LocalDate toDate;
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	@Enumerated(EnumType.STRING)
	private LeaveStatus leaveStatus;
	private String reason;
	private String comments;
	private long employeeId;

	public Leave() {
	}

	public Leave(long id, LocalDate forDate, LocalDate toDate, LeaveType leaveType, LeaveStatus leaveStatus,
			String reason, String comments, long employeeId) {
		super();
		this.id = id;
		this.formDate = forDate;
		this.toDate = toDate;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.reason = reason;
		this.comments = comments;
		this.employeeId = employeeId;
	}

	public void checkLeaveApplicationAndUpdateStatus(LeaveMaster lm) {
		if (leaveType == leaveType.CASUAL) {
			if (lm.getCasualleaves() == 0) {
				rejectLeave("Casual Leave is Exashted");
			}
		} else {

			long diff = ChronoUnit.DAYS.between(formDate, toDate);
			if (diff > lm.getCasualleaves()) {
				comments = "Available leavesv is" + lm.getCasualleaves() + "Applied is" + diff + "...";
			} else {
				comments = "Good to go...";
			}
			// check if fromdate is before today and reject it.
		}
		
		
		if (leaveType == leaveType.SICK) {
			if (lm.getSickleaves() == 0) {
				rejectLeave("Casual Leave is Exashted");

			} else {

				long diff = ChronoUnit.DAYS.between(formDate, toDate);
				if (diff > lm.getCasualleaves()) {
					comments = "Available leaves is" + lm.getCasualleaves() + "Applied is" + diff + "...";
				} else {
					comments = "Good to go...";
				}

			}
		}
		
		if (leaveType == leaveType.OTHERS) {
			if (lm.getOtherleaves() == 0) {
				rejectLeave("Casual Leave is Exashted");

			} else {

				long diff = ChronoUnit.DAYS.between(formDate, toDate);
				if (diff > lm.getCasualleaves()) {
					comments = "Available leavesv is" + lm.getCasualleaves() + "Applied is" + diff + "...";
				} else {
					comments = "Good to go...";
				}

			}
		}
		
		
		
	}
	
	public long leavesInDays() {
		return ChronoUnit.DAYS.between(formDate, toDate);
	}

	public void rejectLeave(String comment) {
		leaveStatus = LeaveStatus.REJECTED;// reject
		comments = comment;

	}
	
	public void updateLeave(String comment) {
		comment += comment;
	}
	
	public void approveLeave(LeaveMaster byEmployeeId, long manager) {
		if(comments == null) comments = "";
		comments = "Your leave is approved";
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFormDate() {
		return formDate;
	}

	public void setFormDate(LocalDate forDate) {
		this.formDate = forDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	

}
