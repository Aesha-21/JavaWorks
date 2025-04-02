package AssignmentEmployee;

import java.util.ArrayList;
import java.util.List;

import AssignmentEmployee.Employee.Gender;

public class EmployeeService {
	
	public static void main(String[] args) {
		
		
		List<Employee> emps = new ArrayList<Employee>();
		

		emps.add(Employee.builder().id(123).name("Aesha").age(23).salary(12334.2F).gender(Gender.FEMALE).level(0)
				.build());

		emps.add(Employee.builder().id(3523).name("Ami").age(25).salary(25000).gender(Gender.FEMALE).level(3).build());

		emps.add(Employee.builder().id(6456).name("Veer").age(30).salary(42000).gender(Gender.MALE).level(4).build());
		
		emps.add(Employee.builder().id(6456).name("Heta").age(35).salary(42000).gender(Gender.FEMALE).level(2).build());
		
		emps.add(Employee.builder().id(3234).name("Richa").age(21).salary(42000).gender(Gender.FEMALE).level(3).build());
		
		emps.add(Employee.builder().id(5431).name("Navya").age(40).salary(42000).gender(Gender.MALE).level(4).build());

		for (Employee emp: emps) {
		System.out.println(emp);
	}
	}

}
