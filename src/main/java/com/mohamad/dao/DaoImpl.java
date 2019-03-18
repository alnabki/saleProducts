package com.mohamad.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mohamad.model.Account;
import com.mohamad.model.AddressDelivery;
import com.mohamad.model.Admin;
import com.mohamad.model.Basket;
import com.mohamad.model.Customer;
import com.mohamad.model.Order;
import com.mohamad.model.Product;









@Repository
public class DaoImpl implements Dao  {
	
	@Autowired
    private SessionFactory sessionFactory;

//Account Process
	
	@Transactional
	public void addAccount(Account account) {
		this.sessionFactory.getCurrentSession().save(account);
	}
	@Transactional
	public Account getAccountById(int id) {
	    Session session = sessionFactory.getCurrentSession();
	    Account account=null;
	    System.out.println("IN GetIteam");
	    try {
	        System.out.println("IN GetIteam");
	        session.beginTransaction();
	        account = (Account) session.get(Account.class, id);
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	   //session.getTransaction().commit();
	    return account;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		return this.sessionFactory.getCurrentSession().createQuery("from Account").list();
	}
	@Transactional
	public void deleteAccount(int accountId) {
		Account account = (Account) sessionFactory.getCurrentSession().load(
				Account.class, accountId);
        if (null != account) {
        	this.sessionFactory.getCurrentSession().delete(account);
        }
    }
	@Transactional
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

// Address Delivery Process
	
	@Transactional
	public void addAddressDelivery(AddressDelivery addressDelivery) {
		this.sessionFactory.getCurrentSession().save(addressDelivery);
	}
	@Transactional
	public AddressDelivery getAddressDeliveryById(int id) {
	    Session session = sessionFactory.getCurrentSession();
	    AddressDelivery addressDelivery=null;
	    System.out.println("IN GetIteam");
	    try {
	        System.out.println("IN GetIteam");
	        session.beginTransaction();
	        addressDelivery = (AddressDelivery) session.get(AddressDelivery.class, id);
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	   //session.getTransaction().commit();
	    return addressDelivery;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<AddressDelivery> getAllAddressDeliverys(){
		return this.sessionFactory.getCurrentSession().createQuery("from AddressDelivery").list();
	}
	@Transactional
	public void deleteAddressDelivery(int id) {
		AddressDelivery addressDelivery = (AddressDelivery) sessionFactory.getCurrentSession().load(
				AddressDelivery.class, id);
        if (null != addressDelivery) {
        	this.sessionFactory.getCurrentSession().delete(addressDelivery);
        }
    }
	@Transactional
	public void updateAddressDelivery(AddressDelivery addressDelivery) {
		 Session session = sessionFactory.getCurrentSession();
		    try {
		        System.out.println("IN Update");
		        session.beginTransaction();
		        session.saveOrUpdate(addressDelivery);
		        } catch (HibernateException e) {
		            e.printStackTrace();
		            session.getTransaction().rollback();
		        }
		    session.getTransaction().commit();
		}

	
	
	
	
// Admin Process	
	@Transactional
	public void addAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		return this.sessionFactory.getCurrentSession().createQuery("from Admin").list();
	}
	@Transactional
	public void deleteAdmin(int adminId) {
		Admin admin = (Admin) sessionFactory.getCurrentSession().load(
				Admin.class, adminId);
        if (null != admin) {
        	this.sessionFactory.getCurrentSession().delete(admin);
        }
    }
	@Transactional
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
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
	}

	@Transactional
	public Product getProductById(int id) {
	    Session session = sessionFactory.getCurrentSession();
	    Product product=null;
	    System.out.println("IN GetIteam");
	    try {
	        System.out.println("IN GetIteam");
	        session.beginTransaction();
	        product = (Product) session.get(Product.class, id);
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	   //session.getTransaction().commit();
	    return product;
	}
	@Transactional
	@SuppressWarnings("unchecked")    
	public List<Product> getAllProducts() {
			return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
		}
	
	@Transactional
	public void deleteProduct(int productId) {
		Product product = (Product) sessionFactory.getCurrentSession().load(
				Product.class, productId);
        if (null != product) {
        	this.sessionFactory.getCurrentSession().delete(product);
        }
    }

	@Transactional
	public void updateProduct(Product product) {
		 Session session = sessionFactory.getCurrentSession();
		  System.out.println("IN Update");
		    try {
		        System.out.println("IN Update");
		        session.beginTransaction();
		        session.saveOrUpdate(product);
		        } catch (HibernateException e) {
		            e.printStackTrace();
		            session.getTransaction().rollback();
		        }
		
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
	public void deleteCustomer(int customerId) {
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
	public Account checkLogin(String email, String password) {
		    Session session = sessionFactory.getCurrentSession();
		    session.beginTransaction();
		    Account account=new Account();
		    List<Account> accounts = null;
		  
		    try {
		        System.out.println("IN LIST1");
		        accounts = (List<Account>)session.createQuery("from Account  ").list();
		        System.out.println("IN LIST2");
		        outer:
		        for(Account acc:accounts) {
			    	if(acc.email.equals(email) && acc.password.equals(password) ) {
			    		account=acc;
			    		System.out.println("IN LIST3");
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
	public Account checkEmail(String email) {
		    Session session = sessionFactory.getCurrentSession();
		    session.beginTransaction();
		    Account account=new Account();
		    List<Account> accounts = null;
		    try {
		        System.out.println("IN LIST");
		        accounts = (List<Account>)session.createQuery("from Account ").list();
		        outer:
		        for(Account acc:accounts) {
			    	if(acc.email.equals(email) /*&& acc.password.equals(password)*/ ) {
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
	public void addOrder(Order order) {
		this.sessionFactory.getCurrentSession().save(order);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		return this.sessionFactory.getCurrentSession().createQuery("from Order").list();
	}
	@Transactional
	public void deleteOrde(int orderId) {
		Order order = (Order) sessionFactory.getCurrentSession().load(
				Order.class, orderId);
        if (null != order) {
        	this.sessionFactory.getCurrentSession().delete(order);
        }
    }
	@Transactional
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
	
	// Product cardList
		@Transactional
		public void addToBasket(Basket basket) {
			this.sessionFactory.getCurrentSession().save(basket);
		}
        
		
		@Transactional
		public Basket getBasketById(int id) {
		    Session session = sessionFactory.getCurrentSession();
		    Basket basket=null;
		    System.out.println("IN GetIteam");
		    try {
		        System.out.println("IN GetIteam");
		        session.beginTransaction();
		        basket = (Basket) session.get(Basket.class, id);
		    } catch (HibernateException e) {
		        e.printStackTrace();
		        session.getTransaction().rollback();
		    }
		   //session.getTransaction().commit();
		   
		    
		    return basket;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<Basket> getBasketByProductIdAccountId(int productId, int accountId) {
			Session session = sessionFactory.getCurrentSession();
		    session.beginTransaction();
		    List<Basket> baskets = null;
		    try {
		        System.out.println("IN LIST");
		        baskets = (List<Basket>)session.createQuery("from Basket WHERE (product_id ="+ productId + " and status = 'New') or (product_id ="+ productId + " and account_id = "+accountId+")").list();
		
		    } catch (HibernateException e) {
		        e.printStackTrace();
		        session.getTransaction().rollback();
		    }
		    session.getTransaction().commit();
		    return baskets;
		}
		
		
		
		@Transactional
		@SuppressWarnings("unchecked")    
		public List<Basket> getAllBaskets() {
				return this.sessionFactory.getCurrentSession().createQuery("from Basket").list();
			}
		
		@Transactional
		public void deleteBasketById(int basketId) {
			System.out.println("har delete-1");
			Basket basket = (Basket) sessionFactory.getCurrentSession().load(
					Basket.class, basketId);
			System.out.println("har delete0");
	        if (null != basket) {
	        	System.out.println("har delete1");
	        	this.sessionFactory.getCurrentSession().delete(basket);
	        }
	    	System.out.println("har delete2");
	    }
	   
		
		@Transactional
		public void updateBasket(Basket basket) {
			 Session session = sessionFactory.getCurrentSession();
			  System.out.println("IN Update");
			    try {
			        System.out.println("IN Update");
			        session.beginTransaction();
			        session.saveOrUpdate(basket);
			        } catch (HibernateException e) {
			            e.printStackTrace();
			            session.getTransaction().rollback();
			        }
			
			}
		
		@Transactional
		@SuppressWarnings("unchecked")
		public List<Basket> getBasketByAccountId(int accountId) {
				Session session = sessionFactory.getCurrentSession();
			    session.beginTransaction();
			    List<Basket> baskets = null;
			    try {
			        System.out.println("IN LIST");
			        baskets = (List<Basket>)session.createQuery("from Basket where account_id="+accountId).list();
			        System.out.println("IN LIST");
			    } catch (HibernateException e) {
			        e.printStackTrace();
			        session.getTransaction().rollback();
			    }
			// session.getTransaction().commit();
			    return baskets;
			}
		
		
	
	}



