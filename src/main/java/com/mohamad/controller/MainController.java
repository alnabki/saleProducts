package com.mohamad.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Customer;
import com.mohamad.model.Log;
import com.mohamad.model.Order;
import com.mohamad.model.Product;
import com.mohamad.service.SaleManager;










	@Controller
	public class MainController {
	@Autowired
		
	@Resource(name = "saleManager")
	    private SaleManager saleManager;
	
		
		private static final Logger logger = LoggerFactory.getLogger(MainController.class);
		
		/**
		 * Simply selects the home view to render by returning its name.
		 */
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String home(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			return "index";
			
		}
		@RequestMapping(value="/index")
		   public ModelAndView test() {	
			String msg="hello i am mohamad";
		 	ModelAndView model = new ModelAndView("index","msg",msg);
		 	return model;
	   }
		
		
	   @RequestMapping(value = "/addaccount" ,method = RequestMethod.POST)
		  public String addaccount(@ModelAttribute("account") Account account) {
			
			Account account1= new Account();
			 account1.username="Mohamad";
			 account1.password="123";
		    saleManager.addAccount(account);
		
			return "redirect:index";
	    }
	   
	   @RequestMapping(value="/login")
	 	public ModelAndView  login(){
	 		ModelAndView model = new ModelAndView("login");
			return model;
	 	}  
	  
	
		@RequestMapping(value="/checklogin",method = RequestMethod.POST)
	 	public String  login(HttpSession session,@RequestParam(value="username", required=true) String  username,@RequestParam(value="password", required=true) String  password)   {	
	    Account  account=new Account();
	    account=saleManager.checkLogin(username,password);
	 		 if (account != null) {
	 			Admin admin=new Admin();
	 			Log log = new Log();
	 			log.account = account;
	 			List<Admin> admins =  saleManager.getAdminsByAccountId(account.id);
	 		
	 			for (Admin ad :admins) {
	 				admin=ad;
	 			}
	 			if( admin.id == 0 ) {
	 				
	 				log.role = "Customer";
	 			}
	 			else {
	 				log.role = "Admin" ;
	 			}
	 			
	 			session.setAttribute("log", log);
		 		session.setMaxInactiveInterval(-1);
		 		return "redirect:main";
	        }
	 		else {
				return "redirect:notlogin";
			}			
	 		
		}
	   
	   @RequestMapping(value="/main")
		public String main(HttpSession session) {
		   
			Log log = (Log)session.getAttribute("log");
			if(log != null) {
				if(log.role == "Admin") {
					
					return "redirect:admin";
				}else {
					session.getCreationTime();
					return "redirect:customer";
				}
			} 
			else {
				return "redirect:notlogin";
			}			
		}
	   
	   @RequestMapping(value="/admin")
	   public ModelAndView adminpage(HttpSession session) {
			Log log = (Log)session.getAttribute("log");
			if(log != null && ( log.role == "Admin" )) {
		        	ModelAndView model = new ModelAndView("admin");
		            List<Product> products=saleManager.getAllProducts();
		            List<Customer> customers=saleManager.getAllCustomers();
		            List<Order> orders=saleManager.getAllOrders();
			 	    model.addObject("log.role",log.role);
			 	    model.addObject("products", products);
			 	    model.addObject("customers", customers);
			 	    model.addObject("orders", orders);
			 	    return model;
		        }
			
			else {
		 		ModelAndView model2 = new ModelAndView("notlogin");
		 		return model2;
			}
	 	}	
	   @RequestMapping(value="/customer")
	   public ModelAndView customerpage(HttpSession session) {
			Log log = (Log)session.getAttribute("log");
			
			
			if(log != null && ( log.role == "Customer" )) {
		        	ModelAndView model = new ModelAndView("customer");
			 	   
		        	
		        	
			 	    model.addObject("log.role",log.role);
			 	    return model;
		        }
			else {
		 		ModelAndView model2 = new ModelAndView("notlogin");
		 		return model2;
			}
		
	 	}	   
	   
	  
	   
	   @RequestMapping(value="/notlogin")
		public ModelAndView notlogin() {
			ModelAndView model = new ModelAndView("notLoged");
			return model;			
		}
	   @RequestMapping(value="/logout")
		public String logout(HttpSession session) throws ParseException {
			Log log = (Log) session.getAttribute("log");
			if(log != null ) {
			session.removeAttribute("log");
			}
			return "redirect:login";			
		}
	   
		@RequestMapping(value="/addProduct")
		public ModelAndView addproduct(HttpSession session) {
			Log log = (Log)session.getAttribute("log");
			if(log != null &&  log.role == "Admin" ) {	
		        	ModelAndView model = new ModelAndView("addProduct");
			 	 
					List<Product> products= saleManager.getAllProducts();
			        model.addObject("products", products);	
			 	    model.addObject("log.role",log.role);
			 	    return model;
		        }
			else {
		 		ModelAndView model2 = new ModelAndView("notLoged");
		 		return model2;
			}
	 	}
		@RequestMapping(value = "/updateproduct" ,method = RequestMethod.POST)	
		 public String update(@ModelAttribute("product") Product product) {	
			System.out.println(product.id);
		     if(null != product ) {	
		    	 System.out.println(product.id);
		       saleManager.updateProduct(product);
	         }
		     return "redirect:addProduct";		     	
	    }
		@RequestMapping(value="/deleteproduct")
	    public String deleteproduct(@RequestParam(value="id", required=true) int id) {
	       saleManager.deleteProduct(id);
	        return "redirect:addProduct";	 
	    }
		@RequestMapping(value = "/addproduct" ,method = RequestMethod.POST)
		 public String addproduct(@ModelAttribute("product") Product product,@Validated Product product1, BindingResult bindingResult) {
			product1=product;
			product.validate(product1, bindingResult); 
			if (bindingResult.hasErrors()) {
	        	 return "redirect:addProduct";
	        }
	        else {
		    saleManager.addProduct(product1);
		    return "redirect:addProduct";
	        }
		}
	}
