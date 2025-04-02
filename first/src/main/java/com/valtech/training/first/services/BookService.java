package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.BookInfoDTO;

public interface BookService {
	
	Book saveBook(Book book);

	List<Book> findAllByName(String name);

//	List<Book> getBookByYearBetween(int i, int j);

	List<Book> getBookByPriceGreaterThan(int i);
	List<Integer> findAllPriceByAuthorsId(long id);
	
	List<BookInfoDTO> getBookInfoByAuthor(int id);
}
