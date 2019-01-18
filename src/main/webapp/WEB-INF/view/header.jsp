<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    

       <c:if test='${ log.role =="Customer"  }' >
           <div   align='right'>
		        Account: ${log.account.username} 
		        <a href="logout"><button>Logout</button></a><br>

           </div>
      
      
	        
     </c:if>
     <c:if test='${ log.role =="Admin"   }' >
           <div    align='right'>
			    Account: ${log.account.username } 
			    <a href="logout"><button>Logout</button></a>
           </div>
      
     </c:if>
      
</body>
</html>


