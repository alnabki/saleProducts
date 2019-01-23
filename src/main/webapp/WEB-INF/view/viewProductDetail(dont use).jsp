<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>
<title>Sale - Upload Multiple Files Example</title>
<style type="text/css">
body {
    <body background="<c:url value='/resources/images/laptopBackground3.png'  />">
}
</style>
</head>
<body>
    <br>
    <br>
    <div align="center">
 
        <h1>Sale - Spring MVC Upload Multiple Files Example</h1>
        <p>Awesome.. Following files are uploaded successfully.</p>
        <ol>
            <c:forEach items="${files}" var="file">
           - ${file} <br>
            </c:forEach>
        </ol>
        <a href="http://localhost:8080/saleProducts/addproduct"><input
            type="button" value="Go Back" /></a> <br />
        <br />
        <br />
       
    </div>
</body>
</html>