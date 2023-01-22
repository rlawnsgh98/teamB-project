<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>modify_myinfo</title>
	<link rel="stylesheet" type="text/css" href="css/member.css?<%=new java.util.Date()%>">
</head>
<body>
	<h3 class="d-none">회원서비스</h3>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<div class="left_area lnb03">
				<h3 class="d-none">lnb영역</h3>
				<h3 class="lnb_title">마이페이지</h3>
				<ul id="lnb" class="lnb_list" data-code="member">
					<li id="lnb_enrolment_log">
						<a href="enrolment_log.me" target="_self">수강현황</a>
					</li>
					<li id="lnb_modify_myinfo" class="on">
						<a href="modify_myinfo.me" target="_self">회원정보수정</a>
					</li>
				</ul>
			</div>
			<div id="contet_area">
				<div class="path">
					<ol class='path_list'>
						<li>마이페이지</li>
						<li class="last">메인</li>
					</ol>
				</div>
				<h4 class="content_title">마이페이지</h4>
				<div class="content_body">
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>