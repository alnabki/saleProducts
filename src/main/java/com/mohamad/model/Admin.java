package com.mohamad.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_account")
public class Admin {

	/**
	 * 
	 */


	@Id
    @GeneratedValue
    
	@Column (name="id")
	public int id;
	
	@Column (name="account_id")
    public String accountId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
    
	
	
}
