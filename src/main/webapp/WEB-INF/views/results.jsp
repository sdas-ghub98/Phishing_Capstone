<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doppelganger Results</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<center><img src="resources/logo.png" alt="Doppelganger Logo" height="300px" width="200px"></center>
<br>
<div class="container">
	<br><br>
	<div class="jumbotron">
	<h2>URL entered by you : ${UserInput}</h2>
	</div>
	<br>
	<h3>What our directory search says...?</h3><br>
	
	<c:if test="${Java}">
	<c:out value="${Java}"/>
	<c:if test="true">
	<c:out value=" It is a Phishing website"/>
	</c:if>
	<c:if test="false">
	<c:out value="It is not a Phishing website"/>
	</c:if>
	</c:if> 
	<hr>
	<div class="row">
		<p> Your URL is <button class="btn btn-danger">Unsafe to visit</button></p>	
	</div>
	If the URL is not database
	<div class="row">
		<p> Your URL is <button class="btn btn-success">Safe to visit</button><br>
		Based on the database, the protocol, filepath and domain names, the URL entered seems to be safe to visit
		</p>
	</div>
	
	<!-- <h3>What our machine learning algorithm says...?</h3> -->
</div>
</body>
</html>