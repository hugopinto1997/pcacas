package com.uca.capas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="CINEMA")
public class Cinema {
	@Id 
	@GeneratedValue(generator="cinema_id_cinema_seq",strategy= GenerationType.AUTO)
	@SequenceGenerator(name="cinema_id_cinema_seq",sequenceName= "public.cinema_id_cinema_seq",allocationSize=1)
    @Column(name="id_cinema")
    private Integer IdCinema;
	
	@Column(name="cinema")
    private String Cinema;
	
	@OneToMany(mappedBy="Cinema",fetch= FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.PERSIST)
	private List<Seat> Seat;

	public Integer getIdCinema() {
		return IdCinema;
	}

	public void setIdCinema(Integer idCinema) {
		IdCinema = idCinema;
	}

	public String getCinema() {
		return Cinema;
	}

	public void setCinema(String cinema) {
		Cinema = cinema;
	}

	public List<Seat> getSeat() {
		return Seat;
	}

	public void setSeat(List<Seat> seat) {
		Seat = seat;
	}
	
	
	
	
}
