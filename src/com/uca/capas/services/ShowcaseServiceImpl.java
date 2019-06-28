package com.uca.capas.services;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.uca.capas.domain.Showcase;
import com.uca.capas.dto.ShowDTO;
import com.uca.capas.repositories.MovieRepository;
import com.uca.capas.repositories.ShowcaseRepository;

@Service
public class ShowcaseServiceImpl implements ShowcaseService {
	
	
	@Autowired
	ShowcaseRepository Show;
	
	@Autowired
	private EntityManager entityManager;
	

	@Autowired
	MovieRepository Movie;

	@Override
	public List<Showcase> findALL() throws DataAccessException {
		return Show.findAll();
	}
	
	@Override
	public List<Showcase> findAllPerMovie(int idf) throws DataAccessException
	{
		return Show.findByMovie(idf);
	}
	
	@Override
	public List<Showcase> findAllPerMovieFilter(int idf, String tipo, String fecha) throws DataAccessException {

		if(tipo.equals("Todas") && fecha.equals("Todas")) {
			return Show.findByMovie(idf);
		}
		if(!tipo.equals("Todas") && fecha.equals("Todas")) {
			return Show.findByMovietype(idf, tipo);
		}
		if(tipo.equals("Todas") && !fecha.equals("Todas")) {
			return Show.findByMoviedate(idf, Date.valueOf(fecha));
		}
		if(!tipo.equals("Todas") && !fecha.equals("Todas")) {
			return Show.findByMovietypedate(idf, tipo, Date.valueOf(fecha));
		}
		return null;
	}

	
	
	public List<String> fechas() throws DataAccessException{
		return Show.findDistinctDate();
	}

	@Override
	public ShowDTO MapDTO(int id) throws DataAccessException {
		Showcase show = Show.findOne(id);
		ShowDTO M = new ShowDTO();
		M.setIdShowcase(show.getIdShowcase());
		M.setShowType(show.getShowType());
		M.setShowDate(show.getShowDate());
		M.setShowHour(show.getnewHour());
		M.setIdMovie(show.getMovie().getIdMovie());
		return M;
	}

	@Override
	@Transactional
	public void UpdateS(ShowDTO M) throws DataAccessException {
		Showcase show = Show.findOne(M.getIdShowcase());
		show.setShowType(M.getShowType());
		show.setShowDate(M.getShowDate());
		show.setShowHour(M.getHourE());
		show.setMovie(Movie.findOne(M.getIdMovie()));
		
		entityManager.merge(show);
		entityManager.flush();
		
	}

	@Override
	@Transactional
	public void AddS(ShowDTO M) throws DataAccessException {
		Showcase show = new Showcase();
		show.setShowType(M.getShowType());
		show.setShowDate(M.getShowDate());
		show.setShowHour(M.getHourE());
		show.setMovie(Movie.findOne(M.getIdMovie()));
		
		entityManager.persist(show);
		entityManager.flush();
	}

}
