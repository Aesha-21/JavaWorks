package com.valtech.hackathon.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class Vehicle {

	public enum VehicleType{
		GAS,EV,PETROL,HYBRID
	}
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vehSeq")
	@SequenceGenerator(name = "vehSeq", sequenceName = "veh_seq", allocationSize = 1)
	private int id;
	private String vin;
	private String manufacturer;
	private String model;
	private VehicleType type;
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="owner_id", referencedColumnName = "id")
	private User owner;
	private int year;
	private List<Integer> featureIds = new ArrayList<Integer>();
	
	
	
	public Vehicle() {}
	
	
	public Vehicle(String vin, String manufacturer, String model, VehicleType type, User owner, int year) {
		super();
		this.vin = vin;
		this.manufacturer = manufacturer;
		this.model = model;
		this.type = type;
		this.owner = owner;
		this.year = year;
	}
	
	public Vehicle addFeatureId(int featureId) {
		featureIds.add(featureId);
		return this;
	}
	public Vehicle removeFeature(int featureId) {
		featureIds.remove(featureId);
		return this;
	}

	

	public Vehicle(String vin, String manufacturer, String model, VehicleType type, User owner, int year,
			List<Integer> featureIds) {
		super();
		this.vin = vin;
		this.manufacturer = manufacturer;
		this.model = model;
		this.type = type;
		this.owner = owner;
		this.year = year;
		this.featureIds = featureIds;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}


	public List<Integer> getFeatureIds() {
		return featureIds;
	}


	public void setFeatureIds(List<Integer> featureIds) {
		this.featureIds = featureIds;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vin=" + vin + ", manufacturer=" + manufacturer + ", model=" + model + ", type="
				+ type + ", owner=" + owner + ", year=" + year + ", featureIds=" + featureIds + "]";
	}
	
	
}
