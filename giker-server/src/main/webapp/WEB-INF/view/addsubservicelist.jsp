
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="/addsubservicelist/style1.css">


  </head>
  <body>
<div class="main">
  <!-- nav -->
<nav class="navbar bg-dark navbar-expand-lg navbar-dark">
<a class="navbar-brand" href="${pageContext.request.contextPath}/" id="c">GIKER</a>
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
 <span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
 <ul class="navbar-nav ml-auto">
   <li class="nav-item">
     <a class="nav-link" href="showmyprofile"><img src="/addsubservicelist/profile.png"></a>
   </li>
   <li class="nav-item">
     <a class="nav-link" href="showslider"><img src="/addsubservicelist/uploadxxs.png"></a>
   </li>
   <li class="nav-item">
     <a class="nav-link" href="${pageContext.request.contextPath}/logout"><img src="/addsubservicelist/logout.png"></a>
   </li>
 </ul>
</div>
</nav>
</div>
<!-- navend -->

<!-- logo -->
<h1 class="h1">giker</h1>

<!-- search -->
<form action="searchshowaddsubservicelist" >
<div class="search-box">
  <input class="search-txt" name="search" type="text" placeholder="Search..">
  <button type="submit" class="a-link search-btn" onclick="window.location.href='searchshowaddsubservicelist'"><img class="" src="/addsubservicelist/search.png" alt=""></button>
</div>
</form>
<!-- search end -->

<c:if test="${listsize==0}">
<div class="container container2">
  <div class="row">
    <div class="col-7">
      <div class="col-12 ">
        <a class="a-link  main-h service-name" href="#">WOOOPS No Match Found !!!</a>
      </div>
   </div>
  </div>
</div>
</c:if>
<c:if test="${subservices.size()>0}">
<!-- service -->
<c:set var="i"  value="${1}"/>

<c:forEach var="subservice"  items="${subservices}" >

<div class="container container${i}">
  <div class="row">
    <div class="col-7">
      <div class="col-12 ">
        <a class="a-link  main-h service-name" href="#">${subservice.name}</a>
      </div>
      <div class="col-12 target target${i}">
      <c:set var="i"  value="${i+1}"/>
      
        <span class="des a-link">Description</span><br> <p class="a-link">${subservice.description}</p>
      </div>
    </div>
    <div class="col-2">
      <div class="row">
        <a class="a-link  main-h" href="#">category </a>
      </div>
      <div class="row">
        <a class="a-link" href="#">${subservice.servicecode.name}</a>
      </div>
    </div>
    <div class="col-3">
    <c:url var="subserviceurl" value="${subservice.servicecode.name}form">
      <c:param name="subservice" value="${subservice.code}"></c:param>
    </c:url>
      <a href="${subserviceurl}"><img class="add" src="/addsubservicelist/add.png" alt=""></a>
      <div class="row">
        <a class="a-link main-h" href="#">givers</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">${subservice.givers}</a>
      </div>
    </div>
  </div>
</div>

</c:forEach>
</c:if>
<!-- service end -->
<!--  
<!-- service 
<div class="container container2">
  <div class="row">
    <div class="col-7">
      <div class="col-12 ">
        <a class="a-link  main-h service-name" href="#">physics teacher</a>
      </div>
      <div class="col-12  target target2">
        <span class="des a-link">Description</span><br> <p class="a-link">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
    </div>
    <div class="col-2">
      <div class="row">
        <a class="a-link  main-h" href="#">category name</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">sports</a>
      </div>
    </div>
    <div class="col-3">
      <a href="#"><img class="add" src="/addsubservicelist/add.png" alt=""></a>
      <div class="row">
        <a class="a-link main-h" href="#">givers</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">7</a>
      </div>
    </div>
  </div>
</div>
<!-- service end 

<!-- service 
<div class="container container3">
  <div class="row">
    <div class="col-7">
      <div class="col-12 ">
        <a class="a-link  main-h service-name" href="#">maths teacher</a>
      </div>
      <div class="col-12  target target3">
        <span class="des a-link">Description</span><br> <p class="a-link">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
    </div>
    <div class="col-2">
      <div class="row">
        <a class="a-link  main-h" href="#">category name</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">sports</a>
      </div>
    </div>
    <div class="col-3">
      <a href="#"><img class="add" src="/addsubservicelist/add.png" alt=""></a>
      <div class="row">
        <a class="a-link main-h" href="#">givers</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">7</a>
      </div>
    </div>
  </div>
</div>
<!-- service end

<!-- service 
<div class="container container4">
  <div class="row">
    <div class="col-7">
      <div class="col-12 ">
        <a class="a-link  main-h service-name" href="#">tennis couch</a>
      </div>
      <div class="col-12  target target4">
        <span class="des a-link">Description</span><br> <p class="a-link">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
    </div>
    <div class="col-2">
      <div class="row">
        <a class="a-link  main-h" href="#">category name</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">sports</a>
      </div>
    </div>
    <div class="col-3">
      <a href="#"><img class="add" src="/addsubservicelist/add.png" alt=""></a>
      <div class="row">
        <a class="a-link main-h" href="#">givers</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">7</a>
      </div>
    </div>
  </div>
</div>
<!-- service end 

<!-- service 
<div class="container container5">
  <div class="row">
    <div class="col-7">
      <div class="col-12 ">
        <a class="a-link  main-h service-name" href="#">basketball couch</a>
      </div>
      <div class="col-12  target target5">
        <span class="des a-link">Description</span><br> <p class="a-link">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
    </div>
    <div class="col-2">
      <div class="row">
        <a class="a-link  main-h" href="#">category name</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">sports</a>
      </div>
    </div>
    <div class="col-3">
      <a href="#"><img class="add" src="/addsubservicelist/add.png" alt=""></a>
      <div class="row">
        <a class="a-link main-h" href="#">givers</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">7</a>
      </div>
    </div>
  </div>
</div>
<!-- service end



<!-- service 
<div class="container container2">
  <div class="row">
    <div class="col-7">
      <div class="col-12 ">
        <a class="a-link  main-h service-name" href="#">football couch</a>
      </div>
      <div class="col-12  target target2">
        <span class="des a-link">Description</span><br> <p class="a-link">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
    </div>
    <div class="col-2">
      <div class="row">
        <a class="a-link  main-h" href="#">category name</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">sports</a>
      </div>
    </div>
    <div class="col-3">
      <a href="#"><img class="add" src="/addsubservicelist/add.png" alt=""></a>
      <div class="row">
        <a class="a-link main-h" href="#">givers</a>
      </div>
      <div class="row">
        <a class="a-link" href="#">7</a>
      </div>
    </div>
  </div>
</div>
service end -->





    <!-- script -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
