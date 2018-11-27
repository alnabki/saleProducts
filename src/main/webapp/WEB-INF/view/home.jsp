<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style><%@include file="/resources/css/mystyle.css"%></style>
    <link rel="stylesheet" href="<c:url value="/resources/css/mystyle.css"/>" >
</head>
<body>



<h1>
	Hello world!  
	
</h1>
<h1>
   
	Hello world!  
  
   
   	
	<a href="login">Click here to See test page... </a>
</h1>

<P>  The time on the server is ${serverTime}. </P>

</body>
</html>
