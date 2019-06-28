package com.uca.capas.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.User;
import com.uca.capas.dto.UserDTO;
import com.uca.capas.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository Users;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> findALL() throws DataAccessException {
		
		return Users.findCliente();
	}

	@Override
	public User findUserandPass(String usuario, String clave) throws DataAccessException {
		
		return Users.findUserandPass(usuario, clave);
	}

	@Override
	@Transactional
	public void UpdateU(int id) throws DataAccessException {
		User user = Users.findOne(id);
		if(user.getStateU().equals("Inactivo")) {
			user.setState(true);
		}
		user.setComment(" ");
		entityManager.merge(user);
		entityManager.flush();
		
		
	}

	@Override
	public UserDTO mapDTO(int id) {
		User user = Users.findOne(id);
		UserDTO u = new UserDTO();
		u.setIdUser(user.getIdUser());
		u.setComment(user.getComment());
		return u;
	}

	@Override
	public User findOne(int id) throws DataAccessException {
		
		return Users.findOne(id);
	}

	@Override
	@Transactional
	public void UpdateC(UserDTO u) throws DataAccessException {
		User user = Users.findOne(u.getIdUser());
		user.setState(false);
		user.setComment(u.getComment());
		entityManager.merge(user);
		entityManager.flush();
		
	}

	@Override
	@Transactional
	public void UpdateS(int id) throws DataAccessException {
		User user = Users.findOne(id);
		if(user.getSeccion()) {
			user.setSeccion(false);		}
		else {
			user.setSeccion(true);
		}
		entityManager.merge(user);
		entityManager.flush();
		
		
	}

	@Override
	public User findOneAdmin() throws DataAccessException {
		return Users.findAdmin();
	}

}
