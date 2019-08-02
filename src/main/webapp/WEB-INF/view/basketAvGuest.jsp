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
<body onload="calculate()">
<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
</div>
 
<div class="positioncheckOrder" >
	    <h1  align="center"><i>Shopping cart (${i })items<b></b></i></h1>
	     
	   <c:if test='${ i == 0 && log == null  }' >
		   <table align="center" >
		     <tr>
		       <td align="center">  you don't have anything in the basket</td>
		      </tr>
		   </table>
	    </c:if>
	    
	    
	     <c:if test='${ i !=0   }' >
	      <hr class="my-4">
	              <c:forEach var="log" items="${logs}" varStatus="status">
		      
			           <c:if test='${ log !=null }' >
					     <form:form id="usrform" name="getForm" action="gotochekout&updateforguest"  method="post" modelAttribute="log" enctype="multipart/form-data"> 
				                             ${status.index + 1} =     <b><u> ${log.basket.product.name} </u></b>
				                             <img class="imageProductInBasket"  src="<c:url value="/resources/images/${log.basket.product.fileName}" />"/><br> <br>
		                                     Qty = <input id="quantityShop" type="number"   name="basket.quantityShop" value="${log.basket.quantityShop}" oninput="calculate()" />
		                                      <input type="submit" name="updateForGuest"  value="Change"   /><br>    
		                                     Price  =  ${log.basket.price} Kr <br>  
		                                     Request Total =  ${log.itemPrice} Kr    <br> 
		                                     
		                                     <!--   the cost = <i id="result"></i>  -->
		                                     <input type="hidden" id="price" name="basket.price" value="${log.basket.price}" oninput="calculate()" />
		                                     <input type="hidden" name="basket.product.id" value="${log.basket.product.id}" />
		                                     
		                                     <input type="submit" name="gotocheckoutforguest"  value="Pay only this seller"   /><br>
		                                     <a href="deleteelement?id=${log.basket.product.id}">  Remove</a> <br>
		                 </form:form>
		              <hr class="my-4">
		               </c:if>
		      </c:forEach>
		       <div class="alignInCenterForBasketAvGuest">
		      The Total =  ${sum}  Kr 
		      </div>
		       <div class="alignInCenterForBasketAvGuest1">
		         <a href="login"><button class="btn btn-lg btn-primary btn-block text-uppercase">go to checkout</button>  </a>
		        </div>
	   </c:if>
	    
</div>
 
<!-- <script>

  function calculate() {
    var quantityShop = document.getElementById('quantityShop').value; 
    var price = document.getElementById('price').value;
    var result = document.getElementById('result'); 
    var myResult = quantityShop * price;
    result.innerHTML = myResult;
}
</script> -->	      

</body>
</html>