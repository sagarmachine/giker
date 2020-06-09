
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width initial-scale=1">
  <title>Giver Profile</title>
  <!-- fevicon -->
  <link rel="icon" href="/myprofile/favicon.ico">

  <!-- font -->
  <link href="https://fonts.googleapis.com/css2?family=Nova+Mono&family=Oxygen+Mono&family=Roboto+Condensed:wght@700&display=swap" rel="stylesheet">


  <!-- css -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="/myprofile/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">


  <!-- script -->

</head>

<body>

  <!-- nav -->
  <nav class="navbar bg-dark navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/" id="c">GIKER</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="">contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="myshop">My Shop</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=""><img src="/myprofile/profile.png" alt="pr"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="showslider"> <img src="/myprofile/uploadxxs.png" alt="u"> </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout"><img src="/myprofile/logout.png" alt="o"></a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- heading -->
  <h1>giker</h1>


  <!-- profile -->
  <div class="container">
    <!-- main row -->
    <div class="row">
      <!-- first column -->
      <div class="col-4 column-1">
        <!-- first column first row -->
        <div class="row profile-box">
          <!-- image row -->
          <c:if test="${empty user.image}">
          <div class="col-12">
            <a class="a-link" href="#"><img class="image" src="/default.jpg"></a>
          </div>
          </c:if>
          <c:if test="${ not empty user.image}">
          <div class="col-12">
            <a class="a-link" href="#"><img class="image" src="data:image/jpeg;base64,${user.profilepic}"></a>
          </div>
          </c:if>
          <!-- name row -->
          <div class="col-12">
            <a class="a-link" href="#">
              <h4>${user.firstname}  ${user.lastname} </h4>
            
            </a>
          </div>
          <!-- rating row -->
          <div class="col-12">
            
             <c:forEach begin="1" end="${reviewservice.getTotalRating(user)}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>  
          </div>
          <!-- request section -->
          <div class="row newadd">

            <div class="col-4 newadd5 requests">
              <a class="a-link" href="#">Accepted</a>
            </div>
            <div class="col-4 newadd5 requests">
              <a class="a-link" href="#">Pending</a>
            </div>
            <div class="col-4 newadd5 requests">
              <a class="a-link" href="#">Declined</a>
            </div>
            <div class="col-4 newadd5 ">
              <a class="a-link" href="myacceptedlist">${myaccepted}</a>
            </div>
            <div class="col-4 newadd5 ">
              <a class="a-link" href="mypendinglist">${mypending}</a>
            </div>
            <div class="col-4  newadd5">
              <a class="a-link" href="mydeclinedlist">${mydiclined}</a>
          </div>
          </div>
        </div>

        <!-- first column second row -->
        <div class="a-link row profile-info">
          <div class="col-12 info-head">
            Profile Details <a href="showupdatemyprofile"><img class="edit" src="/myprofile/edit.png" alt=""></a>
          </div>
       <div class="col-12 profile-detail">
            ${user.username}
          </div>
          <c:if test="${not empty user.email}">
          <div class="col-12 profile-detail">
            ${user.email}
          </div></c:if>
          <div class="col-12 profile-detail">
            <strong>${user.phone}</strong>
          </div>
        </div>
      </div>
      <!-- first column end -->
      <!-- second column -->
      <div class="col-8 column-2">
        <div class="row newadd2 row-head">
          <div class="col-3">
            <a class="a-link newadd3" href="#">Service</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd3" href="#">Request Accepted</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd3" href="#">Request Pending</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd3" href="#">Rating</a>
          </div>
        </div>
        
        <c:forEach var="usersubservice"  items="${mysubservicelist}">
        <div class="row newadd2 row-content">
          <div class="col-3">
            <a class="a-link newadd4" href="#">${usersubservice.subservice.name}</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd4" href="giveracceptedlist?subservicecode=${usersubservice.subservice.code}">${usersubserviceservice.mySubServiceAcceptedNumber(usersubservice)}</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd4" href="giverpendinglist?subservicecode=${usersubservice.subservice.code}">${usersubserviceservice.mySubServicePendingNumber(usersubservice)}</a>
          </div>
          <c:set var="review" value="${reviewservice.getSubServiceRating(usersubservice)}"></c:set>
          <div class="col-3">
          
           <c:forEach begin="1" end="${reviewservice.getSubServiceRating(usersubservice)[0]}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach><br>
          
           <span class="a-link newadd4" > (${review[1]})</span>   
          </div>
        </div>
        </c:forEach>
    <!--     
        <div class="row newadd2 row-content">
          <div class="col-3">
            <a class="a-link newadd4" href="#">science</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd4" href="#">123</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd4" href="#">1010</a>
          </div>
          <div class="col-3">
            <a class="a-link newadd4" href="#">⭐⭐⭐⭐⭐</a>
          </div>
        </div>
         -->
        
        <button  onclick="window.location.href='showaddsubservicelist'" class="btn btn-outline-dark btn-sm custom" type="button" name="button"><img class="add" src="/myprofile/add.png" alt="">Add a service</button>
      </div>





    </div>
  </div>

<!-- script -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript" src="/myprofile/index.js">

</script>


</body>

</html>
