package com.valtech.project.QuestionService.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.project.QuestionService.entites.Question;

public record QuestionVO(Integer id, String questionText ,String option1,String option2,String option3,String answer,String topic,Long quizId ) {

	

	public static QuestionVO from(Question que) {
		return new QuestionVO(que.getId(),que.getQuestionText(),que.getOption1(), que.getOption2(), que.getOption3(), que.getAnswer(), que.getTopic(),que.getQuizId());
	
	}
	
	public static List<QuestionVO> from(List<Question> ques) {

		return ques.stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
	
	public Question to() {
		return new Question(questionText, option1, option2, option3, answer, topic, quizId);
	}
	
	public void updateTo(Question que) {
		que.setQuestionText(questionText);
		que.setOption1(option1);
		que.setOption2(option2);
		que.setOption3(option3);
		que.setAnswer(answer);
		que.setTopic(topic);
		que.setQuizId(quizId);
	}
}
