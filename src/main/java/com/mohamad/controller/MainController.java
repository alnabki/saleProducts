package com.mohamad.controller;


import java.text.DateFormat;
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


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Log;
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
			
			return "home";
			
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
		//System.out.println(account.username);
			System.out.println("account="+account.username);
	 		 if (account != null) {
	 			System.out.println("account="+account.username);
	 			Admin admin=new Admin();
	 			Log log = new Log();
	 			log.account = account;
	 			System.out.println("account_id="+account.id);
	 			List<Admin> admins =  saleManager.getAdminsByAccountId(account.id);
	 			/*
	 			for (Admin ad :admins) {
	 				admin=ad;
	 			}
	 			if( admin.id == 0 ) {
	 				
	 				log.role = "Customer";
	 			}
	 			else {
	 				log.role = "Admin" ;
	 			}
	 			*/
	        }
	        
	 		return "redirect:login";
		}
	   
	   @RequestMapping(value="/main")
		public String main(HttpSession session) {

			Log log = (Log)session.getAttribute("log");
			if(log != null) {
				if(log.role == "Admin") {
					
					return "redirect:admin";
				}else {
					session.getCreationTime();
					return "redirect:employee";
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
			 	   // List<Project>projects = dio.getProjects();
			 		//List<Employee>employees = dio.getEmployees();
			 	//    model.addObject("projects", projects);	
			 	 //   model.addObject("employees", employees);
			 	    model.addObject("log.role",log.role);
			 	    return model;
		        }
			else {
		 		ModelAndView model2 = new ModelAndView("notLoged");
		 		return model2;
			}
		
	 	}	   
	}
