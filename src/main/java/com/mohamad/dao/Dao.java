package com.mohamad.dao;

import java.util.List;

import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Customer;
import com.mohamad.model.Product;

public interface Dao {

	public void addAccount(Account account);
	void updateAccount(Account account);
	public List<Account> getAllAccounts();
	public void deleteAccount(Integer accountId);
	
	public void addAdmin(Admin admin);
	public List<Admin> getAllAdmins();
	public void deleteAdmin(Integer adminId);
	public void updateAdmin(Admin admin);
	
	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public void deleteProduct(Integer productId);
	public void updateProduct(Product product);
	
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public void deleteCustomer(Integer customerId);
	public void updateCustomer(Customer customer);
	public Account checkLogin(String username, String password);
	public List<Admin> getAdminsByAccountId(int accountId);
}
