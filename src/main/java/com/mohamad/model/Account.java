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
	
	@Column (name="first_name")
    public String firstName;
	
	@Column (name="last_name")
    public String lastName;
    
	@Column (name="password")
    public String password;

	@Column (name="email")
	public String email;
	
	@Column (name="age")
	public int age;
	
	@Column (name="phone")
	public int phone;
	
	@Column (name="address")
	public String address;
	
	@Column (name="postcode")
	public String postcode;
	
	@Column (name="city")
	public String city;
	
	
	
	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}
	@Column (name="country")
	public String country;

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
	
}
