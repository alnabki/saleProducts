<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <style><%@include file="/resources/css/mystyle.css"%></style>
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <style><%@include file="/resources/css/mystyle.css"%></style>
      <title> Login</title>
   </head>
   <body >
      <div align="right">
         <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
      </div>
      <div class="container-fluid">
         <div class="row no-gutter">
            <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
            <div class="col-md-8 col-lg-6">
               <div class="login d-flex align-items-center py-5">
                  <div class="container">
                     <div class="row">
                        <div class="col-md-9 col-lg-8 mx-auto">
                           <h3 class="login-heading mb-4">Create an account</h3>
                           <form:form name="gratAccount" method="post" action="greatnewaccount" modelAttribute="account">
                              <div class="form-label-group">
                                 <input type="text" id="inputFirstname" class="form-control" placeholder="First name" name="firstName" maxlength="64" value='${account.firstName}' required autofocus>
                                 <label for="inputFirstname">First name</label>
                              </div>
                              <div class="form-label-group">
                                 <input type="text" id="inputLastname" class="form-control" placeholder="Last name" name="lastName" maxlength="64" value='${account.lastName}' required>
                                 <label for="inputLastname">Last name</label>
                              </div>
                              <div class="form-label-group">
                                 <input type="email" id="inputEmail" class="form-control" placeholder="Email adress" name="email" maxlength="64" value='${account.email}' required >
                                 <label for="inputEmail">Email address</label>
                              </div>
                              <div class="form-label-group">
                                 <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" maxlength="64" value='${account.password}' required>
                                 <label for="inputPassword">Password</label>
                              </div>
                              <div class="custom-control custom-checkbox mb-3">
                                 <input type="checkbox" class="custom-control-input" id="customCheck" name="example1">
                                 <label class="custom-control-label" for="customCheck">I agree to the <a href="#">terms of service</a> and <a href="#">Privacy policy</a></label>
                              </div>
                              <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign up</button>
                              <hr class="my-4">
                              <button class="btn btn-lg btn-google btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>
                              <div class="text-center">
                                 <a class="small" href="login">Already have an account?</a>
                              </div>
                           </form:form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>