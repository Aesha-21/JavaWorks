package com.valtech.traning.jexs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.traning.jexs.Movie;
import com.valtech.traning.jexs.repos.MovieRepo;


@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepo movieRepo;
	

	@Override
	public List<Movie> getAllMovie(){
		return movieRepo.findAll();
	}
	
	@Override
	public Movie getMovie(long id) {
		return movieRepo.getReferenceById(id);
	}
	
	@Override
	public Movie createMovie(Movie m) {
		return movieRepo.save(m);
	}

}
