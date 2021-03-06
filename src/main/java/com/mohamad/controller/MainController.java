package com.mohamad.controller;






import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
import com.mohamad.model.AddressDelivery;
import com.mohamad.model.Admin;
import com.mohamad.model.Basket;
import com.mohamad.model.CrunchifyEmailAPI;
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
	    private int itemNummberInBasket=0;
	   	
	    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
				
				/**
				 * Simply selects the home view to render by returning its name.
				 */
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home(HttpSession session,Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
		    session.setAttribute("i",0);
		    session.removeAttribute("log");
		    
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
						productViews.add(productView);
			        }
				}
		    model1.addObject("productViews",productViews);
			model1.addObject("serverTime", formattedDate );
			return model1;
		}
		
		 @RequestMapping(value="/login")
		 	public ModelAndView  login(HttpSession session){
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
		 			    log.account.id=account.id;
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
					}else{
						session.getCreationTime();
						int i=(int) session.getAttribute("i");
		 				if(i!=0) {
			 				return "redirect:maineftershop";
			 			}
			 			else {
				 	   	    return "redirect:customer";
			 			}
					}
				} 
				else {
					return "redirect:notlogin";
				}			
			}
		  
		   @SuppressWarnings({ "unused", "rawtypes" })
		   @RequestMapping(value="/maineftershop")
			public String maineftershop(HttpSession session) {
			    Log log=(Log) session.getAttribute("log");
				List<Log> logs = new ArrayList<Log>();
				int i = (int) session.getAttribute("i");
				System.out.println("i="+i);
				 session.removeAttribute("log.numberOfTheItemsInTheBasket");
				log.numberOfTheItemsInTheBasket=i;
				session.setAttribute("log", log);
				Enumeration   keys = session.getAttributeNames();
				List<Basket>  baskets= new ArrayList<Basket>();
				baskets=saleManager.getBasketByAccountId(log.account.id);
				int sum=0;
				for(Basket basket2 : baskets) {
					 sum=sum+basket2.quantityShop;
		        }
	            while (keys.hasMoreElements()) {
	                String key = (String)keys.nextElement();
	                System.out.println(key + ": " + session.getAttribute(key) );
	                if (key.contentEquals("log.numberOfTheItemsInTheBasket") || key.contentEquals("i") || key.contentEquals("log")|| key.contentEquals("acc")) {
	            	
	                }
	                else {
	            	   Log x=(Log) session.getAttribute(""+key+"");
	            	   Basket basket= x.basket;
	            	   basket.account=log.account;
	            	    session.removeAttribute(""+key+"");
	            	    if (baskets.isEmpty()) {
	            	    	 saleManager.addToBasket(basket);
	            	    }
	            	    else {                     // for collection the items in the basket before login and after
							 boolean itemNotExist=true;
							 outer:
			                 for(Basket basket1 : baskets) {
						    	if(basket1.product.id == basket.product.id) {
						    		basket1.quantityShop=basket1.quantityShop+basket.quantityShop;
						    		saleManager.updateBasket(basket1);
						    	 /* System.out.println("basket1.quantityShop="+basket1.quantityShop);
						    		 System.out.println("log.numberOfTheItemsInTheBasketBeforSum="+log.numberOfTheItemsInTheBasket);
						    		log.numberOfTheItemsInTheBasket = basket1.quantityShop ;
								    System.out.println("itemNummberInBasket+="+itemNummberInBasket);
								    System.out.println("log.numberOfTheItemsInTheBasket="+log.numberOfTheItemsInTheBasket);
								    sum=sum+log.numberOfTheItemsInTheBasket;
									session.setAttribute("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);*/
									itemNotExist=false;
									break outer;
						    	}
			                 }
					    	 if(itemNotExist) {
					    		saleManager.addToBasket(basket);
					          	 /*log.numberOfTheItemsInTheBasket=basket.quantityShop +log.numberOfTheItemsInTheBasket;
					    		 sum=sum+log.numberOfTheItemsInTheBasket;
							     System.out.println("log.numberOfTheItemsInTheBasket="+log.numberOfTheItemsInTheBasket);*/
					    	 }
						}
	                }
	            }
	            log.numberOfTheItemsInTheBasket=sum+i;
	            session.setAttribute("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
	            System.out.println("sum="+sum);
	            System.out.println("i="+i);
	            System.out.println("log.numberOfTheItemsInTheBasket-finish="+log.numberOfTheItemsInTheBasket);
	            session.setAttribute("i", 0);
	            return "redirect:basket";
		   }
						
						
		   @RequestMapping(value="/admin")
		   public ModelAndView adminpage(HttpSession session) {
				Log log = (Log)session.getAttribute("log");
				if(log != null && ( log.role == "Admin" )) {
			        	ModelAndView model = new ModelAndView("admin");
			            List<Product> products=saleManager.getAllProducts();
			                         System.out.println("commant test1");
			            List<Account> accounts=saleManager.getAllAccounts();
			                            System.out.println("commant test1");
			            List<Order> orders=saleManager.getAllOrders();
			                           System.out.println("commant test2");
				 	    model.addObject("log.role",log.role);
				 	    model.addObject("products", products);
				 	    model.addObject("accounts", accounts);
				 	    model.addObject("orders", orders);
				 	   System.out.println("commant test3");
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
				session.removeAttribute("acc");
				}
				return "redirect:login";			
			}
		   
		   
		   
		   
		/*
		 * Customer Process
		 */
		   
		@RequestMapping(value = "/customer", method = RequestMethod.GET)
		public ModelAndView customer(HttpSession session) {
			Log log = (Log)session.getAttribute("log");
			List<Basket> baskets=saleManager.getAllBaskets();
			int counter=0;
			if(null != baskets ) {
				for (Basket basket: baskets) {
					
					if(basket.account.id==log.account.id) {
		                counter=counter+basket.quantityShop;
					}
				}
				log.numberOfTheItemsInTheBasket=counter;
			 }
			 else {
			    log.numberOfTheItemsInTheBasket=counter;
			 }
			List<Product> allProducts=saleManager.getAllProducts();
	        List<Product> productViews = new ArrayList<Product>();
	        
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
			 	    model1.addObject("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
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
		
	    @RequestMapping(value="/greataccount")
		 	public ModelAndView  greataccount(HttpSession session){
		 		ModelAndView model = new ModelAndView("greatAccount");
			 	return model;
		 	}  
		
		@RequestMapping(value="/greatnewaccount")
	 	public String  greataccount(HttpSession session,@ModelAttribute("Account") Account account){
			 Account acc=saleManager.checkEmail(account.email);
			 session.setAttribute("acc", acc);
			 if(   acc==null) {
			 		saleManager.addAccount(account);
			 		account=saleManager.checkLogin(account.email,account.password);
			 		if (account != null) {
			 			Log log = new Log();
			 			log.account = account;
			 			log.role = "Customer";
			 			session.setAttribute("log", log);
				 		session.setMaxInactiveInterval(-1);
				 		return "redirect:customer";
			 		}
			 		else {
						return "redirect:accountexist";
					}	
			 }
			 else {
					return "redirect:accountexist ";
			 }
	 }
		
		@RequestMapping(value="/accountexist")
	 	public ModelAndView  accountexist(HttpSession session){
	 		ModelAndView model = new ModelAndView("accountExist");
	 		Account acc=(Account) session.getAttribute("acc");
	 		model.addObject("acc",acc);
		 	return model;
	 	}  
		
		@RequestMapping(value="/forgetpassword")
	 	public ModelAndView  forgetpassword(HttpSession session){
	 		ModelAndView model = new ModelAndView("submitEmail");
		 	return model;
	 	}  
		@RequestMapping(value="/forgetpasswordwhentheloginfaild")
	 	public ModelAndView  forgetpasswordwhentheloginfaild(HttpSession session){
	 		ModelAndView model = new ModelAndView("submitEmailWhenTheLoginFaild");
		 	return model;
	 	}  
		
		 	
		@RequestMapping(value="/sendnewpasswordbyemail")
	 	public ModelAndView  sendnewpasswordbyemail(){
	 		ModelAndView model = new ModelAndView("passwordSent");
		 	return model;
	 	}  
		
		@SuppressWarnings("resource")
		@RequestMapping(value="/sendnewpasswordbyemailwhentheloginfaild",method=RequestMethod.POST)
		 	public ModelAndView  sendnewpasswordbyemailwhentheloginfaild(HttpSession session,@ModelAttribute("Account") Account account){
			 Account acc=saleManager.checkEmail(account.email);
			 session.setAttribute("acc", acc);
			ModelAndView model = new ModelAndView("passwordSentWhenTheLoginFaild");
			 if(acc !=null){
				
				// Spring Bean file you specified in /src/main/resources folder
					String crunchifyConfFile = "crunchify-bean.xml";
					ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
					
					// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
					CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");
					
					String toAddr = acc.email;
					String fromAddr = "systemcamera4you@gmail.com";
					
					// email subject
					String subject = "Hey.. This email sent for correct password";
			 
					// email body
					String body = "your email="+acc.email+"     "+
							"your password="+acc.password+"";
					crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
					String msg=" ";
					 model.addObject("msg",msg);
				} 
	            else
	            {
	            	System.out.println("hereyyyyyyyyyyyyyyy1");
	            	String msg="Please, Write correct email";
	            	 model.addObject("msg",msg);
	            }
			   
			 	return model;
		}
		
		@SuppressWarnings("resource")
			@RequestMapping(value="/sendnewpasswordbyemail",method=RequestMethod.POST)
			 	public ModelAndView  sendnewpasswordbyemail(HttpSession session,@ModelAttribute("Account") Account account){
			    ModelAndView model = new ModelAndView("passwordSent");			 
				Account acc=(Account) session.getAttribute("acc");
				 if(acc.email.equals(account.email)){
					 
					// Spring Bean file you specified in /src/main/resources folder
						String crunchifyConfFile = "crunchify-bean.xml";
						ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
						
						// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
						CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");
						
						String toAddr = acc.email;
						String fromAddr = "systemcamera4you@gmail.com";
						
						// email subject
						String subject = "Hey.. This email sent for correct password";
				 
						// email body
						String body = "your email="+acc.email+"     "+
								"your password="+acc.password+"";
						crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
						String msg=" ";
						 model.addObject("msg",msg);
					} 
		            else
		            {
		            	String msg="Please, Write correct email";
		            	 model.addObject("msg",msg);
		            }
				   
				 	return model;
			}
		
	   @RequestMapping(value = "/addtobasket" ,method = RequestMethod.POST)
		  public String addtobasket(HttpSession session,@ModelAttribute("BASKET") Basket basket) {
		    List<Basket>  baskets= new ArrayList<Basket>();
		    Log log=(Log) session.getAttribute("log");
		    baskets=saleManager.getBasketByAccountId(log.account.id);
		    if ( baskets.isEmpty()) {
		    	saleManager.addToBasket(basket);
			    log.numberOfTheItemsInTheBasket=basket.quantityShop;  
			    session.setAttribute("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
		    }
		    else {
		    	 boolean itemNotExist=true;
                 for(Basket basket1 : baskets) {
			    	if(basket1.product.id == basket.product.id) {
			    		basket1.quantityShop=basket.quantityShop+basket1.quantityShop;
			    		saleManager.updateBasket(basket1);
			    		log.numberOfTheItemsInTheBasket=basket.quantityShop +log.numberOfTheItemsInTheBasket;
					                                                    System.out.println("itemNummberInBasket"+itemNummberInBasket);
						session.setAttribute("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
						itemNotExist=false;
			    	}
                 }
		    	 if(itemNotExist) {
		    		saleManager.addToBasket(basket);
		    		log.numberOfTheItemsInTheBasket=basket.quantityShop +log.numberOfTheItemsInTheBasket;
				                                 System.out.println("log.numberOfTheItemsInTheBasket="+log.numberOfTheItemsInTheBasket);
				    session.setAttribute("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
		    	 }
	    	}
			return "redirect:customer";
	   }
	   
       @SuppressWarnings("unused")
	   @RequestMapping(value = "/basket", method = RequestMethod.GET)
		public ModelAndView basket(HttpSession session) {
		    List<Basket> baskets=saleManager.getAllBaskets();
	        List<Basket> basketViews = new ArrayList<Basket>();
			Log log = (Log)session.getAttribute("log");
			int i = (int)session.getAttribute("i");
			if(log != null && ( log.role == "Customer" )) {
				ModelAndView model1 = new ModelAndView("basket");
				int sum=0;
				if(null != baskets ) {
					for (Basket basket: baskets) {
						System.out.println("basket.account.id="+basket.account.id);
						System.out.println("log.basket.account.id="+log.account.id);
						if(basket.account.id==log.account.id) {
						   basket.product.fileName=basket.product.FirstImage(basket.product.fileName);
						   Basket basketView=basket;
						   basketViews.add(basketView);
						   basket.itemRequest =basket.quantityShop * basket.price;
		            	   sum=sum+basket.itemRequest;
						}
			        }
				}
		 	    model1.addObject("productViews",basketViews);
		 	    model1.addObject("log.role",log.role);
		 	    model1.addObject("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
		 	    model1.addObject("sum",sum);
				return model1;
			}
			else {
				   ModelAndView model2 = new ModelAndView("notlogin");
		 		return model2;
			}
	   }
	   
	   @RequestMapping(value="/deleteitemfromBasket")
	    public String deleteitemfromBasket(HttpSession session,@RequestParam(value="id", required=true) int id,@RequestParam(value="quantityShop", required=true) int quantityShop) {
		  Log log =(Log) session.getAttribute("log");
		  saleManager.deleteBasketById(id);
		  log.numberOfTheItemsInTheBasket=log.numberOfTheItemsInTheBasket-quantityShop;
		  session.setAttribute("log",log);
		  return "redirect:basket";
	   }
	   
	   @RequestMapping(value = "/deleteitemfrombasket&update", method = RequestMethod.POST,params = { "update" })
	    public String updateitemfrombasket(HttpSession session,@ModelAttribute("BASKET") Basket basket) {
		   Basket oldBasket=saleManager.getBasketById(basket.id);
		   saleManager.updateBasket(basket);
		   Log log=(Log) session.getAttribute("log");
		   if(oldBasket.quantityShop >= basket.quantityShop) {
		       log.numberOfTheItemsInTheBasket=log.numberOfTheItemsInTheBasket-(oldBasket.quantityShop-basket.quantityShop);
		   }
		   if(oldBasket.quantityShop <= basket.quantityShop) {
			   log.numberOfTheItemsInTheBasket=log.numberOfTheItemsInTheBasket+(basket.quantityShop-oldBasket.quantityShop);
		   }
		   session.setAttribute("log", log);
			return"redirect:basket";
	   }
	  
	   @SuppressWarnings("rawtypes")
	   @RequestMapping(value = "/addtobasketasguest" ,method = RequestMethod.POST)
		  public String addtobasketasguest(HttpSession session,@ModelAttribute("log") Log log) {
		   log.role="Guest";
		   Log[] elementArray = (Log[]) Array.newInstance(Log.class, 1000);
		   int i ;
		   i = (int) session.getAttribute("i");
		
	       Enumeration keys = session.getAttributeNames();
	       boolean check=false;
           while (keys.hasMoreElements()) {
               String key = (String)keys.nextElement();
               System.out.println(key + ": " + session.getAttribute(key) );
               if ( key.contentEquals("log.numberOfTheItemsInTheBasket") || key.contentEquals("i")|| key.contentEquals("acc")) {
            	   System.out.println("har=" );
               }
               else {
           	         Log x=(Log) session.getAttribute(""+key+"");
	           	     if (x.basket.product.id == log.basket.product.id){
	           	    	 i=i+log.basket.quantityShop;
	           	    	 log.basket.quantityShop=log.basket.quantityShop+x.basket.quantityShop;
	           	    	session.setAttribute("i",i);
	           	    	Array.set(elementArray, i, log);
	           	    	session.setAttribute("p("+log.basket.product.id+")",Array.get(elementArray,i));
	    		    	check=true;
	           	     }
	           	     else {
	           	    	 System.out.println("no thing to add");
           	         }
              }
           }
           if( check==false) {
				  if (i!=0 ) {
				    	i=log.basket.getQuantityShop()+i;
				    	Array.set(elementArray, i, log);
				    	session.setAttribute("i",i);
				    	session.setAttribute("p("+log.basket.product.id+")",Array.get(elementArray,i));
				    	
				   }
				  else  {
				    	i=log.basket.getQuantityShop();
				    	Array.set(elementArray, 1, log);
				    	session.setAttribute("p("+log.basket.product.id+")",Array.get(elementArray,1));
				    	session.setAttribute("i",i);
				  }
			 }
           return "redirect:index";
	   }
	   
       @SuppressWarnings("rawtypes")  
       @RequestMapping(value = "/basketasgest", method = RequestMethod.GET)
	   public ModelAndView basketasguest(HttpSession session) {
		   ModelAndView model =new ModelAndView("basketAvGuest");
		   List<Log> logs = new ArrayList<Log>();
		   int i = (int) session.getAttribute("i");
				Enumeration keys = session.getAttributeNames();
				int sum=0;
	            while (keys.hasMoreElements()) {
	                String key = (String)keys.nextElement();
	                System.out.println(key + ": " + session.getAttribute(key) );
	                if (key.contentEquals("log.numberOfTheItemsInTheBasket") || key.contentEquals("i")|| key.contentEquals("acc")) {
	            	    model.addObject("i",i);
	                }
	                else {
	            	    Log x=(Log) session.getAttribute(""+key+"");
	            	    x.itemPrice =x.basket.quantityShop * x.basket.price;
	            	    sum=sum+x.itemPrice;
		 		        logs.add(x);
		 		        // model.addObject("i",i);
	                }
	            }
	       model.addObject("logs",logs);
	       model.addObject("sum",sum);
		   return model;
	   }
	   
	   @RequestMapping(value="/deleteelement")
	    public String deletelement(HttpSession session,@RequestParam(value="id", required=true) int id) {
		   int i =(int) session.getAttribute("i");
		   Log x=(Log) session.getAttribute("p("+id+")");
		   i=i- x.basket.quantityShop;
		   session.removeAttribute("p("+id+")");
		   session.setAttribute("i",i);
		   return "redirect:basketasgest";
	   }
	   
	   @RequestMapping(value="/gotocheckout&updateforguest", method = RequestMethod.POST,params = { "updateForGuest" })
	   public String gotochekoutandupdateforguest (HttpSession session,@ModelAttribute("Log") Log log) { 
		   int i =(int) session.getAttribute("i");
		   System.out.println("here11");
		   Log x=(Log) session.getAttribute("p("+log.basket.product.id+")");
		   System.out.println("here12");
		   if(x.basket.quantityShop >= log.basket.quantityShop) {
		       i=i-(x.basket.quantityShop-log.basket.quantityShop);
		       System.out.println("x.basket.quantityShop="+x.basket.quantityShop);
		       System.out.println("log.basket.quantityShop="+log.basket.quantityShop);
		       System.out.println("here11="+i);
		       x.basket.quantityShop=log.basket.quantityShop;
		   }
		   else {
			   i=i+(log.basket.quantityShop-x.basket.quantityShop);
			   System.out.println("here11="+i);
			   x.basket.quantityShop=log.basket.quantityShop;
		   }
		   session.setAttribute("i",i);
		   session.setAttribute("p("+log.basket.product.id+")",x);
		   return "redirect:basketasgest";
	   }
	   
	   @RequestMapping(value="/deleteorder")
	    public String deleteorder(@RequestParam(value="id", required=true) int id) {
	       saleManager.deleteOrde(id);
	       return "redirect:basket";	 
	    }
	   
	   
	   
	   
	   
		   /*
		    *  Checkout For Customer
		    */
	      
	   @RequestMapping(value = "/addaddressdeliveryandcontinuetopay", method = RequestMethod.POST)
	    public String addaddressdeliveryandcontinuetopay(HttpSession session,@ModelAttribute("AddressDelivery") AddressDelivery addressDelivery) {
		  boolean  check=false;
		  List<AddressDelivery> addresses=saleManager.getAllAddressDeliverys();
		  for (AddressDelivery address :addresses) {
			 if  (address.account.id==addressDelivery.account.id) {
				 check=true;
			 }
		  }
		  if(check==false) {
		  saleManager.addAddressDelivery(addressDelivery);
		  }
		  else {
			  System.out.println("your address is registreted");
		  }
		  return "redirect:payment";  
	   }
	   
	   
	   @RequestMapping(value="/payment")
	   public ModelAndView payment (HttpSession session) {
		    List<Basket> baskets=saleManager.getAllBaskets();
	        List<Basket> basketViews = new ArrayList<Basket>();
			Log log = (Log)session.getAttribute("log");
			
			if(log != null && ( log.role == "Customer" )) {
				ModelAndView model1 = new ModelAndView("payment");
				int sum=0;
				if(null != baskets ) {
					for (Basket basket: baskets) {
						System.out.println("basket.account.id="+basket.account.id);
						System.out.println("log.basket.account.id="+log.account.id);
						if(basket.account.id==log.account.id) {
						   basket.product.fileName=basket.product.FirstImage(basket.product.fileName);
						   Basket basketView=basket;
						   basketViews.add(basketView);
						   basket.itemRequest =basket.quantityShop * basket.price;
		            	   sum=sum+basket.itemRequest;
		            	  List<AddressDelivery> addreses= saleManager.getAddressDeliveryByAccountId(basket.account.id);
		            	  model1.addObject("addreses",addreses);
						}
			        }
				}
				
				
				 
		 	    model1.addObject("productViews",basketViews);
		 	    model1.addObject("log.role",log.role);
		 	    model1.addObject("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
		 	    model1.addObject("sum",sum);
				return model1;
			}
			else {
				   ModelAndView model2 = new ModelAndView("notlogin");
		 		return model2;
			}
	   }
	   
	   @RequestMapping(value = "/deleteitemfrombasket&update", method = RequestMethod.POST,params = { "payforthisitem" })
	    public String payforthisitem(HttpSession session,@ModelAttribute("BASKET") Basket basket) {
		   
		   
		   
		  return null; 
	   }
	   
	   @RequestMapping(value="/gotocheckout")
	   public ModelAndView gotocheckout (HttpSession session) {
		    List<Basket> baskets=saleManager.getAllBaskets();
	        List<Basket> basketViews = new ArrayList<Basket>();
			Log log = (Log)session.getAttribute("log");
			
			if(log != null && ( log.role == "Customer" )) {
				ModelAndView model1 = new ModelAndView("checkout");
				int sum=0;
				if(null != baskets ) {
					for (Basket basket: baskets) {
						System.out.println("basket.account.id="+basket.account.id);
						System.out.println("log.basket.account.id="+log.account.id);
						if(basket.account.id==log.account.id) {
						   basket.product.fileName=basket.product.FirstImage(basket.product.fileName);
						   Basket basketView=basket;
						   basketViews.add(basketView);
						   basket.itemRequest =basket.quantityShop * basket.price;
		            	   sum=sum+basket.itemRequest;
						}
			        }
				}
		 	    model1.addObject("productViews",basketViews);
		 	    model1.addObject("log.role",log.role);
		 	    model1.addObject("log.numberOfTheItemsInTheBasket",log.numberOfTheItemsInTheBasket);
		 	    model1.addObject("sum",sum);
				return model1;
			}
			else {
				   ModelAndView model2 = new ModelAndView("notlogin");
		 		return model2;
			}
	   }
	   
	   

	   
	   /*
	    *  Checkout As Guest
	    */
	   
	   
	   @RequestMapping(value="/gotocheckout&updateforguest", method = RequestMethod.POST,params = { "gotocheckout" })
	   public String  gotochekoutforguest1 (HttpSession session,@ModelAttribute("Log") Log log) {
		
		   
		   
		   return null;  
	   }
	   
	   
	   
	   
	   
	   
	   
	   /*
	    *    Administrator Process 
	    */
	   
	   
	   @RequestMapping(value = "/addaccount" ,method = RequestMethod.POST)
		  public String addaccount(@ModelAttribute("account") Account account) {
			
			Account account1= new Account();
		    account1.firstName="Mohamad";
		    account1.lastName="alnabki";
		    account1.password="123";
		    saleManager.addAccount(account);
			return "redirect:index";
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
		
		@RequestMapping(value="/getproduct")
	    public ModelAndView getproduct(@RequestParam(value="id", required=true) int id) {
	        Product product = saleManager.getProductById(id);
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
		  
			@RequestMapping(value = "/savefiles&update", method = RequestMethod.POST,params = { "savefiles" })
		    public ModelAndView crunchifySave(HttpSession session,@ModelAttribute("uploadForm") SaleFileUpload uploadForm,Model map) throws IllegalStateException, IOException {
		            
		        String saveDirectory = "c:/Users/mohamad/eclipse-workspace/saleProducts/src/main/webapp/resources/images/";
		        List<MultipartFile> saleFiles = uploadForm.getFiles();
		        List<String> fileNames = new ArrayList<String>();
		        if (null != saleFiles && saleFiles.size() > 0) {
		            for (MultipartFile multipartFile : saleFiles) {
		                String fileName = multipartFile.getOriginalFilename();
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
			
			@RequestMapping(value = "/savefiles&update", method = RequestMethod.POST,params = { "update" })
		    public ModelAndView crunchifyEdit(HttpSession session,@RequestParam(value="id", required=true) int id,@ModelAttribute("uploadForm") SaleFileUpload uploadForm,Model map) throws IllegalStateException, IOException {
		        String saveDirectory = "c:/Users/mohamad/eclipse-workspace/saleProducts/src/main/webapp/resources/images/";
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
						Product product=saleManager.getProductById(id);
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
			 @SuppressWarnings("unused")
			   @RequestMapping(value = "/search", method = RequestMethod.GET)
				public ModelAndView search(HttpSession session) {
				 
				 ModelAndView model = new ModelAndView("searchResult");
				 return model;
				 
				 
			 }
	}
