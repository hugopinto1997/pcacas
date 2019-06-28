package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Movie;
import com.uca.capas.domain.ShowXCinema;

@Service
public interface ShowXCinemaService {

	
	public ShowXCinema getSXC(int idshowcase) throws DataAccessException;

}
