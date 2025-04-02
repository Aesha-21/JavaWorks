package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryClient {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Factory.xml");
//		System.out.println(ctx.getBean("p2"));
//		System.out.println(ctx.getBean("p2"));
//        System.out.println(ctx.getBean("p2") == ctx.getBean("p2"));
        
        System.out.println(ctx.getBean("p3"));
        ctx.close();
	}

}
