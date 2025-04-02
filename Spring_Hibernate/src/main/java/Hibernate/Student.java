package Hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import Hibernate.client.StudentAddress;

@Entity
public class Student {

	private String name;
	private String fatherName;
	private String stream;
	private long mobile;
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="current_street")),
		@AttributeOverride(name="city", column=@Column(name="current_city")),
		@AttributeOverride(name="pincode", column=@Column(name="current_pincode"))

	})
	private StudentAddress cuurentAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="home_street")),
		@AttributeOverride(name="city", column=@Column(name="home_city")),
		@AttributeOverride(name="pincode", column=@Column(name="home_pincode"))

	})
	private StudentAddress homeAddress;
	
	@EmbeddedId
	private StudentId stuid;
	
	public Student(StudentId studentId, String string, String string2, String string3, long l, StudentAddress studentAddress){}
	
	public Student(String name, String fatherName, String stream, long mobile, StudentId stuid) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.stream = stream;
		this.mobile = mobile;
		this.stuid =stuid ;
	}

	public StudentAddress getCuurentAddress() {
		return cuurentAddress;
	}
	public void setCuurentAddress(StudentAddress cuurentAddress) {
		this.cuurentAddress = cuurentAddress;
	}
	
	public StudentAddress getHomeAddress() {
		return homeAddress;
	}
	
	public void setHomeAddress(StudentAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public StudentId getStuid() {
		return stuid;
	}
	
	public void setStuid(StudentId stuid) {
		this.stuid = stuid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	

	
}
