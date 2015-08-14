<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Category | R-Shopping</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">

</head>


<body>

<c:if test="${sessionScope.username ne null }">
<%@include file="header1.jsp" %>

<section>
							
		<div class="brands_products">
			<h2>Choose a Category</h2>
				<div class="brands-name">
				<form action="scat">
					<ul class="nav nav-pills nav-stacked" align="center">
						<li><a href="SearchByCategory?cat=electronics"> Electronics </a></li>
						<li><a href="SearchByCategory?cat=clothing"> Clothing </a></li>
						<li><a href="SearchByCategory?cat=sports"> Sports </a></li>
						<li><a href="SearchByCategory?cat=footwear"> Footwear </a></li>
						<li><a href="SearchByCategory?cat=food"> Food </a></li>
						<li><a href="SearchByCategory?cat=departmental"> Departmental </a></li>
					</ul>
				</form>
				</div>
			</div>
					
</section>
</c:if>
<c:if test="${sessionScope.username eq null }">
	<%@include file="header.jsp" %>	
	<div align="center">
		<h3 style="color: red; ">You are not authenticated user.</h3>
		<h4 >Please Login to view the contents of the Page.</h4>
		<a href="SignupPage.jsp">Login</a>
	</div>
	</c:if>
	
</body>
</html>