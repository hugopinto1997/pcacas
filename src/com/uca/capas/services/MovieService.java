package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Movie;
import com.uca.capas.dto.MovieDTO;

@Service
public interface MovieService {
	
	public List<Movie> findALL() throws DataAccessException;
	public List<Movie> findALLACTIVE() throws DataAccessException;

	
	public Movie findOne(int id) throws DataAccessException;
	
	public MovieDTO MapDTO(int id) throws DataAccessException;
	
	public void Update(MovieDTO M) throws DataAccessException;
	
	public void UpdateS(int id) throws DataAccessException;
	
	public void Add(MovieDTO M) throws DataAccessException;

}
