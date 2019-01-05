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
		       <c:forEach var="product" items="${products}" varStatus="status">
			          <form:form name="formupdateproducts" method="post" action="updateproduct" modelAttribute="product">
			          
					      <tr>
				              <td>${status.index + 1}</td>
				                  <input type='hidden' name="id"       value ='${product.id}'/>
				              <td><input type='text'   name="name"     value ='${product.name}'     required/></td>
				              <td><input type='text'   name="quantity" value ='${product.quantity}' required/></td>
				              <td><input type='text'   name="price"    value ='${product.price}'    required/></td>
				              <td > <a href="getproduct?id=${product.id}"  >  GO</a>     </td>
				              <td > <a href="deleteproduct?id=${product.id}">  DELETE</a> </td>	                   
				              <td > <input type="submit" value="UPDATE"   />             </td>
					      </tr>
					     
		              </form:form>
		        </c:forEach>
		         <form:form name="addForm" action="addproduct"  method="post" modelAttribute="product" >
                        <td></td>
	                    <td><input type='text'   name="name"     value ='${product.name}'     required/></td>
				              <td><input type='text'   name="quantity" value ='${product.quantity}' required/></td>
				              <td><input type='text'   name="price"    value ='${product.price}'    required/></td>
	                    <td ><input type="submit" value="ADD Product     "/></td>            
                    </form:form>       
	            </table>
			
             </table>
</div>
</body>
</html>