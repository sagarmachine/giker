
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>inside1</title>
  <!-- fevicon -->
  <link rel="icon" href="favicon.ico">

  <!-- font -->
  <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@500;600;700&display=swap" rel="stylesheet">


  <!-- css -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="/slider/style.css">


  <!-- script -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
          <a class="nav-link" href="#footer-contact">Contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">About</a>
        </li>
         <li class="nav-item">
        <a class="nav-link" href="showmyprofile"> <img src="/slider/profile.png" alt="u"> </a>
        </li>
         <li class="nav-item">
        <a class="nav-link" href="#"> <img src="/slider/downloadxxs.png" alt="u"> </a>
        </li>
         <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/logout"> <img src="/slider/logout.png" alt="logout"> </a>
        </li>
      </ul>
    </div>
  </nav>

  <!-- giver button -->


  
  <!-- section 1 -->
 <div class="container con">

    <div class="container">
      <h1 class="topic-title">SELLERS</h1>
    </div>

    <div class="container">
      <div id="carouselExampleIndicators92" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators92" data-slide-to="0" class="active"></li>
        <c:forEach var="i" begin="${1}" end="${sellerslider-1}">
            <li data-target="#carouselExampleIndicators92" data-slide-to="${i}"></li>
         </c:forEach>
        </ol>
        
    <div class="carousel-inner">
          
          <div class="carousel-item active">
            <div class="row">
              <c:forEach var="i" begin="${0}" end="${2}">
              <c:url var="listurl" value="showsellerlist">
              <c:param name="subservicecode" value="${subserviceseller[i].code}"/>
               <c:param name="search" value="none"/>
              
              </c:url>
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subserviceseller[i].imagesrc}" alt="${subserviceseller[i].name}">
                  <p class="carousel-caption d-none d-md-block">${subserviceseller[i].name}</p>
                </a></div>
                </c:forEach>
              </div>
          </div>
           <c:set var="k" value="${3}"/>
          
          <c:forEach var="i" begin="${1}" end="${sellerslider-1}">
     
         <div class="carousel-item">
            <div class="row">
             
             <c:forEach var="j" begin="${0}" end="${2}">
            <c:url var="listurl" value="showsellerlist">
              <c:param name="subservicecode" value="${subserviceseller[k].code}"/>
                  <c:param name="search" value="none"/>
              
              </c:url>
               <c:if test="${k < subserviceseller.size()}">
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subserviceseller[k].imagesrc}" alt="${subserviceseller[k].name}">
                  <p class="carousel-caption d-none d-md-block">${subserviceseller[k].name}</p>
                </a></div> <c:set var="k" value="${k+1}"/>
                </c:if>
                </c:forEach>
            </div>
          </div>
          </c:forEach>
         
      </div><!-- carousael inner -->
        <a class="carousel-control-prev" href="#carouselExampleIndicators92" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators92" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
  </div>
  
  
  
  
  
  
  
  
  
  

  <!-- section 2 -->
 <div class="container con">

    <div class="container">
      <h1 class="topic-title">TUTORS</h1>
    </div>

    <div class="container">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <c:forEach var="i" begin="${1}" end="${tutorslider-1}">
            <li data-target="#carouselExampleIndicators" data-slide-to="${i}"></li>
         </c:forEach>
        </ol>
        
    <div class="carousel-inner">
          
          <div class="carousel-item active">
            <div class="row">
              <c:forEach var="i" begin="${0}" end="${2}">
              <c:url var="listurl" value="showgiverlist">
              <c:param name="subservicecode" value="${subservicetutor[i].code}"/>
               <c:param name="search" value="none"/>
              
              </c:url>
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subservicetutor[i].imagesrc}" alt="${subservicetutor[i].name}">
                  <p class="carousel-caption d-none d-md-block">${subservicetutor[i].name}</p>
                </a></div>
                </c:forEach>
              </div>
          </div>
           <c:set var="k" value="${3}"/>
          
          <c:forEach var="i" begin="${1}" end="${tutorslider-1}">
     
         <div class="carousel-item">
            <div class="row">
             
             <c:forEach var="j" begin="${0}" end="${2}">
            <c:url var="listurl" value="showgiverlist">
              <c:param name="subservicecode" value="${subservicetutor[k].code}"/>
                  <c:param name="search" value="none"/>
              
              </c:url>
               <c:if test="${k < subservicetutor.size()}">
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subservicetutor[k].imagesrc}" alt="${subservicetutor[k].name}">
                  <p class="carousel-caption d-none d-md-block">${subservicetutor[k].name}</p>
                </a></div> <c:set var="k" value="${k+1}"/>
                </c:if>
                </c:forEach>
            </div>
          </div>
          </c:forEach>
         
      </div><!-- carousael inner -->
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
  </div>

  <!-- section 3 -->
  <div class="container con">

    <div class="container">
      <h1 class="topic-title">COACH</h1>
    </div>

    <div class="container">
      <div id="carouselExampleIndicators2" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators2" data-slide-to="0" class="active"></li>
        <c:forEach var="i" begin="${1}" end="${coachslider-1}">
            <li data-target="#carouselExampleIndicators2" data-slide-to="${i}"></li>
         </c:forEach>
        </ol>
        
    <div class="carousel-inner">
          
          <div class="carousel-item active">
            <div class="row">
              <c:forEach var="i" begin="${0}" end="${2}">
               <c:url var="listurl" value="showgiverlist">
              <c:param name="subservicecode" value="${subservicecoach[i].code}"/>
                            <c:param name="search" value="none"/>
              
              </c:url>
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subservicecoach[i].imagesrc}" alt="${subservicecoach[i].name}">
                  <p class="carousel-caption d-none d-md-block">${subservicecoach[i].name}</p>
                </a></div>
                </c:forEach>
              </div>
          </div>
           <c:set var="k" value="${3}"/>
          
          <c:forEach var="i" begin="${1}" end="${coachslider-1}">
     
         <div class="carousel-item">
            <div class="row">
             <c:forEach var="j" begin="${0}" end="${2}">
             <c:url var="listurl" value="showgiverlist">
              <c:param name="subservicecode" value="${subservicecoach[k].code}"/>
              <c:param name="search" value="none"/>
              </c:url>
               <c:if test="${k < subservicecoach.size()}">
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subservicecoach[k].imagesrc}" alt="${subservicecoach[k].name}">
                  <p class="carousel-caption d-none d-md-block">${subservicecoach[k].name}</p>
                </a></div> <c:set var="k" value="${k+1}"/>
                </c:if>
                </c:forEach>
            </div>
          </div>
          </c:forEach>
         
      </div><!-- carousael inner -->
        <a class="carousel-control-prev" href="#carouselExampleIndicators2" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators2" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
  </div>

  <!-- section 4 -->
  <div class="container con">

    <div class="container">
      <h1 class="topic-title">Coding</h1>
    </div>

    <div class="container">
      <div id="carouselExampleIndicators6" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators6" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators6" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators6" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="c.png" alt="First slide">
                  <p class="carousel-caption d-none d-md-block">C programming  Teacher</p>
                </a></div>
              <div class="col-4"><a href="#"> <img class="d-block w-100 image-size" src="cpp.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block">C++  Teacher</p>
                </a></div>
              <div class="col-4"><a href="#"> <img class="d-block w-100 image-size" src="csh.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block">C# Teacher</p>
                </a></div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/java.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block">Java Teacher</p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="flut.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block">Flutter Teacher</p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="kot.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block">Kotlin Teacher</p>
                </a></div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/pyt.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block">Python Teacher</p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/html.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block">Html/Css Teacher</p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/javascript.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block">Javascript Teacher</p>
                </a></div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators6" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators6" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
  </div>

  <!-- section 5 -->
  <div class="container con">

    <div class="container">
      <h1 class="topic-title">EDUCATION</h1>
    </div>

    <div class="container">
      <div id="carouselExampleIndicators7" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators7" data-slide-to="0" class="active"></li>
        <c:forEach var="i" begin="${1}" end="${educationslider-1}">
            <li data-target="#carouselExampleIndicators7" data-slide-to="${i}"></li>
         </c:forEach>
        </ol>
        
    <div class="carousel-inner">
          
          <div class="carousel-item active">
            <div class="row">
              <c:forEach var="i" begin="${0}" end="${2}">
               <c:url var="listurl" value="showgiverlist">
              <c:param name="subservicecode" value="${subserviceeducation[i].code}"/>
                            <c:param name="search" value="none"/>
              
              </c:url>
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subserviceeducation[i].imagesrc}" alt="${subserviceeducation[i].name}">
                  <p class="carousel-caption d-none d-md-block">${subserviceeducation[i].name}</p>
                </a></div>
                </c:forEach>
              </div>
          </div>
           <c:set var="k" value="${3}"/>
          
          <c:forEach var="i" begin="${1}" end="${educationslider-1}">
     
         <div class="carousel-item">
            <div class="row">
             
             <c:forEach var="j" begin="${0}" end="${2}">
             <c:url var="listurl" value="showgiverlist">
              <c:param name="subservicecode" value="${subserviceeducation[k].code}"/>
             <c:param name="search" value="none"/>
              
              </c:url>
               <c:if test="${k < subserviceeducation.size()}">
             <div class="col-4"><a href="${listurl}"><img class="d-block w-100 image-size" src="${subserviceeducation[k].imagesrc}" alt="${subserviceeducation[k].name}">
                  <p class="carousel-caption d-none d-md-block">${subserviceeducation[k].name}</p>
                </a></div> <c:set var="k" value="${k+1}"/>
                </c:if>
                </c:forEach>
            </div>
          </div>
          </c:forEach>
         
      </div><!-- carousael inner -->
        <a class="carousel-control-prev" href="#carouselExampleIndicators7" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators7" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
  </div>

  <!-- other section -->
  <!-- other 1 -->
  <div class="container con">

    <div class="container">
      <h1 class="topic-title">Others</h1>
    </div>

    <div class="container">
      <div id="carouselExampleIndicators4" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators4" data-slide-to="0" class="active"></li>
         <!-- <li data-target="#carouselExampleIndicators4" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators4" data-slide-to="2"></li>-->
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/b.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
            <!--    <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/b.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/b.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>-->
            </div>
          </div>
         <!--   <div class="carousel-item">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/b.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="/slider/b.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size"  src="b.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators4" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators4" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
  </div>  -->


  <!-- other 2
  <div class="container con">

    <div class="container">
      <h1 class="topic-title">Other 2</h1>
    </div>

    <div class="container">
      <div id="carouselExampleIndicators5" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators5" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators5" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators5" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="First slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Second slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
              <div class="col-4"><a href="#"><img class="d-block w-100 image-size" src="b.jpg" alt="Third slide">
                  <p class="carousel-caption d-none d-md-block"></p>
                </a></div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators5" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators5" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
  </div>
 -->


  <!-- footer -->
  <footer id="footer-contact">
    <h4>Contact on</h4>
    <hr>
    <div class="row">

      <div class="col-lg-4">
        <a href="#">
        <img src="/slider/instagramsm.png" alt="instagram">
          <p>Instagram</p>
        </a>
      </div>
      <div class="col-lg-4">
        <a href="#">
          <img src="/slider/twittersm.png" alt="twitter">
          <p>twitter</p>
        </a>
      </div>
      <div class="col-lg-4">
        <a href="#">
          <img src="/slider/facebooksm.png" alt="facebook">
          <p>facebook</p>
        </a>
      </div>
    </div>

  </footer>


</body>

</html>
