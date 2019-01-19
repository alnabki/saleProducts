<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/resources/css/mystyle.css"%></style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login</title>
</head>
<body background="<c:url value='/resources/images/laptopBackground3.png'  />">


        <div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
        </div>
        
        <ul>
         <li> <a href="addproduct">Add Product</a> </li>
         <li> <a href="viewsales">View sales</a> </li>
         <li> <a href="managecustomers">Manage Account</a> </li>
        </ul>
        
        <br><br><br><br><br><br><br><br><br><br>
       <div align="center">
         <h1 ><i> Products<b></b></i></h1>
         <table  >
		      <tr>
		          <th>S.No.</th>
		          <th>Products name</th>
		          <th>quantity</th>
		          <th>price</th>
		      </tr>  
	          <c:forEach var="product" items="${products}" varStatus="status">
		      <tr >
	              <td> ${status.index + 1}   </td>
	              <td> ${product.name}       </td>
	              <td> ${product.quantity}   </td>
	              <td> ${product.price}      </td>
		      </tr>
		     </c:forEach>
          </table>
          <br><br>
          
           <h1 ><i>Customers<b></b></i></h1>
           
          <table  >
		      <tr>
		          <th>S.No.    </th>
		          <th> Name    </th>
		          <th> Email   </th>
		          <th> Password</th>
		          <th> Address </th>
		          <th> Age     </th>
		          <th> Phone   </th>
		      </tr>  
	          <c:forEach var="customer" items="${customers}" varStatus="status">
		      <tr >
	              <td> ${status.index + 1}   </td>
	              <td> ${customer.name}      </td>
	              <td> ${customer.email}     </td>
	              <td> ${customer.password}  </td>
	              <td> ${customer.address}   </td>
	              <td> ${customer.age}       </td>
	              <td> ${customer.phone}     </td>
		      </tr>
		     </c:forEach>
		    </table>
		       
            <br><br>
               <h1 ><i>Orders<b></b></i></h1>
		      <table >
		      <tr>
		          <th>S.No.    </th>
		          <th> CustomerName   </th>
		          <th> Product   </th>
		      </tr> 
		       <c:forEach var="order" items="${orders}" varStatus="status"> 
		          <tr >
		             <td> ${status.index + 1}       </td>
		             <td> ${order.customer.name }   </td>
		             <td> ${order.product.name }    </td>
		          </tr>   
		       </c:forEach>
		       
            </table>
            </div>
</body>
</html>



<!--  
       <img  src="<c:url value="/resources/images/laptopBackground2_02.gif" />" width="460" height="345" />
      
         <div align="center">
	          <p class="site-title" itemprop="headline" >
	          <a href="http://localhost:8080/saleProducts/"> <font size="7" ><b>DealBig</b></font></a>
	          </p>
          </div>
 --> 