package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class orange_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      out.write("<!DOCTYPE html \n");
      out.write("    PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\"> \n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content='text/html; charset=UTF-8'/>\n");
      out.write("    <meta http-equiv=\"Content-Style-Type\" content=\"text/css\"/>\n");
      out.write("    <link rel=\"stylesheet\" media=\"screen\" type=\"text/css\" title=\"Preferred\" href=\"number-guess.css\"/>\n");
      out.write("    <title>JSP Number Guess</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <h1>JSP Number Guess</h1>\n");
      out.write("\n");
      out.write("    <div class='content'>\n");

//  Initialize.

    final HttpSession       Sess = request.getSession();
    final boolean           JustStarted = Sess.isNew();
    final Integer           No;
    final ArrayList         Hist;

    if (JustStarted) {

        No = new Integer(new java.util.Random().nextInt(101));
        Hist = new ArrayList();

        Sess.setAttribute("no", No);
        Sess.setAttribute("hist", Hist);

    } else {

        No = (Integer) Sess.getAttribute("no");
        Hist = (ArrayList) Sess.getAttribute("hist");
    }

//  Process the input.

    final String            GuessStr = request.getParameter("guess");
    String                  GuessErrorMsg = null;
    int                     Guess = -1;

    if (!JustStarted) {

        if (GuessStr != null && GuessStr.length() != 0) {

            try {

                Guess = Integer.parseInt(GuessStr);
                if (Guess < 0 || Guess > 100)
                    GuessErrorMsg = "The guess must be in the range 0 to 100 (inclusive). " + 
                        "The number \"" + Guess + "\" is not in that range.";
                else
                    Hist.add(new Integer(Guess));

            } catch (NumberFormatException e) {
                GuessErrorMsg = "The guess \"" + GuessStr + "\" is not a number.";
            }

        } else
            GuessErrorMsg = "The guess should be a number, but is blank.";
    }

//  Produce the dynamic portions of the web page.

    if (Guess != No.intValue()) {

      out.write("\n");
      out.write("        <div class='guess'>\n");
      out.write("            <p>A random number between 0 and 100 (inclusive) has been selected.</p>\n");

        if (GuessErrorMsg != null) {

      out.write("\n");
      out.write("            <div class='bad-field-error-message'>");
      out.print( GuessErrorMsg );
      out.write("</div>\n");

        }

      out.write("\n");
      out.write("            <form method='post'>\n");
      out.write("                <label ");
      out.print( GuessErrorMsg != null ? "class='bad-field'" : "" );
      out.write(" >Guess the number: \n");
      out.write("                    <input type='text' size='6' name='guess' \n");
      out.write("                    ");
      out.print( GuessErrorMsg != null ? "value='" + GuessStr + "'" : "" );
      out.write(" />\n");
      out.write("                </label>\n");
      out.write("                <input type='submit' value='Guess'/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");

    } else {

        Sess.invalidate();  //  Destroy this session. We're done.

      out.write("\n");
      out.write("        <div class='done'>\n");
      out.write("            <p>Correct! The number was ");
      out.print( No );
      out.write(". \n");
      out.write("            You guessed it in ");
      out.print( Hist.size() );
      out.write(" attempts.</p>\n");
      out.write("\n");
      out.write("            <form method='post'>\n");
      out.write("                <input type='submit' value='Play Again'/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");

    }

    if (Hist.size() > 0) {

      out.write("\n");
      out.write("        <div class='history'>\n");
      out.write("            <table class='history'>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>No.</th> <th>Guess</th> <th>Result</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");

        for (int Index = Hist.size() - 1; Index >= 0; Index--) {
            final Integer           PrevGuess = (Integer) Hist.get(Index);
            final int               Relationship = PrevGuess.compareTo(No);
            String                  Result = "Correct!";

            if (Relationship < 0)
                Result = "Too Low";
            else if (Relationship > 0)
                Result = "Too High";

      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( Index + 1 );
      out.write("</td> <td>");
      out.print( PrevGuess );
      out.write("</td> <td class='result'>");
      out.print( Result );
      out.write("</td>\n");
      out.write("                    </tr>\n");

        }

      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");

    }

      out.write("\n");
      out.write("    </div>\n");
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
