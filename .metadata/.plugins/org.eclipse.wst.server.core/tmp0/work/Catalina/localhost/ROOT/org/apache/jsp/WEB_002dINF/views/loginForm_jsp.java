/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-04-01 11:13:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");


	String toURL = request.getParameter("toURL");

	System.out.println("loingForm toURL : " + toURL);
	String checkInfo = null;
	String cookieId = "";

	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		System.out.println("COOKIES LENGTH : "+cookies.length);
		System.out.println("Cookies != null 쿠키 있음 " + cookies);
		for (Cookie cookie : cookies) {
			System.out.println("Cookies for 문 도는 중 : " + cookie.getName());
			if (cookie.getName().equals("cookieId")) {
				System.out.println("cookieId 쿠키 있음");
				checkInfo = "checked";
				break;
			}
		}
	}
	
	System.out.println("checkInfo : " + checkInfo);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("/* Bordered form */\r\n");
      out.write("form {\r\n");
      out.write("	border: 3px solid #f1f1f1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Full-width inputs */\r\n");
      out.write("input[type=text], input[type=password] {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	padding: 12px 20px;\r\n");
      out.write("	margin: 8px 0;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("	border: 1px solid #ccc;\r\n");
      out.write("	box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Set a style for all buttons */\r\n");
      out.write("button {\r\n");
      out.write("	color: white;\r\n");
      out.write("	padding: 14px 20px;\r\n");
      out.write("	margin: 8px 0;\r\n");
      out.write("	border: none;\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("	width: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Add a hover effect for buttons */\r\n");
      out.write("button:hover {\r\n");
      out.write("	opacity: 0.8;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login {\r\n");
      out.write("	background-color: #04AA6D;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Extra style for the cancel button (red) */\r\n");
      out.write("#back {\r\n");
      out.write("	width: auto;\r\n");
      out.write("	padding: 10px 18px;\r\n");
      out.write("	background-color: #f44336;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Center the avatar image inside this container */\r\n");
      out.write(".imgcontainer {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	margin: 24px 0 12px 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Avatar image */\r\n");
      out.write("img.avatar {\r\n");
      out.write("	width: 40%;\r\n");
      out.write("	border-radius: 50%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Add padding to containers */\r\n");
      out.write(".container {\r\n");
      out.write("	padding: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The \"Forgot password\" text */\r\n");
      out.write("span.psw {\r\n");
      out.write("	float: right;\r\n");
      out.write("	padding-top: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Change styles for span and cancel button on extra small screens */\r\n");
      out.write("@media screen and (max-width: 300px) {\r\n");
      out.write("	span.psw {\r\n");
      out.write("		display: block;\r\n");
      out.write("		float: none;\r\n");
      out.write("	}\r\n");
      out.write("	.cancelbtn {\r\n");
      out.write("		width: 100%;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<form action=\"/login/loginCheck\" method=\"post\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<label for=\"uname\"><b>id : </b></label><input type=\"text\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cookie.cookieId.value}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"><br>\r\n");
      out.write("			<label for=\"psw\"><b>pwd : </b></label><input type=\"password\" name=\"pwd\"><br>\r\n");
      out.write("			<label for=\"remember\"> <input id=\"rememebr\" type=\"checkbox\" name=\"checkBox\" ");
      out.print(checkInfo);
      out.write("> id 저장</label><br>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"container\" style=\"background-color: #f1f1f1\">\r\n");
      out.write("			<!--<input type=\"submit\" value=\"로그인\">-->\r\n");
      out.write("			<button id=\"login\" type=\"submit\">로그인</button>\r\n");
      out.write("		</div>\r\n");
      out.write("		<input name=\"toURL\" type=\"text\" value=");
      out.print(toURL);
      out.write(">\r\n");
      out.write("	</form>\r\n");
      out.write("	<div class=\"container\" style=\"background-color: #f1f1f1\">\r\n");
      out.write("		<button id=\"back\" onClick=\"location.href='/'\">돌아가기</button>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		let rememebr = document.getElementById(\"rememebr\");\r\n");
      out.write("		window.onload = function() {\r\n");
      out.write("			rememebr.onclick = question;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		let question = function () {\r\n");
      out.write("			if(rememebr.checked != false) {\r\n");
      out.write("				confirm(\"id를 저장하시겠습니까?\");\r\n");
      out.write("			} else {\r\n");
      out.write("				confirm(\"id 저장을 취소하시겠습니까?\");\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	</script>\r\n");
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
