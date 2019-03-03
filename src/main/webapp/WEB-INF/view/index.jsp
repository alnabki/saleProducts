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


<body>
 <!-- <img  src="<c:url value="/resources/images/laptopBackground.png" />"/><br> -->
 

<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
</div>


 


<div id="positionIndex" >
	    <h1  align="center"><i>Products for sale<b></b></i></h1>
	    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>
	      
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			    <form:form id="usrform" name="getForm" action="addtobasketasguest"  method="post" modelAttribute="log" >  
		                              <h2 ><b><u> ${product.name} </u></b></h2> 
		                               <b>S.No.</b>                  =  ${status.index + 1} 
                                          <input type="hidden" name="basket.product.id"  value="${product.id}" />
                                          <input type="hidden" name="basket.product.name"  value="${product.name}" />
                                          <input type="hidden" name="basket.product.fileName"  value="${product.fileName}" />
                                          <input type="hidden" name="basket.price"      value="${product.price}" />
                                          
                                       <b> Quantity in the Store</b>  =  ${product.quantity} <br>
                                       <b>Price </b>                 =  ${product.price} Kr <br>
                                       <b>Quantity</b>               = <input type="number"  name="basket.quantityShop" value="${quantityShop}" required />
                                    
                                      <input type="submit" value="Add to basket "   /><br>
               
                                        
				                      
                                      <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/><br> <br>
                                      <b>DescriptionM</b>            =  ${product.description} <br>
                    </form:form>
         ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>                     
					     
		          
		        </c:forEach>
		       </div>
		       
</body>
</html>