package com.valtech.project.QuizeService.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.project.QuizeService.entities.Quize;
import com.valtech.project.QuizeService.repos.QuizeRepo;
import com.valtech.project.QuizeService.vos.QuizeVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizeServiceImpl implements QuizeService{

	@Autowired
	QuizeRepo quizeRepo;
	@Autowired
	QuestionClient questionClient;
	
	@Override
	public QuizeVO getQuiz(long id) {
		

//		Quize quiz = quizeRepo.getReferenceById(id);
//		
//		
//		List<QuestionVO> qu = questionClient.getQuestionsOfQuize(quiz.getId());
//		return qu;
		return QuizeVO.from(quizeRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuizeVO> getAllQuiz() {
		
//		List<Quize> quiz = quizeRepo.findAll();
		
//		List<Quize> qvo = quiz.stream().map(q -> {
//			
//			QuizeVO.setQuestionVO(questionClient.getQuestionsOfQuize
//				(q.getId()));
//			return q;
//		}).collect(Collectors.toList());
		
		
//		return quizeRepo.findAll().stream().map(q -> QuizeVO.setQuestionVO(questionClient.getQuestionsOfQuize(q.getId()))).collect(Collectors.toList());
	
		return quizeRepo.findAll().stream().map(q -> QuizeVO.from(q)).collect(Collectors.toList());
	}

	@Override
	public QuizeVO saveQuiz(QuizeVO qvo) {
		Quize quz = qvo.to();
		quz = quizeRepo.save(quz);
		return QuizeVO.from(quz);
	}

	@Override
	public QuizeVO updateQuiz(long id, QuizeVO qvo) {
		Quize quz = quizeRepo.getReferenceById(id);
		qvo.updateTo(quz);
		quz = quizeRepo.save(quz);
		return QuizeVO.from(quz);
	}

	
}
