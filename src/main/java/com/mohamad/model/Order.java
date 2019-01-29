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
	
	@Column(name="quantity")
	 public int quantity;
	 
	
	@Column(name="orders_time")
	 public long ordersDate;

	
	public long getOrdersDate() {
		return ordersDate;
	}
	public void setOrdersDate(long ordersDate) {
		this.ordersDate = ordersDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	public Account account;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = true)
	public Product product;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
