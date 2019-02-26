package com.mohamad.model;

import java.beans.Transient;
import java.util.List;

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
	
	 



	
	
	@Column(name="quantity_shop")
	 public int quantityShop;
	
	@Column(name="price")
	 public int price;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = true)
	public Account account;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = true)
	public Product product;
	
	
	
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	@Column(name="request_price")
	 public int itemRequest;
	 
	
		public int getItemRequest() {
			return itemRequest;
		}

		public void setItemRequest(int itemRequest) {
			this.itemRequest = itemRequest;
		}

	
	


	

}
