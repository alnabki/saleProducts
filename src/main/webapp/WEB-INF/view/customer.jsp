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
<body> 
 <!-- <img  src="<c:url value="/resources/images/laptopBackground.png" />"/><br> -->

<div align="right">
          <jsp:include  flush="true" page="/WEB-INF/view/header.jsp"/>
</div>
<div class="container">
      <div class="row">
        <div class="col-lg-3">
          <h1 class="my-4">Shop Name</h1>
          <div class="list-group">
            <div class="list-group-item">
              <form action="">
                <div class="form-group">
                  <!--  <input type="text" class="form-control" id="" placeholder="Search for items"/>-->
		                 <form:form class="form-inline my-2 my-lg-0" name="getForm"  action="search"  method="get" modelAttribute="product">
			             
			             <input  class="form-control mr-sm-2" type="text" placeholder="Search1"  aria-label="Search">
			             <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			         </form:form> 
                </div>
              </form>
            </div>
            <a href="#" class="list-group-item"><i class="fas fa-mobile mr-2"></i>Phones</a>
            <a href="#" class="list-group-item"><i class="fas fa-tv mr-2"></i>TV´s</a>
            <a href="#" class="list-group-item"><i class="fas fa-tshirt mr-2"></i>Clothes</a>
          </div>
        </div>
                <div class="col-lg-9">
          <div
            id="carouselExampleIndicators"
            class="carousel slide my-4"
            data-ride="carousel"
          >
            <ol class="carousel-indicators">
              <li
                data-target="#carouselExampleIndicators"
                data-slide-to="0"
                class="active"
              ></li>
              <li
                data-target="#carouselExampleIndicators"
                data-slide-to="1"
              ></li>
              <li
                data-target="#carouselExampleIndicators"
                data-slide-to="2"
              ></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img
                  class="d-block img-fluid"
                  src="https://cdn.pixabay.com/photo/2016/09/01/10/23/image-1635747_960_720.jpg"
                  alt="First slide"
                />
              </div>
              <div class="carousel-item">
                <img
                  class="d-block img-fluid"
                  src="https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg"
                  alt="Second slide"
                />
              </div>
              <div class="carousel-item">
                <img
                  class="d-block img-fluid"
                  src="http://placehold.it/900x350"
                  alt="Third slide"
                />
              </div>
            </div>
            <a
              class="carousel-control-prev"
              href="#carouselExampleIndicators"
              role="button"
              data-slide="prev"
            >
              <span
                class="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span class="sr-only">Previous</span>
            </a>
            <a
              class="carousel-control-next"
              href="#carouselExampleIndicators"
              role="button"
              data-slide="next"
            >
              <span
                class="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

 <div id="positionIndex" >
  
	    <h1  align="center"><i>Products for sale<b></b></i></h1>
	      <hr class="my-4">
	      <c:forEach var="product" items="${productViews}" varStatus="status">
			    <form:form id="usrform" name="getForm" action="addtobasket"  method="post" modelAttribute="basket" >  
			                          
		                             
		                              <h2 ><b><u> ${product.name} </u></b></h2> 
		                              <b>S.No.</b>                  =  ${status.index + 1} <br>
		                              
                                      <input type="hidden" name="product.id"  value="${product.id}" />
                                      <input type="hidden" name="product.name"  value="${product.name}" />
                                      <input type="hidden" name="product.fileName"  value="${product.fileName}" />
                                      <input type="hidden" name="price"      value="${product.price}" />
                                      <input type="hidden" name="account.id" value="${log.account.id}" />
                                      
                                      <b>Quantity in the Store</b>  =  ${product.quantity} <br>
                                      <b>Price </b>                 =  ${product.price} Kr <br>
                                      <b>Quantity</b>               = <input type="number"  name="quantityShop" value="${quantityShop}" required />
                                    
                                      <input type="submit" value="Add to basket "   /><br>
               
                                      
				                      
                                      <img class="imageProduct"  src="<c:url value="/resources/images/${product.fileName}" />"/><br> <br>
                                       <b>Description</b>        =  ${product.description} <br> 
                    </form:form>
           <hr class="my-4">		     
		          
		        </c:forEach>
		       </div>
					 

</body>
</html>