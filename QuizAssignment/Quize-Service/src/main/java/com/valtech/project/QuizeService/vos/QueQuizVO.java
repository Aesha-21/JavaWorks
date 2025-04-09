package com.valtech.project.QuizeService.vos;

import java.util.ArrayList;
import java.util.List;

import com.valtech.project.QuizeService.entities.QueQuiz;

public record QueQuizVO(Long id, Long questionId, Long quizeId) {
	public static  List<QuestionVO> questionVO = new ArrayList<QuestionVO>(); 

	public static List<QuestionVO> getQuestionVO() {
		return questionVO;
	}
	
	public static void setQuestionVO(List<QuestionVO> questionVO) {
		QueQuizVO.questionVO = questionVO;
	}
	
	public static QueQuizVO from(QueQuiz qq) {
		return new QueQuizVO(qq.getId(), qq.getQuestionId(), qq.getQuizeId());
	}
	
	public QueQuiz to(QueQuiz qq) {
		return new QueQuiz(questionId, quizeId);
	}
}
