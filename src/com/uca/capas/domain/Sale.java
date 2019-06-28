package com.uca.capas.domain;

import java.math.BigDecimal;

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
@Table(schema="public",name="SALE")
public class Sale {

	@Id 
	@GeneratedValue(generator="sale_id_order_seq",strategy= GenerationType.AUTO)
	@SequenceGenerator(name="sale_id_order_seq",sequenceName= "public.sale_id_order_seq",allocationSize=1)
    @Column(name="id_order")
    private Integer IdUser;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User User;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_showcase")
	private Showcase ShowCase;
	
	@Column(name="total")
    private BigDecimal Total;
	
	@Column(name="subTotal")
    private BigDecimal SubTotal;
	
	@Column(name="accountTotal")
    private BigDecimal AccountTotal;
	
	//Setters and Getters

	public Integer getIdUser() {
		return IdUser;
	}

	public void setIdUser(Integer idUser) {
		IdUser = idUser;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public Showcase getShowCase() {
		return ShowCase;
	}

	public void setShowCase(Showcase showCase) {
		ShowCase = showCase;
	}

	public BigDecimal getTotal() {
		return Total;
	}

	public void setTotal(BigDecimal total) {
		Total = total;
	}

	public BigDecimal getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		SubTotal = subTotal;
	}

	public BigDecimal getAccountTotal() {
		return AccountTotal;
	}

	public void setAccountTotal(BigDecimal accountTotal) {
		AccountTotal = accountTotal;
	}
	
	
	
}
