package com.valtech.training.first;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.QuetionsService;

@SpringBootTest
class FirstApplicationTests {

	@Autowired
	private QuetionsService queService;
	
	
	
	@Autowired
	private BookService bookService;
	
	
	
	@Test
	void initBook() {
		
//		System.out.println("Add que...");
//		bookService.saveBook(new Book("The Alchemist", 120));
		
		
	}
	
	@Test
	void bookService() {
		
		assertEquals(2, bookService.findAllByName("Java book").size());
		
//		assertEquals(6, bookService.getBookByYearBetween(2009,2012).size());
		
//		assertEquals(2, bookService.getBookByPriceGreaterThan(123).size());
		
		
		
//		System.out.println(bookService.findAllPriceByAuthorsId(1));
		
		System.out.println(bookService.getBookInfoByAuthor(2));
	}
	
//	@Test
//	void initPublisher() {}
//	
//	@Test
//	void initAuthor() {}

	
	
//	@BeforeEach
//	void initData() {
//		long count = queService.count();
//		if(count!=0) return;
//		
//		System.out.println("Quetion service class name ---> "+Question.class);
//		Question q = queService.saveQuetion(new Question("whats is devops?", "tool", "method?", "terminology", "method", "Devops"));
//		
//		queService.saveQuetion(new Question("What is git?","UI Tool","cli Tool","Just a cat","cli tool","GIT"));
//		
//		queService.saveQuetion(new Question("What is Mobility?", "Finance Company", "Auto-Motive Company", "Gaming Comapany", "Auto-Motive Company", "Company"));
//		
//		queService.saveQuetion(new Question("who is big patner of mobility?", "contry man", "BMW", "WV", "Auto-Motive Company", "Company"));
//		
//		queService.saveQuetion(new Question("What is jenkins?","A manager tool","a version control","ci/cd tool","ci/cd tool","Devops"));
//		
//		queService.saveQuetion(new Question("what is Docker?", "a swim container", "Big fish", "Containrization Tool", "C", "Devops"));
//		
//		queService.saveQuetion(new Question("what is my name?", "Esha", "Isha", "Aesha", "Aesha", "Find name"));
////		
//		queService.saveQuetion(new Question("What is my hobbies?", "skeching", "Writing Jokes", "Both of", "Both of", "Person"));
//
////		
//		
//	}
	
	
//	@Test
//	@Rollback
//	void queService() {
//		long count = queService.count();
//		if(count!=0) return;
//		
//		System.out.println("Quetion service class name ---> "+Quetion.class);
//		
//		
//		
//		System.out.println("Test que");
//		assertTrue(q.getId() > 0);
//		assertEquals(count+1, queService.count());
		
//		assertEquals(1, queService.findAllByTopic("GIT").size());
//		assertEquals(1, queService.countByTopic("GIT"));
//		assertEquals(2, queService.countByTopicAndQuestionTextContaining("Company","mobility"));
		
//		assertEquals(2,queService.countByTopicAndQuestionTextContainingIgnoreCase("Company", "Mobility"));
//		
//		assertEquals(1, queService.findAllByTopic("GIT").size());
//		
//		assertEquals(1, queService.findAllByTopic("GIT", 0, 2).size());
//
//		assertEquals(1, queService.findAllByTopic("GIT", 1, 2).size());
		
//	}

	@Autowired
	private SimpleInterface simpleint;
	@Autowired
	private Arithmetic arithmetic;

	@Test
	void testArith() {
		assertEquals(10, arithmetic.add(5, 5));
		assertEquals(200, simpleint.compute(200, 5, 20));
		
		
	}

}
