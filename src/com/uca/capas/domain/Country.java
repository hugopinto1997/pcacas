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
@Table(schema="public",name="COUNTRY")
public class Country {
	
	@Id 
	@GeneratedValue(generator="country_id_country_seq",strategy= GenerationType.AUTO)
	@SequenceGenerator(name="country_id_country_seq",sequenceName= "public.country_id_country_seq",allocationSize=1)
    @Column(name="id_country")
    private Integer IdCountry;
	
	@Column(name="countryName")
    private String Country;
	
	@OneToMany(mappedBy="Country",fetch= FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.PERSIST)
	private List<User> Users;
	
	//Setters and Getters

	public Integer getIdCountry() {
		return IdCountry;
	}

	public void setIdCountry(Integer idCountry) {
		IdCountry = idCountry;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public List<User> getUsers() {
		return Users;
	}

	public void setUsers(List<User> users) {
		Users = users;
	}
	

}
