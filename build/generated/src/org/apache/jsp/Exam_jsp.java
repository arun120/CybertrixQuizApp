package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import Database.Dbcon;
import java.sql.Connection;

public final class Exam_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Cybertrix</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"post\" action=\"\">\n");
      out.write("        ");

        Connection conn;
        Statement stmt;
        try
        {
        conn=Dbcon.getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from question");
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
       
        
      out.write("\n");
      out.write("        ");
      out.print(question);
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <input type=\"radio\" name=\"");
      out.print(sno);
      out.write("\" value=\"1\">");
      out.print(choice1);
      out.write("<br>\n");
      out.write("        <input type=\"radio\" name=\"");
      out.print(sno);
      out.write("\" value=\"2\">");
      out.print(choice2);
      out.write("<br>\n");
      out.write("        <input type=\"radio\" name=\"");
      out.print(sno);
      out.write("\" value=\"3\">");
      out.print(choice3);
      out.write("<br>\n");
      out.write("        <input type=\"radio\" name=\"");
      out.print(sno);
      out.write("\" value=\"4\">");
      out.print(choice4);
      out.write("<br>\n");
      out.write("      \n");
      out.write("        ");

      }
}catch(Exception e){
    e.printStackTrace();
    }
      
      
      out.write("  \n");
      out.write("        </form>\n");
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
