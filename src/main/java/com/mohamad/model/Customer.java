package com.mohamad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer  {

	
	/**
	 * 
	 */


	@Id
    @GeneratedValue
    
    @Column(name="id")
	 public int id;
	 
	@Column(name="name")
    public String name;
	
	@Column(name="email")
    public String email;
	
	@Column(name="password")
    public String password;
	
	@Column(name="address")
    public String address;
	
	@Column(name="age")
    public int age;
	
	

	@Column(name="phone")
    public long phone;

	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
