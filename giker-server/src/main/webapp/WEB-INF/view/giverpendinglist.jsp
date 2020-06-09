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
  <link rel="stylesheet" href="/giverpendinglist/index.css">
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
          <a class="nav-link" href=""><img src="/giverpendinglist/profile.png" alt="pr"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> <img src="/giverpendinglist/uploadxxs.png" alt="u"> </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><img src="/giverpendinglist/logout.png" alt="o"></a>
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
  
  <c:forEach var="pendingrequest"  items="${giverpendinglist}">
  <div class="container accepted">
    <div class="box">
      <div class="box1">
       
       
        <div class="picture">
         <c:if test="${empty pendingrequest.username.image}">
            <img class="mainpic" src="/default.jpg" alt="/default.jpg">
          </c:if>
          <c:if test="${not empty pendingrequest.username.image}">
           <img class="mainpic" src="data:image/jpeg;base64,${pendingrequest.username.profilepic}" alt="/default.jpg">
          </c:if>
         
          
          <br>
          <span class="star">
          
          
          <c:forEach begin="1" end="${reviewservice.getTotalRating(pendingrequest.username)}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>
          </span>
        </div>
        
        
        <div class="details">
          <div class="row">
            <div class="col-6">
              <span>Name: ${pendingrequest.username.firstname} ${pendingrequest.username.lastname}</span><br>
              
              
              <c:if test="${pendingrequest.username.publicinfo.contains('age') && not empty pendingrequest.username.dob}">
						<span>Age:${pendingrequest.username.age}</span><br>
					</c:if>
               <c:if test="${pendingrequest.username.publicinfo.contains('phone')}">
						<span>${pendingrequest.username.phone}</span><br>
					</c:if>
					
					 <c:if test="${pendingrequest.username.publicinfo.contains('instagram') && not empty pendingrequest.username.instagram}">
						<span><a style="color:red;" href="https://www.instagram.com/${pendingrequest.username.instagram} }">${pendingrequest.username.instagram}</a></span><br>
					</c:if>
               <c:if test="${pendingrequest.username.publicinfo.contains('email')}">
						<span>${pendingrequest.username.email}</span><br>
					</c:if>
              
            </div>
            <div class="col-6">
            <span>Service: ${pendingrequest.givercode.subservice.name}</span><br>
              <span>Services Giving: 4</span><br>
              <span>Services Taken: 5</span><br>
              <span>Requested On: ${dateformatter.format(pendingrequest.date)}</span>
            </div>
          </div>

        </div>
      </div>
      <div class="box2">
        <p class="text-center">Message By Taker:</p>
        <p class="text-justify">${pendingrequest.message1} </p>
        
        
        <c:url var="accept" value="acceptrequest" >
        <c:param name="user"  value="${pendingrequest.username.username}"></c:param>
        <c:param name="usersubservice" value="${pendingrequest.givercode.givercode}" ></c:param>
        </c:url>
        
        <c:url var="decline" value="declinerequest" >
        <c:param name="user" value="${pendingrequest.username.username}"></c:param>
        <c:param name="usersubservice" value="${pendingrequest.givercode.givercode}" ></c:param>
        </c:url>
        
        
         <p class="text-center">
         <button type="submit"  onclick="window.location.href='${accept}'"  class="btn btn-primary feed" name="button">Accept</button>
          <button type="submit" onclick="window.location.href='${decline}'"   class="btn btn-danger feed" name="button">Decline</button>
          </p>
        
      </div>
    </div>
  </div>

</c:forEach>

</body>

</html>
