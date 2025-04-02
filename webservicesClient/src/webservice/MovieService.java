package webservice;

import java.util.List;

public interface MovieService {

	List<Movie> getAllMovies();

//	Movie getMovie(int id);

	void addMovie(Movie m);

	void removeMovie(Movie m);

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}