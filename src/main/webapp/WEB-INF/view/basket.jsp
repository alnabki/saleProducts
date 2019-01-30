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

<div id="positionIndex" >
	    <h1  align="center"><i>Shopping cart (# items)<b></b></i></h1>
	    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>
	  
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			    <form:form id="usrform" name="getForm" action="gotockeckout"  method="post" modelAttribute="order" >  
			                          
		                             
		                             <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/>
                                       ${status.index + 1} = <h2 ><b><u> ${product.name} </u></b></h2>         Qty = <input type="number"  name="quantity" value="${quantity}"  />     Price        =  ${product.price} Kr <br>
		                             
		                                                        <input type="hidden" name="product.id" value="${product.id}" />
		                                                        <input type="hidden" name="account.id" value="${log.account.id}" />
			                                                   <br>
		                                                         <input type="submit" value="Go to Checkout"   /><br><br>
		                                                         <td><a href="deleteorder?id=${order.id}">  Remove</a> </td>
                              <br>
                              
                              </form:form>
         ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>                     
					     
		          
		        </c:forEach>
		       
		       </div>

</body>
</html>