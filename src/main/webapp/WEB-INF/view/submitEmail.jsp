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
   <body>
      <div align="right">
         <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
      </div>
      <div class="container text-center">
         <div class="row justify-content-center">
            <div class="col-lg-5 text-center center-text">
               <h1 class="display-4">Forget password</h1>
               <p>You can reset your password here. Write your email here and recieve a message from us</p>
               <form:form name="gratAccount" class="form-signin" method="post" action="sendnewpasswordbyemail" modelAttribute="account">
                  <div class="form-label-group">
                     <input class="form-control"  id="inputEmail"  name="email" type="email" placeholder="Email address" value=""  maxlength="64" value='${account.email}' required>
                     <label for="inputEmail">Email address</label>
                  </div>
                  <button class="btn btn-lg btn-primary text-uppercase w-50 text-center" type="submit">Forget password</button>
               </form:form> 
            </div>
         </div>
      </div>
   </body>
</html>