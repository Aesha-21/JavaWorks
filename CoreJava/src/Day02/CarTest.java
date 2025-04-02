package Day02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	
	@Test
	void testClone() throws CloneNotSupportedException{
		Car car = new Car("Honda","City",2024,3,7);
		Car car1 = (Car)car.clone();
		assertEquals(car, car1);
		assertSame(car, car1); // when you run this test case it gives error because here both refrence are changes so comment this and then run.
	}
	

	@Test
	void testTostring() {
		Car cr = new Car("Honda","City",2024,3,7);
		assertEquals("Honda City 2024 3 7",cr.toString());
		cr.setMake("Honda");
		assertEquals("Honda City 2024 3 7",cr.toString());
		cr.setModel("City"); 
		assertEquals("Honda City 2024 3 7",cr.toString());
		cr.setYear(2024);
		assertEquals("Honda City 2024 3 7",cr.toString());
		cr.setVersion(3);
		assertEquals("Honda City 2024 3 7",cr.toString());
		cr.setVariant(7);
	}
	
	
	@Test
	void testhashcode() {
		Car car = new Car("Honda","City",2024,3,7);
		int hash = car.hashcode();
		System.out.println(car+" "+ car.hashcode());
		assertEquals(hash, car.hashcode());
		assertEquals(hash, new Car("Honda","City",2024,3,7).hashcode());
		
		car.setVariant(3);
		System.out.println(car +" "+car.hashcode());
		assertNotEquals(hash, car.hashcode());
		
		car.setVersion(7);
		System.out.println(car +" "+car.hashcode());
		assertNotEquals(hash, car.hashcode());
		
		car.setModel("City");
		System.out.println(car +" "+car.hashcode());
		assertNotEquals(hash, car.hashcode());
		


	}

}
