package com.valtech.project.QuestionService.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.project.QuestionService.entites.Question;
import com.valtech.project.QuestionService.repos.QuestionRepo;
import com.valtech.project.QuestionService.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public QuestionVO getQuestion(int id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}

	@Override
	public List<QuestionVO> getAllQuetions() {
		return questionRepo.findAll().stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}

	@Override
	public QuestionVO saveQuestion(QuestionVO qvo) {
		Question q = qvo.to();
		q = questionRepo.save(q);
		return QuestionVO.from(q);
	}

	@Override
	public QuestionVO update(int id, QuestionVO qvo) {
		Question q = questionRepo.getReferenceById(id);
		qvo.updateTo(q);
		q = questionRepo.save(q);
		return QuestionVO.from(q);
	}

	@Override
	public List<QuestionVO> getQuestionByTopic(String topic) {
		
		return questionRepo.findAllByTopic(topic);
	}

	@Override
	public List<QuestionVO> getQuestionsOfQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return questionRepo.findByQuizId(quizId);
	}

	@Override
	public List<QuestionVO> getQueByListOfIds(List<Integer> ids) {
		return QuestionVO.from(questionRepo.findAllById(ids));
	}

}
