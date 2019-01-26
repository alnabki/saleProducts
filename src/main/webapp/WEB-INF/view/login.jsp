<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
       
<!DOCTYPE html>

<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style><%@include file="/resources/css/mystyle.css"%></style>
</head>

 <body background="<c:url value='/resources/images/background7.jpg'  />">
 

 <div class="navbar">
  <a class="active" href="/saleProducts/"><i class="fa fa-fw fa-home"></i> Home</a> 
  <a href="#"><i class="fa fa-fw fa-search"></i> Search</a> 
  <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a> 
  <a href="login"    >  <i class="fa fa-fw fa-user"></i> Sign in</a>
</div>

        
        <div id= "positionIndex" >
            <br><br><br>
			    <h1>Login</h1>
			<br><br><br>
				<form:form name="login" method="post" action="checklogin" modelAttribute="account">
				             Email:<br>
				             <input type='text' name="username"     value='${account.username}'/><br><br>
				           password:<br>
				             <input type='password' name="password" value='${account.password}'/><br><br>
				              <input  type="submit" value="login"/> 
				     
			     </form:form>
        </div>
      

</body>

</html>