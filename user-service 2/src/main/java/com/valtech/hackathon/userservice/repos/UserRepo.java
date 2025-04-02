package com.valtech.hackathon.userservice.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.valtech.hackathon.userservice.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	List<User> findByVehiclesIsNotEmpty();
	UserDetails findByUsername(String name);
//	 Optional<User> findByEmail(String email);

	
}
