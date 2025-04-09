package com.valtech.project.QuizeService.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.QuizeService.entities.QueQuiz;

@Repository
public interface QueQuizRepo extends JpaRepository<QueQuiz, Long>{

//	void findQueByQuizeId();
}
