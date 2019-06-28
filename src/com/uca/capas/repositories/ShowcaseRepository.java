package com.uca.capas.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Movie;
import com.uca.capas.domain.Showcase;

@Repository
public interface ShowcaseRepository extends JpaRepository<Showcase, Integer> {

	public List<Showcase> findAll();
	@Query(nativeQuery= true,value="select * "
			+"from showcase "
			+ "where id_movie = ?1")
	public List<Showcase> findByMovie(int id);
	
	@Query(nativeQuery= true,value="select * "
			+"from showcase "
			+ "where id_movie = ?1 and show_type = ?2")
	public List<Showcase> findByMovietype(int id, String tipo);
	
	@Query(nativeQuery= true,value="select * "
			+"from showcase "
			+ "where id_movie = ?1 and showdate = ?2")
	public List<Showcase> findByMoviedate(int id, Date date);
	
	@Query(nativeQuery= true,value="select * "
			+"from showcase "
			+ "where id_movie = ?1 and show_type= ?2 and showdate = ?3")
	public List<Showcase> findByMovietypedate(int id, String type, Date date);
	
	
	@Query(nativeQuery= true,value="select distinct showDate "
			+"from showcase ORDER BY showDate ASC")
	public List<String> findDistinctDate();

	
	public Showcase findOne(int id);
}
