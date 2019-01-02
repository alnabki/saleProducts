<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	     <h1 ><i>Products<b></b></i></h1>
		     <table border="1">
			      <tr class="staticInfoTable">
			          <th>S.No.</th>
			          <th>Products name</th>
			          <th>quantity</th>
			          <th>price</th>
			          <th>Select</th>
			          <th>Delete</th>
			          <th>Update</th>
			      </tr>  
		        
			          <form:form name="formshowproducts" method="post" action="showproducts" modelAttribute="product">
					      <tr>
				              <td>${status.index + 1}</td>
				                  <input type='hidden' name="id"       value ='${product.id}'/>
				              <td><input type='text'   name="name"     value ='${product.name}'     required/></td>
				              <td><input type='text'   name="quantity" value ='${product.quantity}' required/></td>
				              <td><input type='text'   name="price"    value ='${product.price}'    required/></td>
				              <td > <a href="getproduct?id=${project.id}"  >  GO</a>     </td>
				              <td > <a href="deleteprduct?id=${project.id}">  DELETE</a> </td>	                   
				              <td > <input type="submit" value="UPDATE"   />             </td>
					      </tr>
		              </form:form>
			   
             </table>
</div>
</body>
</html>