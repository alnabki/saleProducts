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

<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
</div>

<div id="positionIndex" >
	    <h1  align="center"><i>Shopping cart (# items)<b></b></i></h1>
	   
	   <c:if test='${ i == 0 }' >
	   
		   <table align="center" >
		     <tr>
		       <td align="center">  you don't have any thing in the basket</td>
		      </tr>
		   </table>
	       
	   
	    </c:if>
	  
	     <c:if test='${ i !=0   }' >
	      ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>
		      <c:forEach var="basket" items="${productViews}" varStatus="status">
		      
		          
				     <form:form id="usrform" name="getForm" action="deleteitemfromBasket"  method="post" modelAttribute="basket" > 
			                             ${status.index + 1} =     <b><u> ${basket.product.name} </u></b>
			                             <img class="imageProductInBasket"  src="<c:url value="/resources/images/${basket.product.fileName}" />"/><br> <br>
	                                     Qty = <input id="quantityShop" type="number"   name="quantityShop" value="${basket.quantityShop}" oninput="calculate()" />    
	                                       Price  =  ${basket.price} Kr   
	                                       Request Total =  ######## Kr    <br> 
	                                     
	                                    <!--   the cost = <i id="result"></i>  -->
	                                     <input type="hidden" id="price" name="price" value="${basket.price}" oninput="calculate()" />
	                                     <input type="hidden" name="product.id" value="${basket.product.id}" />
	                                     <input type="hidden" name="account.id" value="${basket.account.id}" /> <br>
	                                     <input type="submit" value="Go to Checkout"   /><br>
	                                     <a href="deleteitemfromBasket?id=${basket.id}">  Remove</a> <br>
	                 </form:form>
	                  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br> 
		          
		      </c:forEach>
		      &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	   
		        The Total = #####  Kr
	   </c:if>
		       </div>

</body>
</html>