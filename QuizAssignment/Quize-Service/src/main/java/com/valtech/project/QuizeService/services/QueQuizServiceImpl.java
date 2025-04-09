package com.valtech.project.QuizeService.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.project.QuizeService.entities.Quize;
import com.valtech.project.QuizeService.entities.QueQuiz;

import com.valtech.project.QuizeService.repos.QueQuizRepo;
import com.valtech.project.QuizeService.repos.QuizeRepo;
import com.valtech.project.QuizeService.vos.QueQuizVO;
import com.valtech.project.QuizeService.vos.QuestionVO;
import com.valtech.project.QuizeService.vos.QuizeVO;

@Service
public class QueQuizServiceImpl implements QueQuizService{

	@Autowired
	private QueQuizRepo queQuizRepo;
	@Autowired
	private QuizeRepo qrepo;
	@Autowired
	QuestionClient questionClient;
	
	public List<QuestionVO> addQuestionsToQuiz(long id) {
		
		Quize qq = qrepo.getReferenceById(id);
//		QueQuiz quq = queQuizRepo.getReferenceById(id);
		
//		List<Integer> que = questionClient.getQuestionsOfQuize(que.get(id));
//		
//		QueQuiz queQuiz = queQuizRepo.getReferenceById(id);
//		questions.stream().map(q -> QueQuizVO.setQuestionVO(questionClient.getQuestionsOfQuize(q.get));).collect(Collectors.toList());
//		return questionClient.getQuestionsOfQuize(quq.getQuestionId());
		return questionClient.getQuestionsOfQuize(qq.getId());
		
	}

	@Override
	public QuizeVO saveOrUpdateQuiz(QuizeVO qvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuizeVO getQuizById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuizeVO> getAllQuize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuizeVO> getQuesForQuiz(int quizid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuizeVO takeQuiz(long quizId, List<String> answers) {
		// TODO Auto-generated method stub
		return null;
	}
}
