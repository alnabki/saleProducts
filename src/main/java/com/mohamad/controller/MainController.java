package com.mohamad.controller;



import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
import com.mohamad.model.Basket;
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
		public ModelAndView home(HttpSession session,Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			session.setAttribute("i",0);
			ModelAndView model1 = new ModelAndView("index");
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			String formattedDate = dateFormat.format(date);
			List<Product> allProducts=saleManager.getAllProducts();
	         List<Product> productViews = new ArrayList<Product>();
				if(null != allProducts ) {	
					for (Product product: allProducts) {
						product.fileName=product.FirstImage(product.fileName);
						Product productView=product;
						  System.out.println( productView.name);
						  System.out.println( productView.name);
						productViews.add(productView);
			        }
				}
		 	  model1.addObject("productViews",productViews);
			
			model1.addObject("serverTime", formattedDate );
			return model1;
		}
		
		 @RequestMapping(value="/login")
		 	public ModelAndView  login(){
		 		ModelAndView model = new ModelAndView("login");
		 		
		 		
			 	    return model;
		    
		 	}  
		  
		
			@RequestMapping(value="/checklogin",method = RequestMethod.POST)
		 	public String  login(HttpSession session,@RequestParam(value="email", required=true) String  email,@RequestParam(value="password", required=true) String  password)   {	
		    Account  account=new Account();
		    account=saleManager.checkLogin(email,password);
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
			            List<Account> accounts=saleManager.getAllAccounts();
			            List<Order> orders=saleManager.getAllOrders();
				 	    model.addObject("log.role",log.role);
				 	    model.addObject("products", products);
				 	    model.addObject("accounts", accounts);
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
		   
		
		@RequestMapping(value = "/customer", method = RequestMethod.GET)
		public ModelAndView customer(HttpSession session) {
			
		
			List<Product> allProducts=saleManager.getAllProducts();
	        List<Product> productViews = new ArrayList<Product>();
			Log log = (Log)session.getAttribute("log");
			if(log != null && ( log.role == "Customer" )) {
				
					ModelAndView model1 = new ModelAndView("customer");
					if(null != allProducts ) {	
						for (Product product: allProducts) {
							product.fileName=product.FirstImage(product.fileName);
							Product productView=product;
							productViews.add(productView);
				        }
					}
			 	    model1.addObject("productViews",productViews);
			 	    model1.addObject("log.role",log.role);
					return model1;
				}
			    else {
				   ModelAndView model2 = new ModelAndView("notlogin");
		 		return model2;
			   }
		}
		
		
		
		
		
		
		
		
		
		
		
		@RequestMapping(value="/index")
		   public ModelAndView test(HttpSession session) {
			
			
			
			
			
			
		 	List<Product> allProducts=saleManager.getAllProducts();
	        List<Product> productViews = new ArrayList<Product>();
					ModelAndView model1 = new ModelAndView("index");
					if(null != allProducts ) {	
						for (Product product: allProducts) {
							product.fileName=product.FirstImage(product.fileName);
							Product productView=product;
							productViews.add(productView);
				        }
					}
			 	    model1.addObject("productViews",productViews);
					return model1;
	   }
		
		
	   
	   
	  
	   @RequestMapping(value = "/addaccount" ,method = RequestMethod.POST)
		  public String addaccount(@ModelAttribute("account") Account account) {
			
			Account account1= new Account();
			 account1.username="Mohamad";
			 account1.password="123";
		    saleManager.addAccount(account);
		
			return "redirect:index";
	    }
	   @RequestMapping(value = "/addtobasket" ,method = RequestMethod.POST)
		  public String addtobasket(@ModelAttribute("BASKET") Basket basket) {
		    saleManager.addToBasket(basket);
			return "redirect:customer";
	    }
	   
	   
	   @RequestMapping(value = "/addtobasketasguest" ,method = RequestMethod.POST)
		  public String addtobasketasguest(HttpSession session,@ModelAttribute("log") Log log) {
		   log.role="Guest";
		   Log[] elementArray = (Log[]) Array.newInstance(Log.class, 10);
		   int i ;
		   i = (int) session.getAttribute("i");
		   if (i!=0) {
		    	i=i+1;
		    	Array.set(elementArray, i, log);
		    	session.setAttribute("i",i);
		    	session.setAttribute("p("+i+")",Array.get(elementArray,i));
		    }
		    else
		    {
		    	i=i+1;
		    	Array.set(elementArray, 1, log);
		    	session.setAttribute("p(1)",Array.get(elementArray,1));
		    	session.setAttribute("i",i);
		    }
		    session.setAttribute("cust",log.role);
	 		return "redirect:index";
	    }
	
	   @RequestMapping(value = "/basketasgest", method = RequestMethod.GET)
		public ModelAndView basketasguest(HttpSession session) {
		   ModelAndView model =new ModelAndView("basketAvGuest");
		   List<Log> logs = new ArrayList<Log>();
		    int i = (int) session.getAttribute("i");
		   int j=1;
		   while (  j <= i ) {
		       Log x=(Log) session.getAttribute("p("+j+")");
		       logs.add(x);
		       j=j+1;
		    }
		   String cust =  (String) session.getAttribute("cust");
		   model.addObject("cust",cust);
		   model.addObject("logs",logs);
		return model; 
		
		
	   }
	 
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
		public ModelAndView basket(HttpSession session) {
		   
			List<Product> allProducts=saleManager.getAllProducts();
	        List<Product> productViews = new ArrayList<Product>();
			Log log = (Log)session.getAttribute("log");
			 
			 if ( log == null ) {
				  ModelAndView model4 = new ModelAndView("basketAvGuest");
			 	  return model4;
			 }
					 
			 if  (log != null && ( log.role == "Guest" )) {
					ModelAndView model3 = new ModelAndView("basketAvGuest");
					
					
					if(null != allProducts ) {	
						for (Product product: allProducts) {
							product.fileName=product.FirstImage(product.fileName);
							Product productView=product;
							productViews.add(productView);
				        }
					}
				   
			 	    model3.addObject("productViews",productViews);
					return model3;
				  }
			
			if(log != null && ( log.role == "Customer" )) {
				ModelAndView model1 = new ModelAndView("basket");
				if(null != allProducts ) {	
					for (Product product: allProducts) {
						product.fileName=product.FirstImage(product.fileName);
						Product productView=product;
						productViews.add(productView);
			        }
				}
		 	    model1.addObject("productViews",productViews);
		 	    model1.addObject("log.role",log.role);
				return model1;
			}
			 
			  else {
				   ModelAndView model2 = new ModelAndView("notlogin");
		 		return model2;
			   }
		}
	   
	   @RequestMapping(value="/deleteorder")
	    public String deleteorder(@RequestParam(value="id", required=true) int id) {
	       saleManager.deleteOrde(id);
	        return "redirect:basket";	 
	    }
		@RequestMapping(value="/addproduct")
		public ModelAndView addproduct(HttpSession session) {
			Log log = (Log)session.getAttribute("log");
			if(log != null &&  log.role == "Admin" ) {	
		        	ModelAndView model = new ModelAndView("addProduct");
					List<Product> products= saleManager.getAllProducts();
					List<Product> productViews=new ArrayList<Product>();
					if(null != products ) {	
						
						for (Product product: products) {
							product.fileName=product.FirstImage(product.fileName);
							Product productView=product;
							  System.out.println( productView.name);
							  System.out.println( productView.name);
							productViews.add(productView);
				        }
						model.addObject("productViews",productViews);
					}
					
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
		 @RequestMapping(value="/viewallproducts")
		   public ModelAndView viewallproducts(HttpSession session) {
				Log log = (Log)session.getAttribute("log");
				if(log != null && ( log.role == "Admin" )) {
			        	ModelAndView model = new ModelAndView("viewAllProducts");
			            List<Product> allProducts=saleManager.getAllProducts();
			            List<Product> productViews = new ArrayList<Product>();
			            
						if(null != allProducts ) {	
							
							for (Product product: allProducts) {
								product.fileName=product.FirstImage(product.fileName);
								Product productView=product;
								  System.out.println( productView.name);
								  System.out.println( productView.name);
								productViews.add(productView);
					        }
							
						}
				 	    model.addObject("log.role",log.role);
				 	   model.addObject("productViews",productViews);
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
			            List<Account> accounts=saleManager.getAllAccounts();
				 	    model.addObject("log.role",log.role);
				 	    model.addObject("accounts", accounts);
				 	    return model;
			     }
				else {
			    	ModelAndView model2 = new ModelAndView("notlogin");
					return model2;
				}
		 	}	
		 @RequestMapping(value="/deleteaccount")
		    public String deleteaccount(@RequestParam(value="id", required=true) int id) {
		       saleManager.deleteAccount(id);
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
			        	ModelAndView model = new ModelAndView("addProduct2");
						List<Product> products= saleManager.getAllProducts();
						  List<Product> productViews = new ArrayList<Product>();
						if(null != products ) {	
							
							for (Product product: products) {
								product.fileName=product.FirstImage(product.fileName);
								Product productView=product;
								  System.out.println( productView.name);
								  System.out.println( productView.name);
								productViews.add(productView);
					        }
							model.addObject("productViews",productViews);
						}
						
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
