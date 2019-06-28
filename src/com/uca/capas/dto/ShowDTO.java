package com.uca.capas.dto;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ShowDTO {
	
	
    private Integer IdShowcase;
	
    @NotEmpty(message="El tipo de funcion es requerido")
    @Size(message="Ha pasado el maximo de 100 caracteres",max=100)
    private String ShowType;
	
    @NotNull(message="La Fecha es requerida")
    private Date ShowDate;
	
    @NotEmpty(message="El nombre es requerido")
    @Size(message="Ha pasado el maximo de 100 caracteres",max=5)
    private String ShowHour;
	
    @NotNull(message="La pelicula es requerida")
    @PositiveOrZero(message="Solo Numeros Positivos")
    @Digits(fraction = 0, integer = 2,message="formato de longitud erronea. Solo Dos digitos maximos admitidos")
	private Integer IdMovie;
    
	
	public Time getHourE(){
		if(this.ShowHour == null) {
			return null;
		}
		else {
			int hora = Integer.parseInt(ShowHour.substring(0,2));
			int min = Integer.parseInt(ShowHour.substring(3,5));
			Time HourS = new Time(hora,min,00);
			return HourS;
			}	
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

	public String getShowHour() {
		return ShowHour;
	}

	public void setShowHour(String showHour) {
		ShowHour = showHour;
	}

	public Integer getIdMovie() {
		return IdMovie;
	}

	public void setIdMovie(Integer idMovie) {
		IdMovie = idMovie;
	}
	
	

}
