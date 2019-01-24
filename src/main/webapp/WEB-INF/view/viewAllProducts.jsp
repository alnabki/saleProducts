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
        
        <ul>
         <li> <a href="addproduct">Add Product</a> </li>
         <li> <a href="viewsales">View sales</a> </li>
         <li> <a href="managecustomers">Manage Account</a> </li>
         <li><a href="admin">Back</a></li>
        </ul>
     


	     <h1 ><i>Products for sale<b></b></i></h1>
	     ---------------------------------------------------------------------------------------------------------------<br>
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			        
			          
		 
			                         <input type='hidden' name="id"       value ='${product.id}'/>
			         S.No.        =  ${status.index + 1} <br>
			         Products name=  ${product.name}  <br> 
			         Quantity     =  ${product.quantity} <br>
			         Price        =  ${product.price}  <br>
				     Description  =  ${product.description} <br>        
				            
				         
			                    <td>  <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/></td>
                              <br><br>
         ---------------------------------------------------------------------------------------------------------------------<br>                     
					     
		          
		        </c:forEach>
		      
					 

</body>
</html>
			
			
