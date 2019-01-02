<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="/resources/css/mystyle.css"%></style>


</head>
<style>

</style>


<body background="<c:url value='/resources/images/laptopBackground.png'  />">
 <!-- <img  src="<c:url value="/resources/images/laptopBackground.png" />"/><br> -->




  
  <form:form name="add" method="post" action="addaccount" modelAttribute="account">
			        <table  class="tableLogin"  align="center">
				        <tr>
				           <td>  Email </td>
				           <td>  <input type='text' name="username" value='${account.username}'/></td>
				           </tr>
				        <tr>
				            <td>  password </td>
				            <td> <input type='password' name="password" value='${account.password}'/></td>
				            <td style="color:blue"><input  type="submit" value="add"/></td> 
				        </tr>
			        </table>
  </form:form>
  
 
</body>
</html>