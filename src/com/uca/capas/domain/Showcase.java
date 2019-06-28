package com.uca.capas.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="SHOWCASE")
public class Showcase {

	@Id 
	@GeneratedValue(generator="showcase_id_showcase_seq",strategy= GenerationType.AUTO)
	@SequenceGenerator(name="showcase_id_showcase_seq",sequenceName= "public.showcase_id_showcase_seq",allocationSize=1)
    @Column(name="id_showcase")
    private Integer IdShowcase;
	
	@Column(name="show_type")
    private String ShowType;
	
	@Column(name="showDate")
    private Date ShowDate;
	
	@Column(name="showHour")
    private Time ShowHour;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_movie")
	private Movie Movie;
	 
	@OneToMany(mappedBy="ShowCase",fetch= FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.PERSIST)
	private List<Sale> Sales;
	
	//Delegate methods
	public String getnewHour(){
		 return (String) ShowHour.toString().subSequence(0,5);
		}

	public Integer getIdShowcase() {
		return IdShowcase;
	}

	public void setIdShowcase(Integer idShowcase) {
		IdShowcase = idShowcase;
	}

	public String getShowType() {
		return ShowType;
	}

	public void setShowType(String showType) {
		ShowType = showType;
	}

	public Date getShowDate() {
		return ShowDate;
	}

	public void setShowDate(Date showDate) {
		ShowDate = showDate;
	}

	public Time getShowHour() {
		return ShowHour;
	}

	public void setShowHour(Time showHour) {
		ShowHour = showHour;
	}

	public Movie getMovie() {
		return Movie;
	}

	public void setMovie(Movie movie) {
		Movie = movie;
	}

	public List<Sale> getSales() {
		return Sales;
	}

	public void setSales(List<Sale> sales) {
		Sales = sales;
	}
	
}
