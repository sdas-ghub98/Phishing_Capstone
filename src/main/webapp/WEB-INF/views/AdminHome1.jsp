<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	  <link href="<c:url value="/resources/bootstrap/style.css"/>" rel="stylesheet">
	   <link href="<c:url value="/resources/bootstrap/javascr.js"/>" rel="stylesheet">
	    <link href="css/font-awesome.css" rel="stylesheet">
	     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
	   



<title>Admin Home</title>
</head>
<body>
<p>Hello Admin</p>
<c:if test="${loggedin==true}">
<a class="btn btn-primary btn-md" data-submit="parent" href="${pageContext.request.contextPath}/logout" rel="nofollow">
               <i class="icon-off"></i> Logout
            </a></c:if>

<a href="adminmanage">Admin Home</a>
</body>
</html>