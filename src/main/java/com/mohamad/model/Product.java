package com.mohamad.model;



import java.util.ArrayList;
import java.util.List;

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
    public String fileName;
	
	
	@Column(name="directory")
    public String directory;
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

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
	 
	 public List<String> CleanNameImage(String fileName){
		 List<String> imageNames = new ArrayList<String>();
		 if(fileName != null && !fileName.isEmpty()) {
		    	String test = fileName; 
		    	test= test.replaceAll("[\\[\\],(){}]","");  
		    	String[] arr = test.split(" ");  
		     
		    	for ( String imageName : arr) {
		    	    System.out.println(imageName);
		    	    imageNames.add(imageName);
		    	}
	    	 }
		  return imageNames;
	 }
}
