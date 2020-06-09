<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>tutor list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/tutorlist/index.css">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  <body>
    <!-- nav -->
<nav class="up navbar bg-dark navbar-expand-lg navbar-dark">
  <a class="navbar-brand" href="" id="c">GIKER </a>
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
        <a class="nav-link" href=""><img src="/tutorlist/profile.png" alt="pr"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"> <img src="/tutorlist/downloadxxs.png" alt="u"> </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><img src="/tutorlist/logout.png" alt="o"></a>
      </li>
    </ul>
  </div>
</nav>
<!-- navend -->
<div class="container c1">
  <div class="row">
    <div class="col-9 main">
    
    
    
    <c:if test="${empty usersubservices}">
    
      <div class="container c2">
           <div class="row">
             
             <div class="col-9 content column">
               <div class="row r1">
                 <div class="col-6">
                <h3>Whoops no one yet in ${city}!!</h3>
                 </div>
                
              </div>
             
               </div>
             </div>
             </div>
   
    
    </c:if>
    
    
    
        <c:forEach  var="usersubservice" items="${usersubservices}">
     <c:url var="giverprofile" value="showgiverprofile" > 
     <c:param name="givercode" value="${usersubservice.givercode}"> </c:param>
     </c:url>
    
      <div class="container c2">
           <div class="row">
             <div class="col-3  advert">
               <div class="row  justify-content-center">
  <c:if test="${empty usersubservice.user.image}">
          <div class="row  justify-content-center">
            <img class="image" src="/default.jpg">
          </div>
          </c:if>
          <c:if test="${ not empty usersubservice.user.image}">
          <div class="row  justify-content-center">
           <img class="image" src="data:image/jpeg;base64,${usersubservice.user.profilepic}">
          </div>
          </c:if>               </div>
                 <c:set var="review" value="${reviewservice.getSubServiceRating(usersubservice)}" ></c:set>
               <div class="row justify-content-center">
                <c:forEach begin="1" end="${review[0]}">
            <img src="https://img.icons8.com/emoji/20/000000/star-emoji.png" />
            </c:forEach>(${review[1]})�
               </div>
             </div>
             <div class="col-9 content column">
               <div class="row r1">
                 <div class="col-6">
               Name: <a href="${giverprofile}">${usersubservice.getUser().getFirstname()} ${usersubservice.getUser().getLastname()} </a>
                 </div>
                  <div class="col-6">
                   <c:if test="${not empty usersubservice.user.dob && usersubservice.user.publicinfo.contains('age')}">
                  age:${usersubservice.user.age}
                  </c:if>
                  <c:if test="${ empty usersubservice.user.dob}">
                  age: N/A
                  </c:if>
                   
                 </div>
              </div>
              <div class="row r1">
                <div class="col-6">
                  Takers: 1000
                </div>
                <div class="col-6">
                  Own place: ${usersubservice.tutor.ownplace}
                </div>
              </div>
                <div class="row r1">
                  <div class="col-6">
                    Exp: ${usersubservice.experience}
                  </div>
                  <div class="col-6">
                    Own Tools: ${usersubservice.tutor.owntools}
                  </div>
                   </div>
                <div class="row r1">
                 
                  <div class="col-6">
                   Posted On: ${dateformat.format(usersubservice.date)}
                  </div>
                   <div class="col-6">
                City: ${usersubservice.city.name}
                    
                 </div>
               </div>
             </div>
             </div>
           </div>
           
           </c:forEach>
          
        <!--     <div class="container c2">
                <div class="row">
                  <div class="col-3  advert">
                    <div class="row  justify-content-center">
                      <img class="image" src="/tutorlist/image.jpg" alt="">
                    </div>
                    <div class="row justify-content-center">
                      ⭐⭐⭐⭐
                    </div>
                  </div>
                  <div class="col-9 content column">
                    <div class="row r1">
                      <div class="col-6">
                        Name: anuj
                      </div>
                      <div class="col-6">
                        age: 20 years
                      </div>
                   </div>
                   <div class="row r1">
                     <div class="col-6">
                       Takers: 1000
                     </div>
                     <div class="col-6">
                       Own place: yes
                     </div>
                   </div>
                     <div class="row r1">
                       <div class="col-6">
                         Exp: 20 years
                       </div>
                       <div class="col-6">
                         Own Tools: no
                       </div>
                    </div>
                  </div>
                  </div>
                </div>
                <div class="container c2">
                     <div class="row">
                       <div class="col-3  advert">
                         <div class="row  justify-content-center">
                           <img class="image" src="/tutorlist/image.jpg" alt="">
                         </div>
                         <div class="row justify-content-center">
                           ⭐⭐⭐⭐
                         </div>
                       </div>
                       <div class="col-9 content column">
                         <div class="row r1">
                           <div class="col-6">
                             Name: anuj
                           </div>
                           <div class="col-6">
                             age: 20 years
                           </div>
                        </div>
                        <div class="row r1">
                          <div class="col-6">
                            Takers: 1000
                          </div>
                          <div class="col-6">
                            Own place: yes
                          </div>
                        </div>
                          <div class="row r1">
                            <div class="col-6">
                              Exp: 20 years
                            </div>
                            <div class="col-6">
                              Own Tools: no
                            </div>
                         </div>
                       </div>
                       </div>
                     </div>-->
      </div>
    </div>
   
    <div class="container col-3 fix">
      <div class="roti">
      <form action="showgiverlist">
        <div class="col-3 co3">
          <button  type="submit" class="schbtn"> <img src="/tutorlist/searchicon.png" alt=""> </button>
        </div>
         <div class="col-6 co4">
           <input type="text" placeholder="search by city or pincode" name="search" value="">
         </div>
         <input type="hidden" name="subservicecode" value="${subservicecode}">
         </form>
      </div>
      <div class="sort">
        <h4>sort by</h4>
        <ul>
          <a href=""><li>exp</li></a>
          <a href=""><li>takers</li></a>
          <a href=""><li>rating</li></a>
        </ul>

      </div>
    </div>

  </div>




      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/tutorlist/index.js"></script>
  </body>
</html>
