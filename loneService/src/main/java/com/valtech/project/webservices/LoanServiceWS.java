package com.valtech.project.webservices;

import java.util.List;

import javax.jws.WebService;
import com.valtech.project.entities.Loan;
import com.valtech.project.vos.LoanVO;

@WebService
public interface LoanServiceWS {

	Loan createLoan(Loan loan);

	Loan getLoan(int id);

	List<Loan> getAllLoans();
	
	Loan applyForLoan(Loan loan);

}