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
        <br><br><br>
        <ul>
         <li> <a href="viewallproducts">View All Products</a> </li>
         <li> <a href="addproduct">Add Product</a> </li>
         <li> <a href="viewsales">View sales</a> </li>
         <li> <a href="managecustomers">Manage Account</a> </li>
         <li><a href="admin">Back</a></li>
        </ul>

          <br><br><br><br>
          <div align="center">
           <h1 ><i><b>All Customers</b></i></h1>
          <table >
		      <tr>
		          <th>S.No.    </th>
		          <th> First Name    </th>
		          <th> Last Name    </th>
		          <th> Email   </th>
		          <th> Password</th>
		          <th> Age     </th>
		          <th> Phone   </th>
		          <th> Address </th>
		          <th> Post code     </th>
		          <th> City   </th>
		          <th> Country   </th>
		      </tr>  
	          <c:forEach var="account" items="${accounts}" varStatus="status">
		      <tr >
	              <td> ${status.index + 1}   </td>
	                 <input type='hidden'   name="id"            value = '${account.id}'/>
	             <td><input type='text'     name="firstName"          value = '${account.firstName}'      required/></td>
	              <td><input type='text'     name="lastName"          value = '${account.lastName}'      required/></td>
	             <td><input type='text'     name="email"         value = '${account.email}'    required/></td>    
	             <td><input type='password' name="password"      value = '${account.password}' required/></td>
	             <td><input type='text'     name="age"           value = '${account.age}'      required/></td>
	             <td><input type='text'     name="phone"         value = '${account.phone}'      required/></td>
	             <td><input type='text'     name="address"       value = '${account.address}'    required/></td> 
	             <td><input type='text'     name="postcode"      value = '${account.postcode}'    required/></td>
	             <td><input type='text'     name="city"          value = '${account.city}'    required/></td>
	             <td><input type='text'     name="country"       value = '${account.country}'    required/></td>
	               
	             <td><a href="deleteaccount?id=${account.id}">  DELETE</a> </td>	  
		      </tr>
		     </c:forEach>
		     
		    </table>
           </div>
  
</body>
</html>