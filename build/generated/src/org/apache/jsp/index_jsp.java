package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html >\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>REVERSE CODING/LOGIN</title>\n");
      out.write("    \n");
      out.write("     <link rel=\"icon\" href=\"img/favicon.png\" type=\"image/x-icon\" /> \n");
      out.write("    <link rel=\"stylesheet\" href=\"css/reset.css\">\n");
      out.write("\n");
      out.write("       <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    \n");
      out.write("    ");

        HttpSession newsession = request.getSession(false);
    if (newsession != null) 
    {
         newsession.invalidate();

    }
        
        
        
      out.write("    \n");
      out.write("    \n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("    \n");
      out.write("<!-- Mixins-->\n");
      out.write("<!-- Pen Title-->\n");
      out.write("<div class=\"pen-title\">\n");
      out.write("  <h1>REVERSE CODING</h1>\n");
      out.write("</div>\n");
      out.write("<div class=\"container\">\n");
      out.write("  <div class=\"card\"></div>\n");
      out.write("  <div class=\"card\">\n");
      out.write("    <h1 class=\"title\">WELCOME</h1>\n");
      out.write("    <form action=\"Exam.jsp\" method=\"post\">\n");
      out.write("      <div class=\"input-container\">\n");
      out.write("        <input name=\"user\" type=\"text\" id=\"name\" required=\"required\"/>\n");
      out.write("        <label for=\"name\">NAME</label>\n");
      out.write("        <div class=\"bar\"></div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"input-container\">\n");
      out.write("        <input name=\"clg\" type=\"text\" id=\"collagename\" required=\"required\"/>\n");
      out.write("        <label for=\"collagename\">COLLEGE NAME</label>\n");
      out.write("        <div class=\"bar\"></div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"input-container\">\n");
      out.write("        <input type=\"text\" name=\"mobile\" id=\"mobile\" required=\"required\"/>\n");
      out.write("        <label for=\"mobile\">PHONE NUMBER</label>\n");
      out.write("        <div class=\"bar\"></div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"button-container\">\n");
      out.write("        <button><span>START QUIZ</span></button>\n");
      out.write("      </div>\n");
      out.write("\t  </form >\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("  \n");
      out.write("        <script src=\"js/index.js\"></script>\n");
      out.write("  \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("  </body>\n");
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
