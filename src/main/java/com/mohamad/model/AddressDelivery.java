package com.mohamad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="address_delivery")
public class AddressDelivery {



	
	/**
	 * 
	 */
	

	@Id
    @GeneratedValue
    
	@Column (name="id")
	public int id;
	
	@Column (name="account_id")
	public int accountId;
	
	@Column (name="order_id")
	public int orderId;
	
	@Column (name="first_name")
    public String firstName;
	
	@Column (name="last_name")
    public String lastName;
	
	@Column (name="person_number")
	public String personNumber;
	
	@Column (name="c_o")
	public String cO;
	
	@Column (name="street_address")
	public String streetAddress;
	
	@Column (name="zip_code")
	public String zipCode;
	
	@Column (name="city")
	public String city;
	
	@Column (name="door_code")
	public String doorCode;
	
	@Column (name="email")
	public String email;
	
	@Column (name="phone")
	public int phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

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

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public String getcO() {
		return cO;
	}

	public void setcO(String cO) {
		this.cO = cO;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDoorCode() {
		return doorCode;
	}

	public void setDoorCode(String doorCode) {
		this.doorCode = doorCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	
}
	