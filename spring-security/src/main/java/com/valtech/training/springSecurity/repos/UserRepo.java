package com.valtech.training.springSecurity.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.valtech.training.springSecurity.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	UserDetails findByUsername(String username);


}
