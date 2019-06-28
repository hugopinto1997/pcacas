package com.uca.capas.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="SEAT")
public class Seat {

	@Id 
	@GeneratedValue(generator="seat_id_seat_seq",strategy= GenerationType.AUTO)
	@SequenceGenerator(name="seat_id_seat_seq",sequenceName= "public.seat_id_seat_seq",allocationSize=1)
    @Column(name="id_seat")
    private Integer IdSeat;
	
	@Column(name="seatType")
    private String seatType;
	
	@Column(name="seatNum")
    private BigInteger seatNum;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_cinema")
	private Cinema Cinema;
	
	//Setters and Getters

	public Integer getIdSeat() {
		return IdSeat;
	}

	public void setIdSeat(Integer idSeat) {
		IdSeat = idSeat;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public BigInteger getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(BigInteger seatNum) {
		this.seatNum = seatNum;
	}

	public Cinema getCinema() {
		return Cinema;
	}

	public void setCinema(Cinema cinema) {
		Cinema = cinema;
	}
	
}
