<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/giverprofile/index.css">
<link
	href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&family=Girassol&family=Inconsolata:wght@700&family=Lato&family=Open+Sans&family=Roboto&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</head>

<body>

	<!--nav bar-->
	<div class="main">
		<nav class="navbar bg-dark navbar-expand-lg navbar-dark">
			<a class="navbar-brand" href="" id="c">GIKER</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="#footer-contact">Contact</a></li>
					<li class="nav-item"><a class="nav-link" href="">About</a></li>
					<li class="nav-item"><a class="nav-link" href=""><img
							src="/giverprofile/profile.png"></a></li>
					<li class="nav-item"><a class="nav-link" href=""><img
							src="/giverprofile/uploadxxs.png"></a></li>
					<li class="nav-item"><a class="nav-link" href=""><img
							src="/giverprofile/logout.png"></a></li>
				</ul>
			</div>
		</nav>
	</div>

	<!-- heading -->
	<h1>giker</h1>

	<!-- profile -->
	<div class="container">
		<div class="row">
			<div class="col-4 column-1 ">
				<div class="row profile-box column-1-1">
					<div class="col-12 profile-box-1">
						  <c:if test="${empty giveruser.image}">
          <div class="row  justify-content-center">
            <img class="dp" src="/default.jpg" alt="/default.jpg">
          </div>
          </c:if>
          <c:if test="${not empty giveruser.image}">
          <div class="row  justify-content-center">
           <img class="dp" src="data:image/jpeg;base64,${giveruser.profilepic}" alt="/default.jpg">
          </div>
          </c:if>
					</div>
					<div class="col-12 profile-box-2">
						<a class="a-link" href="#">${giveruser.firstname}
							${giveruser.lastname}</a>
					</div>
					<c:if test="${giveruser.publicinfo.contains('phone')}">
						<div class="col-12 profile-box-2">
							<a class="a-link" href="#">${giveruser.phone}</a>
						</div>
					</c:if>
					<c:if test="${giveruser.publicinfo.contains('email')}">
						<div class="col-12 profile-box-2">
							<a class="a-link" href="#">${giveruser.email}</a>
						</div>
					</c:if>

					<c:if test="${giveruser.publicinfo.contains('instagram')}">
						<div class="col-12 profile-box-2">
							<a style="color:red;" href="https://www.instagram.com/${giveruser.instagram}"> ${giveruser.instagram}</a>
						</div>
					</c:if>

           
            <c:if test="${not empty giveruser.dob && giveruser.publicinfo.contains('age')}">

						<div class="col-12 profile-box-2">
							<a class="a-link" href="#">${giveruser.age} Years</a>
						</div>
					</c:if>
					<div class="col-12 profile-box-3">
						<c:forEach begin="1" end="${reviewservice.getTotalRating(user)}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>
					</div>
				</div>

				<!-- other-service-start -->
				<div class="row other-service-box column-1-2 justify-content-start">
					<div class="col-12 other-1">
						<a class="a-link" href="#">
							<h4>
								<strong>Other services</strong>
							</h4>
						</a>
					</div>
					<c:forEach var="secondary" items="${secondaries}">
						<c:url var="giverprofile" value="showgiverprofile">
							<c:param name="givercode" value="${secondary.givercode}">
							</c:param>
						</c:url>
						<div class="row other-2">
							<div class="col-6 ">
								 <a style="color:orange;" href="${giverprofile}"><h5>${secondary.subservice.name}</h5></a>
								
							</div>
							<div class="col-6">
								
								
								  <c:set var="review" value="${reviewservice.getSubServiceRating(secondary)}" ></c:set>
               <div class="row justify-content-center">
                <c:forEach begin="1" end="${review[0]}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>(${review[1]})�
               </div>
								
								
							</div>
						</div>
					</c:forEach>
					<!--  
          <div class="row other-2">
            <div class="col-6 ">
              <a class="a-link" href="#">
                <h5>plumbing</h5>
              </a>
            </div>
            <div class="col-6">
              <a class="a-link" href="#">
                <h6 class="plumbing"></h6>
              </a>
            </div>
          </div>
          <div class="row other-2">
            <div class="col-6 ">
              <a class="a-link" href="#">
                <h5>Gym cleaner</h5>
              </a>
            </div>
            <div class="col-6">
              <a class="a-link" href="#">
                <h6 class="gym"></h6>
              </a>
            </div>
          </div>
          <div class="row other-2">
            <div class="col-6 ">
              <a class="a-link" href="#">
                <h5>Maths nhi aati</h5>
              </a>
            </div>
            <div class="col-6">
              <a class="a-link" href="#">
                <h6 class="math"></h6>
              </a>
            </div>
          </div>-->
				</div>
				<!-- other-service-end   -->
			</div>
			<!-- profile-end -->



			<!-- main-content-start -->
			<div class="col-8 column-2">
				<div class="row a-link">
					<div class="col-12">
						<h2>${primary.subservice.name}</h2>
					</div>
				</div>
				<div class="row a-link">
					<div class="col-3 ques">Posted On:</div>

					<div class="col-9 ans">${dateformat.format(primary.date)}</div>
					<div class="row a-link">
						<div class="col-3 ques">Experience:</div>

						<div class="col-9 ans">${primary.experience}</div>
						<div class="col-3 ques">Achievements:</div>
						<c:if test=" ${primary.achievements.length()==0}">
							<div class="col-9 ans">N/A</div>
						</c:if>
						<div class="col-9 ans">${ primary.achievements}</div>


						<c:if test="${not empty tutor.ownplace}">
							<div class="col-3 ques">Own Place:</div>
							<div class="col-9 ans">${ tutor.ownplace}</div>
						</c:if>

						<c:if test="${not empty tutor.owntools}">
							<div class="col-3 ques">Own Tools:</div>
							<div class="col-9 ans">${ tutor.owntools}</div>
						</c:if>

						<c:if test="${not empty education.grade}">
							<div class="col-3 ques">Level:</div>
							<div class="col-9 ans">${ education.grade}</div>
						</c:if>

						<c:if test="${not empty education.hometution}">
							<div class="col-3 ques">Home Tution:</div>
							<div class="col-9 ans">${ education.hometution}</div>
						</c:if>


						<div class="col-3 ques">Location:</div>
						<div class="col-9 ans">${ primary.location}</div>
						<div class="col-3 ques">Description:</div>
						<div class="col-9 ans">${ primary.description}</div>
					</div>
					</div>
					<!-- casourel start -->
					<div class="row">
						<div class="col-12 ques">
							<div class="container2">
								<div id="carouselExampleIndicators3" class="carousel slide"
									data-ride="carousel">
									<ol class="carousel-indicators">
										<li data-target="#carouselExampleIndicators3"
											data-slide-to="0" class="active"></li>
										<li data-target="#carouselExampleIndicators3"
											data-slide-to="1"></li>
										<li data-target="#carouselExampleIndicators3"
											data-slide-to="2"></li>
									</ol>
									<div class="carousel-inner">
										<div class="carousel-item active">
											<div class="row">
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="First slide">
														<p class="carousel-caption d-none d-md-block">Grocery
															Store</p> </a>
												</div>
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="First slide">
														<p class="carousel-caption d-none d-md-block">Confectionery</p>
													</a>
												</div>
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="First slide">
														<p class="carousel-caption d-none d-md-block">Furniture</p>
													</a>
												</div>
											</div>
										</div>
										<div class="carousel-item">
											<div class="row">
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="Second slide">
														<p class="carousel-caption d-none d-md-block">Chemist
															Shop</p> </a>
												</div>
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="Second slide">
														<p class="carousel-caption d-none d-md-block">Book
															Store</p> </a>
												</div>
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="Second slide">
														<p class="carousel-caption d-none d-md-block">Cosmetics
															Store</p> </a>
												</div>
											</div>
										</div>
										<div class="carousel-item">
											<div class="row">
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="Third slide">
														<p class="carousel-caption d-none d-md-block">Instruments
															Store</p> </a>
												</div>
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="Third slide">
														<p class="carousel-caption d-none d-md-block">Clothes
															Store</p> </a>
												</div>
												<div class="col-4">
													<a href="#"><img class="d-block w-100 image-size"
														src="/giverprofile/foot.jpg" alt="Third slide">
														<p class="carousel-caption d-none d-md-block">Shoes
															Store</p> </a>
												</div>
											</div>
										</div>
									</div>
									<a class="carousel-control-prev"
										href="#carouselExampleIndicators3" role="button"
										data-slide="prev"> <span
										class="carousel-control-prev-icon" aria-hidden="true"></span>
										<span class="sr-only">Previous</span>
									</a> <a class="carousel-control-next"
										href="#carouselExampleIndicators3" role="button"
										data-slide="next"> <span
										class="carousel-control-next-icon" aria-hidden="true"></span>
										<span class="sr-only">Next</span>
									</a>
								</div>

							</div>
						</div>
					</div>
					<!-- casourel end -->
					<!-- form -->
					<h3>${primary.givercode}</h3>
					<div class="row justify-content-end">
						<div class=" form last justify-content-end">
							<form:form class="formIn" modelAttribute="requestdto" action="sendrequest" method="post">
							<input type="hidden" name="givercode" value="${primary.givercode}">
								<label for="message">Message:</label><br>
								<form:textarea path="message" class="textarea" name="textarea" id="message" rows="4"
									cols="50" maxlength="300" placeholder="Write a message to then giver and check the details below you want to share. You will be mailed the giver's contact details once your request is accepted"/>
								<br> <form:checkbox id="instagram" path="detailstoshare" value="instagram"/> 
									<label for="instagram">instagram</label><br>
                               <form:checkbox id="instagram" path="detailstoshare" value="email"/>						
                               		<label for="email">email</label><br> 
                            <form:checkbox id="instagram" path="detailstoshare" value="phone"/>						
                              <label for="phone">phone</label><br>
								<button class="formbutton btn btn-sm btn-dark" type="submit"
									name="button">Proceed</button>
							</form:form>
						</div>

					</div>
					<!-- form end -->
					<c:if test="${!requestpending}">
					<div class="justify-content-end row">
						<button class="last send-req btn btn-lg btn-dark" type="button"
							name="button">Send Request 🛩</button>
					</div>
				</c:if>
				
				<c:if test="${requestpending}"> 	<div class="justify-content-end row">
						<button  style="background-color:green;" type="button"
							name="button">Requested 🛩</button>
					</div>
 </c:if>
				</div>
			</div>
		</div>
		
		
		<div class="container reviews">
         <div class="taker">
           <div class="img text-center">
             <img class="dp" src="/giverprofile/img4.png" alt="">
             <p class="nameOfTaker">By <span class="text-primary">joey</span> </p>
           </div>
           <div class="rev">
            <p class="text-left ">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad </p>
            <p class="text-left"><img src="https://img.icons8.com/color/30/000000/filled-star.png"/><img src="https://img.icons8.com/color/30/000000/filled-star.png"/><img src="https://img.icons8.com/color/30/000000/filled-star.png"/></p>
            <p class="text-left">March 26,2017</p>
           </div>
         </div>
         <div class="giver">
           <div class="img text-center">
             <img class="dp" src="img4.png" alt="">
             <p class="nameOfTaker">By <span class="text-primary">joey</span> </p>
           </div>
           <div class="rev">
            <p class="text-left ">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad </p>
            <p class="text-left"><img src="https://img.icons8.com/color/30/000000/filled-star.png"/><img src="https://img.icons8.com/color/30/000000/filled-star.png"/><img src="https://img.icons8.com/color/30/000000/filled-star.png"/></p>
            <p class="text-left">March 26,2017</p>
           </div>
         </div>
  </div>






		<!-- <script type="text/javascript"> -->
		<script src="/giverprofile/sim.js" type="text/javascript"></script>
		<script src="https://code.jquery.com/jquery-3.5.0.min.js"
			integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="
			crossorigin="anonymous"></script>
</body>

</html>
