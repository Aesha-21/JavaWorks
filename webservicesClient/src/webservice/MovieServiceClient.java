package webservice;

import java.util.List;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class MovieServiceClient {
	
	public static void main(String[] args) {
		
		ClientProxyFactoryBean client = new ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/MovieService");
		
		MovieService ms = client.create(MovieService.class);
		System.out.println(ms.getAllMovies());
		System.out.println(ms.getMovie(1));
		System.out.println(ms.getMovie(4));
		
		ms.addMovie(new Movie(1,"Gardian of the Galaxcy","English","Action",List.of("Chris Pratt")));
		System.out.println(ms.getAllMovies());
	}

}
