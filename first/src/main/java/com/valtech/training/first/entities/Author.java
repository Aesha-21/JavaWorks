package com.valtech.training.first.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
	@SequenceGenerator(name = "author_seq", sequenceName = "author_seq", allocationSize = 1)
	private int id;
	private String name;
	private String address;

	
	@ManyToMany(targetEntity = Book.class,fetch = FetchType.LAZY, mappedBy = "authors")
	private Set<Book> book;
	
	public Set<Book> getBook() {
		return book;
	}
	
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
	
	
	public Author() {
	}

	public Author(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", address=" + address + "]";
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
