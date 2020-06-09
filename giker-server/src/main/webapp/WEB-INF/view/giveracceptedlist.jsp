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
  <link rel="stylesheet" href="/myacceptedlist/index.css">
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
          <a class="nav-link" href=""><img src="/myacceptedlist/profile.png" alt="pr"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> <img src="/myacceptedlist/uploadxxs.png" alt="u"> </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><img src="/myacceptedlist/logout.png" alt="o"></a>
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
  
  
  
  <c:forEach var="request"  items="${giveracceptedlist}">
 
 <c:set var="i" value="${0}" ></c:set>
 
 <c:if  test="${request.reviewstatusgiver.toString() == 'N' }">
  <div class="container accepted">
    <div class="box">
      <div class="box1">
        <div class="picture">
 <c:if test="${empty request.username.image}">
          <div class="row  justify-content-center">
            <img class="mainpic" src="/default.jpg">
          </div>
          </c:if>
          <c:if test="${ not empty request.username.image}">
          <div class="row  justify-content-center">
           <img class="mainpic" src="data:image/jpeg;base64,${request.username.profilepic}">
          </div>
          </c:if>        
            <span class="star">
             <c:forEach begin="1" end="${reviewservice.getTotalRating(request.username)}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>
            </span>
        </div>
        
       
        <div class="details">
        
       <div class="row">
        <div class="col-6 bc1">
            <span>Name: ${request.username.firstname} ${request.username.lastname}</span><br>
           <c:if test="${request.username.publicinfo.contains('age') && not empty request.username.dob}">
						<span>Age:${request.username.age}</span><br>
					</c:if>
               <c:if test="${request.username.publicinfo.contains('phone')}">
						<span>${request.username.phone}</span><br>
					</c:if>
					
					 <c:if test="${request.username.publicinfo.contains('instagram')&& not empty request.username.instagram}">
						<span><a style="color:red;" href="https://www.instagram.com/${request.username.instagram}">${request.username.instagram}@insta</a></span><br>
					</c:if>
					 <c:if test="${request.username.publicinfo.contains('email')}">
						<span>${request.username.email}</span><br>
					</c:if>
        </div>
        <div class="col-6 bc2">
                  <span>Service: ${request.givercode.subservice.name}</span><br>
        
           
					 <span>Accepted On: ${dateformatter.format(request.acceptdate)}</span>
        
        </div>
       </div>
          
               
        </div>
      </div>
      <div class="box2">
      
      
        <span>Give your fedback</span><br>
          <form:form  modelAttribute="reviewdto" action="giverfeedback" method="post">
          <input type="hidden" name="username"  value="${request.username.username}">
          <input type="hidden" name="usersubservice" value="${request.givercode.givercode}">
          
          <form:textarea path="feedback" /><br>
          <div class="rateOut">
       <div class="rating-wrapper">
             <form:radiobutton id="star1${i}"    value="5"  path="ratings" />
           <label for="star1${i}"></label>
           <form:radiobutton id="star2${i}"    value="4" path="ratings" />
           <label for="star2${i}"></label>
           <form:radiobutton id="star3${i}"   value="3"  path="ratings"/>
           <label for="star3${i}"></label>
           <form:radiobutton id="star4${i}"    value="2"  path="ratings"/>
           <label for="star4${i}"></label>
           <form:radiobutton id="star5${i}"   value="1"  path="ratings"/>
           <label for="star5${i}"></label>
           <c:set var="i" value="${i+1}" ></c:set>
       </div>
     </div>
          <button type="submit" class="btn btn-primary feed" name="button">feed</button>

         </form:form>
      </div>
    </div>
  </div>
  
  </c:if>
  
  <c:if test="${ request.reviewstatusgiver.toString() == 'Y'}">
  
  <div class="container accepted">
    <div class="box">
      <div class="box1">
          <div class="picture">
 <c:if test="${empty request.username.image}">
          <div class="row  justify-content-center">
            <img class="mainpic" src="/default.jpg">
          </div>
          </c:if>
          <c:if test="${ not empty request.username.image}">
          <div class="row  justify-content-center">
           <img class="mainpic" src="data:image/jpeg;base64,${request.username.profilepic}">
          </div>
          </c:if>         
          
          <span class="star">
          <c:forEach begin="1" end="${reviewservice.getTotalRating(request.username)}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>
          </span>
        
        </div>
        <div class="details">
        <div class="row">
           <div class="col-6 bc1">
          <span>Name: ${request.username.firstname} ${request.username.lastname}</span><br>
          <c:if test="${request.username.publicinfo.contains('age') && not empty request.username.dob}">
						<span>Age:${request.username.age}</span><br>
					</c:if>
               <c:if test="${request.username.publicinfo.contains('phone')}">
						<span>${request.username.phone}</span><br>
					</c:if>
					
					 <c:if test="${request.username.publicinfo.contains('instagram') && not empty request.username.instagram}">
						<span><a style="color:red;" href="https://www.instagram.com/${request.username.instagram}">${request.username.instagram}@insta</a></span><br>
					</c:if>
					
					  <c:if test="${request.username.publicinfo.contains('email')}">
						<span>${request.username.email}</span><br>
					</c:if>
	</div>
	<div class="col-6 bc1">
	          <span>Service: ${request.givercode.subservice.name}</span><br>
	         <span>Accepted On: ${dateformatter.format(request.acceptdate)}</span>
          	         <span>Requested On: ${dateformatter.format(request.date)}</span>
          
          </div>
         </div> 
        </div>
      </div>
     
     
     
     
      <div class="boxkabaap">
       
       
        <div class="box2 beta1">
          <p class="text-center">feedback by me</p>
          <span>${reviewservice.getReview(request.username,request.givercode).feedbackgiver} </span><br>
            <span class="star">
          
          
            <c:forEach begin="1" end="${reviewservice.getReview(request.username,request.givercode).ratinggiver}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>  
            
            </span>
          </div>
          
          
            <c:if test="${request.reviewstatustaker.toString() == 'Y'}">
          
          <div class="box2 beta2">
            <p class="text-center">feedback for me</p>
            <span>${reviewservice.getReview(request.username,request.givercode).feedback_taker} </span><br>
              <span class="star">
               <c:forEach begin="1" end="${reviewservice.getReview(request.username,request.givercode).ratingtaker}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>  
              </span>
            </div>
            </c:if>


 <c:if test="${request.reviewstatustaker.toString() == 'N'}">
          
          <div class="box2 beta2">
            <p class="text-center">feedback for me</p>
            <span style="color:red;">No feed back by Taker yet. Taker won'tbe able to see your feedback till then. </span><br>
            </div>
            </c:if>
  </div>
    </div>
  </div>
  
  </c:if>
  
  
</c:forEach>

</body>

</html>
