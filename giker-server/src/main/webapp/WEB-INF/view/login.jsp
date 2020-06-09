<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Giker</title>
  <link rel="icon" href="favicon.ico">


  <!-- css -->

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="/home/login1.css">
  <link rel="stylesheet" href="/home/style.css">

  <!-- fontawesome -->
  <script src="https://kit.fontawesome.com/2aec3b4eb9.js" crossorigin="anonymous"></script>

  <!-- bootstrapScript  -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

  <!-- font -->
  <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&family=Girassol&family=Inconsolata:wght@700&family=Lato&family=Open+Sans&family=Roboto&display=swap" rel="stylesheet">
</head>

<body>

  <!--nav bar-->
  <nav class="navbar bg-dark navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="" id="c">GIKER</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">


        <li class="nav-item">
          <a class="nav-link" href="#footer-contact">Contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">About</a>
        </li>
      </ul>
    </div>
  </nav>

  <hr>

  <!-- header -->

  <div class="row giker">
    <div class="col">
      <p class="slogan"> Giker</p>
    </div>
  </div>

  <!-- login -->
  <div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		<input id="tab-2" type="radio" name="tab" class="for-pwd"><label for="tab-2" class="tab">Forgot</label>
		<div class="login-form">
 <form:form action="loginuser" modelAttribute="user">
			<div class="sign-in-htm">
			  <c:if test= "${not empty loginmsg}">
				<p class="warning">${loginmsg}</p>
				</c:if>
				<div class="group">
					<label for="user" class="label">Username</label>
					<form:input  path="username" id="user" type="text" class="input"/>
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<form:input  path="password" id="pass" type="password" class="input" data-type="password"/>
				</div>
				<div class="group">
					<input type="submit" class="button" value="Sign In">
				</div>
				
      <div class="group">
	      <a  href="/"><button type="button" class="btn btn-link btn-lg custom-btn">Sign Up</button></a>
        </div>
				<div class="hr"></div>
			</div>
		
			</form:form>
			
			<form:form>
			<div class="for-pwd-htm">
		
				<p class="warning">🌡WARNING🌡</p>
				<div class="group">
					<label for="user" class="label">Phone No. or Email</label>
					<input id="user" type="text" class="input">
				</div>
				<div class="group">
					<input type="submit" class="button" value="Reset Password">
				</div>
        <div class="group">
          <button type="button" class="btn btn-link btn-lg custom-btn">Get your username</button>
        </div>
				<div class="hr"></div>
			</div>
			
			</form:form>
		</div>
	</div>
</div>


  <hr>

  <!-- footer -->
  <footer id="footer-contact">
    <h4>Contact on</h4>
    <hr>
    <div class="row">

      <div class="col-lg-4">
        <a href="#">
        <img src="/home/instagramsm.png" alt="instagram">
          <p>Instagram</p>
        </a>
      </div>
      <div class="col-lg-4">
        <a href="#">
          <img src="/home/twittersm.png" alt="twitter">
          <p>twitter</p>
        </a>
      </div>
      <div class="col-lg-4">
        <a href="#">
          <img src="/home/facebooksm.png" alt="facebook">
          <p>facebook</p>
        </a>
      </div>
    </div>

  </footer>




</body>

</html>

<% session.setAttribute("loginmsg",null);%>>
