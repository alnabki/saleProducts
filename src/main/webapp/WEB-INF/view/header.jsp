<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>        
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://kit.fontawesome.com/f11e7fef2e.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>

<title>Insert title here</title>
</head>
<body>
    
  
   <div>  
       <c:if test='${ log.role =="Customer"  }' >
          
	   <nav id="mainNav" class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="index">BRAND NAME</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="index"><i class="fas fa-home mr-2"></i>Home<span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="fas fa-envelope mr-2"></i> Contact</a>
                    </li>
               
		             <li class="nav-item active">
		              <a href="logout"> <i class="fa fa-fw fa-user"> </i> ${log.account.firstName } ${log.account.lastName } <button> Logout</button>   </a> 
		             </li>
		             
		        </ul>
		     </div> 
		     
	         <form:form class="form-inline my-2 my-lg-0" name="getForm"  action="search"  method="get" modelAttribute="product">
	             <i class="fa fa-fw fa-search"></i>
	             <input class="form-control mr-sm-2" type="text" placeholder="Search1"  aria-label="Search">
	            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	         </form:form>
	                   <div >
	                 
                         
               
                          <a  class="nav-link" href="basket">   <button   class="btn btn-outline-primary my-2 my-sm-0" ><i class="fas fa-shopping-basket mr-2"></i>Basket(${log.numberOfTheItemsInTheBasket })</button>    </a>
                  
		              
		     		  </div>
		     		  
		     		  
		     		  
		        <ul class="navbar-nav mt-2 mt-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link active dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user mr-2"></i>Profile</a>
                        <div class="dropdown-menu" aria-labelledby="dropdownId">
                            <a class="dropdown-item" href="#"><i class="fas fa-shopping-basket mr-2"></i>Basket(NUMBER)</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-key mr-2"></i>Reset password</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt mr-2"></i>Sign out</a>
                        </div>
                        
                    </li>
                </ul>
		     		   </nav>
		     		   
		     		   
       </c:if>
     
      </div>
     
     
     <c:if test='${ log.role =="Admin"   }' >
            <div class="navbar">
				  <a class="active" href="admin"><i class="fa fa-fw fa-home"></i> Home</a> 
				   <a href="logout"><i class="fa fa-fw fa-user"> </i> ${log.account.firstName } ${log.account.lastName }[Admin Account] <button> Logout</button>   </a> 
		    </div>
		   
     </c:if>
     
     <c:if test='${ log == null   }' >
     
      <nav id="mainNav" class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="index">BRAND NAME</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="index"><i class="fas fa-home mr-2"></i>Home<span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="fas fa-envelope mr-2"></i> Contact</a>
                    </li>
                </ul>
              
                <ul class="navbar-nav mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="login"><button class="btn btn-outline-primary my-2 my-sm-0">Sign
                                in</button></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="greataccount"><button
                                class="btn btn-outline-primary my-2 my-sm-0">Sign
                                up</button></a>
                    </li>
                    <li>
                          <a  class="nav-link" href="basketasgest">   <button   class="btn btn-outline-primary my-2 my-sm-0" ><i class="fas fa-shopping-basket mr-2"></i>Basket(${i })</button>    </a>
                    </li>
                    
                </ul>
            </div>
        </div>
    </nav>
                    
		   
     </c:if>
     
      <c:if test='${ log.role =="Guest"  }' >
     
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                 <a class="active" href="/saleProducts/"><i class="fa fa-fw fa-home"></i> Home</a> 
            </li>
            <li class="nav-item active">
                 <a href="login"    >  <i class="fa fa-fw fa-user"></i> Sign in</a> 
            </li>
            <li class="nav-item active">
                 <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a>  
            </li>
        </ul>
         <a > <i  class="nav-item active"> The time in Stockholm: ${serverTime}.</i></a>
        <form class="form-inline my-2 my-lg-0">
           
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
         
           <a   href="basket">   <button class="btn btn-outline-success my-2 my-sm-0" >Basket(${i })</button>    </a> 
    </div>
</nav>
		   
     </c:if>
     
     
     
     
   
     
</body>
</html>


