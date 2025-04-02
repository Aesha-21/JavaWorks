package webservice;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class HelloWorldClient {

	public static void main(String[] args) {
		ClientProxyFactoryBean client = new ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/Helloworld");
		Helloworld hw =client.create(Helloworld.class);
		System.out.println(hw.getClass().getName());
		System.out.println(hw.first("hgfg"));
	}
}
