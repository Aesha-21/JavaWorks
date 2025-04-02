package Hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class StudentId implements Serializable{

	private int rollno;
	private int year;
	
	public StudentId() {}
	
	public StudentId(int rollno, int year) {
		super();
		this.rollno = rollno;
		this.year = year;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(rollno, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentId other = (StudentId) obj;
		return rollno == other.rollno && year == other.year;
	}

	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
