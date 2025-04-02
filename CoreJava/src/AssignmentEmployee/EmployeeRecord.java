package AssignmentEmployee;

import AssignmentEmployee.Employee.Gender;

public record EmployeeRecord(long id,String name,int age,int salary,int level,
		Gender gender,int exp) {
	
	
	public EmployeeRecord() {
		this(0,"",0,0,0,Gender.MALE,0);
	}
	
	public int computeBonus() {
		return exp * 100 + level * 1000;
 	}

}
