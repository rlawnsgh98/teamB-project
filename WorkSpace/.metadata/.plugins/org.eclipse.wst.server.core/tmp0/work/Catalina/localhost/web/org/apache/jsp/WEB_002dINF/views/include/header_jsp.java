/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
<<<<<<< HEAD
 * Generated at: 2023-01-26 01:50:01 UTC
=======
 * Generated at: 2023-01-25 07:39:48 UTC
>>>>>>> origin/wonhee_web
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
<<<<<<< HEAD
    _jspx_dependants.put("jar:file:/D:/teamB-project/WorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1669102095569L));
=======
    _jspx_dependants.put("jar:file:/C:/_Project/spring_web/WorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1670224434196L));
>>>>>>> origin/wonhee_web
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("<meta content=\"Free HTML Templates\" name=\"keywords\">\r\n");
      out.write("<meta content=\"Free HTML Templates\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Favicon -->\r\n");
      out.write("<link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("<!-- Google Web Fonts -->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Oswald:wght@500;600;700&family=Pacifico&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Icon Font Stylesheet -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
<<<<<<< HEAD
      out.write("<!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
=======
      out.write("    <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css?");
      out.print(new java.util.Date() );
      out.write("\" rel=\"stylesheet\">\r\n");
>>>>>>> origin/wonhee_web
      out.write("\r\n");
      out.write("<!-- Template Stylesheet -->\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css\" />\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("nav {\r\n");
      out.write("	margin: 0 auto;\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	height: auto;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("	background: #293859;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul {\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("	list-style-type: none;\r\n");
      out.write("	float: left;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li {\r\n");
      out.write("	position: relative;\r\n");
      out.write("	margin: 0 20px 0 0;\r\n");
      out.write("	float: left;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li a {\r\n");
      out.write("	padding: 20px;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li a:hover {\r\n");
      out.write("	color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li ul {\r\n");
      out.write("	display: none;\r\n");
      out.write("	position: absolute;\r\n");
      out.write("	left: 0;\r\n");
      out.write("	background-color: #293859;\r\n");
      out.write("	float: left;\r\n");
      out.write("	font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li ul li {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	border-bottom: 1px solid rgba(255, 255, 255, .3);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li:hover ul {\r\n");
      out.write("	display: block;\r\n");
      out.write("	z-index: 999; /* 우선순위 적용? */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("strong {\r\n");
      out.write("	color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("span {\r\n");
      out.write("	color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".text_main {\r\n");
      out.write("	color: #1d273d;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bg_main {\r\n");
      out.write("	background-color: #293859;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bg_sub {\r\n");
      out.write("	background-color: #b8c6e6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".text-start {\r\n");
      out.write("	text-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".border-inner {\r\n");
      out.write("	position: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".border-inner::before {\r\n");
      out.write("	position: absolute;\r\n");
      out.write("	content: \"\";\r\n");
      out.write("	background: none;\r\n");
      out.write("	top: 10px;\r\n");
      out.write("	right: 10px;\r\n");
      out.write("	bottom: 10px;\r\n");
      out.write("	left: 10px;\r\n");
      out.write("	border: 1px solid #fff;\r\n");
      out.write("	z-index: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".logo_img {\r\n");
      out.write("	border-radius: 70%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".logo_title {\r\n");
      out.write("	font-size: 30px;\r\n");
      out.write("	color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-brand {\r\n");
      out.write("	padding-top: 0.3125rem;\r\n");
      out.write("	padding-bottom: 0.3125rem;\r\n");
      out.write("	margin-right: 1rem;\r\n");
      out.write("	font-size: 1.25rem;\r\n");
      out.write("	white-space: nowrap;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".profile {\r\n");
      out.write("	width: 50px;\r\n");
      out.write("	height: 50px;\r\n");
      out.write("	border-radius: 70%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".left-items {\r\n");
      out.write("	width: 60%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".left-items li:hover {\r\n");
      out.write("	background: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".right-items {\r\n");
      out.write("	width: 40%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".left-items>ul {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	color: #fff;\r\n");
      out.write("	font-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginfo {\r\n");
      out.write("	height: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginfo>ul {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	height: inherit;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".nav_link {\r\n");
      out.write("	font-size: 20px;\r\n");
      out.write("	padding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginfo>ul>li {\r\n");
      out.write("	margin-right: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginfo>ul>li>a {\r\n");
      out.write("	color: #fff;\r\n");
      out.write("	font-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<div class=\"container-fluid px-0\">\r\n");
      out.write("	<div class=\"row\">\r\n");
      out.write("		<div class=\"col-lg-4 text-center bg_sub py-3\">\r\n");
      out.write("			<div\r\n");
      out.write("				class=\"d-inline-flex align-items-center justify-content-center navbar-brand\">\r\n");
      out.write("				<i class=\"fa-regular fa-envelope text_main fs-1 me-3\"></i>\r\n");
      out.write("				<div class=\"text-start\">\r\n");
      out.write("					<h6 class=\"text-uppercase mb-1\">Email Us</h6>\r\n");
      out.write("					<span>YH2023@naver.com</span>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"col-lg-4 text-center bg_main border-inner py-3\">\r\n");
      out.write("			<div class=\"d-inline-flex align-items-center justify-content-center\">\r\n");
      out.write("				<img src=\"img/common/icons8_tree.png\" alt=\"로고\" class=\"me-3 logo_img\">\r\n");
      out.write("				<h6 class=\"text-uppercase text-white mb-1 logo_title\">YH-Academy</h6>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"col-lg-4 text-center bg_sub py-3\">\r\n");
      out.write("			<div\r\n");
      out.write("				class=\"d-inline-flex align-items-center justify-content-center navbar-brand\">\r\n");
      out.write("				<i class=\"fa-solid fa-mobile-screen text_main fs-1 me-3\"></i>\r\n");
      out.write("				<div class=\"text-start\">\r\n");
      out.write("					<h6 class=\"text-uppercase mb-1\">Call Us</h6>\r\n");
      out.write("					<span>010-0345-0789</span>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("<nav>\r\n");
      out.write("	<div class=\"container\" style=\"display: flex;\r\n");
      out.write("											height: 80px;\r\n");
      out.write("											align-items: center;\">\r\n");
      out.write("		<div class=\"left-items\">\r\n");
      out.write("			<ul>\r\n");
      out.write("				<li><a href='");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("' style=\"a: hover{ color:#FFF\">홈</a></li>\r\n");
      out.write("				<li><a href=\"gallery_list.le\">수강</a></li>\r\n");
      out.write("				<li><a href=\"open_lecture.le\">강의</a>\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li><a href=\"open_lecture.le\">강의<br>개설</a></li>\r\n");
      out.write("					</ul></li>\r\n");
      out.write("				<li><a href=\"list.le?member_code=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.member_code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
<<<<<<< HEAD
      out.write("\" class=\"nav-item nav-link\">내 강의실</a></li>	\r\n");
      out.write("				<li><a href=\"#\">게시판</a>\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li><a href=\"#\">공통</a></li>\r\n");
      out.write("						<li><a href=\"#\">자유게시판</a></li>\r\n");
      out.write("					</ul></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"right-items\">\r\n");
      out.write("			");
=======
      out.write("\" class=\"nav-item nav-link\">강의</a>\r\n");
      out.write("                <a href=\"list.bo\" class=\"nav-item nav-link\">게시판</a>\r\n");
      out.write("                <a href=\"mypage.me\" class=\"nav-item nav-link\">마이페이지</a>\r\n");
      out.write("                <div class=\"nav-item dropdown\">\r\n");
      out.write("                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">Pages</a>\r\n");
      out.write("                    <div class=\"dropdown-menu m-0\">\r\n");
      out.write("                        <a href=\"service.html\" class=\"dropdown-item\">Our Service</a>\r\n");
      out.write("                        <a href=\"testimonial.html\" class=\"dropdown-item\">Testimonial</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"right-items\">\r\n");
      out.write("				");
>>>>>>> origin/wonhee_web
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("			");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</nav>");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/views/include/header.jsp(240,17) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/include/header.jsp(255,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty loginInfo }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("				<div class=\"loginfo\">\r\n");
          out.write("					<ul>\r\n");
          out.write("						<!-- 로그인 하지 않은 경우 -->\r\n");
          out.write("						<li><a href='login.me'>로그인</a></li>\r\n");
          out.write("						<li><a href='member.me'>회원가입</a></li>\r\n");
          out.write("					</ul>\r\n");
          out.write("				</div>\r\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/include/header.jsp(264,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty loginInfo }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("				<div class=\"loginfo\">\r\n");
          out.write("					<ul>\r\n");
          out.write("						<!-- 로그인 한 경우 -->\r\n");
          out.write("						");
          if (_jspx_meth_c_005fif_005f2(_jspx_th_c_005fif_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("						");
          if (_jspx_meth_c_005fif_005f3(_jspx_th_c_005fif_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("						<li><strong>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.member_name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</strong></li>\r\n");
          out.write("						<li><a href=\"modify_pw.me\">비밀번호변경</a></li>\r\n");
          out.write("						<li><a href=\"logout.me\">로그아웃</a></li>\r\n");
          out.write("					</ul>\r\n");
          out.write("				</div>\r\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
      // /WEB-INF/views/include/header.jsp(268,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty loginInfo.profilepath}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("							<li><a href=\"mypage.me\"><img class='profile'\r\n");
          out.write("									src=\"img/common/default_profile_img.png\"></a></li>\r\n");
          out.write("						");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
      // /WEB-INF/views/include/header.jsp(272,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty loginInfo.profilepath}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("							<li><a href=\"mypage.me\"><img class='profile'\r\n");
          out.write("									src='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.profilepath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("'></a></li>\r\n");
          out.write("						");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }
}
