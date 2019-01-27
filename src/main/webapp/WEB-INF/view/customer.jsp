<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login</title>
</head>
<body background="<c:url value='/resources/images/background7.jpg'  />">
 <!-- <img  src="<c:url value="/resources/images/laptopBackground.png" />"/><br> -->

<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
        </div>
        
        <br><br>
        <div>
	        <ul>
	        <li>  <a href="#">#</a> </li>
	         <li> <a href="#">#</a> </li>
	         <li> <a href="#">#</a> </li>
	         <li> <a href="#">#</a> </li>
	        </ul>
        </div>




 <div id="positionIndex" >
	    <h1  align="center"><i>Products for sale<b></b></i></h1>
	    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			    
			                          <input type='hidden' name="id"       value ='${product.id}'/>   
		                             
		                              <h2 ><b><u> ${product.name} </u></b></h2> 
		                               S.No.        =  ${status.index + 1} <br>
		                             
		                                                        Quantity in the Store     =  ${product.quantity} <br>
			                                                     Price        =  ${product.price} Kr <br>
		                              <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/><br>
				                       Description  =  ${product.description} <br> 
                  
                              <br>
         ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>                     
					     
		          
		        </c:forEach>
		       </div>
					 

</body>
</html>