package AssignmentEmployee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import AssignmentEmployee.Employee.Gender;

class EmployeeRecordTest {

	@Test
	void test() {
		EmployeeRecord er = new EmployeeRecord(1, "abc", 23, 3, 3, Gender.MALE, 3);
		System.out.println(er);
		
		assertEquals(1, er.id());
		assertEquals("Aesha", er.name());
		assertEquals(32, er.age());
		assertEquals(Gender.MALE, er.gender());
		assertEquals(34000, er.salary());
		assertEquals(2, er.exp());
		assertEquals(2, er.level());
		
		
		EmployeeRecord er1 = new EmployeeRecord(1, "abc", 23, 3, 3, Gender.MALE, 3);
		System.out.println(er1);
		assertEquals(er.hashCode(), er1.hashCode());
		assertEquals(er, er1);
		
		
		EmployeeRecord er2 = new EmployeeRecord(1, "abc1", 23, 3, 3, Gender.MALE, 3);
		System.out.println(er2);
		assertFalse(er.hashCode() == er2.hashCode());
		assertNotEquals(er, er2);
		assertEquals(2500, er.computeBonus());
		
		
	
	}

}
