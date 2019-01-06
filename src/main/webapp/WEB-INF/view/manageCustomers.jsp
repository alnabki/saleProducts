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
<title>Insert title here</title>

</head>
<body background="<c:url value='/resources/images/laptopBackground3.png'  />">
     <div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
        </div>

          <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
          <div align="center">
           <h1 ><i><b>All Customers</b></i></h1>
          <table >
		      <tr>
		          <th> S.No.   </th>
		          <th> Name    </th>
		          <th> Email   </th>
		          <th> Password</th>
		          <th> Address </th>
		          <th> Age     </th>
		          <th> Phone   </th>
		          <th> DELETE  </th>
		      </tr>  
	          <c:forEach var="customer" items="${customers}" varStatus="status">
		      <tr >
	              <td> ${status.index + 1}   </td>
	                 <input type='hidden'   name="id"            value = '${customer.id}'/>
	             <td><input type='text'     name="name"          value = '${customer.name}'      required/></td>
	             <td><input type='text'     name="email"         value = '${customer.email}'    required/></td>    
	             <td><input type='password' name="password"      value = '${customer.password}' required/></td>
	             <td><input type='text'     name="address"       value = '${customer.address}'    required/></td> 
	             <td><input type='text'     name="age"           value = '${customer.age}'      required/></td>
	             <td><input type='text'     name="phone"         value = '${customer.phone}'    required/></td>
	             <td><a href="deletecustomer?id=${customer.id}">  DELETE</a> </td>	  
		      </tr>
		     </c:forEach>
		     
		    </table>
           </div>
  
</body>
</html>