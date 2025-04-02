package Hibernate.client;


import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;

import org.hibernate.*;

//import org.hibernate.Session;

import org.hibernate.cfg.AnnotationConfiguration;

import Hibernate.Account;
import Hibernate.Address;
import Hibernate.AtmTx;
import Hibernate.Car;
import Hibernate.CheckTx;
import Hibernate.Customer;
import Hibernate.Student;
import Hibernate.StudentId;
import Hibernate.TellerTx;
import Hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration().
				addAnnotatedClass(Car.class).
				addAnnotatedClass(Tx.class).
				addAnnotatedClass(CheckTx.class).
				addAnnotatedClass(TellerTx.class).
				addAnnotatedClass(AtmTx.class).
				addAnnotatedClass(Customer.class).
				addAnnotatedClass(Address.class).
				addAnnotatedClass(Account.class).
				addAnnotatedClass(Student.class).
				addAnnotatedClass(StudentAddress.class).
				buildSessionFactory();
		
		Session ses = sf.openSession();
		
		Transaction tx = ses.beginTransaction();
		
		
//		ses.createQuery("FROM Tx t").list().stream().forEach(t -> System.out.println(t)); //print all the transaction in eachlike
		
//		ses.createQuery("FROM Customer c WHERE c.age>?").setInteger(0, 20).list().stream().forEach(t->System.out.println(t));
		
//ses.createQuery("FROM Tx t JOIN t.accounts a JOIN a.customers c WHERE c.age < ?").setInteger(0, 20).list().stream().forEach(t->System.out.println(Arrays.asList(t)));
		
		
		ses.createQuery("SELECT t.amt FROM Tx t JOIN t.accounts.customers c WHERE c.age < ?").setInteger(0, 20).list().stream().forEach(t->System.out.println(t));
		
		///------------------------------Student----------------------------///
	
//		StudentId sid = (StudentId) ses.save(new Student("Aesha","H","Arts",6734324242L,(new StudentId(3,2024))));
//		System.out.println(ses.load(Student.class, sid));
//		
//		
//		StudentId sid1 = (StudentId) ses.save(new Student(new StudentId(5,2024),"Aesha","H","Arts",6734324242L,
//				new StudentAddress("abc1","xyz1",380009)));
//		System.out.println(sid1);

//		Account acc =(Account)ses.load(Account.class, 3L);
//		Customer cust =(Customer)ses.load(Customer.class, 3L);
//		
//		Account a1 = new Account(45000,3, "Ami");
//		Customer c1 = new Customer(3, "Heta",34,false);
//		
//		ses.save(a1);
//		ses.save(c1);
//		
//		cust.addAccount(acc);
//		cust.addAccount(a1);
//		c1.addAccount(acc);
//		c1.addAccount(a1);
		
		
		
//		List<Tx> txs = ses.createQuery("from Tx t").list();
//		Account ac = new Account(25000,3, "SB");
//		ses.save(ac);
//		txs.stream().forEach(t -> ac.addTx(t));

		
//		Customer c1 = (Customer)ses.load(Customer.class,1L);
//		System.out.println("cust id..."+c1.getName());
		
////		
//		Customer c = new Customer(3, "Aesha",24,true);
//		ses.save(c);
//		
//		Address a = new Address(0, "Narayannagr","SBI",380007);
//		c.setAddress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		ses.saveOrUpdate(a);
		
		
		
		
		///---------------Transaction(TX)-----------------///
//		ses.save(new Tx(1000));
//		ses.save(new CheckTx(2000,324223));
//		ses.save(new TellerTx(2300,"Admin","Aesha"));
//		ses.save(new AtmTx(5000,123));
//		
//		List<Tx>txc =ses.createQuery("from Tx t").list(); //change update in hb prop
//		System.out.println(txc);
		///-------------------------------------Car----------------------------///
		
//		Long id = (Long)ses.save(new Car(0,"Hundai","i20",2019));
//		System.out.println(id);
//		ses.save(new Car(0,"Hundai","i20",2019));
		
//		Car car = (Car)ses.load(Car.class, id);
//		System.out.println(car);
//		car.setManufeacture("COOPER");
//		Car car1 = (Car)ses.load(Car.class, id);
//		ses.update(car);
//		ses.flush(); //pls dont call session flush anywhere its just an example
//		System.out.println(car);
//		System.out.println(car.getClass().getName());
//		System.out.println(car1.getClass().getName());
////		System.out.println(car.getManufeacture());
	///-------------------------------------Car----------------------------///

		
		tx.commit();
		ses.close();
		sf.close();
 	}

	
}
