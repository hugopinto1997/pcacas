package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	
	@Query(nativeQuery= true,value="select * "
			+"from USR "
			+ "where username = ?1 and password = ?2")
    public User findUserandPass(String username, String clave);
	
	public User findOne(int id);
	
	@Query(nativeQuery= true,value="select * "
			+"from USR "
			+ "where accountType = 'cliente'")
    public List<User> findCliente();
	
	@Query(nativeQuery= true,value="select * "
			+"from USR "
			+ "where accountType = 'admin'")
    public User findAdmin();

}
