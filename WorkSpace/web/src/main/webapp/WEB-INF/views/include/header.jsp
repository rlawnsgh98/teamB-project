<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">


<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Oswald:wght@500;600;700&family=Pacifico&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.min.js"></script>

<style>
header {
	height: 60px;
}

header h1 {
	color: #293859;
}

.header_box {
	width: 1040px;
	margin: 0 auto;
}

.header_box1 {
	float: left;
	height: 60px;
}

.header_box2 {
	float: right;
	height: 60px;
}

nav {
	margin: 0 auto;
	width: 100%;
	height: 60px;
	background-color: #293859;
}

nav ul {
	margin: 0;
	padding: 0;
}

nav ul li {
	position: relative;
	margin: 0 20px 0 0;
	float: left;
	display: inline-block;
}

nav ul li a {
	padding: 20px;
	display: inline-block;
}

nav ul li a:hover {
	color: #fff;
}

nav ul li ul {
	display: none;
	position: absolute;
	left: 0;
	background-color: #293859;
	float: left;
	width: 100%;
}

nav ul li ul li {
	width: 100%;
	border-bottom: 1px solid rgba(255, 255, 255, .3);
}

nav ul li:hover ul {
	display: block;
	z-index: 999; /* 우선순위 적용? */
}

.text_main {
	color: #1d273d;
}

.bg_main {
	background-color: #293859;
}

.bg_sub {
	background-color: #b8c6e6;
}

.text-start {
	text-align: left;
}

.logo_img {
	border-radius: 70%;
}

.logo_title {
	font-size: 30px;
	color: #fff;
}

.profile {
	width: 20px;
	height: 20px;
	margin-bottom: 2.5px;
}

.loginfo {
	margin: 20px 0;
}

.loginfo>ul {
	display: flex;
	margin: 0;
	padding: 0;
}

.loginfo>ul>li {
	margin-right: 10px;
}

.nav_box {
	width: 1040px;
	margin: 0 auto;
	color: #fff;
	height: 60px;
}

.nav_box ul li a {
	height: 60px;
}

.nav_box ul li a:hover {
	background-color: #627db7;
}

.nav_box_li a {
	width: 100%;
}
</style>
</head>
<header>
	<div class="header_box">
		<div class="header_box1">
			<h1 class="font-secondary"><a href='<c:url value="/"/>'>YH-Academy</a></h1>
		</div>
		<div class="header_box2">
			<c:if test="${empty loginInfo}">
				<div class="loginfo">
					<ul>
						<!-- 로그인 하지 않은 경우 -->
						<li><a href='login.me'>로그인</a></li>
						<li><a href='member.me'>회원가입</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${not empty loginInfo}">
				<div class="loginfo">
					<ul>
						<!-- 로그인 한 경우 -->
						<c:if test='${empty loginInfo.profilepath}'>
							<li><a href="mypage.me"><img class='profile'
									src="img/common/default_profile_img.png"></a></li>
						</c:if>
						<c:if test='${not empty loginInfo.profilepath}'>
							<li><a href="mypage.me"><img class='profile'
									src='${loginInfo.profilepath}'>${loginInfo.member_name}</a></li>
						</c:if>
						<li><strong>${loginInfo.member_name}</strong></li>
						<li><a href="modify_pw.me">비밀번호변경</a></li>
						<li><a href="logout.me">로그아웃</a></li>
					</ul>
				</div>
			</c:if>
		</div>
	</div>
</header>
<nav>
	<div class="nav_box">
		<ul>
			<li><a href='<c:url value="/"/>'>홈</a></li>
			<li><a href="gallery_list.le">수강</a></li>
			<li><a
				href="open_lecture.le?member_code=${loginInfo.member_code}">강의</a>
				<!-- <ul>
					<li><a href="#">관리</a></li>lecture_home.le?
				</ul></li> -->
			<li><a href="list.le?member_code=${loginInfo.member_code }">내 강의실</a></li>		
			<li><a href="#">게시판</a>
				<ul>
					<li class="nav_box_li"><a href="list.no">공지</a></li>
					<li class="nav_box_li"><a href="list.bo">자유</a></li>
				</ul></li>
		</ul>
	</div>
</nav>