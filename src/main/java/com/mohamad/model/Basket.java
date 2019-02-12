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
	
	 



	@Column(name="product_id")
	 public int productId;
	
	@Column(name="quantity_shop")
	 public int quantityShop;
	
	@Column(name="price")
	 public int price;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	public Account account;
	
	
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantityShop() {
		return quantityShop;
	}

	public void setQuantityShop(int quantityShop) {
		this.quantityShop = quantityShop;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

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

	

	
	


	

}
