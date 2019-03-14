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
		  
<div id="positioncheckOrder" >
         <h1  align="left"><i>Check your order</i></h1>
	    <p  align="left"><i>Shopping cart (${log.numberOfTheItemsInTheBasket} items)</i></p>
	   
	     
	                ___________________________________________________________________
	    
		      <c:forEach var="basket" items="${productViews}" varStatus="status">
		             <form:form  id="usrform"  method="post" action="deleteitemfrombasket&update" modelAttribute="basket" enctype="multipart/form-data">
				   
			                             ${status.index + 1} =     <b><u> ${basket.product.name} </u></b>
			                             <img class="imageProductInBasket"  src="<c:url value="/resources/images/${basket.product.fileName}" />"/><br> <br>
	                                     Qty = <input id="quantityShop" type="number"   name="quantityShop" value="${basket.quantityShop}" oninput="calculate()" /> 
	                                     <input type="submit" name="update" value="Change"   />  <br> 
	                                     Price  =  ${basket.price} Kr  <br> 
	                                     Request Total = ${basket.itemRequest} Kr    <br> 
	                                     <!--   the cost = <i id="result"></i>  -->
	                                     <input type="hidden" id="id" name="id" value="${basket.id}"  />
	                                     <input type="hidden" id="price" name="price" value="${basket.price}" oninput="calculate()" />
	                                     <input type="hidden" name="product.id" value="${basket.product.id}" />
	                                     <input type="hidden" name="account.id" value="${basket.account.id}" /> <br>
	                                    
	                                     <a href="deleteitemfromBasket?id=${basket.id}&quantityShop=${basket.quantityShop}">  Remove</a> <br>
	                 </form:form>
	                    ___________________________________________________________________
	    
		      </c:forEach>
		      <br>
		   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <b>The Total =  ${sum}  Kr</b><br></b>
		     
		                ___________________________________________________________________
	    
	          
</div>
<br> 	    
		     <div id="positionContinueToPay">
	           <a href="checkout" ><button>Continue to Pay</button>  </a><br>
	         </div>
</body>

</html>