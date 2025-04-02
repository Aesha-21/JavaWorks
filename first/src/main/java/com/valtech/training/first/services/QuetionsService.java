package com.valtech.training.first.services;

import java.awt.print.Pageable;
import java.util.List;

import com.valtech.training.first.entities.Question;

public interface QuetionsService {
	
	long count();

	Question saveQuetion(Question quetion);

	Question updateQuetion(Question quetion);

	void deleteQuetion(Question quetion);

	Question getQuetion(long id);

	List<Question> getAllQue();
	List<Question> findAllByTopic(String topic);
	List<Question> findAllByTopic(String topic,int page,int size);
	long countByTopic(String topic);


	long countByTopicAndQuestionTextContaining(String string, String string2);
	
	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);

}