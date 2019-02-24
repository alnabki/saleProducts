package com.mohamad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohamad.dao.Dao;
import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Basket;
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
			public void deleteAccount(int accountId){
				dao.deleteAccount( accountId);
			}
			
			
			
			
			
			public void addAdmin(Admin admin){
				dao.addAdmin( admin);
			}
			public List<Admin> getAllAdmins(){
				return dao.getAllAdmins();
			}
			public void deleteAdmin(int adminId){
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
			public void deleteProduct(int productId){
				dao.deleteProduct( productId);
			}
			public void updateProduct(Product product) {
				dao.updateProduct(product);
			}
			public Product getProduct(int id) {
				return dao.getProduct(id);
			}
		
			
			
			
			
			public void addCustomer(Customer customer){
				dao.addCustomer( customer);
			}
			public List<Customer> getAllCustomers(){
				return dao.getAllCustomers();
			}
			public void deleteCustomer(int customerId){
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
			public void deleteOrde(int orderId) {
				dao.deleteOrde(orderId);
			}
			public void updateOrder(Order order) {
				dao.updateOrder(order);
			}
			
			
			
			public void addToBasket(Basket basket){
				dao.addToBasket( basket);
			}
			public List<Basket> getAllBaskets(){
				return dao.getAllBaskets();
			}
			public void deleteBasketById(int productId){
				dao.deleteProduct( productId);
			}
			public void updateBasket(Basket basket) {
				dao.updateBasket(basket);
			}
			public Basket getBasketById(int id) {
				return dao.getBasketById(id);
			}
			
	}

