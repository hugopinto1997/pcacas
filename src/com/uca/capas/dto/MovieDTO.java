package com.uca.capas.dto;

import java.math.BigInteger;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class MovieDTO {
	
	private Integer IdMovie ;
	
	@NotEmpty(message="El nombre es requerido")
    @Size(message="Ha pasado el maximo de 100 caracteres",max=100)
    private String Name;
	
    @NotNull(message="La longitud es requerido")
    @PositiveOrZero(message="Solo Numeros Positivos")
    @Digits(fraction = 0, integer = 3,message="formato de longitud erronea. Solo tres digitos admitidos")
    @Range(min=80,max=200,message="Favor ingresar dentro del rango de 80  200")
    private BigInteger length;

    @NotNull(message="El estado es requerido")
    private String Status;
	
    @NotEmpty(message="La url de la imagen es requerida")
    private String image;
	
    @NotEmpty(message="La url del trailer es requerida")
    private String video;
	
	 public boolean getEstadoM() {
			if(this.Status.equals("Activo")) {
			return true;
		               }
			else {
				return false;
				}
			}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public BigInteger getLength() {
		return length;
	}

	public void setLength(BigInteger length) {
		this.length = length;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	 
	public Integer getIdMovie() {
		return IdMovie;
	}

	public void setIdMovie(Integer idMovie) {
		IdMovie = idMovie;
	}

	 

}
