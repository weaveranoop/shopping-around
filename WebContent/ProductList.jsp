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
    <title>Area | R-Shopping</title>
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

<div class="features_items"><!--features_items-->

<!-- 						<h2 class="title text-center">You can shop in</h2> -->
						<h2 class="title text-center">${requestScope.sname }</h2>
						<c:forEach items="${requestScope.plist}" var="p">
      
        
						<div class="col-sm-4">
							<div class="product-image-wrapper" >
								<div class="single-products">
										<div class="productinfo text-center" >
											<img src="images/home/product1.gif" alt="">
											<h2>Rs. ${p.price }</h2>
											<p>${p.product_name}</p>
											
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
												<h2>Rs. ${p.price }</h2>
											<p>${p.product_name}</p>
												
											</div>
										</div>
								</div>
								
							</div>
						</div>
						</c:forEach>  
						
</div>

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