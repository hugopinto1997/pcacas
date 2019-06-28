package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.User;
import com.uca.capas.dto.UserDTO;

@Service
public interface UserService {

  public List<User> findALL() throws DataAccessException;

  public User findUserandPass(String usuario, String clave) throws DataAccessException;
  
  public void UpdateU(int id) throws DataAccessException;
  
  public void UpdateC(UserDTO u) throws DataAccessException;
  
  public void UpdateS(int id) throws DataAccessException;
  
  public User findOne(int id) throws DataAccessException;
  
  public User findOneAdmin() throws DataAccessException;
  
  public UserDTO mapDTO	(int id);
}
