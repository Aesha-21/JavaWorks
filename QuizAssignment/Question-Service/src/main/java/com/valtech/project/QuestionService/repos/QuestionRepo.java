package com.valtech.project.QuestionService.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.QuestionService.entites.Question;
import com.valtech.project.QuestionService.vos.QuestionVO;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

	List<QuestionVO> findAllByTopic(String topic);
	List<QuestionVO> findByQuizId(Long quizId);

}
