package com.valtech.project.netflix.registerService.vos;

import java.time.LocalDate;

import com.valtech.project.netflix.registerService.entities.Subscription;

public record SubscriptionVO(long id, 
		int amount ,LocalDate startDate,LocalDate endDate) {

	public static SubscriptionVO from(Subscription sub) {
		return new SubscriptionVO(sub.getId(), sub.getAmount(), 
				sub.getStartDate(), sub.getEndDate());
	}
	
	public Subscription to() {
		
	}
}
