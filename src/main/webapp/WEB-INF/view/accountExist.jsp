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

<style><%@include file="/resources/css/mystyle.css"%></style>
<title> Login</title>
</head>
<body >

<div align="right">
     <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
</div>

<div align="center" color-text="red">
<h1>  An account already exists with the email address ########</h1>
<p1>If you forgot te password click to forget password below</p1>

</div>

 <div id= "positionIndex" >
		<form:form name="gratAccount" method="post" action="greatnewaccount" modelAttribute="account">
		             Firat Name:<br>
		             <span>
		             <input class="GreatFirstName"  name="firstName" type="text" value="" maxlength="64"   value='${account.firstName}'><br>
		            </span>
		            <span>
		             Last Name:<br>
		              <input class="GeartLastName"  name="lastName" type="text" value="" maxlength="64"   value='${account.lastName}'><br>
		             
		            </span>
		            <span>
		             Email Address:<br>
		             <input class="GreatEmail"  name="email" type="text" value="" maxlength="64"   value='${account.email}'><br>
		            </span>
		            
		             <span>
		             password:<br>
		              <input class="GeartPasswor"  name="password" type="password" value="" maxlength="64"   value='${account.password}'><br>
		            </span>
		            <span>
		             Confirm Password:<br>
		             
		            </span>
		            
		            <span>
		             Sign me up, Receive special offers, exclusives and promotions:<br>
		            </span>
		              <input  type="submit" value="Create Your Account"/> 
		     
	     </form:form>
</div>	     
 
</body>
</html>