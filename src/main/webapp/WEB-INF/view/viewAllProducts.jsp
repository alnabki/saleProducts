<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
    $(document).ready(function() {
                        //add more file components if Add is clicked
           $('#addFile').click(function() {
                               var fileIndex = $('#fileTable tr').children().length - 1;
                               $('#fileTable').append('<tr><td>'
                                                       + '   <input type="file" name="files['+ fileIndex +']" />'
                                                       + '</td></tr>');
           });
    });
</script>

<body background="<c:url value='/resources/images/background7.jpg'  />">
<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
        </div>
        <br><br><br>
        <ul>
         <li> <a href="addproduct">Add Product</a> </li>
         <li> <a href="viewsales">View sales</a> </li>
         <li> <a href="managecustomers">Manage Account</a> </li>
         <li><a href="admin">Back</a></li>
        </ul>
     

 <div align="center">
	     <h1 ><i>Products for sale<b></b></i></h1>
	 ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			       <form:form name="formupdateproducts" method="post" action="updateproduct" modelAttribute="product">
			                          <input type='hidden' name="id"       value ='${product.id}'/> 
		                              <h2 >Products name=<b><u> ${product.name} </u></b></h2> 
		                                  S.No.        =  ${status.index + 1} <br>
		                              <a href="getproduct?id=${product.id}"><u> <big> Edit </big> </u></a><br><br>
		                                                        Quantity     =  ${product.quantity} <br>
			                                                     Price        =  ${product.price}  <br>
		                              <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/><br>
			                        
			        
			        
			        
				     Description  =  ${product.description} <br><br><br>        
				            
				         
			                       
                    </form:form> 
                              <br><br>
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>                     
					     
		          
		        </c:forEach>
		       </div>
					 

</body>
</html>
			
			
