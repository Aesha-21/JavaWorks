package com.valtech.traning.jexs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.traning.jexs.Movie;


@Repository
public interface MovieRepo extends JpaRepository<Movie,Long>{

}
