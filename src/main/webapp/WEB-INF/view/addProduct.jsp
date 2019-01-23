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

<body background="<c:url value='/resources/images/laptopBackground3.png'  />">
<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
        </div>
        
        <ul>
         <li> <a href="addproduct">Add Product</a> </li>
         <li> <a href="viewsales">View sales</a> </li>
         <li> <a href="managecustomers">Manage Account</a> </li>
         <li><a href="admin">Back</a></li>
        </ul>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<div align="center">
	     <h1 ><i>Products for sale<b></b></i></h1>
		     <table border="1">
			      <tr class="staticInfoTable">
			          <th>S.No.</th>
			          <th>Products name</th>
			          <th>quantity</th>
			          <th>price</th>
			          <th>Photos</th>
			          <th>Edit</th>
			      </tr>  
		       <c:forEach var="product" items="${productViews}" varStatus="status">
			          <form:form name="formupdateproducts" method="post" action="updateproduct" modelAttribute="product">
			          
					      <tr>
					           <input type='hidden' name="id"       value ='${product.id}'/>
				              <td  height=100 width=20>${status.index + 1}</td>
				                  
				             
				             
				                <td  height=100 width=20>${product.name}</td>
				             
				                <td  height=100 width=20>${product.quantity}</td>
				             
				                <td  height=100 width=20>${product.price}</td>
				                     
				             
				                <td height=100 width=50 ><img class="imageProduct1"  src="<c:url value="/resources/images/${product.fileName}"  />"/></td>
				                <td  height=100 width=20   > <a href="getproduct?id=${product.id}">Edit</a> </td> 
				                 
	                       
					      </tr>
		               </form:form>
		        </c:forEach>
		      </table>
					      <br> <br><br> <br> 
					      
                      <h1 ><i>Add New Product<b></b></i></h1>
		          
         <form:form method="post" action="savefiles&update" modelAttribute="uploadForm" enctype="multipart/form-data">
 
            <p>Select files to upload. Press Add button to add more file  inputs.</p>
            
	            <table id="fileTable">
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
	            
                  
                 
                     <input type="submit"  name="savefiles" value="upload"/>    <br/>
               </form:form>  
                <table>
		             <tr class="staticInfoTable">
			        
			          <th>Products name</th>
			          <th>quantity</th>
			          <th>price</th>
			         
			        </tr>  
		            <form:form id="usrform" name="addForm" action="addproduct"  method="post" modelAttribute="product" >
                          <tr>
                              
	                          <td><input type='text'   name="name"     value ='${product.name}'     required/></td>
				              <td><input type='text'   name="quantity" value ='${product.quantity}' required/></td>
				              <td><input type='text'   name="price"    value ='${product.price}'    required/></td>
				               
			              </tr>
	           </table> <br>
	                        Description =<textarea   rows="4" cols="50" name="description" form="usrform">
                                             ${product.description}</textarea>  
	                        <br><br>
			               <input type="submit" value="     ADD Product   "/>
                    </form:form> 
			</div>
</body>
</html>
			
			
