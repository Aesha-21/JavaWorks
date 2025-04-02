package AssignmentEmployee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import AssignmentEmployee.Employee.Gender;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao = new EmployeeDAOImpl();
//		dao.save(new Employee(19,"againtest",32,15000,3,Gender.FEMALE,4));
		//Employee e = new Employee(2,"temp",33,2,2,Gender.MALE,2);
		
		//dao.update(e);
		
		//dao.delete(1);
		
		Employee e = dao.get(19);
//		System.out.println(e);
		
		assertEquals(19, e.getId());
		assertEquals("againtest", e.getName());
		assertEquals(32, e.getAge());
		assertEquals(4, e.getExp());
		assertEquals(15000, e.getSalary());
		assertEquals(Gender.FEMALE,e.getGender());
		System.out.println(e.getLevel());
		assertEquals(3, e.getLevel());
		
		assertTrue(dao.getAll().size()>1);
	}

}
