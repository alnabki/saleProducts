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

<style><%@include file="/resources/css/mystyle.css"%></style>
<title> Login</title>
</head>
<body >

<div align="right">
     <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
</div>
<div align="center"	>
    <h1> Payment</h1>
</div>	  
<div id="positioncheckOrder" >
         
	    <p  align="left"><i>Your Order (${log.numberOfTheItemsInTheBasket} items)</i></p>
	     
	                ____________________________________________________________________________________
	       <div>
		      <c:forEach var="basket" items="${productViews}" varStatus="status">
		            
			                            
			                             <img class="imageProductInBasket"  src="<c:url value="/resources/images/${basket.product.fileName}" />"/><br>
			                               ${status.index + 1} =     <b><u> ${basket.product.name} </u></b><br>
	                                       Qty ${basket.quantityShop} ,
	                                       Price  =  ${basket.price} Kr  ,  
	                                       Request Total = ${basket.itemRequest} Kr   ,  
	                                       price=${basket.price}<br><br><br>
	                                     
	                                    
	                        ____________________________________________________________________________________<br>
	    
		      </c:forEach>
		      </div>
		      <br>
		      <div id="totalSum"><b>The Total =  ${sum}  Kr</b><br></div>
		     
		                ____________________________________________________________________________________
	          
</div>    
                     
<br> 	    
		     <div id="positionContinueToPay">
		             
		              <p> Your Delivery Address </p>
		             __________________________________________________________________
			                <table style="width:120%"> 
			                     
			                <tr>
			                    <td> FirstName:${addressDelivery.firstName}  </td>
	                            <td> LastName:${addressDelivery.lastName}   </td>
	                        </tr>
	                         <tr> 
	                            <td colspan="2"> personNumber:${addressDelivery.personNumber} </td>
	                        
	                         </tr>
	                         
	                         <tr>                         
	                             <td colspan="2">C/O :${addressDelivery.cO} </td>
	                         </tr>
	                             
	                        
			                <tr>                         
	                             <td colspan="2"> Street Address*:<br>${addressDelivery.streetAddress}</td>
			                </tr>
			                
			                 
	                         <tr> 
	                              <td> city:*<br> 
	                                  ${addressDelivery.city}</td>
	                        
	                              <td> Post/Zip Code:*<br>
	                                   ${addressDelivery.zipCode}</td>
	                         </tr>
	                        
	                         <tr>
	                            <td >Phone:*<br>
	                               ${addressDelivery.phone}  </td>
	                            <td > Door Code:<br>
	                              ${addressDelivery.doorCode}  <br>
	                            </td>    
	                         </tr>
	                         <tr>                         
	                           <td colspan="2"> country: ${addressDelivery.country}</td>
			                </tr>
	                             </table>  
	                            <br> <br><br>
	                          
	                
	            
		                 <br> <br><br>
	         </div>
	         
</body>

</html>