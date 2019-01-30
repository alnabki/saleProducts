package com.mohamad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="cart")
public class Basket {
	
	
	@Id
    @GeneratedValue
    
	 @Column(name="id")
	 public int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	public Account account;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = true)
	public Order order;


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


}
