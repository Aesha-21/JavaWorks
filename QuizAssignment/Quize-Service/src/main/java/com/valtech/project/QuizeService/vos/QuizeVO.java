package com.valtech.project.QuizeService.vos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.project.QuizeService.entities.Quize;

public record QuizeVO(Long id, int noOfQuestions,String topic,Long queId,List<String> answer) {

	public static  List<QuestionVO> questionVO = new ArrayList<QuestionVO>(); 
//	
//	
//
//	public static List<QuestionVO> getQuestionVO() {
//		return questionVO;
//	}
//	
//	public static void setQuestionVO(List<QuestionVO> questionVO) {
//		QuizeVO.questionVO = questionVO;
//	}
	
//	private static List<QuizeVO> queVO;
	
	public static QuizeVO from(Quize qz) {
		return new QuizeVO(qz.getId(),qz.getNoOfQuestions(),qz.getTopic(),qz.getQueId(),qz.getAnswer());
	}

	public static List<QuizeVO> from(List<Quize> qz) {
		return qz.stream().map(q -> QuizeVO.from(q)).collect(Collectors.toList());
	}
	
	public Quize to() {
		return new Quize(noOfQuestions, noOfQuestions, topic, queId, answer);
	}

	public void updateTo(Quize q) {
		
		q.setNoOfQuestions(noOfQuestions);
		
		q.setTopic(topic);
	}
}
