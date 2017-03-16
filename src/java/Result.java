/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Database.Dbcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Home
 */
public class Result extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Result</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Result at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        Connection conn=null;
        Statement stmt=null;
        int mark=0;
        try{
        conn=Dbcon.getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from question");
        String answer[]=new String[50];
        String solution[]=new String[50];
         
        int[] sno = new int[50];
        int i=0;
        while(rs.next()){
        sno[i]=rs.getInt("sno");
        solution[i]=rs.getString("answer");
        answer[i]=request.getParameter(String.valueOf(sno[i]));
        if(answer[i]!=null)
        {
        //response.getWriter().println("answer"+answer[i]);
        //response.getWriter().println("solution"+solution[i]);
        if(answer[i].equals(solution[i]))
            mark++;
        }
        i++;
        }
        rs.close();
        
        HttpSession session=request.getSession();
        String user,clg,mobile;
        user=(String)session.getAttribute("user");
        clg=(String)session.getAttribute("clg");
        mobile=(String)session.getAttribute("mobile");
        mobile=mobile.replace("'", "");
        clg=clg.replace("'","");
        user=user.replace("'", "");
       int update=stmt.executeUpdate("insert into mark values('"+user+"','"+clg+"','"+mobile+"','"+mark+"')");
      //int update=1; 
       if(update==1)
        {
            response.getWriter().println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
            response.getWriter().println("<div class='container'><center><h1>Your Score is :"+mark+"</h1><br><br><br>\n" +
"  \n" +
"  <h1>Thank You!!</h1>\n" +
"  <h1>Results will be announced soon!!!</h1></center></div>");
       // response.getWriter().println("<a href='Leaderboard.jsp'><input type='button' value='LeaderBoard'></a>");
        }
        
        
        }catch(Exception e){e.printStackTrace();}
        finally{
            try {
                
                if(stmt!=null)
                    stmt.close();
                if(conn!=null)
                    conn.close();
            } catch (Exception ex) {
      ex.printStackTrace();
      response.sendRedirect("index.html");
            }
        }
        
        
        }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
