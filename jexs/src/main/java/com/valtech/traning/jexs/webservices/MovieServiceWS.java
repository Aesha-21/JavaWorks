package com.valtech.traning.jexs.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.traning.jexs.Movie;


@WebService
public interface MovieServiceWS {

//	List<Movie> getAllMovies();
//
//	Movie getMovie(int id);
//
//	void addMovie(Movie m);
//
//	void removeMovie(Movie m);
	List<Movie> getAllMovie();

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}