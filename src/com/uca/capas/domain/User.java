package com.uca.capas.domain;

import java.math.BigDecimal;
import java.sql.Date;
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
@Table(schema="public",name="USR")
public class User {

	@Id 
	@GeneratedValue(generator="usr_user_id_seq",strategy= GenerationType.AUTO)
	@SequenceGenerator(name="usr_user_id_seq",sequenceName= "public.usr_user_id_seq",allocationSize=1)
    @Column(name="user_id")
    private Integer IdUser;

	@Column(name="username")
    private String Username;
	
	@Column(name="password")
    private String password;
	
	@Column(name="birthDate")
    private Date cumple;
	
	@Column(name="balance")
    private BigDecimal Balance;
	
	@Column(name="f_name")
    private String Fname;
	
	@Column(name="L_name")
    private String Lname;
	
	@Column(name="comment")
    private String Comment;
	
	@Column(name="active")
    private boolean state;
	
	@Column(name="activeSession")
    private boolean seccion;
	
	@Column(name="municipality")
    private String Municipality;
	
	@Column(name="accountType")
    private String Account;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_department")
	private Department Department;
	 
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_country")
	private Country Country;
	 
	@OneToMany(mappedBy="User",fetch= FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.PERSIST)
	private List<Sale> Sales;
	
   
	
	//Delegate methods
	
	public String Municipio() {
		if(Municipality==null) return "N/A";
		else return Municipality;
	}

	public String getStateU() {
		if(this.state) {
		return "Activo";
	               }
		else {
			return "Inactivo";
			}
		}
	
	public String getFullName() {
		 if(Fname == null) setFname("N/A");
		 if(Lname == null) setLname("N/A");
		 return Fname.concat(" ").concat(Lname);
		}
	
	//Setters and Getters
	 
	public Integer getIdUser() {
		return IdUser;
	}

	public void setIdUser(Integer idUser) {
		IdUser = idUser;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCumple() {
		return cumple;
	}

	public void setCumple(Date cumple) {
		this.cumple = cumple;
	}

	public BigDecimal getBalance() {
		return Balance;
	}

	public void setBalance(BigDecimal balance) {
		Balance = balance;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMunicipality() {
		return Municipality;
	}

	public void setMunicipality(String municipality) {
		Municipality = municipality;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}
	
	public Department getDepartment() {
		return Department;
	}

	public void setDepartment(Department department) {
		Department = department;
	}

	public Country getCountry() {
		return Country;
	}

	public void setCountry(Country country) {
		Country = country;
	}
	
	public List<Sale> getSales() {
		return Sales;
	}

	public void setSales(List<Sale> sales) {
		Sales = sales;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public boolean getSeccion() {
		return seccion;
	}

	public void setSeccion(boolean seccion) {
		this.seccion = seccion;
	}
	
	

}
