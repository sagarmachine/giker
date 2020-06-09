<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Coach Registration</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="/otherform/index.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
</head>

<body>
  <!-- nav -->
  <nav class="up navbar bg-dark navbar-expand-lg navbar-dark">
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
          <a class="nav-link" href=""><img src="/otherform/profile.png" alt="pr"></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> <img src="/otherform/uploadxxs.png" alt="u"> </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><img src="/otherform/logout.png" alt="o"></a>
        </li>
      </ul>
    </div>
  </nav>
  <!-- navend -->
  <h1 class="h1 up">giker</h1>
  <!-- logo -->

  <!-- logo end -->

  <!-- form -->
  <form:form class="up" action="addgiverother" method="post" modelAttribute="otherdto">
       <input type="hidden" name="subservicecode"  value="${subservicecode}"/>
   
    <div class="container con-out">
      <div class="singup">
        <h1>One Last Step</h1>
      </div>
      <!-- <hr> -->
      <div class="container pinnlov">
        <div class="select-div">
          <label for="location" class="location">City</label>
          <form:select id="location" class="select-btn" path="city" name="">
            <form:options items="${coachdto.getCitylist()}"/>
          </form:select>
        </div>
       <div class="pincode">
          <label for="pin">Enter pincode</label><br>
          <form:input  path="pincode" maxlength="20" type="text" id="pin" name="pin" placeholder="any three"/>
        </div>
        <div class="ins">
          <label for="ins">Your Instagram</label><br>
          <form:input type="text" path="instagram" id="ins" name="ins" placeholder="it's fun right"/>
        </div>
    </div>

      <!-- selectors radio and check box -->
      <div class="radioCheck">
        <!-- <hr> -->
        <div class="col-md-12">
          <div class="mediaRadio">
            <div class="col-md-6  radio1">

              <h4>Exprience</h4>

             <div class="funkyradio">
                <div class="funkyradio-default">
                  <form:radiobutton  path="experience" value="0-1 years"  />
                  <label for="radio1">0-1 years</label>
                </div>
                <div class="funkyradio-default">
                  <form:radiobutton path="experience" value="1-3 years" />
                  <label for="radio2">1-3 years</label>
                </div>
                <div class="funkyradio-default">
                  <form:radiobutton path="experience" value="3-5 years" />
                  <label for="radio3">3-5 years</label>
                </div>
                <div class="funkyradio-default">
                  <form:radiobutton path="experience" value="5-10 years" />
                  <label for="radio4">5-10 years</label>
                </div>
                <div class="funkyradio-default">
                  <form:radiobutton path="experience" value="10+ years" />
                  <label for="radio5">10+ years</label>
                </div>
              </div>
            </div>
            <div class="radio1 col-md-12">
              <div class="funkyradio">
                <div class="funkyradio-default">
                  <div>
               <form:textarea path="keyword" id="keyword"  rows="" cols="" placeholder="Add keywords you want to get searched on."></form:textarea>
                  </div>

                </div>
              </div>

            </div>

          </div>
        </div>

      </div>

      <!-- radio and check end -->
      <!-- textarea con -->
      <div class="d">
         <div class="d1">
           <div class="container">
             <fieldset>
               <form:textarea path="achievement" id="achievements" rows="" cols="" placeholder="Add Your Achievements"></form:textarea>
               <div class="input-group">
                 <div class="input-group-prepend">
                 </div>

               </div>

             </fieldset>
           </div>

         </div>
         <div class="d2">
           <div class="container">
             <div class="des">
               <fieldset>
                 <form:textarea path="description" id="desbox" rows="" cols="" placeholder="Add Description/Something releted to your coaching"></form:textarea>
               </fieldset>
             </div>
           </div>
         </div>
       </div>
    <!--    <div class="container">
         <div class="custom-file">
           <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
           <label class="custom-file-label" for="inputGroupFile01">choose a file</label>
         </div>
       </div> -->

               <div class="last">

                 <div class="container link">
                     <form:input type="text" path="location" id="address" name="location" placeholder=" enter your location" required/>
                   </div>
                   <div class="signbtn">
                     <input type="submit" name="" value="ADD" class="btn btn-lg btn-dark">
                   </div>
               </div>
             <div class="container tnc">
               <p>By clicking the ADD button, you agree to our <a href="#">Terms & Conditions</a>  and<br> <a href="#">Privacy Policy</a>.........YEEPEEE</p>
             </div>
      <!-- textarea con up -->
      <!-- container closingdiv  -->
    </div>
    <!-- container closingdiv  -->

  </form:form>
  <!-- formend -->
  <div class="overlay">

  </div>

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
