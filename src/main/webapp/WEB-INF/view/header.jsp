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
<style><%@include file="/resources/css/mystyle.css"%></style>
<title>Insert title here</title>
</head>
<body>
    
  
   
       <c:if test='${ log.role =="Customer"  }' >
           
		    <div class="navbar">
				  <a class="active" href="/saleProducts/"><i class="fa fa-fw fa-home"></i> Home</a> 
				  <a href="#"><i class="fa fa-fw fa-search"></i> Search</a> 
				  <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a> 
				   <i class="fa fa-fw fa-envelope"> </i> <a href="logout"> ${log.account.username } <button> Logout</button></i>   </a>
			</div>
      
      
	        
     </c:if>
     <c:if test='${ log.role =="Admin"   }' >
            <div class="navbar">
				  <a class="active" href="/saleProducts/"><i class="fa fa-fw fa-home"></i> Home</a> 
				  <a href="#"><i class="fa fa-fw fa-search"></i> Search</a> 
				  <i class="fa fa-fw fa-envelope"> </i> <a href="logout"> ${log.account.username } <button> Logout</button></i>   </a> 
		    </div>      
     </c:if>
    
</body>
</html>


