package com.valtech.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.entities.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

	
}
