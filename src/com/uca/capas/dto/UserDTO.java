package com.uca.capas.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {
	
    private Integer idUser ;
	
	@NotEmpty(message="El comentario es requerido")
    @Size(message="Ha pasado el maximo de 100 caracteres",max=100)
    private String Comment;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
	
	

}
