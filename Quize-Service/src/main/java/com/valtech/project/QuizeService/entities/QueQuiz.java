package com.valtech.project.QuizeService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

//@Entity
public class QueQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "queQuize-seq")
	@SequenceGenerator(name = "queQuize-seq", sequenceName = "queQuize-seq", allocationSize = 1)
	private long id;
	private long questionId;
	private long quizeId;

	public QueQuiz() {
	}

	public QueQuiz(long questionId, long quizeId) {
		super();
		this.questionId = questionId;
		this.quizeId = quizeId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getQuizeId() {
		return quizeId;
	}

	public void setQuizeId(long quizeId) {
		this.quizeId = quizeId;
	}

}
