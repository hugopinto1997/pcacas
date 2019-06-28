package com.uca.capas.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	public List<Movie> findAll();
	
	@Query(nativeQuery= true,value="select * "
			+"from movie "
			+ "where status = true")
	public List<Movie> findAllActive();
	public Movie findOne(int id);
	
}
