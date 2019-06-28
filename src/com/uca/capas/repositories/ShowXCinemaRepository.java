package com.uca.capas.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.uca.capas.domain.ShowXCinema;

import com.uca.capas.domain.Showcase;

@Repository
public interface ShowXCinemaRepository extends JpaRepository<ShowXCinema, Integer> {
	@Query(nativeQuery= true,value="select * "
			+"from showxcinema "
			+ "where id_showcase = ?1")
	public ShowXCinema findSXC(int idshowcase);
	public ShowXCinema findOne(int idsxc);

}
