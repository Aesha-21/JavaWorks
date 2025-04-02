package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTx.Employee;
import springTx.Employee.Gender;
import springTx.EmployeeService;

public class TxClient {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Tx-Hibernate-Annotaion.xml");
		EmployeeService es = ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		
//		es.save(new Employee(12,"Darshi",25,120000,12,Gender.FEMALE,12));
		es.update(new Employee(12,"Darshi",25,123443,12,Gender.FEMALE,12));
//		System.out.println(es);
		es.getAll().forEach(e -> System.out.println(e));
		
		ctx.close();
	}

}
