/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2023-01-26 02:05:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/teamB-project/WorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1669102095569L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Home</title>\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("#container {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("	position: relative;\r\n");
      out.write("	min-height: 820px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main_wrap {\r\n");
      out.write("	min-width: 1200px;\r\n");
      out.write("	position: relative;\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("	background-color: #3bbbf3;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".sub_wrap {\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("	padding: 80px 100px;\r\n");
      out.write("	width: 1200px;\r\n");
      out.write("	margin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrap1 {\r\n");
      out.write("	float: left;\r\n");
      out.write("	background-color: black;\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("	width: 300px;\r\n");
      out.write("	height: 500px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrap2 {\r\n");
      out.write("	float: right;\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("	height: 500px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrap2_1 {\r\n");
      out.write("	width: 380px;\r\n");
      out.write("	height: 240px;\r\n");
      out.write("	float: left;\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("	position: relative;\r\n");
      out.write("	background-color: blue;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrap2_2 {\r\n");
      out.write("	float: left;\r\n");
      out.write("	margin-left: 15px;\r\n");
      out.write("	margin-bottom: 15px;\r\n");
      out.write("	width: 270px;\r\n");
      out.write("	height: 240px;\r\n");
      out.write("	background-color: green;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".clr {\r\n");
      out.write("	clear: both;\r\n");
      out.write("	height: 0;\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<style>\r\n");
      out.write(".mySlides {\r\n");
      out.write("	display: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slideshow-container {\r\n");
      out.write("	height: 450px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".mySlides>img {\r\n");
      out.write("	vertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dots {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dot {\r\n");
      out.write("	height: 15px;\r\n");
      out.write("	width: 15px;\r\n");
      out.write("	margin: 0 2px;\r\n");
      out.write("	background-color: #bbb;\r\n");
      out.write("	border-radius: 50%;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("	transition: background-color 0.6s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slide_active {\r\n");
      out.write("	background-color: #717171;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".fade {\r\n");
      out.write("	animation-name: fade;\r\n");
      out.write("	animation-duration: 1.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".fade:not(.show) {\r\n");
      out.write("	opacity: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@\r\n");
      out.write("keyframes fade {\r\n");
      out.write("	from {opacity: .4\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("	opacity: 1\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<style>\r\n");
      out.write(".teacher_intro {\r\n");
      out.write("	min-width: 1200px;\r\n");
      out.write("	position: relative;\r\n");
      out.write("	overflow: hidden;\r\n");
      out.write("	margin: 20px 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".flex_box {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".flex_box_border {\r\n");
      out.write("	border: 1px solid #000;	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".flex_box img {\r\n");
      out.write("	width: 400px;\r\n");
      out.write("	height: 400px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".teacher_intro h2 {\r\n");
      out.write("	font-size: 50px;\r\n");
      out.write("	margin: 20px 0;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("	<div id=\"container\">\r\n");
      out.write("		<div class=\"main_wrap\">\r\n");
      out.write("			<div class=\"sub_wrap\">\r\n");
      out.write("				<div class=\"wrap1\">\r\n");
      out.write("					<div class=\"slideshow-container\">\r\n");
      out.write("						<div class=\"mySlides fade\">\r\n");
      out.write("							<img src=\"img/banner/banner1.png\">\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"mySlides fade\">\r\n");
      out.write("							<img src=\"img/banner/banner2.png\">\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"mySlides fade\">\r\n");
      out.write("							<img src=\"img/banner/banner3.png\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"dots\">\r\n");
      out.write("						<span class=\"dot\"></span> <span class=\"dot\"></span> <span\r\n");
      out.write("							class=\"dot\"></span>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"wrap2\">\r\n");
      out.write("					<div class=\"wrap2_1\">\r\n");
      out.write("						<img src=\"img/banner/banner4.png\">\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"wrap2_2\">\r\n");
      out.write("						<img src=\"img/banner/banner6.png\">\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"clr\"></div>\r\n");
      out.write("					<div class=\"wrap2_1\">\r\n");
      out.write("						<img src=\"img/banner/banner5.png\">\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"wrap2_2\">\r\n");
      out.write("						<img src=\"img/banner/banner7.png\">\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"teacher_intro\">\r\n");
      out.write("			<h2 class=\"text-primary font-secondary\">Teacher Intro</h2>\r\n");
      out.write("			<div class=\"flex_box\">\r\n");
      out.write("				<div class=\"flex_box_border\">\r\n");
      out.write("					<div class=\"team-item\">\r\n");
      out.write("						<div class=\"position-relative overflow-hidden\">\r\n");
      out.write("							<img class=\"img-fluid w-100\" src=\"img/teacher/teacher1.png\">\r\n");
      out.write("							<div\r\n");
      out.write("								class=\"team-overlay w-100 h-100 position-absolute top-50 start-50 translate-middle d-flex align-items-center justify-content-center\">\r\n");
      out.write("								<div class=\"d-flex align-items-center justify-content-start\">\r\n");
      out.write("									<a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-twitter fw-normal\"></i></a> <a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-facebook-f fw-normal\"></i></a> <a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-linkedin-in fw-normal\"></i></a>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"bg-dark border-inner text-center p-4\">\r\n");
      out.write("							<h4 class=\"text-uppercase text-primary\">박선향</h4>\r\n");
      out.write("							<p class=\"text-white m-0\">국어</p>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"flex_box_border\">\r\n");
      out.write("					<div class=\"team-item\">\r\n");
      out.write("						<div class=\"position-relative overflow-hidden\">\r\n");
      out.write("							<img class=\"img-fluid w-100\" src=\"img/teacher/teacher2.png\">\r\n");
      out.write("							<div\r\n");
      out.write("								class=\"team-overlay w-100 h-100 position-absolute top-50 start-50 translate-middle d-flex align-items-center justify-content-center\">\r\n");
      out.write("								<div class=\"d-flex align-items-center justify-content-start\">\r\n");
      out.write("									<a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-twitter fw-normal\"></i></a> <a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-facebook-f fw-normal\"></i></a> <a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-linkedin-in fw-normal\"></i></a>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"bg-dark border-inner text-center p-4\">\r\n");
      out.write("							<h4 class=\"text-uppercase text-primary\">김보라</h4>\r\n");
      out.write("							<p class=\"text-white m-0\">영어</p>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"flex_box_border\">\r\n");
      out.write("					<div class=\"team-item\">\r\n");
      out.write("						<div class=\"position-relative overflow-hidden\">\r\n");
      out.write("							<img class=\"img-fluid w-100\" src=\"img/teacher/teacher1.png\">\r\n");
      out.write("							<div\r\n");
      out.write("								class=\"team-overlay w-100 h-100 position-absolute top-50 start-50 translate-middle d-flex align-items-center justify-content-center\">\r\n");
      out.write("								<div class=\"d-flex align-items-center justify-content-start\">\r\n");
      out.write("									<a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-twitter fw-normal\"></i></a> <a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-facebook-f fw-normal\"></i></a> <a\r\n");
      out.write("										class=\"btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1\"\r\n");
      out.write("										href=\"#\"><i class=\"fab fa-linkedin-in fw-normal\"></i></a>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"bg-dark border-inner text-center p-4\">\r\n");
      out.write("							<h4 class=\"text-uppercase text-primary\">황혜경</h4>\r\n");
      out.write("							<p class=\"text-white m-0\">수학</p>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		let slideIndex = 0;\r\n");
      out.write("		showSlides();\r\n");
      out.write("\r\n");
      out.write("		function showSlides() {\r\n");
      out.write("			let i;\r\n");
      out.write("			let slides = document.getElementsByClassName(\"mySlides\");\r\n");
      out.write("			let dots = document.getElementsByClassName(\"dot\");\r\n");
      out.write("			for (i = 0; i < slides.length; i++) {\r\n");
      out.write("				slides[i].style.display = \"none\";\r\n");
      out.write("			}\r\n");
      out.write("			slideIndex++;\r\n");
      out.write("			if (slideIndex > slides.length) {\r\n");
      out.write("				slideIndex = 1\r\n");
      out.write("			}\r\n");
      out.write("			for (i = 0; i < dots.length; i++) {\r\n");
      out.write("				dots[i].className = dots[i].className.replace(\" slide_active\",\r\n");
      out.write("						\"\");\r\n");
      out.write("			}\r\n");
      out.write("			slides[slideIndex - 1].style.display = \"block\";\r\n");
      out.write("			dots[slideIndex - 1].className += \" slide_active\";\r\n");
      out.write("			setTimeout(showSlides, 2000);\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
