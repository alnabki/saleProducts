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
      <title>Login</title>
   </head>
   <body >
      <div align="right">
         <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
      </div>
      <c:if test='${msg =="Please, Write correct email"}'>
         <div align="center" text-color="red">
            <h1>${msg}</h1>
            <big><b> Hello ${acc.firstName } ${acc.lastName }</b></big><br>
            Write your email to send correct password</b></big> <br>
            <br>
            <form:form name="gratAccount" method="post" action="sendnewpasswordbyemail" modelAttribute="account">
               <span>
               Email Address:<br>
               <input class="GreatEmail"  name="email" type="text" value="" maxlength="64"   value='${account.email}'><br>
               <input   type="submit" value="submit"/>
               </span>
            </form:form>
         </div>
      </c:if>
      <c:if test='${msg == " "   }'>
         <div align="center" text-color="red">
            <h1>forget password</h1>
            <big><b> Hello ${acc.firstName } ${acc.lastName }</b></big><br><br>
            <big><b>The password has been sent</b></big> <br>.
            <big><b>Try to Login by using the correct password  <br><a href="login" >Login</a></b></big> <br>
            <br>         	
         </div>
      </c:if>
   </body>
</html>