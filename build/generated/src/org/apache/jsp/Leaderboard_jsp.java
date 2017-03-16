package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import Database.Dbcon;
import java.sql.Statement;
import java.sql.Connection;

public final class Leaderboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Leader Board</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <center><table width=\"80%\">\n");
      out.write("                 <thead><tr>\n");
      out.write("                     <th>Name</th>\n");
      out.write("                     <th>College</th>\n");
      out.write("                     <th>Score</th>\n");
      out.write("                     <th>Position</th>\n");
      out.write("                     </tr></thead>\n");
      out.write("       \n");
      out.write("         ");

           
            
        Connection conn=null;
        Statement stmt=null; 
        try
        {
        conn=Dbcon.getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from mark orderby score desc");
        String user="",clg="",score="";
        int i=0;
        while(rs.next())
        {
            i++;
            //out.write(rs.getString("question"));
       user=rs.getString("name");
       clg=rs.getString("clg");
       score=rs.getString("score");
       
        
      out.write("\n");
      out.write("      \n");
      out.write("            <tr>\n");
      out.write("                \n");
      out.write("                <td>");
      out.print(user);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(clg);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(score);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i);
      out.write("</td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        \n");
      out.write("      \n");
      out.write("        ");

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
        
      
      
      out.write("  \n");
      out.write("      </table></center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
