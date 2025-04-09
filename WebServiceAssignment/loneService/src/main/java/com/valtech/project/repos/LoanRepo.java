package com.valtech.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
