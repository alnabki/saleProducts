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
			    <form:form id="usrform" name="getForm" action="addtobasket"  method="post" modelAttribute="basket" >  
			                          
		                             
		                              <h2 ><b><u> ${product.name} </u></b></h2> 
		                               S.No.                  =  ${status.index + 1} <br>
                                          <input type="hidden" name="productId" value="${product.id}" />
                                          <input type="hidden" name="account.id" value="${log.account.id}" />
                                           <input type="hidden" name="price" value="${product.price}" />
                                           
                                       Quantity in the Store  =  ${product.quantity} <br>
                                       Price                  =  ${product.price} Kr <br>
                                       Quantity               = <input type="number"  name="quantityShop" value="${quantityShop}" required />
                                    
                                      <input type="submit" value="Add to basket"   /><br>
               
                                       Description            =  ${product.description} <br> 
				                      
                                      <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/><br> <br>
                                     
                    </form:form>
         ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>                     
					     
		          
		        </c:forEach>
		       </div>
					 

</body>
</html>