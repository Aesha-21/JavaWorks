package com.valtech.project.services;

import java.util.List;

import com.valtech.project.vos.LoanVO;

public interface LoanService {

	LoanVO saveLoan(LoanVO lvo);

	LoanVO getLoan(int id);

	List<LoanVO> getAllLoans();
	
	LoanVO applyForLoan(LoanVO lvo);

}