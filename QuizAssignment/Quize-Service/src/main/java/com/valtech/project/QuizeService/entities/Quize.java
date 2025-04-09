package com.valtech.project.QuizeService.entities;

import java.util.ArrayList;
import java.util.List;

import com.valtech.project.QuizeService.vos.QuestionVO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class Quize {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quize-seq")
	@SequenceGenerator(name = "quize-seq",sequenceName = "quize-seq")
	private long id;
//	private int maxMarks;
	private int noOfQuestions;
//	private int score;
	private String topic;
	private Long queId;
	private List<String> answer;
	
	
	
	
	
	
//	@Transient
//	private List<QuestionVO> questionVO = new ArrayList<QuestionVO>();
//	
//	public List<QuestionVO> getQuestionVO() {
//		return questionVO;
//	}
//	
//	public void setQuestionVO(List<QuestionVO> questionVO) {
//		this.questionVO = questionVO;
//	}
	
	//insted of score take grade like A,B,C
	//and also add one enum for criterial BAD,GOOD and VERY GOOD 
	
	public Quize() {}
	
	public String getTopic() {
		return topic;
	}
	public Quize(long id, int noOfQuestions, String topic, Long queId, List<String> answes) {
	super();
	this.id = id;
	this.noOfQuestions = noOfQuestions;
	this.topic = topic;
	this.queId = queId;
	this.answer = answes;
}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public Long getQueId() {
		return queId;
	}

	public void setQueId(Long queId) {
		this.queId = queId;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answes) {
		this.answer = answes;
	}
	
//	public int getMaxMarks() {
//	return maxMarks;
//}
//
//public void setMaxMarks(int maxQuestion) {
//	this.maxMarks = maxQuestion;
//}
	

//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
	
	
}
