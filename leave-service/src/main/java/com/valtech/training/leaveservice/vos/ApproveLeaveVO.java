package com.valtech.training.leaveservice.vos;

/// here manager approve the leave with ;leaveid  put comments and send his id 

public record ApproveLeaveVO(long leveId,String comments,long manager) {

}
