package com.mohamad.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Entity
@Table(name="products")
public class Product  {
	
	/**
	 * 
	 */
	

	@Id
    @GeneratedValue
    
    @Column(name="id")
	 public int id;
	
	@Column (name="product_name")
	public String name;
	
	@Column(name="price")
	public int price;
	
	@Column(name="quantity")
    public int quantity;
    
	@Column(name="image_name")
    public int fileName;
	
	@Column(name="directory")
    public int directory;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 public void validate(Object target, Errors errors) {
	       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "field.required");
	       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"price", "field.required");
	       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "field.required");
	       
	 }
}
