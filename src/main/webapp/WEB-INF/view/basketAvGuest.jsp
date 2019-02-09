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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>
<title> Login</title>
</head>
<body >

<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
</div>

<!--  
<div id="positionIndex" >
	    <h1  align="center"><i>Shopping cart (As Guest)<b></b></i></h1>
	   
	   <c:if test='${ log == null   }' >
	   
		   <table align="center" >
		     <tr>
		       <td align="center">  you don't add any thing to basket</td>
		      </tr>
		   </table>
	       
	   
	    </c:if>
	     <c:if test='${ log.role =="Guest"   }' >
	      ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			    <form:form id="usrform" name="getForm" action="gotockeckout"  method="post" modelAttribute="order" >  
			                          
		                             ${status.index + 1} = <br>
		                             <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/>
		                            
                                        <h2 ><b><u> ${product.name} </u></b></h2>       Qty = <input type="number"  name="quantity" value="${quantity}"  />      Price  =  ${product.price} Kr  <br>  
                                        
		                             
		                                                        <input type="hidden" name="product.id" value="${product.id}" />
		                                                        <input type="hidden" name="account.id" value="${log.account.id}" />
			                                                   <br>
		                                                         <input type="submit" value="Go to Checkout"   /><br><br>
		                                                        
		                                                         <td><a href="deleteorder?id=${order.id}">  Remove</a> </td>
                              <br>
                              
                              </form:form>
                             
         ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>                     
					     
	        
		        </c:forEach>
		         </c:if>
		          </div>
		          	-->  
		       <c:forEach var="log" items="${logs}" varStatus="status">
		           22222222222222222 
		          ${log.basket.price}
		       </c:forEach>
		      

</body>
</html>