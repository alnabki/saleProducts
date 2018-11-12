package com.mohamad.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.mohamad.model.Account;
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

	  
	
	}