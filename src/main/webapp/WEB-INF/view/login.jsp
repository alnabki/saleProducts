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
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
<style><%@include file="/resources/css/mystyle.css"%></style>
</head>

 <body> 
 
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                 <a class="active" href="/saleProducts/"><i class="fa fa-fw fa-home"></i> Home</a> 
            </li>
            <li class="nav-item active">
                 <a href="login"    >  <i class="fa fa-fw fa-user"></i> Sign in</a> 
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
        
        <div id= "positionIndex" >
           <br>
			    <h1>Login</h1>
			<br>
				<form:form name="login" method="post" action="checklogin" modelAttribute="account">
				             Email:<br>
				             <span>
				             <input class="loginUserName" id="userid" name="email" type="text" value="" maxlength="64"   value='${account.email}'><br>
				            </span>
				            <span>
				             password:<br>
				              <input class="loginUserPass" id="pass-Loginid" name="password" type="password" value="" maxlength="64"   value='${account.password}'>
				          
				            </span>
				              <input  type="submit" value="login"/> 
				     
			     </form:form>
        </div>
      

</body>

</html>