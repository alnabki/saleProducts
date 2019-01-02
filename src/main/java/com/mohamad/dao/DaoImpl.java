package com.mohamad.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Customer;
import com.mohamad.model.Order;
import com.mohamad.model.Product;




@Repository
public class DaoImpl implements Dao  {
	
	@Autowired
    private SessionFactory sessionFactory;

//Account Process
	
	@Transactional
	@SuppressWarnings("unchecked")
	public void addAccount(Account account) {
		this.sessionFactory.getCurrentSession().save(account);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		return this.sessionFactory.getCurrentSession().createQuery("from Account").list();
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public void deleteAccount(Integer accountId) {
		Account account = (Account) sessionFactory.getCurrentSession().load(
				Account.class, accountId);
        if (null != account) {
        	this.sessionFactory.getCurrentSession().delete(account);
        }
    }
	@Transactional
	@SuppressWarnings("unchecked")
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
	@Transactional
	@SuppressWarnings("unchecked")
	public void addAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		return this.sessionFactory.getCurrentSession().createQuery("from Admin").list();
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public void deleteAdmin(Integer adminId) {
		Admin admin = (Admin) sessionFactory.getCurrentSession().load(
				Admin.class, adminId);
        if (null != admin) {
        	this.sessionFactory.getCurrentSession().delete(admin);
        }
    }
	@Transactional
	@SuppressWarnings("unchecked")
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
	@Transactional
	@SuppressWarnings("unchecked")
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
	}
	@Transactional
	@SuppressWarnings("unchecked")    
	public List<Product> getAllProducts() {
			return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
		}
	
	@Transactional
	@SuppressWarnings("unchecked")    
	public void deleteProduct(Integer productId) {
		Product product = (Product) sessionFactory.getCurrentSession().load(
				Product.class, productId);
        if (null != product) {
        	this.sessionFactory.getCurrentSession().delete(product);
        }
    }
	@Transactional
	@SuppressWarnings("unchecked")
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
	@Transactional
	
	public void addCustomer(Customer customer) {
		this.sessionFactory.getCurrentSession().save(customer);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		return this.sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}
	
	@Transactional
	public void deleteCustomer(Integer customerId) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().load(
				Customer.class, customerId);
        if (null != customer) {
        	this.sessionFactory.getCurrentSession().delete(customer);
        }
    }
	@Transactional
	
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
	
	@Transactional
	@SuppressWarnings("unchecked")
	public Account checkLogin(String username, String password) {
		    Session session = sessionFactory.getCurrentSession();
		    session.beginTransaction();
		    Account account=new Account();
		    List<Account> accounts = null;
		    try {
		        System.out.println("IN LIST");
		        accounts = (List<Account>)session.createQuery("from Account ").list();
		        outer:
		        for(Account acc:accounts) {
			    	if(acc.username.equals(username) && acc.password.equals(password) ) {
			    		account=acc;
			    		System.out.println("IN LIST");
			    		break outer;
			        }
			    	else {
			    		account=null;
			    	}
		        }
		    }
   	 catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	  //  session.getTransaction().commit();	  
	    return account;
       }

	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Admin> getAdminsByAccountId(int accountId) {
			Session session = sessionFactory.getCurrentSession();
		    session.beginTransaction();
		    List<Admin> admins = null;
		    try {
		        System.out.println("IN LIST");
		        admins = (List<Admin>)session.createQuery("from Admin where account_id="+accountId).list();
		        System.out.println("IN LIST");
		    } catch (HibernateException e) {
		        e.printStackTrace();
		        session.getTransaction().rollback();
		    }
		// session.getTransaction().commit();
		    return admins;
		}

	
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public void addOrder(Order order) {
		this.sessionFactory.getCurrentSession().save(order);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		return this.sessionFactory.getCurrentSession().createQuery("from Order").list();
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public void deleteOrde(Integer orderId) {
		Order order = (Order) sessionFactory.getCurrentSession().load(
				Order.class, orderId);
        if (null != order) {
        	this.sessionFactory.getCurrentSession().delete(order);
        }
    }
	@Transactional
	@SuppressWarnings("unchecked")
	public void updateOrder(Order order) {
		 Session session = sessionFactory.getCurrentSession();
		    try {
		        System.out.println("IN Update");
		        session.beginTransaction();
		        session.saveOrUpdate(order);
		        } catch (HibernateException e) {
		            e.printStackTrace();
		            session.getTransaction().rollback();
		        }
		    session.getTransaction().commit();
		}
	
	}



