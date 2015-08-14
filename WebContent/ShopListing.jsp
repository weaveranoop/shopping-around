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
    <title>List | R-Shopping</title>
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

<form action="prod" method="post">
<div class="col-sm-3">
		<div class="search_box" style="padding-left: 10px">
				<input type="text" placeholder="Search" name="item">
		</div>
</div>
</form>
	<div class="features_items"><!--features_items-->

						<h2 class="title text-center">You can shop in</h2>
													
							
							 
						<c:forEach items="${requestScope.slist}" var="s">
      
      <div class="col-sm-4">
		 				<div class="product-image-wrapper" >
								<div class="single-products">
										<div class="productinfo text-center" >
											<img src="images/home/market1.jpg" alt="">
												<h2>${s.shop_name }</h2>
												<p>${s.location }</p>
											<a href="SearchProduct?shop_id=${s.shop_id }" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Shop Here</a>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
													<h2>${s.shop_name }</h2>
													<p>${s.location }</p>
												<a href="SearchProduct?shop_id=${s.shop_id }" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Shop Here</a>
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