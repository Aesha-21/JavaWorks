package com.valtech.training.restApis.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.restApis.entites.Owner;

public class OwnerVO {

	private long id;
	private String name;
	private String mobileno;
	private String email;
	private List<Long> watches;
	
	public OwnerVO() {}

	public OwnerVO(long id, String name, String mobileno, String email,List<Long> watches) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.email = email;
		this.watches =watches;
	}
	
	
	public static OwnerVO from(Owner owner) {
		
		List<Long> watches = owner.getWatches() == null ? List.of() : owner.getWatches().stream().map(o -> o.getId()).collect(Collectors.toList());
		return new OwnerVO(owner.getId(),owner.getName(),owner.getMobileno(),owner.getEmail(),watches);
	}
	
	public static List<OwnerVO> toOwnerVo(List<Owner> owners){
		return owners.stream().map(o -> OwnerVO.from(o)).collect(Collectors.toList());
	}
	
	public Owner toOwner() {
		Owner o = new Owner(name, mobileno, email);
		o.setId(id);
		return o;
	}
	
	public void updateOwnerFromVO(Owner o) {
		o.setName(name);
		o.setMobileno(mobileno);
		o.setEmail(email);
	}
	
	

	@Override
	public String toString() {
		return "OwnerVO [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", email=" + email + ", watches="
				+ watches + "]";
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

	public List<Long> getWatches() {
		return watches;
	}

	public void setWatches(List<Long> watches) {
		this.watches = watches;
	}
	
	
	
	
}
