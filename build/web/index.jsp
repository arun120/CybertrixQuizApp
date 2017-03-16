<%-- 
    Document   : index
    Created on : Sep 7, 2016, 3:50:42 PM
    Author     : Lenovo
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>REVERSE CODING/LOGIN</title>
    
     <link rel="icon" href="img/favicon.png" type="image/x-icon" /> 
    <link rel="stylesheet" href="css/reset.css">

       <link rel="stylesheet" href="css/style.css">

    
    <%
        HttpSession newsession = request.getSession(false);
    if (newsession != null) 
    {
         newsession.invalidate();

    }
        
        
        %>    
    
  </head>

  <body>

    
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>REVERSE CODING</h1>
</div>
<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">WELCOME</h1>
    <form action="Exam.jsp" method="post">
      <div class="input-container">
        <input name="user" type="text" id="name" required="required"/>
        <label for="name">NAME</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input name="clg" type="text" id="collagename" required="required"/>
        <label for="collagename">COLLEGE NAME</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" name="mobile" id="mobile" required="required"/>
        <label for="mobile">PHONE NUMBER</label>
        <div class="bar"></div>
      </div>

      <div class="button-container">
        <button><span>START QUIZ</span></button>
      </div>
	  </form >
  </div>
</div>

  
        <script src="js/index.js"></script>
  
    
    
    
  </body>
</html>
