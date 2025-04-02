package com.valtech.project.QuizeService.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuizeAnswer {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quizeans-seq")
	@SequenceGenerator(name = "quizeans-seq",sequenceName = "quizeans-seq")
	private long id;
	
	public QuizeAnswer() {
		super();
	}

	public QuizeAnswer(long id, List<String> answers) {
		super();
		this.id = id;
		this.answers = answers;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	private List<String> answers;
}
