package com.valtech.training.first.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "que_seq")
	@SequenceGenerator(name = "que_seq", sequenceName = "que_seq", allocationSize = 1)
	private long id;
	private String questionText;
	private String option1;
	private String option2;
	private String option3;
	private String correctOption;
	private String topic;

	public Question() {
	}

	public Question(String quetionText, String option1, String option2, String option3, String correctOption,
			String topic) {
		super();

		this.questionText = quetionText;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.correctOption = correctOption;
		this.topic = topic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String quetionText) {
		this.questionText = quetionText;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
