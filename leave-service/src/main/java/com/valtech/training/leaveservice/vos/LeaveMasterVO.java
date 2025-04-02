package com.valtech.training.leaveservice.vos;

import com.valtech.training.leaveservice.entities.LeaveMaster;

public record LeaveMasterVO(long id, int casualleaves, int sickleaves, int otherleaves,long employeeId) {


	public static LeaveMasterVO from(LeaveMaster lm) {
		return new LeaveMasterVO(lm.getId(), lm.getCasualleaves(), lm.getSickleaves(), lm.getOtherleaves(),lm.getEmployeeId());
	}
	
	public LeaveMaster to() {
		return new LeaveMaster(id, casualleaves, sickleaves, otherleaves,employeeId);
		
	}
}
