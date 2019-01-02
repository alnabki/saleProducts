<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login</title>
</head>
<body background="<c:url value='/resources/images/laptopBackground.png'  />">

        <div align="right">
				<form:form name="login" method="post" action="checklogin" modelAttribute="account">
			        <table  class="tableLogin">
				        <tr>
				           <td>  Email </td>
				           <td>  <input type='text' name="username" value='${account.username}'/></td>
				           </tr>
				        <tr>
				            <td>  password </td>
				            <td> <input type='password' name="password" value='${account.password}'/></td>
				            <td ><input class="" type="submit" value="login"/></td> 
				        </tr>
			        </table>
			     </form:form>
        </div>
</body>
</html>