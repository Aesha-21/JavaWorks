package com.valtech.training.first.services;


import java.util.List;

import java.util.Set;
import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.BookInfoDTO;
import com.valtech.training.first.repos.BookRepo;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepo bookRepo;
	
	

	public List<Book> getAllBooks(){ //also wirite this for publisher and author
		return bookRepo.findAll();
	}
	
	
	
	@Override
	public Book saveBook(Book book) {
		System.out.println(" Books Repo...");
		return bookRepo.save(book);
	}

	@Override
	public List<Book> findAllByName(String name) {
		
		return bookRepo.findAllByName(name);
	}



//	@Override
//	public List<Book> getBookByYearBetween(int i, int j) {
//		
//		return bookRepo.findAllByYearBetween(i,j);
//	}



	@Override
	public List<Book> getBookByPriceGreaterThan(int i) {
		
		return bookRepo.findAllByPriceGreaterThan(i);
	}



	@Override
	public List<Integer> findAllPriceByAuthorsId(long id) {
		
		return bookRepo.findAllPriceByAuthorsId(id);
	}



	@Override
	public List<BookInfoDTO> getBookInfoByAuthor(int id) {
		// TODO Auto-generated method stub
		return bookRepo.getBookInfoByAuthor(id);
	}
	
	
 
	

}
