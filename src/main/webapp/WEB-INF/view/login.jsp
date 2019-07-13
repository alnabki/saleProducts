<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

        <!DOCTYPE html>

        <html>

        <head>

          <meta charset="ISO-8859-1">
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
          <title>Login page- company name</title>
          <style>
            <%@include file="/resources/css/mystyle.css"%>
          </style>
        </head>

        <body>

          <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
              <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                  <a class="active" href="/saleProducts/"><i class="fas fa-home"></i>Home</a>
                </li>
                <li class="nav-item active">
                  <a href="login">  <i class="fa fa-fw fa-user"></i> Sign in</a>
                </li>
                <li class="nav-item active">
                  <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a>
                </li>
              </ul>

              <form class="form-inline my-2 my-lg-0">

                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
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
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" maxlength="64" value='${account.email}' required autofocus>
                <label for="inputEmail">Email address</label>
              </div>
              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" maxlength="64" value='${account.password}' required>
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

          <div id="positionIndex">
            <form:form name="login" method="post" action="checklogin" modelAttribute="account">
              Email:<br>
              <span>
		             <input name="email" type="text" maxlength="64" value='${account.email}'><br>
		            </span>
              <span>
		             password:<br>
		              <input class="loginUserPass" id="pass-Loginid" name="password" type="password" maxlength="64" value='${account.password}'>
		          
		            </span>
              <input type="submit" value="login" />

            </form:form>
          </div>

  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://kit.fontawesome.com/9008cdf4dc.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </body>
        </html>