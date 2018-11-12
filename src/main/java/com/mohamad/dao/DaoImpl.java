package com.mohamad.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Customer;
import com.mohamad.model.Product;




public class DaoImpl implements Dao  {
	
	@Autowired
    private SessionFactory sessionFactory;

//Account Process	
	
	public void addAccount(Account account) {
		this.sessionFactory.getCurrentSession().save(account);
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		return this.sessionFactory.getCurrentSession().createQuery("from Account").list();
	}
	
	public void deleteAccount(Integer accountId) {
		Account account = (Account) sessionFactory.getCurrentSession().load(
				Account.class, accountId);
        if (null != account) {
        	this.sessionFactory.getCurrentSession().delete(account);
        }
    }
	
	public void updateAccount(Account account) {
		 Session session = sessionFactory.getCurrentSession();
		    try {
		        System.out.println("IN Update");
		        session.beginTransaction();
		        session.saveOrUpdate(account);
		        } catch (HibernateException e) {
		            e.printStackTrace();
		            session.getTransaction().rollback();
		        }
		    session.getTransaction().commit();
		}

	
// Admin Process	
	
	public void addAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
	}
	
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		return this.sessionFactory.getCurrentSession().createQuery("from Admin").list();
	}
	
	public void deleteAdmin(Integer adminId) {
		Admin admin = (Admin) sessionFactory.getCurrentSession().load(
				Admin.class, adminId);
        if (null != admin) {
        	this.sessionFactory.getCurrentSession().delete(admin);
        }
    }
	
	public void updateAdmin(Admin admin) {
		 Session session = sessionFactory.getCurrentSession();
		    try {
		        System.out.println("IN Update");
		        session.beginTransaction();
		        session.saveOrUpdate(admin);
		        } catch (HibernateException e) {
		            e.printStackTrace();
		            session.getTransaction().rollback();
		        }
		    session.getTransaction().commit();
		}

	
	
// Product Process
	
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
	}
	
		@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
			return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
		}
	
	
	public void deleteProduct(Integer productId) {
		Product product = (Product) sessionFactory.getCurrentSession().load(
				Product.class, productId);
        if (null != product) {
        	this.sessionFactory.getCurrentSession().delete(product);
        }
    }
	
	public void updateProduct(Product product) {
		 Session session = sessionFactory.getCurrentSession();
		    try {
		        System.out.println("IN Update");
		        session.beginTransaction();
		        session.saveOrUpdate(product);
		        } catch (HibernateException e) {
		            e.printStackTrace();
		            session.getTransaction().rollback();
		        }
		    session.getTransaction().commit();
		}
	
	
// Customer process
	
	public void addCustomer(Customer customer) {
		this.sessionFactory.getCurrentSession().save(customer);
	}
	
		@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		return this.sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}
	
	public void deleteCustomer(Integer customerId) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().load(
				Customer.class, customerId);
        if (null != customer) {
        	this.sessionFactory.getCurrentSession().delete(customer);
        }
    }
	
	public void updateCustomer(Customer customer) {
		 Session session = sessionFactory.getCurrentSession();
		    try {
		        System.out.println("IN Update");
		        session.beginTransaction();
		        session.saveOrUpdate(customer);
		        } catch (HibernateException e) {
		            e.printStackTrace();
		            session.getTransaction().rollback();
		        }
		    session.getTransaction().commit();
	}
}



