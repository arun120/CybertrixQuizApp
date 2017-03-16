<%-- 
    Document   : Leaderboard
    Created on : 31 Aug, 2016, 6:57:22 PM
    Author     : Home
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Database.Dbcon"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leader Board</title>
        <style>
            
 body {
  font-family: "Helvetica Neue", "Helvetica", "Arial";
  font-size: 14px;
  line-height: 20px;
  font-weight: 400;
  color: #3b3b3b;
  -webkit-font-smoothing: antialiased;
  font-smoothing: antialiased;
  background: #2b2b2b;
}

.wrapper {
  margin: 0 auto;
  padding: 40px;
  max-width: 800px;
}

.table {
  margin: 0 0 40px 0;
  width: 100%;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
  display: table;
}
@media screen and (max-width: 580px) {
  .table {
    display: block;
  }
}

.row {
  display: table-row;
  background: #f6f6f6;
}
.row:nth-of-type(odd) {
  background: #e9e9e9;
}
.row.header {
  font-weight: bold;
  color: #ffffff;
  background: #ea6153;
}
.row.green {
  background: #27ae60;
}
.row.blue {
  background: #2980b9;
}
@media screen and (max-width: 580px) {
  .row {
    padding: 8px 0;
    display: block;
  }
}

.cell {
  padding: 6px 12px;
  display: table-cell;
}
@media screen and (max-width: 580px) {
  .cell {
    padding: 2px 12px;
    display: block;
  }
}
</style>
    </head>
    <body>
        <br><br><br>
         <center><div class="wrapper">
  
  <div class="table">
    
    <div class="row header blue">
        <div class="cell">Name</div>
                     <div class="cell">College</div>
                     <div class="cell">Score</div>
                     <div class="cell">Position</div>
                     
    </div>
       
         <%
           
            
        Connection conn=null;
        Statement stmt=null; 
        try
        {
        conn=Dbcon.getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from mark order by score desc");
        String user="",clg="";
        int score=0;
        int i=0;
        while(rs.next())
        {
            i++;
            //out.write(rs.getString("question"));
       user=rs.getString("name");
       clg=rs.getString("college");
       score=rs.getInt("score");
       
        %>
      
            <div class="row">
                
                <div class="cell"><%=user%></div>
                <div class="cell"><%=clg%></div>
                <div class="cell"><%=score%></div>
                <div class="cell"><%=i%></div>

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
  </div></div>
    </body>
</html>
