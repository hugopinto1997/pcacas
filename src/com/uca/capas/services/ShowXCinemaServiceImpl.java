package com.uca.capas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.ShowXCinema;
import com.uca.capas.repositories.ShowXCinemaRepository;

@Service
public class ShowXCinemaServiceImpl implements ShowXCinemaService {
	
	@Autowired
	ShowXCinemaRepository SXCRepository;
	
	public ShowXCinema getSXC(int idshowcase) throws DataAccessException{
		return SXCRepository.findOne(SXCRepository.findSXC(idshowcase).getIdSXC());
	}

}
