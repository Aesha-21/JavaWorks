package com.valtech.training.first.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)

	private int id;
	private String name;
	private int price;

	///----------------------------Publisher--------------------------///
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Publisher.class)
	@JoinColumn(name="publisher_id",referencedColumnName = "id")
	private Publisher publisher;
	
	public Publisher getPublisher() {
		return publisher;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	
	///----------------------------Author--------------------------///
	
	@ManyToMany(targetEntity = Author.class,fetch = FetchType.LAZY)
	@JoinTable(name="book_author",joinColumns = @JoinColumn(name="author_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="book_id",referencedColumnName = "id"))
	private Set<Author> authors;
	
	
	public void addAuthor(Author a) {
		if(authors == null) authors = new HashSet<Author>();
		authors.add(a);
		if(a.getBook()==null) a.setBook(new HashSet<Book>());
		a.getBook().add(this);
	}
	
	public void removeAuthor(Author a) {
		authors.remove(a);
		a.getBook().remove(this);
	}
	
	public Set<Author> getAuthor() {
		return authors;
	}
	
	public void setAuthor(Set<Author> author) {
		this.authors = author;
	}
	
	
	
	public Book(String name, int price) {
		super();

		this.name = name;
		this.price = price;
	}

	public Book() {
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

}
