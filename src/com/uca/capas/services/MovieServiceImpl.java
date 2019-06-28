package com.uca.capas.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Movie;
import com.uca.capas.dto.MovieDTO;
import com.uca.capas.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository Movie;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Movie> findALL() throws DataAccessException {
		return Movie.findAll();
	}
	
	@Override
	public List<Movie> findALLACTIVE() throws DataAccessException {
		return Movie.findAllActive();
	}

	@Override
	public MovieDTO MapDTO(int id) throws DataAccessException {
		Movie movie = Movie.findOne(id);
		MovieDTO M = new MovieDTO();
		M.setIdMovie(movie.getIdMovie());
		M.setName(movie.getName());
		M.setLength(movie.getLength());
		M.setImage(movie.getImage());
		M.setVideo(movie.getVideo());
		return M;
	}

	@Override
	@Transactional
	public void Update(MovieDTO M) throws DataAccessException {
		Movie movie = Movie.findOne(M.getIdMovie());
		movie.setName(M.getName());
		movie.setLength(M.getLength());
		movie.setImage(M.getImage());
		movie.setVideo(M.getVideo());
		
		entityManager.merge(movie);
		entityManager.flush();
	}

	@Override
	@Transactional
	public void UpdateS(int id) throws DataAccessException {
		Movie movie = Movie.findOne(id);
		if(movie.getStateM().equals("Activo")) {
			movie.setStatus(false);
		}
		else {
			movie.setStatus(true);
		}
		entityManager.merge(movie);
		entityManager.flush();
		
	}

	@Override
	@Transactional
	public void Add(MovieDTO M) throws DataAccessException {
		Movie movie = new Movie();
		movie.setName(M.getName());
		movie.setLength(M.getLength());
		movie.setStatus(M.getEstadoM());
		movie.setImage(M.getImage());
		movie.setVideo(M.getVideo());
		
		entityManager.persist(movie);
		entityManager.flush();
	}

	@Override
	public com.uca.capas.domain.Movie findOne(int id) throws DataAccessException {
	
		return Movie.findOne(id);
	}

}
