package springTx;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class Employee implements Comparable<Employee>{
	
	public enum Gender {
		MALE,FEMALE,OTHER;
	}
	
	//define enum variables
	@Id
	private long id;
	private String name;
	private int age;
	private float salary;
	private int level;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "experiance")
	private int exp;
//	private int dept_id;
	
	
	
	
//	public int getDept_id() {
//		return dept_id;
//	}
//	public void setDept_id(int dept_id) {
//		this.dept_id = dept_id;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
	//Create a Constructor
	public Employee(long id, String name, int age, float salary, int level,Gender gender, int exp) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.level = level;
		this.gender = gender;
		this.exp = exp;
		
	}
	

	//create builder class
	public static class EmployeeBuilder{
		
		private Employee emp;
		
		public EmployeeBuilder(Employee emp) {
			this.emp=emp;
		}
		
		public Employee build() {
			return emp;
		}
		
		public EmployeeBuilder id(long id) {
			emp.setId(id);
			return this;
		}
		
		public EmployeeBuilder name(String name) {
			emp.setName(name);
			return this;
		}
		
		public EmployeeBuilder age(int age) {
			emp.setAge(age);
			return this;
		}
		
		public EmployeeBuilder salary(float salary) {
			emp.setSalary(salary);
			return this;
		}
		
		public EmployeeBuilder level(int level) {
			emp.setLevel(level);
			return this;
		}
		
		public EmployeeBuilder gender(Gender gender) {
			emp.setGender(gender);
			return this;
		}
		
		public EmployeeBuilder exp(int exp) {
			emp.setExp(exp);
			return this;
		}
		
		
		
		
		
	}
	
	//create constructor of emp class
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//here we use emp constructor
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		/* if object is car */

		if(!(obj instanceof Employee)) return false;
	
		Employee other = (Employee) obj;
		//compare the obj
		
		//name and salary dout.....
		return age == other.age && exp == other.exp && gender == other.gender && id == other.id && level == other.level
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
	
	//add tostring 
	
	public String toString() {
		return new StringBuilder()
				.append(id)
				.append(" ")
				.append(name)
				.append(" ")
				.append(age)
				.append(" ")
				.append(salary)
				.append(" ")
				.append(level)
				.append(" ")
				.append(gender)
				.append(" ")
				.append(exp)
				.append(" ")
				.toString();
	}	
	
	
	
	
	
	@Override
	public int hashCode() {
		return (toString()+"Employee").hashCode();
	}
	
	
	@Override
	public int compareTo(Employee o) {
		
//		if(this.level != o.level) {
//			return Integer.compare(this.level, o.level);
//		}
//		
		int a = Integer.compare(this.level, o.level);
		if (a!=0)
				return a;
	
		
		int b = Integer.compare(this.exp, o.exp);
		if (b!=0)
			return b;
			
		int c = this.gender.compareTo(o.gender);
		if (c!=0)
			return c;
		
		int d = Float.compare(this.salary, o.salary);
		return d;
		
		
		
		}
	

}