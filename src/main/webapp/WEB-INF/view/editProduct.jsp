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
<body background="<c:url value='/resources/images/laptopBackground3.png'  />">
     <div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
     </div>
     <br><br><br><br><br><br><br><br><br><br><br><br>
     
     <div align="center">
     
     
     
	     <h1 ><i>Edit Product<b></b></i></h1>
        
        
        
        
        <h1>Add more photo to this Product</h1>
         <form:form method="post" action="savefiles&update" modelAttribute="uploadForm" enctype="multipart/form-data">
                <table id="fileTable">
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
			        <form:form name="getForm" action="updateproduct"  method="post" modelAttribute="product" >  
			                        <input type='hidden' name="id"       value ='${product.id}'/>
			          Products name=<input type='text'   name="name"     value ='${product.name}'     required/>
			          quantity     =<input type='text'   name="quantity" value ='${product.quantity}' required/>
			          price        =<input type='text'   name="price"    value ='${product.price}'    required/>
			           <br> <br>
                      <input type="submit" value="Update"   /> 
                    <button> <a href="deleteproduct?id=${product.id}">   Delete this Product</a></button><br>
                     </form:form> 
                      
                      <br> <br>
                  </div>       
			       
             <div align="center">
             
        
            
		      
	            
			
			</div>
	         
     
        
          
</body>
</html>