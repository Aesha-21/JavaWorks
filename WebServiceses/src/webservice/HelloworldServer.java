package webservice;


import org.apache.cxf.frontend.ServerFactoryBean;

public class HelloworldServer {
	
	public static void main(String[] args) {
		ServerFactoryBean server = new ServerFactoryBean();
		server.setAddress("http://localhost:7777/Helloworld");
		server.setServiceBean(new HelloworldImpl());
		server.setServiceClass(Helloworld.class);
		server.create();
		System.out.println("Server is Running....");
	}

}
