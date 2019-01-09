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
    $(document)
            .ready(
                    function() {
                        //add more file components if Add is clicked
                        $('#addFile')
                                .click(
                                        function() {
                                            var fileIndex = $('#fileTable tr')
                                                    .children().length - 1;
                                            $('#fileTable')
                                                    .append(
                                                            '<tr><td>'
                                                                    + '   <input type="file" name="files['+ fileIndex +']" />'
                                                                    + '</td></tr>');
                                        });
 
                    });
</script>

<body background="<c:url value='/resources/images/laptopBackground3.png'  />">
<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
        </div>
<br><br><br><br><br><br><br><br><br><br><br><br><br>

<div align="center">
	     <h1 ><i>Products for sale<b></b></i></h1>
		     <table border="1">
			      <tr class="staticInfoTable">
			          <th>S.No.</th>
			          <th>Products name</th>
			          <th>quantity</th>
			          <th>price</th>
			          <th>Edit</th>
			          <th>Delete</th>
			          <th>Update</th>
			          <th>Photos</th>
			      </tr>  
		       <c:forEach var="product" items="${products}" varStatus="status">
			          <form:form name="formupdateproducts" method="post" action="updateproduct" modelAttribute="product">
			          
					      <tr>
				              <td>${status.index + 1}</td>
				                  <input type='hidden' name="id"       value ='${product.id}'/>
				              <td><input type='text'   name="name"     value ='${product.name}'     required/></td>
				              <td><input type='text'   name="quantity" value ='${product.quantity}' required/></td>
				              <td><input type='text'   name="price"    value ='${product.price}'    required/></td>
				              <td > <a href="getproduct?id=${product.id}"  > Edit</a>     </td>
				              <td > <a href="deleteproduct?id=${product.id}">  DELETE</a> </td>	                   
				              <td > <input type="submit" value="UPDATE"   />             </td>
				               <td >  <img  src="<c:url value="c:/saleUploadFolder/mm1.png" />"/>    </td>
					      </tr>
					     
		              </form:form>
		        </c:forEach>
		              
	            </table>
			
			</div>

   <div align="center">
        <h1>Sale - Spring MVC Upload Multiple Files Example</h1>
 
        <form:form method="post" action="savefiles.html" modelAttribute="uploadForm" enctype="multipart/form-data">
            
 
            <p>Select files to upload. Press Add button to add more file  inputs.</p>
            
	            <table id="fileTable">
	                <tr>
	                    <td><input name="files[0]" type="file" /></td>
	                </tr>
	                <tr>
	                    <td><input name="files[1]" type="file" /></td>
	                </tr>
	            </table>
            <br />
            
            <input type="submit" value="Upload" />
            <input id="addFile" type="button" value="Add File" />
        </form:form>
 
        <br />
    </div>



</body>
</html>
			
			<!--  
		     	<div id="global">
        <form:form name="productImage" action="save-product" method="post" modelAttribute="productImage" enctype="multipart/form-data">
            <fieldset>
                <legend>Add a productImage</legend>
                <p>
                    <label for="name">ProductImage Name: </label>
                   <input type='text'   name="name" value ='${productImage.name}' required/>
				             
                   
                </p>
                <p>
                    <label for="description">Description: </label>
                    <input type='text'   name="description" value ='${productImage.description}' required/>
                </p>
                <p>
                    <label for="image">ProductImage Images: </label>
                    <input type="file" name="images" multiple="multiple"/>
                    
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4">
                    <input id="submit" type="submit" tabindex="5" value="Add ProductImage">
                </p>
            </fieldset>
        </form:form>
    </div>
       -->    
