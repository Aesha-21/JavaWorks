package webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {
	
	private List<Movie> movies = new ArrayList<Movie>();
	
	@Override
	public List<Movie> getAllMovies(){
		return movies;
	}
	
	@Override
	public Movie getMovie(int id) {
		
//		Optional<Movie> empty = Optional.empty();
//		Optional<Movie> noidea = Optional.ofNullable(obj);
//		Optional<Movie> m = Optional.of(null);
		
		Optional<Movie> movie = movies.stream().filter(f -> f.getId()==id).findFirst();
		if(movie.isPresent())
			return movie.get();
		return new Movie();
	}
	
	@Override
	public void addMovie(Movie m) {
		movies.add(m);
	}

	@Override
	public void removeMovie(Movie m) {
		movies.remove(m);
	}
}
