package com.valtech.traning.jexs.services;

import java.util.List;

import com.valtech.traning.jexs.Movie;


public interface MovieService {

	List<Movie> getAllMovie();

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}