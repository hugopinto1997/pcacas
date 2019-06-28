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
@Table(schema="public",name="DEPARTMENT")
public class Department {
	

	@Id 
	@GeneratedValue(generator="department_id_department_seq",strategy= GenerationType.AUTO)
	@SequenceGenerator(name="department_id_department_seq",sequenceName= "public.department_id_department_seq",allocationSize=1)
    @Column(name="id_department")
    private Integer IdDepartment;
	
	@Column(name="departmentName")
    private String Department;
	
	@OneToMany(mappedBy="Department",fetch= FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.PERSIST)
	private List<User> Users;
	
	//Setters and Getters

	public Integer getIdDepartment() {
		return IdDepartment;
	}

	public void setIdDepartment(Integer idDepartment) {
		IdDepartment = idDepartment;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public List<User> getUsers() {
		return Users;
	}

	public void setUsers(List<User> users) {
		Users = users;
	}
	

}
