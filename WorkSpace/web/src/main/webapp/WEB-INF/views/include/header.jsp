<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.min.js"></script>
<style>
	* { box-sizing: border-box; }
	a { text-decoration: none; color: #000; }
	/* ============================================= */
	.text-primary { color: #1d273d; }
	.bg-primary { background-color: #293859; }
	.bg-secondary { background-color: #b8c6e6; }
	/* ============================================= */
	.col-lg-4 {
		flex: 0 0 auto;
		width: 33.33333%;
	}
	.px-0 {
		padding-right: 0;
		padding-left: 0;
	}
	.py-3 {
		padding-top: 1rem;
		padding-bottom: 1rem;
	}
	.mb-1 { margin-bottom: 0.25rem;}
	h6 {
		font-size: 1rem;
		margin-top: 0;
	}
	span { color: #656565; }
	.fs-1 { font-size: calc(1.375rem + 1.5vw); }
	.me-3 { margin-right: 1rem; }
	.mx-lg-auto {
		margin-left: auto;
		margin-right: auto;
	}
	.m-0 { margin: 0; }
	/* ============================================= */
	.text-center { text-align: center; }
	.justify-content-center {
		justify-content: center;
	}
	.d-inline-flex {
		display: inline-flex;
	}
	.container-fluid {
		width: 100%;
		margin-right: auto;
		margin-left: auto;
	}
	.text-uppercase {
		text-transform: uppercase;
	}
	.align-items-center {
		align-items: center;
	}
	/* ============================================= */
	.row {
		display: flex;
		flex-wrap: wrap;
	}
	.text-start {
		text-align: left;
	}
	.border-inner {
    	position: relative;
	}
	.border-inner::before {
    	position: absolute;
    	content: ""; background: none;
    	top: 10px; right: 10px; bottom: 10px; left: 10px;
    	border: 1px solid #fff;
    	z-index: 0;
	}
	.logo_img { border-radius: 70%; }
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
	/* ============================================= */
	nav > ul > li { /* margin: 0px 20px; */ }
	nav > ul > li > a:hover { color: #E88F2A; }
	.nav-link > a { color: #fff; }
	.profile { 
		width: 50px; 
		height: 50px;
		border-radius: 70%;
	}
	.container {
  		display: flex;
  		height: 80px;
  		padding: 0 50px;
	}
	.left-items { width: 70%; }
	.right-items { width: 30%; }
	nav { background: #2b1f08; }
	.left-items > ul { display: flex; justify-content: center; margin: 28.8px auto; }
	.left-items > ul > li {
		margin-right: 20px;
	}
	.loginfo{
		height: 100%;
	}
	.loginfo > ul { 
		display: flex; 
		justify-content: center; 
		margin: 0;
		height: inherit;
	}
	.nav-link:hover .depth_1 { 
		display:block; 
		background-color: #fff;
		border: 1px solid black;
	}
	.depth_1 { 
		display:none; 
		position:absolute;
		left: 100; 
		right: 100; 
		width: 100px;
		height: 100px;
	}
	strong{ color: #fff; }
	.loginfo > ul  > li { 
		margin: 0 20px;
	}
</style>
<header>
	<div class="container-fluid px-0">
	        <div class="row">
	            <div class="col-lg-4 text-center bg-secondary py-3">
	                <div class="d-inline-flex align-items-center justify-content-center navbar-brand">
	                	<i class="fa-regular fa-envelope text-primary fs-1 me-3"></i>
	                    <div class="text-start">
	                        <h6 class="text-uppercase mb-1">Email Us</h6>
	                        <span>YH2023@naver.com</span>
	                    </div>
	                </div>
	            </div>
	            <div class="col-lg-4 text-center bg-primary border-inner py-3">
	                <div class="d-inline-flex align-items-center justify-content-center">
                        <img src="img/common/icons8_tree.png" alt="로고" class="me-3 logo_img">
	                    <h6 class="text-uppercase text-white mb-1 logo_title">YH-Academy</h6>
	                </div>
	            </div>
	            <div class="col-lg-4 text-center bg-secondary py-3">
	                <div class="d-inline-flex align-items-center justify-content-center navbar-brand">
	                	<i class="fa-solid fa-mobile-screen text-primary fs-1 me-3"></i>
	                    <div class="text-start">
	                        <h6 class="text-uppercase mb-1">Call Us</h6>
	                        <span>+010-0345-0789</span>
	                    </div>
	                </div>
	            </div>
	        </div>
	</div>
	<nav>
		<div class="container">
			<div class="left-items">
				<ul>
					<li class="nav-link"><a href='<c:url value="/"/>'>홈</a></li>
					<li class="nav-link"><a href="#강의">강의</a></li>
					<li class="nav-link">
						<a href='#게시판'>게시판</a>
						<ul class="depth_1">
							<li><a href="#공지사항">공지사항</a></li>
							<li><a href="#자유게시판">자유게시판</a></li>
						</ul>
					</li>
					<li class="nav-link">
						<a href='mypage'>마이페이지</a>
						<ul class="depth_1">
							<li><a href="enrolment_log">수강현황</a></li>
							<li><a href="modify_myinfo">회원정보수정</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="right-items">
				<c:if test="${empty loginInfo }">
					<div class="loginfo">
						<ul>
							<!-- 로그인 하지 않은 경우 -->
							<li class="nav-link"><a class='btn-fill' href='login'>로그인</a></li>
							<li class="nav-link"><a class='btn-fill' href='member'>회원가입</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${not empty loginInfo }">
					<div class="loginfo">
						<ul>
							<!-- 로그인 한 경우 -->
							<li><img class='profile' src="${loginInfo.profilepath}">
							<li><strong> ${loginInfo.member_name }</strong></li>
							<li class="nav-link"><a class='btn-fill' href="changePW">비밀번호변경</a></li>
							<li class="nav-link"><a class='btn-fill' href="logout">로그아웃</a></li>
						</ul>
					</div>
				</c:if>
			</div>
		</div>
	</nav>
</header>
