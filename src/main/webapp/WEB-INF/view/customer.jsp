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
<body> 
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
	      __________________________________________________________________________________________________________________________________________
	      
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			    <form:form id="usrform" name="getForm" action="addtobasket"  method="post" modelAttribute="basket" >  
			                          
		                             
		                              <h2 ><b><u> ${product.name} </u></b></h2> 
		                              <b>S.No.</b>                  =  ${status.index + 1} <br>
		                              
                                      <input type="hidden" name="product.id"  value="${product.id}" />
                                      <input type="hidden" name="product.name"  value="${product.name}" />
                                      <input type="hidden" name="product.fileName"  value="${product.fileName}" />
                                      <input type="hidden" name="price"      value="${product.price}" />
                                      <input type="hidden" name="account.id" value="${log.account.id}" />
                                      
                                      <b>Quantity in the Store</b>  =  ${product.quantity} <br>
                                      <b>Price </b>                 =  ${product.price} Kr <br>
                                      <b>Quantity</b>               = <input type="number"  name="quantityShop" value="${quantityShop}" required />
                                    
                                      <input type="submit" value="Add to basket "   /><br>
               
                                      
				                      
                                      <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/><br> <br>
                                       <b>Description</b>        =  ${product.description} <br> 
                    </form:form>
           __________________________________________________________________________________________________________________________________________
	    			     
		          
		        </c:forEach>
		       </div>
					 

</body>
</html>