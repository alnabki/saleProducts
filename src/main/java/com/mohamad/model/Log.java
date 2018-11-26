package com.mohamad.model;

import java.io.Serializable;

//MOHAMAD Code  
public class  Log implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String role;
	
	
	public Account account;


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
