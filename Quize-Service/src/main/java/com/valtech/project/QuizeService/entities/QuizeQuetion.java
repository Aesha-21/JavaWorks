package com.valtech.project.QuizeService.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuizeQuetion {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quizeans-seq")
	@SequenceGenerator(name = "quizeans-seq",sequenceName = "quizeans-seq")
	private long id;
	private int quesId;
	private List<Integer> questionIds;
	
	
	public QuizeQuetion() {
	
	}


	public QuizeQuetion(long id, int quesId, List<Integer> questionIds) {
		super();
		this.id = id;
		this.quesId = quesId;
		this.questionIds = questionIds;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getQuesId() {
		return quesId;
	}


	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}


	public List<Integer> getQuestionIds() {
		return questionIds;
	}


	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}
	
}
