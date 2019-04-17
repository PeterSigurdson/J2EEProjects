package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class purple_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <title>Echoing HTML Request Parameters</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <h3>Choose an author:</h3>\n");
      out.write("  <form method=\"get\">\n");
      out.write("    <input type=\"checkbox\" name=\"author\" value=\"Tan Ah Teck\">Tan\n");
      out.write("    <input type=\"checkbox\" name=\"author\" value=\"Mohd Ali\">Ali\n");
      out.write("    <input type=\"checkbox\" name=\"author\" value=\"Kumar\">Kumar\n");
      out.write("    <input type=\"submit\" value=\"Query\">\n");
      out.write("  </form>\n");
      out.write(" \n");
      out.write("  ");

  String[] authors = request.getParameterValues("author");
  if (authors != null) {
  
      out.write("\n");
      out.write("    <h3>You have selected author(s):</h3>\n");
      out.write("    <ul>\n");
      out.write("  ");

      for (int i = 0; i < authors.length; ++i) {
  
      out.write("\n");
      out.write("        <li>");
      out.print( authors[i] );
      out.write("</li>\n");
      out.write("  ");

      }
  
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <a href=\"");
      out.print( request.getRequestURI() );
      out.write("\">BACK</a>\n");
      out.write("  ");

  }
  
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
