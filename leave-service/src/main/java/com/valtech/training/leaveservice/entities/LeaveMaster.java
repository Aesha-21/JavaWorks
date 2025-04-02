package com.valtech.training.leaveservice.entities;

import com.valtech.training.leaveservice.comans.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LeaveMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_seq")
	@SequenceGenerator(name = "leave_seq", sequenceName = "leave_seq", allocationSize = 1)
	private long id;
	private int casualleaves;
	private int sickleaves;
	private int otherleaves;
	private long employeeId;

	public LeaveMaster() {}

	public LeaveMaster(long id, int casualleaves, int sickleaves, int otherleaves,long employeeId) {
		super();
		this.id = id;
		this.casualleaves = casualleaves;
		this.sickleaves = sickleaves;
		this.otherleaves = otherleaves;
		this.employeeId = employeeId;
	}
	
	public void takeLeaves(Leave leave) {
		if(leave.getLeaveType() == LeaveType.CASUAL) {
			casualleaves -= leave.leavesInDays();
			return;
		}
		if(leave.getLeaveType() == LeaveType.SICK) {
			casualleaves -= leave.leavesInDays();
			return;
		}
	}

	
	public long getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCasualleaves() {
		return casualleaves;
	}

	public void setCasualleaves(int casualleaves) {
		this.casualleaves = casualleaves;
	}

	public int getSickleaves() {
		return sickleaves;
	}

	public void setSickleaves(int sickleaves) {
		this.sickleaves = sickleaves;
	}

	public int getOtherleaves() {
		return otherleaves;
	}

	public void setOtherleaves(int otherleaves) {
		this.otherleaves = otherleaves;
	}

	
}
