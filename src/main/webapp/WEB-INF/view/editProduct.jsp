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
     <br><br><br><br><br><br><br><br><br><br><br><br>
     <div align="center">
	     <h1 ><i>Edit Product<b></b></i></h1>
        <table border="1">
			      <tr >
			         
			          <th>Products name</th>
			          <th>quantity</th>
			          <th>price</th>
			          <th>Edit</th>
			          <th>Delete</th>
			          <th>Update</th>
			          <th>Photos</th>
			      </tr>  

          <form:form name="getForm" action="getproduct"  method="post" modelAttribute="product" >
              <tr>
         
            <td><input type='text'   name="name"     value ='${product.name}'     required/></td>
            <td><input type='text'   name="quantity" value ='${product.quantity}' required/></td>
            <td><input type='text'   name="price"    value ='${product.price}'    required/></td>
            <td ><input type="submit" value="ADD Product     "/></td>   
            </tr>         
           </form:form>    
           </table> 
         </div> 
</body>
</html>