<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | R-Shopping</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">

    <script type="text/javascript">
    
    function svalidate(){
    		   
    		   var name=document.getElementById("sname").value;    		   
    		   var email=document.getElementById("semail").value;
    		   var pass=document.getElementById("spwd").value;
    		   var address=document.getElementById("sadd").value;
    		   var contact=document.getElementById("scontact").value;
    		   var namepatt=/^[a-zA-Z ]+$/;
    		 
    		   var emailpatt=/^[a-zA-Z0-9.]+[@][a-z0-9]+[\.]com|co.in$/;
    		   var contactpatt=/^[0-9]{10}$/;
    		  // var passpatt=/^[a-zA-Z0-9]{8,}$/;
    		   var res1=namepatt.test(name);    		   
    		   var res2=emailpatt.test(email);
    		  // var res3=passpatt.test(pass);
    		   var res4=contactpatt.test(contact);
    		   if(!res1){
    			      alert("name must be only alphabets");
    			      return false;	   
    			   
    			   }
    		   
    		    if(!res2)
    			   {
    			      alert("enter a valid email id");	   
    			      return false;
    			   }
    		    
    		    if (pass.length < 8)
    		    	{
    		    	  alert("password length should be atleast 8 ");
    		    	  return false;
    		    	}
    		    
    		    	 var hasUpperCase = /[A-Z]/.test(pass);
    		    	var hasLowerCase = /[a-z]/.test(pass);
    		    	var hasNumbers = /\d/.test(pass);
    		    	var hasNonalphas = /\W/.test(pass);
    		    	if (hasUpperCase + hasLowerCase + hasNumbers + hasNonalphas < 4)
    		    		{
    		    	       alert("bad password:must have at least one uppercase,one lowercase,one numeric and one non alpha numeric");
    		    	       return false;
    		    		} 
    		    
    		    if(address=="")
    		    {
  			      alert("address should not be empty");	   
  			      return false;
  			   }
    		    
    		    if(!res4)
    			   {
    			      alert("contact number should be of 10 digits");	   
    			      return false;
    			   }
    		   
    		    
    		    return true;
    		   
    		   
    		   
    	   }  
    
    
    
     function lvalidate()
    	   {
    		       		  
    		   var email=document.getElementById("lemail").value;    
    		   var pass=document.getElementById("lpwd").value;
    		   var emailpatt=/^[a-zA-Z0-9.]+[@][a-z0-9]+[\.]com|co.in$/;    		   
    		   var res1=emailpatt.test(email);
    		   
    		    
    		    if(!res1)
    			   {
    			      alert("invalid email id");	
    			      return false;
    			   
    			   }
    		   
    		    if(pass=="")
    		    	{
    		    	   alert("enter password");
    		    	   return false;
    		    	
    		    	}
    		    
    		    return true;       		   
 }  

</script>
</head>

<body>

<%@include file="header.jsp" %>	
<!-- <section id="form">form -->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<form action="login" onsubmit="return lvalidate();" method="post">
							<input type="text" placeholder="Email" name="lemail" id="lemail">
							<input type="password" placeholder="Password" name="lpwd" id="lpwd" >
							<span>
								<input type="checkbox" class="checkbox"> 
								Keep me signed in
							</span>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<form action="signup" onsubmit="return svalidate()" method="post">
							<input type="text" placeholder="Name" name="name" id="sname">
							<input type="text" placeholder="Email Address" name="email" id="semail">
							<input type="password" placeholder="Password" name="password" id="spwd">
							<input type="text" placeholder="Address" name="address" id="sadd">
							<input type="text" placeholder="Contact Number" name="contact" id="scontact">
							<button type="text" class="btn btn-default"  >Signup</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
<!-- 	</section> -->
 	 
</body>

</html>