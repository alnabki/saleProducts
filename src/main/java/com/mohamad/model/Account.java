package com.mohamad.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="account")
	public class Account  {
	/**
	 * 
	 */
	

	@Id
    @GeneratedValue
    
	@Column (name="id")
	public int id;
	
	@Column (name="first_name")
    public String firstName;
	
	@Column (name="last_name")
    public String lastName;
    
	@Column (name="password")
    public String password;

	@Column (name="email")
	public String email;
	
	@Column (name="confirm_email")
	public String confirmEmail;
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	
	
	
}
