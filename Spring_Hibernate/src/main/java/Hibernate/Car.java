package Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

@Entity
public class Car {
	
	
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "carseq")
//	@SequenceGenerator(name = "carseq", sequenceName = "carseq",allocationSize = 1)
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE,generator = "cartable")
	@TableGenerator(name="cartable", table = "car_pk")
 	private long id;
	private String manufeacture;
	private String name;
	private int year;
	@Version
	private int version;
	
	public int getVersion() {
		return version;
	}

//	public void setVersion(int version) {
//		this.version = version;
//	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", manufeacture=" + manufeacture + ", name=" + name + ", year=" + year + ", version="
				+ version + "]";
	}

	public Car() {}

	
	
	public Car(long id, String manufeacture, String name, int year) {
		
		this.id = id;
		this.manufeacture = manufeacture;
		this.name = name;
		this.year = year;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getManufeacture() {
		return manufeacture;
	}
	public void setManufeacture(String manufeacture) {
		this.manufeacture = manufeacture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	
}
