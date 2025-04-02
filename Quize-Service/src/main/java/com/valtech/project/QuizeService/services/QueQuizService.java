package com.valtech.project.QuizeService.services;

import java.util.List;

import com.valtech.project.QuizeService.vos.QueQuizVO;
import com.valtech.project.QuizeService.vos.QuestionVO;
import com.valtech.project.QuizeService.vos.QuizeVO;

public interface QueQuizService {

//	public List<QuestionVO> addQuestionsToQuiz(long id, List<String> questions);
	public  List<QuestionVO> addQuestionsToQuiz(long id);
	
	public QuizeVO saveOrUpdateQuiz(QuizeVO qvo);
	public QuizeVO getQuizById(long id);
	public List<QuizeVO> getAllQuize();
	public List<QuizeVO> getQuesForQuiz(int quizid);
	public QuizeVO takeQuiz(long quizId,List<String> answers);
	

		
	
}
