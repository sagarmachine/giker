
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width initial-scale=1">
  <title>pending</title>
  <!-- fevicon -->
  <link rel="icon" href="favicon.ico">

  <!-- font -->
  <link href="https://fonts.googleapis.com/css2?family=Nova+Mono&family=Oxygen+Mono&family=Roboto+Condensed:wght@700&display=swap" rel="stylesheet">
  <!-- css -->
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/sellerform/index.css">


  <!-- script -->

</head>

<body>

  <!-- nav -->
  <nav class="navbar bg-dark navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="" id="c">GIKER</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="">contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">about</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=""><img src="/sellerform/profile.png" alt="pr"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> <img src="/sellerform/uploadxxs.png" alt="u"> </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><img src="/sellerform/logout.png" alt="o"></a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- heading -->
  <div class="bigb">
    <h1>giker</h1>
    <form:form action="addmyshop" modelAttribute="dto" method="post" enctype="multipart/form-data">
    <div class="container">
      <div class="left-box">
	   <div class="shopDistrict">
          <label class=shop-district for="">District:</label><br>
		  <form:select path="city" id="location" class="select-btn" name="">
            <form:options items="${dto.citylist}" />
          </form:select>
       
	   </div>
		
        <div class="shopName">
          <label class=shop-namee for="">Shop Name:</label><br>
          <form:input class="shop-name-input" type="text" path="shopname"/>
        </div>
        <div class="shopAdd">
          <label class=shop-add for="">Shop Address:</label><br>
          <form:textarea class="shop-add-input" name="name" rows="" cols="" path="location" />
        </div>
        <div class="shopPincode">
          <label class=shop-pin for="">Pincode:</label><br>
          <form:textarea path="pincode" class="shop-pin-input" type="text-field" name="" value=""/>
          <button class="btn btn-dark btn-sm" type="button" name="button">Check</button>
        </div>
      
        <div class="shopno1">
          <label class="shop-state" for="">Primary Contact:</label><br>
          <input class="shop-state-input" type="text" name="" value="456789132" disabled>
        </div>
        <div class="shopno2">
          <label class="shop-no2" for="">Secondary Contact:</label><br>
          <form:input class="shop-no2-input" type="tel" name="" value="" path="secondaryphone"/>
        </div>
        <div class="file">
		 <label class="shop-state"  for="">Pic For Your Shop:</label><br>
        <form:input class="fi"  type="file" name="" value="choose a file" path="pic"/>
        </div>
      </div>
      <div class="right-box">
        <div class="homeDelivery">
          <label for="" class="home-delivery">Home Delivery:</label><br>
          
          <form:radiobutton path="homedelivery" id="yes"  name="hd" value="Y"/>
          <label for="yes">Yes</label>
          <form:radiobutton path="homedelivery" id="no" name="hd" value="N"/>
          <label for="no">No</label>
          
        </div>
        <div class="instagram">
          <label for="" class="insta">Instagram:</label><br>
          <form:input type="text" name="" value="" class="insta-input" path="instagram"/>
        </div>
        <div class="description">
          <label for="" class="qdes">Quick description:</label><br>
          <form:textarea name="name" rows="" cols="" class="qdes-input"  path="description"/>
        </div>
        <div class="catagory">
          <label for="" class="ceta">Category:</label><br>
          <form:select path="category">
            <form:options items="${dto.categorylist}"/>
          </form:select>
        </div>
         <div class="register  text-right">
          <button class="btn btn-success" type="submit" name="button">Register</button>
        </div>
       </div>
      </div>
       </form:form>
    
   </div>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>

</html>
