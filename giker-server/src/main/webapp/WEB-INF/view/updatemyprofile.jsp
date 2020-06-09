<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width initial-scale=1">
  <title>Giver Profile</title>
  <!-- fevicon -->
  <link rel="icon" href="favicon.ico">

  <!-- font -->
  <link href="https://fonts.googleapis.com/css2?family=Nova+Mono&family=Oxygen+Mono&family=Roboto+Condensed:wght@700&display=swap" rel="stylesheet">
  <!-- css -->
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="/updatemyprofile/index.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">


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
          <a class="nav-link" href=""><img src="/updatemyprofile/profile.png" alt="pr"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> <img src="/updatemyprofile/uploadxxs.png" alt="u"> </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><img src="/updatemyprofile/logout.png" alt="o"></a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- heading -->
  <h1>giker</h1>

<div class="container">
  <div class="c1">
    <div class="col-12 username name">
         
         <p>Username:${user.username}</p>
       </div>
       <div class="col-12 n name">
         <p>Name:${user.firstname} ${user.lastname}</p>
       </div>
       <div class="col-12 name phone">
         <p>Phone: ${user.phone}</p>
       </div>
       
       
       
         <c:if test="${not empty user.dob}">
        <div class="col-12 n name">
         <p>DOB:${updateprofiledto.dobstring}</p>
       </div>
       </c:if>
       
       
       <c:if test="${empty user.dob}">
       <div class="col-12 username name">
         <form:form class="" action="updatedob" modelAttribute="updateprofiledto" method="post">
           <label for="dob">DOB:</label>
           <form:input  path="dobstring"  placeholder="DD/MM/YY  *Please follow the pattern"/>
           <button class="update" type="submit" name="button"><img src="https://img.icons8.com/carbon-copy/30/000000/approve-and-update.png"/></button>
         </form:form>
       </div>
       </c:if>
       
       <div class="col-12 email name">
         <form:form modelAttribute="updateprofiledto" class="" action="updatemail" method="post">
           <label for="email">Email:</label>
           <form:input type="email" path="email" placeholder="13132" />
           <button class="update" type="submit" name="button"><img src="https://img.icons8.com/carbon-copy/30/000000/approve-and-update.png"/></button>
         </form:form>
       </div>
       
      
       
        <div class="col-12 email name">
         <form:form modelAttribute="updateprofiledto" class="" action="updateinstagram" method="post">
           <label for="email">Instagram:</label>
           <form:input type="text" path="instagram" placeholder="" />
           <button class="update" type="submit" name="button"><img src="https://img.icons8.com/carbon-copy/30/000000/approve-and-update.png"/></button>
         </form:form>
       </div>
       <div class="col-12 pic name">
         <form:form modelAttribute="updateprofiledto" enctype="multipart/form-data" class="name" action="updateimage" method="post">
           <label for="pic">My 🌽:</label>
           <form:input type="file"  path="image"/>
           <button class="update" type="submit" name="button"><img src="https://img.icons8.com/carbon-copy/30/000000/approve-and-update.png"/></button>
         </form:form>
       </div>
  </div>
  <div class="c2">
    <div class="c11">
      <div class="col-12 password name">
         <form class="" action="index.html" method="post">
           <input class="top" type="password" id="email" name="" value="" placeholder="old password" required><br>
           <input class="middle" type="password" id="email" name="" value="" placeholder="new password" required><br>
           <input class="bottom" type="password" id="email" name="" value="" placeholder="comfirm password" required>
           <button class="update" type="submit" name="button"><img src="https://img.icons8.com/carbon-copy/30/000000/approve-and-update.png"/></button>
         </form>
       </div>
    </div>
    <div class="c12">
      <h5 class="name">Public:</h5>
         <form:form modelAttribute="updateprofiledto" class="name" action="updatepublicinfo" method="post">
           <form:checkbox  path="publicinfo"  value="age"/>
           <label for="age">Age</label><br>
           <form:checkbox  path="publicinfo"  value="instagram"/>
           <label for="insta">Instagram</label><br>
          <form:checkbox  path="publicinfo"  value="phone"/>
           <label for="mobile">Phone</label><br>
           <form:checkbox  path="publicinfo"  value="email"/>
           <label for="mail">Email</label><br>
           <button class="update" type="submit" name="button"><img src="https://img.icons8.com/carbon-copy/30/000000/approve-and-update.png"/></button>
         </form:form>
    </div>
  </div>
</div>


  <!-- script -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
