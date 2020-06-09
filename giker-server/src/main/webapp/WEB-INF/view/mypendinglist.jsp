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
  <link rel="stylesheet" href="/mypendinglist/index.css">
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
          <a class="nav-link" href=""><img src="/mypendinglist/profile.png" alt="pr"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> <img src="/mypendinglist/uploadxxs.png" alt="u"> </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><img src="/mypendinglist/logout.png" alt="o"></a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- heading -->
  <h1>giker</h1>
  <div class="container search justify-content-center row">
    <form class="" action="index.html" method="post">
      <button class="search-btn" type="submit" name="button"><img src="https://img.icons8.com/plasticine/30/000000/search.png" /></button>
      <input type="text" name="" value="">
    </form>
  </div>
  
  <c:forEach var="pendingrequest" items="${mypendinglist}">
  <div class="container accepted">
    <div class="box">
      <div class="box1">
        <div class="picture">
  <c:if test="${empty pendingrequest.givercode.user.image}">
          <div class="row  justify-content-center">
            <img class="mainpic" src="/default.jpg">
          </div>
          </c:if>
          <c:if test="${ not empty pendingrequest.givercode.user.image}">
          <div class="row  justify-content-center">
           <img class="mainpic" src="data:image/jpeg;base64,${pendingrequest.givercode.user.profilepic}">
          </div>
          </c:if>          <span class="star"><img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" /><img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" /></span>
        </div>
        <div class="details">
          <span>Name:${pendingrequest.givercode.user.firstname} ${pendingrequest.givercode.user.lastname} </span><br>
          <span>Service: ${pendingrequest.givercode.subservice.name} </span><br>
          <span>Takers: 100</span><br>
          <span>Experience: ${pendingrequest.givercode.experience} </span>
        </div>
      </div>
      <div class="box2">
       
       
       <c:if test="${pendingrequest.givercode.user.publicinfo.contains('age') && not empty pendingrequest.givercode.user.dob}">
        <span>Age: ${pendingrequest.givercode.user.age}</span><br>
       </c:if>
       
      <c:if test="${pendingrequest.givercode.user.publicinfo.contains('instagram') && not empty pendingrequest.givercode.user.instagram}">
        <span>Instagram: <a style="color:red;" href="https://www.instagram.com/${pendingrequest.givercode.user.instagram}/">${pendingrequest.givercode.user.instagram}</a></span><br>
       </c:if>
       
        <c:if test="${pendingrequest.givercode.user.publicinfo.contains('phone')}">
        <span>Phone: ${pendingrequest.givercode.user.phone}</span><br>
       </c:if>
       
     </div>
      </div>
    </div>
    </c:forEach>
    <!-- 
  <div class="container accepted">
    <div class="box">
      <div class="box1">
        <div class="picture">
          <img class="mainpic" src="/mypendinglist/pic.jpg" alt=""><br>
          <span class="star"><img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" /><img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" /></span>
        </div>
        <div class="details">
          <span>Name: Proteek Aswal</span><br>
          <span>Service: Bomb making and How to get recruited to alkaida</span><br>
          <span>Takers: 100</span><br>
          <span>Date: 45/45/20001</span>
        </div>
      </div>
      <div class="box2">
        <span>Age: 20yrs</span><br>
        <span>Own place: yes</span><br>
        <span>Own tools: no</span>
      </div>
    </div>
  </div>
 -->

</body>

</html>
