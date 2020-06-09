<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Register</title>
  <link rel="icon" href="favicon.ico">

  <!-- css -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="/home/style.css">

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
    <a class="navbar-brand" href="">GIKER</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">


        <li class="nav-item">
          <a class="nav-link" href="">Contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/simon">SIMON</a>
        </li>
           <li class="nav-item">
          <a class="nav-link" href="/user/showmyprofile"><img src="/home/profile.png" alt="dp"></a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="logout"> <img src="/home/logout.png" alt="logout"> </a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- head -->
 <div class="row giker">
    <div class="col">
      <p class="slogan"> Giker</p>
    </div>
  </div>

  <!-- button -->
  <div class="row justify-content-around">

    <button formaction="user/slider" onclick="window.location.href='user/showslider'" type="button"  class="col-xs-12 col-sm-12 col-md-3 col-sm-offset-3 col-md-offset-2 btn btn-light btn-lg"><img src="/home/uploadsm.png" alt="">
      <h3 class="h3h">I'm a Taker</h3>
    </button>

    <button formaction="/user/myprofile" onclick="window.location.href='user/showmyprofile'" type="button" class="col-xs-12 col-sm-12 col-md-3 col-sm-offset-3 col-md-offset-2 btn btn-light btn-lg"><img src="/home/downloadsm.png" alt="">
      <h3 class="h3h">I'm a Giver</h3>
    </button>
   
  </div>

  <!-- Form       -->

  <div class="container con">
    <hr id="hrmove">

    <div class="  row justify-content-center">
      <div class="row-bg col-xs-12 col-sm-12 col-md-6 col-sm-offset-2 col-md-offset-3">
        <form:form action="/registeruser" method="POST" modelAttribute="user" role="form">
          <h2>Please Sign Up <small>It's free and always will be.</small></h2>
          <hr class="colorgraph">
          <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6">
              <div class="form-group">
              
                <form:input  required="required" type="text" path="firstname" name="firstname" id="firstname" class="form-control input-lg" placeholder="first name" tabindex="1" />
              </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-6">
              <div class="form-group">
                <form:input  required="required" type="text" path="lastname" name="lastname" id="lastname" class="form-control input-lg" placeholder="last name" tabindex="2"/>
              </div>
            </div>
          </div>
          <div class="form-group">
            <form:input  required="required" type="text"  path="username" name="username" id="username" class="form-control input-lg" placeholder="username" tabindex="3"/>
          </div>
          <div class="form-group">
            <form:input   type="email" path="email" name="email" class="form-control input-lg" placeholder="email" tabindex="4"/>
          </div>
          <div class="form-group">
            <form:input required="required" type="tel"      maxlength="10" size="10" path="phone" name="phone"  class="form-control input-lg" placeholder="phone number" tabindex="5"/>
          </div>
          <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6">
              <div class="form-group">
                <form:input  required="required" type="password" path="password" name="password" id="password" class="form-control input-lg" placeholder="password" tabindex="6"/>
              </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-6">
              <div class="form-group">
                <input  required="required" type="password" name="passwordconfirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="7"/>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-4 col-sm-3 col-md-3">
              <span class="button-checkbox">
                <button type="button" class="btn" data-color="info" tabindex="8">I Agree</button>
                <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">
              </span>
            </div>
            <div class="col-xs-8 col-sm-9 col-md-9">
              By clicking <strong class="label label-primary">Register</strong>, you agree to the <a href="#" data-toggle="modal" data-target="#t_and_c_m">Terms and Conditions</a> set out by this site, including our Cookie Use.
            </div>
          </div>
          <c:if test="${not empty registermsg}">
          <p class="warning">${registermsg}</p>
          </c:if>
          <hr class="colorgraph">
          <div class="row">
            <div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-dark btn-block btn-lg" tabindex="8"></div>

          </div>





        </form:form>
      </div>
    </div>
  </div>

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
<% session.setAttribute("registermsg",null);%>>
