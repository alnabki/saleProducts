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
          <a href="addproduct">Back</a>
     </div>
     <br><br><br>
      <ul>
         <li> <a href="viewallproducts">View All Products</a> </li>
         <li> <a href="addproduct">Add Product</a> </li>
         <li> <a href="viewsales">View sales</a> </li>
         <li> <a href="managecustomers">Manage Account</a> </li>
         <li><a href="addproduct">Back</a></li>
        </ul>
     
     
     
     <div align="center">
	     <h1 ><i>Edit Product<b></b></i></h1>
	     
	          <c:forEach var="imageName" items="${imageNames}" varStatus="status">
					
					    <img class="imageProduct"  src="<c:url value="/resources/images/${imageName}" />"/>
	           </c:forEach>
	     
         <form:form method="post" action="savefiles&update" modelAttribute="uploadForm" enctype="multipart/form-data">
                <table id="fileTable">
                    <tr>
                       <td>Add  photos to this Product (all old photos will be lost)</td>
                    </tr>
                      <input type='hidden' name="id"       value ='${product.id}'/>
                    <tr>
	                <td><input id="addFile" type="button" value="Add File" /></td>
	                </tr> 
	                   
	                <tr>
	                    <td><input name="files[0]" type="file" /></td>
	                </tr>
	                <tr>
	                    <td><input name="files[1]" type="file" /></td>
	                </tr>
	            </table>
	               <input type="submit"   name="update" value="Upload">
         </form:form>
         
                                        <br/>
                                        
        <form:form id="usrform" name="getForm" action="updateproduct"  method="post" modelAttribute="product" >  
                        <input type='hidden' name="id"             value ='${product.id}'/>
          Products name=<input type='text'   name="name"           value ='${product.name}'     required/>
          quantity     =<input type='text'   name="quantity"       value ='${product.quantity}' required/>
          price        =<input type='text'   name="price"          value ='${product.price}'    required/>
                                      <br> <br>
          Description  =<textarea   rows="4" cols="50" name="description" form="usrform">${product.description}</textarea>
                            
                                        <br> <br>
                       <input type="submit" value="Update"   /> 
                       <button> <a href="deleteproduct?id=${product.id}">   Delete this Product</a></button><br>
          </form:form> 
                      
                                           <br> <br>
      </div>       
	
        
          
</body>
</html>