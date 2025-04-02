package com.valtech.training.restApis.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq")
	@SequenceGenerator(name = "owner_seq", sequenceName = "owner_seq", allocationSize = 1)
	private long id;
	private String name;
	private String mobileno;
	private String email;
	
	
	@OneToMany(mappedBy = "owner",targetEntity = Watch.class,cascade = CascadeType.ALL)
	private List<Watch> watches;
	
	public void addWatch(Watch w) {
		
		if(watches == null) 
			watches = new ArrayList<Watch>();
		
		watches.add(w);
		w.setOwner(this);
		
	}
	
	public void removeWatch(Watch w) {
		w.setOwner(null);
		watches.remove(w);
	}
	
	public List<Watch> getWatches() {
		return watches;
	}
	
	public void setWatches(List<Watch> watches) {
		this.watches = watches;
	}

	public Owner() {
	}

	public Owner(String name, String mobileno, String email) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", email=" + email + "]";
	}

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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
