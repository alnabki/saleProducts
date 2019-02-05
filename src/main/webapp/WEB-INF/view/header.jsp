<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>
<style><%@include file="/resources/css/mystyle.css"%></style>
<title>Insert title here</title>
</head>
<body>
    
  
   <div>  
       <c:if test='${ log.role =="Customer"  }' >
          
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
		                 <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a>  
		            </li>
		             <li class="nav-item active">
		              <a href="logout"> <i class="fa fa-fw fa-user"> </i> ${log.account.username } <button> Logout</button>   </a> 
		             </li>
		             
		        </ul>
		     </div> 
		  
	        <form class="form-inline my-2 my-lg-0">
	             <i class="fa fa-fw fa-search"></i><input class="form-control mr-sm-2" type="search" placeholder="Search"  aria-label="Search">
	            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	        </form>
	       
		              <a   href="basket"> <i class="fa fa-fw fa-cart" > </i> Basket <button > basket</button>   </a> 
		     		   </nav>
       </c:if>
     
      </div>
     
     
     <c:if test='${ log.role =="Admin"   }' >
            <div class="navbar">
				  <a class="active" href="admin"><i class="fa fa-fw fa-home"></i> Home</a> 
				   <a href="logout"><i class="fa fa-fw fa-user"> </i> ${log.account.username } <button> Logout</button>   </a> 
		    </div>
		   
     </c:if>
     
     
</body>
</html>


