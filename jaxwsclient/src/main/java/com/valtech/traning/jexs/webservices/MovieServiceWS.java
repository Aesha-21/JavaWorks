package com.valtech.traning.jexs.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.traning.jexs.Movie;


@WebService
public interface MovieServiceWS {

	List<Movie> getAllMovie();

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}