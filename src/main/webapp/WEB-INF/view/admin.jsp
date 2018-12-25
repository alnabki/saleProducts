<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login</title>
</head>
<body background="<c:url value='/resources/images/laptopBackground3.png'  />">

<!--  
       <img  src="<c:url value="/resources/images/laptopBackground2_02.gif" />" width="460" height="345" />
      
         <div align="center">
	          <p class="site-title" itemprop="headline" >
	          <a href="http://localhost:8080/saleProducts/"> <font size="7" ><b>DealBig</b></font></a>
	          </p>
          </div>
        --> 
        <div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
        </div>
          
          <nav>
           <ul>
            <li> <a href="/Products/">Products</a> </li>
             <li> <a href="/sales/">sales</a> </li>
           </ul>
        </nav>
       
</body>
</html>