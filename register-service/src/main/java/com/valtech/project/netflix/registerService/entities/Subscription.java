package com.valtech.project.netflix.registerService.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subscription {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sub-seq")
	@SequenceGenerator(name = "sub-seq",sequenceName = "sub-seq",allocationSize = 1)
	private long id;
	private int amount;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Subscription() {}
	
	

	public Subscription(int amount, LocalDate startDate, LocalDate endDate) {
		super();
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	

}
