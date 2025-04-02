package com.valtech.project.QuestionService.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Question {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "que-seq")
	@SequenceGenerator(name="que-seq",sequenceName = "que-seq",allocationSize = 1)
	private int id;
	private String questionText;
	private String option1;
	private String option2;
	private String option3;
	private String answer;
	private String topic;
	private Long quizId;
	
	public Question() {}
	
	

	public Question(String queationtext, String option1, String option2, String option3, String answer, String topic, Long quizId) {
		super();
		this.questionText = queationtext;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.answer = answer;
		this.topic = topic;
		this.quizId = quizId;
	}



	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", answer=" + answer + ", topic=" + topic + ", quizId=" + quizId + "]";
	}



	public Long getQuizId() {
		return quizId;
	}



	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}



	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String queationtext) {
		this.questionText = queationtext;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	

}
