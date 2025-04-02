package com.valtech.traning.jexs.webservices;


import java.util.List;

import javax.jws.WebService;

import com.valtech.traning.jexs.Movie;
import com.valtech.traning.jexs.services.MovieService;


@WebService(endpointInterface = "com.valtech.traning.jexs.webservices.MovieServiceWS",
name = "MovieService",portName = "MovieServicePort")
public class MovieServiceWsImpl implements MovieServiceWS {
	
	private MovieService movieService;
	
	
	public MovieServiceWsImpl(com.valtech.traning.jexs.services.MovieService movieService2) {

		this.movieService = movieService2;
	}

	@Override
	public List<Movie> getAllMovie() {
		return movieService.getAllMovie();
	}
	@Override
	public Movie getMovie(long id) {
		return movieService.getMovie(id);
	}
	@Override
	public Movie createMovie(Movie m) {
		return movieService.createMovie(m);
	}

//	@Override
//	public List<Movie> getAllMovies() {
//		return movieService.getAllMovies();
//	}
//
//	@Override
//	public Movie getMovie(int id) {
//		return movieService.getMovie(id);
//	}
//
//	@Override
//	public void addMovie(Movie m) {
//		movieService.addMovie(m);
//	}
//
//	@Override
//	public void removeMovie(Movie m) {
//		movieService.removeMovie(m);
//	}
	
	

}
