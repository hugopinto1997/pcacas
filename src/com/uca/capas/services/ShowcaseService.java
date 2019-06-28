package com.uca.capas.services;

import java.sql.Date;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Showcase;
import com.uca.capas.dto.ShowDTO;

@Service
public interface ShowcaseService {
	
	public List<Showcase> findALL() throws DataAccessException;
	
	public List<String> fechas() throws DataAccessException;

	
	public List<Showcase> findAllPerMovie(int idf) throws DataAccessException;

	
	public List<Showcase> findAllPerMovieFilter(int idf, String tipo, String fecha) throws DataAccessException;

	public ShowDTO MapDTO(int id) throws DataAccessException;
	
	public void UpdateS(ShowDTO M) throws DataAccessException;
	
	public void AddS(ShowDTO M) throws DataAccessException;
	

}
