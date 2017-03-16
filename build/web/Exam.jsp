<%-- 
    Document   : Exam
    Created on : 29 Aug, 2016, 8:21:59 AM
    Author     : Alagesh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Database.Dbcon"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cybertrix</title>
        
          <script type="text/javascript" src="Timer/cmall.js"></script>
    <link rel="stylesheet" href="Timer/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="Timer/nonregV3.css">
 
    <script type="text/javascript">
        
        window.onblur=function(){
            alert("Illegal Access!!!");
            window.location.href="./";
            
        };
        
    </script>
      <style>
                  body, html{
         height: 100%;
        
         font-family: 'Lato', sans-serif;
         }
         .container{
         display: block;
         position: absolute;
         margin: auto;
         height: 450px;
         width: 400px;
         bottom: 0; left:0; right: 0; top:0;
         padding: 0;
         }

         h1 {
         color: #ffffff;
         font-weight: normal;
         }
         h2 {
         color: #ffffff;
         font-size: 18px;
         line-height: 90%;
         font-family: inherit;
         font-weight: normal;
         }
         .container ul{
         list-style: none;
         height: 100%;
         width: 100%;
         margin: 0;
         padding: 0;
         }
         ul li{
         color: #AAAAAA;
         display: block;
         position: relative;
         float: left;
         width: 100%;
         height: 100px;
         }
         ul li input[type=radio]{
         position: absolute;
         visibility: hidden;
         }
         ul li label{
         display: block;
         position: relative;
         font-weight: 300;
         font-size: 1.35em;
         padding: 25px 25px 25px 80px;
         margin: 10px auto;
         height: 30px;
         z-index: 9;
         cursor: pointer;
         -webkit-transition: all 0.25s linear;
         }
         ul li:hover label{
         color: #FFFFFF;
         }
         ul li .check{
         display: block;
         position: absolute;
         border: 5px solid #AAAAAA;
         border-radius: 100%;
         height: 25px;
         width: 25px;
         top: 30px;
         left: 20px;
         z-index: 5;
         transition: border .25s linear;
         -webkit-transition: border .25s linear;
         }
         ul li:hover .check {
         border: 5px solid #FFFFFF;
         }
         ul li .check::before {
         display: block;
         position: absolute;
         content: '';
         border-radius: 100%;
         height: 15px;
         width: 15px;
         top: 5px;
         left: 5px;
         margin: auto;
         transition: background 0.25s linear;
         -webkit-transition: background 0.25s linear;
         }
         input[type=radio]:checked ~ .check {
         border: 5px solid #0DFF92;
         }
         input[type=radio]:checked ~ .check::before{
         background: #0DFF92;
         }
         input[type=radio]:checked ~ label{
         color: #0DFF92;
         }
         .button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}   

.button1 {
    background-color: #041528;
    color: #4CAF50;
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}
      </style>
    </head>
    <body>
        
        <div style="position:fixed;width: 100%;background: #041528;z-index:10;">
 <div class="clearheight30"></div>
                    <div style="z-index:5;" id="quiz_timer_container">
                        <div class="show_timer hide" style="display: block;color:white;"><strong>Time left:</strong> <span class="countdown" style="color:white;">00:15:00</span>
                            <div class="timetotal">
                                <div class="timeleft" style="width:2%;"></div>
                            </div>
                        </div>
                    </div>
        </div>
                    <script type="text/javascript">
                        $(document).ready(function() {
                            var time=900;
                            $('span.countdown').countdown({
                                seconds: time,
                                callback: 'finishTest()'
                            }, time, (Math.round(new Date().getTime() / 1000) + time));
                        });

                        function finishTest() {
                            window.onbeforeunload = null;
                            $("form").submit();
                        }
                    </script>
      <div  style='position: fixed; width: 100%; height: 100%; top: 0; left: 0;  background: #041527 url("img/bg-main.png") 0 0 repeat;overflow-y: scroll;'>
      <div class="container" style="width: 75%;">
         
        <form  class="forms" method="post" action="Result">
             <ol>
        <%
            session.setAttribute("user", request.getParameter("user"));
            
            session.setAttribute("clg", request.getParameter("clg"));
            
            session.setAttribute("mobile", request.getParameter("mobile"));
            
        Connection conn=null;
        Statement stmt=null; 
        try
        {
        conn=Dbcon.getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from question where qset = '1' ORDER BY rand() LIMIT 20");
        String question="",choice1="",choice2="",choice3="",choice4="";
        int sno;
        while(rs.next())
        {
            //out.write(rs.getString("question"));
       sno=rs.getInt("sno");
       question=rs.getString("question");
       choice1=rs.getString("choice1");
       choice2=rs.getString("choice2");
       choice3=rs.getString("choice3");
       choice4=rs.getString("choice4");
       
        %>
        <div class="demo" style="padding-bottom: 25px;">
          
               <div>
            <table>
               
               <li>
                   <h2 class="title title-medium"><code style="line-height:25px;"> <%=question%></code></h2>
               </li>
          
    
            <tr>
               <td>
                  <ul>
                     <li>
                        <input type="radio" id="f-option<%=sno%>" value="1" name="<%=sno%>">
                        <label for="f-option<%=sno%>"><%=choice1%></label>
                        <div class="check"></div>
                     </li>
                  </ul>
               </td>
               <td>
                  <ul>
                     <li>
                        <input type="radio" id="s-option<%=sno%>" value="2" name="<%=sno%>">
                        <label for="s-option<%=sno%>"><%=choice2%></label>
                        <div class="check">
                           <div class="inside"></div>
                        </div>
                     </li>
                  </ul>
               </td>
            </tr>
            <tr>
               <td>
                  <ul>
                     <li>
                        <input type="radio" id="t-option<%=sno%>" value="3" name="<%=sno%>">
                        <label for="t-option<%=sno%>"><%=choice3%></label>
                        <div class="check">
                           <div class="inside"></div>
                        </div>
                     </li>
                  </ul>
               </td>
               <td>
                  <ul>
                     <li>
                        <input type="radio" id="p-option<%=sno%>"   value="4" name="<%=sno%>">
                        <label for="p-option<%=sno%>"><%=choice4%></label>
                        <div class="check">
                           <div class="inside"></div>
                        </div>
                     </li>
                  </ul>
               </td>
            </tr>
            </table>
         </div>
      </div>
   
        
        <%
            
      }
}catch(Exception e){
    e.printStackTrace();
    }finally{
            try {
                
                if(stmt!=null)
                    stmt.close();
                if(conn!=null)
                    conn.close();
            } catch (Exception ex) {
      ex.printStackTrace();
            }
        }
        
      
      %>  
       </ol><br><br><br>
<center><input class="button button1" type="submit" value="Submit"></center>
<br><br><br>
        </form>
      </div>
      </div>
   
      
    </body>
</html>
