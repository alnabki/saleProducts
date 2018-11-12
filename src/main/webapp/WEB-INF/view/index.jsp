<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1> mohamad : ${msg} </h1>
  
  <form:form name="add" method="post" action="addaccount" modelAttribute="account">
			        <table class="loginTable">
				        <tr>
				           <td>  Email </td>
				           <td>  <input type='text' name="username" value='${account.username}'/></td>
				           </tr>
				        <tr>
				            <td>  password </td>
				            <td> <input type='password' name="password" value='${account.password}'/></td>
				            <td style="color:blue"><input class="btnLogin" type="submit" value="add"/></td> 
				        </tr>
			        </table>
  </form:form>
</body>
</html>