package com.valtech.training.first.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pub_seq")
	@SequenceGenerator(name = "pub_seq", sequenceName = "pub_seq", allocationSize = 1)
	private int id;
	private String name;
	
	
	@OneToMany(mappedBy = "publisher",targetEntity = Book.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Book> books;
	

	public Set<Book> getBook() {
		return books;
	}
	
	public void setBook(Set<Book> book) {
		this.books = book;
	}
	
	
	public void addBook(Book book) {
		if(book == null) books = new HashSet<Book>();
		books.add(book);
		book.setPublisher(this);
	}
	
	
	public void removeBook(Book book) {
		books.remove(book);
		book.setPublisher(this);
	}
	
	public Publisher() {}

	public Publisher(String name) {
		super();
		this.name = name;
	}



	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
