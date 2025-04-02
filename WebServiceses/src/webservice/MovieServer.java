package webservice;

import java.util.List;

import org.apache.cxf.frontend.ServerFactoryBean;

public class MovieServer {
	
	public static void main(String[] args) {
		
		ServerFactoryBean server = new ServerFactoryBean();
		server.setAddress("http://localhost:7777/MovieService");
		
		MovieServiceImpl mimpl = new MovieServiceImpl();
		mimpl.addMovie(new Movie(1, "Marvel", "English", "Action", List.of("Robert Downey","Scarlett")));
		mimpl.addMovie(new Movie(2, "Thor", "English", "Action", List.of("Chris Hemsworth","Cobie")));
		mimpl.addMovie(new Movie(4, "The Avengers", "English", "Action", List.of("Chris Hemsworth","Chris Evans","Jeremy Renner")));
		mimpl.addMovie(new Movie(5, "Loki", "English", "Action", List.of("Tom Hiddleston","Elizabeth")));
		mimpl.addMovie(new Movie(6, "Harry Potter Child Curse", "English", "Action", List.of("Danile Resclife","Emma watson","Ruoert Grint")));


		
		
		server.setServiceBean(mimpl);
		server.setServiceClass(MovieService.class);
		server.create();
		System.out.println("Movie server is running now :) ");
		System.out.println(mimpl.getAllMovies());
		
	}

}
