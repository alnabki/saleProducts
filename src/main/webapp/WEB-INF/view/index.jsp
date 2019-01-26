<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
       
<!DOCTYPE html>

<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
<style><%@include file="/resources/css/mystyle.css"%></style>


</head>


<body background="<c:url value='/resources/images/background7.jpg'  />">
 <!-- <img  src="<c:url value="/resources/images/laptopBackground.png" />"/><br> -->
 
 
 <div class="navbar">
  <a class="active" href="/saleProducts/"><i class="fa fa-fw fa-home"></i> Home</a> 
  <a href="#"><i class="fa fa-fw fa-search"></i> Search</a>
  
  <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a> 
  <a href="login"    >  <i class="fa fa-fw fa-user"></i> Sign in</a>
  <a > <i  class="timeserver"> The time in Stockholm: ${serverTime}.</i></a>
  <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
</div>

<br>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    
        <a class="navbar-brand" href="#">Hidden brand</a>
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
            
            
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
        </ul>
        
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>








 <div id="positionIndex" >
	    <h1  align="center"><i>Products for sale<b></b></i></h1>
	     --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			    
			                          <input type='hidden' name="id"       value ='${product.id}'/>   
		                              S.No.        =  ${status.index + 1} <br>
		                              <h2 ><b><u> ${product.name} </u></b></h2> 
		                             
		                                                        Quantity in the Store     =  ${product.quantity} <br>
			                                                     Price        =  ${product.price}  <br>
		                              <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/><br>
				                       Description  =  ${product.description} <br>   
				            
				         
			                       
                  
                              <br><br>
         -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>                     
					     
		          
		        </c:forEach>
		       </div>
					 

</body>
</html>