package com.valtech.project.QuizeService.services;

import java.util.List;

import com.valtech.project.QuizeService.entities.Quize;
import com.valtech.project.QuizeService.vos.QuestionVO;
import com.valtech.project.QuizeService.vos.QuizeVO;

public interface QuizeService {
	
//	public List<QuestionVO> getQuiz(long id);
	public QuizeVO getQuiz(long id);
	public List<QuizeVO> getAllQuiz();
	public QuizeVO saveQuiz(QuizeVO q);
	public QuizeVO updateQuiz(long id ,QuizeVO q);

}
