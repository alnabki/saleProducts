package com.mohamad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="order_t")
public class Order  {

	
	/**
	 * 
	 */


	@Id
    @GeneratedValue
    
    @Column(name="id")
	 public int id;
	 
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = true)
	public Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = true)
	public Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
