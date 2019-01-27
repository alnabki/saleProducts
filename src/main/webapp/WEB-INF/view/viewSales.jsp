<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<c:url value='/resources/images/laptopBackground3.png'  />">

	<div align="right">
	          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
	        </div>
	     <br><br><br>   
	    <ul>
         <li> <a href="addproduct">Add Product</a> </li>
         <li> <a href="viewsales">View sales</a> </li>
         <li> <a href="managecustomers">Manage Account</a> </li>
         <li><a href="admin">Back</a></li>
        </ul>
	        
        <br><br><br><br><br><br><br><br><br><br><br><br>
  <div align="center">
      <h1 ><i><b>all Sales</b></i></h1>
        <table  >
              
		      <tr>
		          <th>S.No.    </th>
		          <th> CustomerName   </th>
		          <th> Product   </th>
		          
		      </tr> 
		      
		       <c:forEach var="order" items="${orders}" varStatus="status">
		       <tr> 
		             <td> ${status.index + 1}   </td>
		             <td> ${order.customer.name }   </td>
		             <td>${order.product.name }   </td>
		       </tr>
		       </c:forEach>
		     
          </table>
    </div>
    
    
</body>
</html>