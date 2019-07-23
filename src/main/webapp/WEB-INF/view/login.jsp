<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">   
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://kit.fontawesome.com/f11e7fef2e.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
 <link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">
</head>

 <body class="login-body"> 

     <div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
     </div>
    
    <div class=" heading text-center text-light">
      <h1 class="Display-4">Sign in to your account</h1>
      <p>Sign in to your account or <a style="text-decoration: underline" class="text-light" href ="greataccount">create an account</a></p>
    </div>
    <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            <form:form name="login" class="form-signin" method="post" action="checklogin" modelAttribute="account">
              <div class="form-label-group">
                <input class="form-control"  id="inputEmail"  name="email" type="email" placeholder="Email address" value=""  maxlength="64" value='${account.email}' required>
                <label for="inputEmail">Email address</label>
              </div>
              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" value="" maxlength="64" value='${account.password}' required>
                <label for="inputPassword">Password</label>
              </div>
              <div class="custom-control custom-checkbox checkbox-inline mb-3">
                 <a href="forgetpassword">forget password</a>
              </div>
              
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>
              <hr class="my-4 hr-text" data-content="OR">
            </form:form>
            <div class="btn-guest-sp">
              <a href="index"><button class="btn btn-lg btn-guest  btn-block text-uppercase"><i class="fas fa-user-clock mr-2"></i>Sign in as a guest</button></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://kit.fontawesome.com/9008cdf4dc.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </body>
        </html>