package com.valtech.training.first.repos;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entities.Question;

@Repository
public interface QuetionsRepo extends JpaRepository<Question, Long>{


	List<Question> findAllByTopic(String topic,org.springframework.data.domain.Pageable pageable);

	List<Question> findAllByTopic(String topic);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContaining(String topic, String keyword);

	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);

	
}
