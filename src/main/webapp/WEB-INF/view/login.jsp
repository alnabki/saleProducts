<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
 <link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">
</head>

 <body class="login-body"> 

    <nav id="mainNav" class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="index">BRAND NAME</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="index"><i class="fas fa-home mr-2"></i>Home<span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="fas fa-envelope mr-2"></i> Contact</a>
                    </li>
                </ul>
                <!--<ul class="navbar-nav mt-2 mt-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link active dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false"><i class="fas fa-user mr-2"></i>Profile</a>
                        <div class="dropdown-menu" aria-labelledby="dropdownId">
                            <a class="dropdown-item" href="#"><i class="fas fa-shopping-basket mr-2"></i>Basket(NUMBER)</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-key mr-2"></i>Reset password</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt mr-2"></i>Sign out</a>
                        </div>
                    </li>
                </ul>-->
                <ul class="navbar-nav mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="login"><button class="btn btn-outline-primary my-2 my-sm-0">Sign
                                in</button></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="greataccount"><button
                                class="btn btn-outline-primary my-2 my-sm-0">Sign
                                up</button></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
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
                <input class="form-control"  id="inputEmail"  name="email" type="text"    placeholder="Email address" value=""  maxlength="64" value='${account.email}' >
                <label for="inputEmail">Email address</label>
              </div>
              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" value="" maxlength="64" value='${account.password}' required>
                <label for="inputPassword">Password</label>
              </div>
              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
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