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
  <body background="<c:url value='/resources/images/background7.jpg'  />">

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