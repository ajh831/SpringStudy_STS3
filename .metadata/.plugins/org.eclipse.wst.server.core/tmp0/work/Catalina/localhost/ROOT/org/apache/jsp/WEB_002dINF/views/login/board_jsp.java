/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-03-28 05:59:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class board_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("  box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Style the body */\r\n");
      out.write("body {\r\n");
      out.write("  font-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("  margin: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Header/logo Title */\r\n");
      out.write(".header {\r\n");
      out.write("  padding: 80px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  background: #1abc9c;\r\n");
      out.write("  color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Increase the font size of the heading */\r\n");
      out.write(".header h1 {\r\n");
      out.write("  font-size: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Sticky navbar - toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it \"sticks\" in place (like position:fixed). The sticky value is not supported in IE or Edge 15 and earlier versions. However, for these versions the navbar will inherit default position */\r\n");
      out.write(".navbar {\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("  background-color: #333;\r\n");
      out.write("  position: sticky;\r\n");
      out.write("  position: -webkit-sticky;\r\n");
      out.write("  top: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Style the navigation bar links */\r\n");
      out.write(".navbar a {\r\n");
      out.write("  float: left;\r\n");
      out.write("  display: block;\r\n");
      out.write("  color: white;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  padding: 14px 20px;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* Right-aligned link */\r\n");
      out.write(".navbar a.right {\r\n");
      out.write("  float: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Change color on hover */\r\n");
      out.write(".navbar a:hover {\r\n");
      out.write("  background-color: #ddd;\r\n");
      out.write("  color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Active/current link */\r\n");
      out.write(".navbar a.active {\r\n");
      out.write("  background-color: #666;\r\n");
      out.write("  color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Column container */\r\n");
      out.write(".row {  \r\n");
      out.write("  display: -ms-flexbox; /* IE10 */\r\n");
      out.write("  display: flex;\r\n");
      out.write("  -ms-flex-wrap: wrap; /* IE10 */\r\n");
      out.write("  flex-wrap: wrap;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Create two unequal columns that sits next to each other */\r\n");
      out.write("/* Sidebar/left column */\r\n");
      out.write(".side {\r\n");
      out.write("  -ms-flex: 30%; /* IE10 */\r\n");
      out.write("  flex: 30%;\r\n");
      out.write("  background-color: #f1f1f1;\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Main column */\r\n");
      out.write(".main {   \r\n");
      out.write("  -ms-flex: 70%; /* IE10 */\r\n");
      out.write("  flex: 70%;\r\n");
      out.write("  background-color: white;\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Fake image, just for this example */\r\n");
      out.write(".fakeimg {\r\n");
      out.write("  background-color: #aaa;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Footer */\r\n");
      out.write(".footer {\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  background: #ddd;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */\r\n");
      out.write("@media screen and (max-width: 700px) {\r\n");
      out.write("  .row {   \r\n");
      out.write("    flex-direction: column;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */\r\n");
      out.write("@media screen and (max-width: 400px) {\r\n");
      out.write("  .navbar a {\r\n");
      out.write("    float: none;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("  <h1>My Website</h1>\r\n");
      out.write("  <p>A <b>responsive</b> website created by me.</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../menue.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("  <img src=\"/w3images/bandmember.jpg\" alt=\"Avatar\" style=\"width:100%;\">\r\n");
      out.write("  <p>Hello. How are you today?</p>\r\n");
      out.write("  <span class=\"time-right\">11:00</span>\r\n");
      out.write("</div><br>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container darker\">\r\n");
      out.write("  <img src=\"/w3images/avatar_g2.jpg\" alt=\"Avatar\" class=\"right\" style=\"width:100%;\">\r\n");
      out.write("  <p>Hey! I'm fine. Thanks for asking!</p>`\r\n");
      out.write("  <span class=\"time-left\">11:01</span>\r\n");
      out.write("</div><br>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <img src=\"/w3images/bandmember.jpg\" alt=\"Avatar\" style=\"width:100%;\">\r\n");
      out.write("  <p>Sweet! So, what do you wanna do today?</p>\r\n");
      out.write("  <span class=\"time-right\">11:02</span>\r\n");
      out.write("</div><br>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container darker\">\r\n");
      out.write("  <img src=\"/w3images/avatar_g2.jpg\" alt=\"Avatar\" class=\"right\" style=\"width:100%;\">\r\n");
      out.write("  <p>Nah, I dunno. Play soccer.. or learn more coding perhaps?</p>\r\n");
      out.write("  <span class=\"time-left\">11:05</span>\r\n");
      out.write("</div><br>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("  <h2>Footer</h2>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}