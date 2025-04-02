package com.valtech.training.first.services;

//import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.QuetionsRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuetionServiceImpl implements QuetionsService {
	
	@Autowired
	private QuetionsRepo queRepo;
	
	
	@Override
	public List<Question> findAllByTopic(String topic) {
		
		return queRepo.findAllByTopic(topic);
	}
	
	@Override
	public Question saveQuetion(Question quetion) {
		System.out.println("Quetion repo ---> "+queRepo.getClass().getName());
		return queRepo.save(quetion);
	}
	
	@Override
	public Question updateQuetion(Question quetion) {
		System.out.println("Quetion repo ---> "+queRepo.getClass().getName());
		return queRepo.save(quetion);
	}
	
	@Override
	public void deleteQuetion(Question quetion) {
		System.out.println("Quetion repo ---> "+queRepo.getClass().getName());
		queRepo.delete(quetion);
	}
	
	@Override
	public Question getQuetion(long id) {
		return queRepo.getReferenceById(id); 
	}
	
	@Override
	public List <Question> getAllQue(){
		return queRepo.findAll();
	}

	@Override
	public long count() {
		return queRepo.count();
	}

	@Override
	public long countByTopic(String topic) {
		
		return queRepo.countByTopic(topic);
	}

	@Override
	public long countByTopicAndQuestionTextContaining(String topic, String keyword) {
		
		return queRepo.countByTopicAndQuestionTextContaining(topic,keyword);
	}

	@Override
	public long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword) {
		// TODO Auto-generated method stub
		return queRepo.countByTopicAndQuestionTextContainingIgnoreCase(topic,keyword);
	}

	@Override
	public List<Question> findAllByTopic(String topic, int page, int size) {
		
		return queRepo.findAllByTopic(topic,Pageable.ofSize(size).withPage(page));
	}

	

}
