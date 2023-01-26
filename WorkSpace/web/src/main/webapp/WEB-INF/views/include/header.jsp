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
nav {
	margin: 0 auto;
	width: 100%;
	height: auto;
	display: inline-block;
	background: #293859;
}

nav ul {
	margin: 0;
	padding: 0;
	list-style-type: none;
	float: left;
	display: inline-block;
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
	font-size: 12px;
}

nav ul li ul li {
	width: 100%;
	border-bottom: 1px solid rgba(255, 255, 255, .3);
}

nav ul li:hover ul {
	display: block;
	z-index: 999; /* 우선순위 적용? */
}

strong {
	color: #fff;
}

span {
	color: #fff;
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

.border-inner {
	position: relative;
}

.border-inner::before {
	position: absolute;
	content: "";
	background: none;
	top: 10px;
	right: 10px;
	bottom: 10px;
	left: 10px;
	border: 1px solid #fff;
	z-index: 0;
}

.logo_img {
	border-radius: 70%;
}

.logo_title {
	font-size: 30px;
	color: #fff;
}

.navbar-brand {
	padding-top: 0.3125rem;
	padding-bottom: 0.3125rem;
	margin-right: 1rem;
	font-size: 1.25rem;
	white-space: nowrap;
}

.profile {
	width: 50px;
	height: 50px;
	border-radius: 70%;
}



.left-items {
	width: 60%;
}

.left-items li:hover {
	background: black;
}

.right-items {
	width: 40%;
}

.left-items>ul {
	display: flex;
	justify-content: center;
	margin: 0;
	height: 100%;
	color: #fff;
	font-size: 20px;
}

.loginfo {
	height: 100%;
}

.loginfo>ul {
	display: flex;
	justify-content: center;
	margin: 0;
	height: inherit;
}

.nav_link {
	font-size: 20px;
	padding: 20px;
}

.loginfo>ul>li {
	margin-right: 10px;
}

.loginfo>ul>li>a {
	color: #fff;
	font-size: 20px;
}
</style>
</head>
<div class="container-fluid px-0">
	<div class="row">
		<div class="col-lg-4 text-center bg_sub py-3">
			<div
				class="d-inline-flex align-items-center justify-content-center navbar-brand">
				<i class="fa-regular fa-envelope text_main fs-1 me-3"></i>
				<div class="text-start">
					<h6 class="text-uppercase mb-1">Email Us</h6>
					<span>YH2023@naver.com</span>
				</div>
			</div>
		</div>
		<div class="col-lg-4 text-center bg_main border-inner py-3">
			<div class="d-inline-flex align-items-center justify-content-center">
				<img src="img/common/icons8_tree.png" alt="로고" class="me-3 logo_img">
				<h6 class="text-uppercase text-white mb-1 logo_title">YH-Academy</h6>
			</div>
		</div>
		<div class="col-lg-4 text-center bg_sub py-3">
			<div
				class="d-inline-flex align-items-center justify-content-center navbar-brand">
				<i class="fa-solid fa-mobile-screen text_main fs-1 me-3"></i>
				<div class="text-start">
					<h6 class="text-uppercase mb-1">Call Us</h6>
					<span>010-0345-0789</span>
				</div>
			</div>
		</div>
	</div>
</div>
<nav>
	<div class="container" style="display: flex;
											height: 80px;
											align-items: center;">
		<div class="left-items">
			<ul>
				<li><a href='<c:url value="/"/>' style="a: hover{ color:#FFF">홈</a></li>
				<li><a href="gallery_list.le">수강</a></li>
				<li><a href="open_lecture.le">강의</a>
					<ul>
						<li><a href="open_lecture.le">강의<br>개설</a></li>
					</ul></li>
				<li><a href="list.le?member_code=${loginInfo.member_code}" class="nav-item nav-link">내 강의실</a></li>	
				<li><a href="#">게시판</a>
					<ul>
						<li><a href="list.no">공통</a></li>
						<li><a href="list.bo">자유게시판</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="right-items">
			<c:if test="${empty loginInfo }">
				<div class="loginfo">
					<ul>
						<!-- 로그인 하지 않은 경우 -->
						<li><a href='login.me'>로그인</a></li>
						<li><a href='member.me'>회원가입</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${not empty loginInfo }">
				<div class="loginfo">
					<ul>
						<!-- 로그인 한 경우 -->
						<c:if test='${empty loginInfo.profilepath}'>
							<li><a href="mypage.me"><img class='profile'
									src="img/common/profile.png"></a></li>
						</c:if>
						<c:if test='${not empty loginInfo.profilepath}'>
							<li><a href="mypage.me"><img class='profile'
									src='${loginInfo.profilepath}'></a></li>
						</c:if>
						<li><strong>${loginInfo.member_name }</strong></li>
						<li><a href="modify_pw.me">비밀번호변경</a></li>
						<li><a href="logout.me">로그아웃</a></li>
					</ul>
				</div>
			</c:if>
		</div>
	</div>
</nav>