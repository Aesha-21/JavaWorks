package com.valtech.project.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.project.entities.Loan;
import com.valtech.project.entities.Loan.LoanType;
import com.valtech.project.entities.Loan.Status;



public record LoanVO (int id,String userName, int aadhar, int cibilScore, String loanType, String asset, int assetValue,
		int value, int income,String status ){

	public static LoanVO from(Loan loan) {
		return new LoanVO(loan.getId(),loan.getUserName(), loan.getAadhar(), loan.getCibilScore(), loan.getLoanType().name(), loan.getAsset(), loan.getAssetValue(), loan.getValue(),loan.getIncome(),loan.getStatus().name() );
	}
	public static List<LoanVO> from(List<Loan> loans){
		return loans.stream().map(loan -> LoanVO.from(loan)).collect(Collectors.toList());
	}
	public Loan to() {
		return new Loan(userName,aadhar,cibilScore,LoanType.valueOf(loanType),asset,assetValue,value,income,Status.valueOf(status));
	}
}
