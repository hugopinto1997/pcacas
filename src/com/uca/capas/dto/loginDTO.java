package com.uca.capas.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class loginDTO {
	
	@NotEmpty(message="El usuario es requerido")
	@Size(message="Ha pasado el maximo de 30 caracteres",max=30)
    private String user;
	 
	 @NotEmpty(message="La contraseña es requerida")
	 @Size(message="Ha pasado el maximo de 30 caracteres",max=30)
     private String clave;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
