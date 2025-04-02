package AssignmentEmployee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import AssignmentEmployee.Employee.Gender;

class EmployeeTest {
	List<Employee> emps = new ArrayList<Employee>();

	@Test
	void testEmp() {

		List<Employee> emps = new ArrayList<Employee>();
		Employee e = new Employee();

//		assertEquals(30000, e.getSalary());
//		assertEquals(3, e.getLevel());

	}

	@Test
	void testEmpUsingStream() {
		List<Employee> eb = emps.stream().filter(emp -> emp.getName().equalsIgnoreCase("aesha"))
				.collect(Collectors.toList());
		System.out.println("ignore case" + eb);

		// using map group the gender
		Map<Gender, List<Employee>> mp = emps.stream().collect(Collectors.groupingBy(Employee::getGender));
		System.out.println(mp);

		// sum of all emp salary
		double ab = emps.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println(ab);

	}

	@Test
	void sumOfEmpSalary() {

		List<Employee> empfl = emps.stream().filter(emp -> emp.getLevel() == 3).collect(Collectors.toList());
		System.out.println(empfl);
		System.out.println(
				empfl + "Salary of the employee by level" + empfl.stream().mapToDouble(Employee::getSalary).sum());

	}

	@Test
	void sortEmpByLevel() {

		List<Employee> empfl = emps.stream().filter(emp -> emp.getLevel() == 3).collect(Collectors.toList());
		System.out.println(empfl);
		// sum of emp by level by salary

	}

	@Test
	void sortEmpByGender() {
		List<Employee> empgn = emps.stream().filter(emp -> emp.getGender() == Gender.FEMALE)
				.collect(Collectors.toList());
		System.out.println(empgn);

		List<Employee> empfl1 = emps.stream().filter(emp -> emp.getLevel() == 3 && emp.getGender() == Gender.MALE)
				.collect(Collectors.toList());
		System.out.println(empfl1);
	}

	@Test
	void comparebyLevel() {

		Employee ep1 = new Employee(123, "ab", 34, 43453, 3, Gender.FEMALE, 1);
		Employee ep2 = new Employee(123, "ab", 34, 43453, 2, Gender.MALE, 5);

		assertTrue(ep1.compareTo(ep2) > 0);
	}

	@Test
	void comparebyExp() {

		Employee ep1 = new Employee(123, "ab", 34, 43453, 2, Gender.FEMALE, 7);
		Employee ep2 = new Employee(123, "ab", 34, 43453, 2, Gender.MALE, 5);

		assertTrue(ep1.compareTo(ep2) > 0);
	}

	// Compateto test cases

	// test hascode
//	@Test
//	void testHashcode() {
//
//		Employee ep = new Employee(123, "ab", 34, 43453, 3, Gender.FEMALE, 1);
//		int hash = ep.hashCode();
//		System.out.println(ep + " " + ep.hashCode());
//		assertEquals(hash, ep.hashCode());
//		assertEquals(hash, new Employee(123, "ab", 34, 43453, 3, Gender.FEMALE, 1).hashCode());
//
//		ep.setAge(34);
//		System.out.println(ep + " " + ep.hashCode());
//		assertNotEquals(hash, ep.hashCode());
//	}

}
