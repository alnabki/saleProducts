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
<title>Insert title here</title>
<style><%@include file="/resources/css/mystyle.css"%></style>


</head>


<body background="<c:url value='/resources/images/background7.jpg'  />">
 <!-- <img  src="<c:url value="/resources/images/laptopBackground.png" />"/><br> -->




  

<h1>
	<a href="login">Login  </a>
</h1>

<P>  The time on the server is ${serverTime}. </P>



 <div align="center">
	     <h1 ><i>Products for sale<b></b></i></h1>
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