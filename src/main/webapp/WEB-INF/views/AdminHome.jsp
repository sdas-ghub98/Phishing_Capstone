<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.niit.model.*" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <link href="<c:url value="/resources/bootstrap/style.css"/>" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>


<c:if test="${!flag}">
	<form action="insertUrl" method="post">
		<table class="table">
			<tr>
				<td>Phishing Url Name</td>
				<td><input type="text" name="url"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>



		</table>
	</form>
	</c:if>

	<table class="table">
		<tr>

			<td>Url Id</td>
			<td>Url Name</td>
		</tr>
		
		<c:forEach items="${listUrlAdmin}" var="obj">
		<%
		System.out.println("wow");
		//UrlAdmin obj=(UrlAdmin)sup;
		//System.out.println(sup.getUrl_ID());
		%>
			<tr>
				<td>${obj.url_ID}</td>
				<td>${obj.url}</td>
				



				<td><a href="<c:url value='/editUrl/${obj.url_ID}'/>">Edit</a>
					

				</td>


			</tr>

		</c:forEach>


	</table>


