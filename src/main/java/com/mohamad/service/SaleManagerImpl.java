package com.mohamad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohamad.dao.Dao;
import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Customer;
import com.mohamad.model.Order;
import com.mohamad.model.Product;

@Service("saleManager")
public class SaleManagerImpl implements SaleManager {
	
			@Autowired
			 private Dao dao;
		
			@Transactional
			public void addAccount(Account account) {
				dao.addAccount(account);
			}
			
			
			public void updateAccount(Account account){
				dao.updateAccount(account);
			}
			
			public List<Account> getAllAccounts(){
				return dao.getAllAccounts();
			}
			public void deleteAccount(Integer accountId){
				dao.deleteAccount( accountId);
			}
			
			public void addAdmin(Admin admin){
				dao.addAdmin( admin);
			}
			public List<Admin> getAllAdmins(){
				return dao.getAllAdmins();
			}
			public void deleteAdmin(Integer adminId){
				dao.deleteAdmin( adminId);
			}
			public void updateAdmin(Admin admin){
				dao.updateAdmin( admin);
			}
			
			public void addProduct(Product product){
				dao.addProduct( product);
			}
			public List<Product> getAllProducts(){
				return dao.getAllProducts();
			}
			public void deleteProduct(Integer productId){
				dao.deleteProduct( productId);
			}
			public void updateProduct(Product product) {
				dao.updateProduct(product);
			}
		
			
			public void addCustomer(Customer customer){
				dao.addCustomer( customer);
			}
			public List<Customer> getAllCustomers(){
				return dao.getAllCustomers();
			}
			public void deleteCustomer(Integer customerId){
				dao.deleteCustomer( customerId);
			}
			public void updateCustomer(Customer customer){
				dao.updateCustomer( customer);
			}
			
			public Account checkLogin(String username, String password) {
				return dao.checkLogin(username,password);
			}
			public List<Admin> getAdminsByAccountId(int accountId){
			   return dao.getAdminsByAccountId(accountId);
			}
			
			public void addOrder(Order order) {
				dao.addOrder(order);
			}
			public List<Order> getAllOrders() {
				return dao.getAllOrders();
			}
			public void deleteOrde(Integer orderId) {
				dao.deleteOrde(orderId);
			}
			public void updateOrder(Order order) {
				dao.updateOrder(order);
			}
	}

