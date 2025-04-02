package com.valtech.hackathon.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserTable")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@SequenceGenerator(name = "user_seq",sequenceName = "userSeq", allocationSize = 1)
	private int id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String address;
	@OneToMany(targetEntity = Vehicle.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "owner")
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	public User() {}
	public User(String name, String password, String phone, String email, String address, List<Vehicle> vehicles) {
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.vehicles = vehicles;
	}
	
	public User(String name, String password, String phone, String email, String address) {
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public void addVehicle(Vehicle v) {
		if(vehicles == null) vehicles = new ArrayList<Vehicle>();
		vehicles.add(v);
		v.setOwner(this);
	}
	public void removeVehicle(Vehicle v) {
		vehicles.remove(v);
		v.setOwner(null);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", vehicles=" + vehicles + "]";
	}
	public boolean isEnable() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
