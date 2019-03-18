package com.mohamad.dao;

import java.util.List;

import com.mohamad.model.Account;
import com.mohamad.model.AddressDelivery;
import com.mohamad.model.Admin;
import com.mohamad.model.Basket;
import com.mohamad.model.Customer;
import com.mohamad.model.Order;
import com.mohamad.model.Product;

public interface Dao {

	public void addAccount(Account account);
	void updateAccount(Account account);
	public List<Account> getAllAccounts();
	public void deleteAccount(int accountId);
	public Account getAccountById(int id);
	
	public void addAddressDelivery(AddressDelivery addressDelivery);
	public void updateAddressDelivery(AddressDelivery addressDelivery);
	public List<AddressDelivery> getAllAddressDeliverys();
	public void deleteAddressDelivery(int id);
	public AddressDelivery getAddressDeliveryById(int id);
	
	public void addAdmin(Admin admin);
	public List<Admin> getAllAdmins();
	public void deleteAdmin(int adminId);
	public void updateAdmin(Admin admin);
	
	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public void deleteProduct(int productId);
	public void updateProduct(Product product);
	public Product getProductById(int id);
	
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public void deleteCustomer(int customerId);
	public void updateCustomer(Customer customer);
	public Account checkLogin(String username, String password);
	public Account checkEmail(String email);
	public List<Admin> getAdminsByAccountId(int accountId);
	
	public void addOrder(Order order);
	public List<Order> getAllOrders();
	public void deleteOrde(int orderId);
	public void updateOrder(Order order);
	
	
	public void addToBasket(Basket basket);
	public List<Basket> getAllBaskets();
	public void deleteBasketById(int basketId);
	public void updateBasket(Basket basket);
	public Basket getBasketById(int id);
	public List<Basket> getBasketByAccountId(int accountId);
	public List<Basket> getBasketByProductIdAccountId(int productId, int accountId);
	
}
