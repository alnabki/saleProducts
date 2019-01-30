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
	
	@Column(name="quantity")
	 public int quantity;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	public Account account;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = true)
	public Product product;


}
