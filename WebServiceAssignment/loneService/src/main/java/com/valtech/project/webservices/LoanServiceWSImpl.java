package com.valtech.project.webservices;

import java.util.List;
import java.util.stream.Collectors;

import javax.jws.WebService;
import com.valtech.project.entities.Loan;
import com.valtech.project.services.LoanService;
import com.valtech.project.vos.LoanVO;

@WebService(endpointInterface = "com.valtech.project.webservices.LoanServiceWS"
,name = "LoanService",portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {

	private LoanService loanService;

	public LoanServiceWSImpl(LoanService loanService) {
		this.loanService = loanService;
	}
	@Override
	public Loan createLoan(Loan loan) {
		System.err.println(loan.toString());
		return loanService.saveLoan(LoanVO.from(loan)).to();
	}

	@Override
	public Loan getLoan(int id) {
		return loanService.getLoan(id).to();
	}

	@Override
	public List<Loan> getAllLoans() {
		return loanService.getAllLoans().stream().map(loan -> loan.to()).collect(Collectors.toList());
	}
	@Override
	public Loan applyForLoan(Loan loan) {
		
		return loanService.applyForLoan(LoanVO.from(loan)).to();
	}
	
	
}
