package com.mohamad.controller;



import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.mohamad.model.Account;
import com.mohamad.model.Admin;
import com.mohamad.model.Customer;
import com.mohamad.model.SaleFileUpload;
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
	   
		@RequestMapping(value="/addproduct")
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
		 public ModelAndView update(@ModelAttribute("product") Product product) {	
			System.out.println(product.id);
			ModelAndView model = new ModelAndView("editProduct2");
		     if(null != product ) {	
		    	 List<String> imageNames = new ArrayList<String>();
		    	 imageNames=product.CleanNameImage(product.fileName);
			      model.addObject("imageNames",imageNames);
		     }
		       System.out.println(product.id);
		       saleManager.updateProduct(product);
	         
		     return model;		     	
	    }
		@RequestMapping(value="/deleteproduct")
	    public String deleteproduct(@RequestParam(value="id", required=true) int id) {
	       saleManager.deleteProduct(id);
	        return "redirect:addproduct";	 
	    }
		@SuppressWarnings("null")
		@RequestMapping(value="/getproduct")
	    public ModelAndView getproduct(@RequestParam(value="id", required=true) int id) {
	        Product product = saleManager.getProduct(id);
	    	System.out.println("name= "+ product.name);
	    	  ModelAndView model = new ModelAndView("editProduct");
	    	  
	     if(null != product ) {	  
	    	 List<String> imageNames = new ArrayList<String>();
	    	 imageNames=product.CleanNameImage(product.fileName);
	    	 model.addObject("imageNames",imageNames);
	    	}
	     
	        model.addObject("product", product);
	        return model;	 
	    }
		
		 @RequestMapping(value="/viewsales")
		   public ModelAndView viewSales(HttpSession session) {
				Log log = (Log)session.getAttribute("log");
				if(log != null && ( log.role == "Admin" )) {
			        	ModelAndView model = new ModelAndView("viewSales");
			            List<Order> orders=saleManager.getAllOrders();
				 	    model.addObject("log.role",log.role);
				 	    model.addObject("orders", orders);
				 	    return model;
			     }
				
				else {
			    	ModelAndView model2 = new ModelAndView("notlogin");
					return model2;
				}
		 	}	
		 @RequestMapping(value="/managecustomers")
		   public ModelAndView manageAccounts(HttpSession session) {
				Log log = (Log)session.getAttribute("log");
				if(log != null && ( log.role == "Admin" )) {
			        	ModelAndView model = new ModelAndView("manageCustomers");
			            List<Customer> customers=saleManager.getAllCustomers();
				 	    model.addObject("log.role",log.role);
				 	    model.addObject("customers", customers);
				 	    return model;
			     }
				else {
			    	ModelAndView model2 = new ModelAndView("notlogin");
					return model2;
				}
		 	}	
		 @RequestMapping(value="/deletecustomer")
		    public String deletecustomer(@RequestParam(value="id", required=true) int id) {
		       saleManager.deleteCustomer(id);
		        return "redirect:managecustomers";	 
		    }
		 
		 
		 @RequestMapping(value = "/addproduct" ,method = RequestMethod.POST)
		 public String addproduct(@ModelAttribute("product") Product product,@Validated Product product1, BindingResult bindingResult) {
			product1=product;
			product.validate(product1, bindingResult); 
			if (bindingResult.hasErrors()) {
	        	 return "redirect:addproduct";
	        }
	        else {
		    saleManager.addProduct(product1);
		    return "redirect:addproduct";
	        }
			
		}
		 
		 @RequestMapping(value = "/upload", method = RequestMethod.GET)
		    public String DisplayForm() {
		        return "addProduct";
		    }
		 
		    @SuppressWarnings("null")
			@RequestMapping(value = "/savefiles&update", method = RequestMethod.POST,params = { "savefiles" })
		    public ModelAndView crunchifySave(HttpSession session,@ModelAttribute("uploadForm") SaleFileUpload uploadForm,Model map) throws IllegalStateException, IOException {
		            
		        String saveDirectory = "c:/Users/mohammad/eclipse-workspace/saleProducts/src/main/webapp/resources/images/";
		        List<MultipartFile> saleFiles = uploadForm.getFiles();
		        List<String> fileNames = new ArrayList<String>();
		       
		        if (null != saleFiles && saleFiles.size() > 0) {
		            for (MultipartFile multipartFile : saleFiles) {
		 
		                String fileName = multipartFile.getOriginalFilename();
		                   System.out.println(fileName);
		                   System.out.println(saveDirectory);
		                  
		                if (!"".equalsIgnoreCase(fileName)) {
		                   //  Handle files.content - multipartFile.getInputStream();
		                    multipartFile.transferTo(new File(saveDirectory + fileName));
		                    fileNames.add(fileName);
		                    System.out.println(fileName);
		                }
		            }
		        }
		        map.addAttribute("files", fileNames);
		        Log log = (Log)session.getAttribute("log");
				if(log != null &&  log.role == "Admin" ) {	
			        	ModelAndView model = new ModelAndView("viewProductDetail2");
						List<Product> products= saleManager.getAllProducts();
						
						
						 model.addObject("fileNames",fileNames);	
				        model.addObject("products", products);	
				 	    model.addObject("log.role",log.role);
				 	    return model;
			        }
				
				else {
			 		ModelAndView model2 = new ModelAndView("notLoged");
			 		return model2;
				}
		        
		    }
		    @SuppressWarnings("null")
			@RequestMapping(value = "/savefiles&update", method = RequestMethod.POST,params = { "update" })
		    public ModelAndView crunchifyEdit(HttpSession session,@RequestParam(value="id", required=true) int id,@ModelAttribute("uploadForm") SaleFileUpload uploadForm,Model map) throws IllegalStateException, IOException {
		            
		        String saveDirectory = "c:/Users/mohammad/eclipse-workspace/saleProducts/src/main/webapp/resources/images/";
		        List<MultipartFile> saleFiles = uploadForm.getFiles();
		        List<String> fileNames = new ArrayList<String>();
		       
		        if (null != saleFiles && saleFiles.size() > 0) {
		            for (MultipartFile multipartFile : saleFiles) {
		 
		                String fileName = multipartFile.getOriginalFilename();
		                   System.out.println(fileName);
		                   System.out.println(saveDirectory);
		                  
		                if (!"".equalsIgnoreCase(fileName)) {
		                    // Handle file content - multipartFile.getInputStream()
		                    multipartFile.transferTo(new File(saveDirectory + fileName));
		                    fileNames.add(fileName);
		                    System.out.println(fileName);
		                   
		                }
		            }
		        }
		        map.addAttribute("files", fileNames);
		        Log log = (Log)session.getAttribute("log");
				if(log != null &&  log.role == "Admin" ) {	
			        	ModelAndView model = new ModelAndView("editProduct2");
						Product product=saleManager.getProduct(id);
					    model.addObject("fileNames",fileNames);
				        model.addObject("product", product);	
				 	    model.addObject("log.role",log.role);
				 	    return model;
			        }
				else {
			 		ModelAndView model2 = new ModelAndView("notLoged");
			 		return model2;
				}
		        
		    }
	}
