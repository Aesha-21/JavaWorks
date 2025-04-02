package com.valtech.traning.jexs;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Movie {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "movie_seq")
	@SequenceGenerator(name = "movie_seq",sequenceName = "movie_seq",allocationSize = 1)
	private long id;
	private String name;
	private String language;
	private String genre;
	@ElementCollection(targetClass = String.class,fetch = FetchType.EAGER)
	@CollectionTable(name="movie_actor",joinColumns = @JoinColumn(name="movie_id",referencedColumnName = "id"))
	private List<String> actor;
	
	public Movie() {}
	
	
	
	public Movie(String name, String language, String genre, List<String> actor) {
		super();
		
		this.name = name;
		this.language = language;
		this.genre = genre;
		this.actor = actor;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<String> getActor() {
		return actor;
	}
	public void setActor(List<String> actor) {
		this.actor = actor;
	}
	

}
