package com.mohamad.model;



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
	
	@Column (name="username")
    public String username;
    
	@Column (name="password")
    public String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
