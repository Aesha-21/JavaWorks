package com.valtech.project.netflix.streamingservice.entities;
import com.valtech.project.netflix.streamingservice.entities.Content;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Content{

	private long dureation;
	
	public Movie() {}

	

	public Movie(String name, String genre, String language, long costPerView, long dureation) {
		super(name, genre, language, costPerView);
		this.dureation = dureation;
	}



	public long getDureation() {
		return dureation;
	}

	public void setDureation(long dureation) {
		this.dureation = dureation;
	}
	
	
}
