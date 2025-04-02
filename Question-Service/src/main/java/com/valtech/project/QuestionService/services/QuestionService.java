package com.valtech.project.QuestionService.services;

import java.util.List;

import com.valtech.project.QuestionService.vos.QuestionVO;

public interface QuestionService {
	
	QuestionVO saveQuestion(QuestionVO qvo);
	QuestionVO getQuestion(int id);
	List<QuestionVO> getAllQuetions();
	QuestionVO update(int id, QuestionVO qvo);
	List<QuestionVO> getQuestionByTopic(String topic);
	List<QuestionVO> getQuestionsOfQuiz(Long quizId);
	List<QuestionVO> getQueByListOfIds(List<Integer> ids);

}
