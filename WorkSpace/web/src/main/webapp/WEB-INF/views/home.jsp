<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="utf-8">
</head>

.main_wrap {
	position: relative;
	overflow: hidden;
}

.sub_wrap {
	overflow: hidden;
	padding: 0 100px;
	width: 1200px;
	margin: 0 auto;
}

.wrap1 {
	float: left;
	overflow: hidden;
	width: 300px;
	height: 495px;
	border: 1px solid #d2d2d2;
}

.wrap2 {
	float: right;
	overflow: hidden;
	height: 500px;
}

.wrap2_1 {
	width: 380px;
	height: 240px;
	float: left;
	overflow: hidden;
	position: relative;
	border: 1px solid #d2d2d2;
}

.wrap2_2 {
	float: left;
	margin-left: 15px;
	margin-bottom: 15px;
	width: 270px;
	height: 240px;
	border: 1px solid #d2d2d2;
}

.clr {
	clear: both;
	height: 0;
	overflow: hidden;
}
</style>
<style>
.mySlides {
	display: none;
}

.slideshow-container {
	height: 450px;
}

.mySlides>img {
	vertical-align: middle;
}

.dots {
	text-align: center;
}

.dot {
	height: 15px;
	width: 15px;
	margin: 0 2px;
	background-color: #bbb;
	border-radius: 50%;
	display: inline-block;
	transition: background-color 0.6s ease;
}

.slide_active {
	background-color: #717171;
}

.fade {
	animation-name: fade;
	animation-duration: 1.5s;
}

.fade:not(.show) {
	opacity: 1;
}

@
keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}
}
</style>
<style>
.cont_box {
	min-width: 1200px;
	position: relative;
	overflow: hidden;
	margin: 40px 0;
}

.flex_box {
	display: flex;
	justify-content: center;
	gap: 10px;
}

.flex_box_border {
	border: 1px solid #d2d2d2;
}

.flex_box img {
	width: 325px;
	height: 300px;
}

.cont_box h2 {
	font-size: 50px;
	margin: 20px 0;
}

.sec_title {
	margin: 10px 0;
}

.sec_title h3 {
	margin-bottom: 20px;
}

.sec_title h3:after {
	content: '';
	position: absolute;
	top: 0;
	left: 50%;
	margin-left: -26px;
	width: 52px;
	height: 2px;
	background: #000;
}

.border-inner {
	background-color: #293859;
}

.book {
	width: 200px;
	height: 220px;
}

.book_shelf {
	width: 1010px;
	height: 20px;
	border: 1px solid #804000;
	margin: 0 auto;
	background-color: #804000;
}

.book img {
	width: 200px;
	height: 220px;
	border: 1px solid #d2d2d2;
}
</style>
<body>
	<div id="container">
		<div class="main_wrap">
			<div class="sub_wrap">
				<div class="wrap1">
					<div class="slideshow-container">
						<div class="mySlides fade">
							<img src="img/banner/banner1.png">
						</div>
						<div class="mySlides fade">
							<img src="img/banner/banner2.png">
						</div>
						<div class="mySlides fade">
							<img src="img/banner/banner3.png">
						</div>
					</div>
					<div class="dots">
						<span class="dot"></span> <span class="dot"></span> <span
							class="dot"></span>
					</div>
				</div>
				<div class="wrap2">
					<div class="wrap2_1">
						<img src="img/banner/banner4.png">
					</div>
					<div class="wrap2_2">
						<img src="img/banner/banner6.png">
					</div>
					<div class="clr"></div>
					<div class="wrap2_1">
						<img src="img/banner/banner5.png">
					</div>
					<div class="wrap2_2">
						<img src="img/banner/banner7.png">
					</div>
				</div>
			</div>
		</div>
		<div class="cont_box">
			<div class="sec_title">
				<h3>강사 소개</h3>
			</div>
			<div class="flex_box">
				<div class="flex_box_border">
					<div class="team-item">
						<div class="position-relative overflow-hidden">
							<img class="img-fluid" src="img/teacher/kt.jpg">
							<div
								class="team-overlay position-absolute top-50 start-50 translate-middle d-flex align-items-center justify-content-center">
								<div class="d-flex align-items-center justify-content-start">
									<a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-twitter fw-normal"></i></a> <a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-facebook-f fw-normal"></i></a> <a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-linkedin-in fw-normal"></i></a>
								</div>
							</div>
						</div>
						<div class="border-inner text-center p-4">
							<h4 class="text-uppercase text-primary">박선향</h4>
							<p class="text-white m-0">국어</p>
						</div>
					</div>
				</div>
				<div class="flex_box_border">
					<div class="team-item">
						<div class="position-relative overflow-hidden">
							<img class="img-fluid" src="img/teacher/et.jpg">
							<div
								class="team-overlay position-absolute top-50 start-50 translate-middle d-flex align-items-center justify-content-center">
								<div class="d-flex align-items-center justify-content-start">
									<a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-twitter fw-normal"></i></a> <a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-facebook-f fw-normal"></i></a> <a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-linkedin-in fw-normal"></i></a>
								</div>
							</div>
						</div>
						<div class="border-inner text-center p-4">
							<h4 class="text-uppercase text-primary">김보라</h4>
							<p class="text-white m-0">영어</p>
						</div>
					</div>
				</div>
				<div class="flex_box_border">
					<div class="team-item">
						<div class="position-relative overflow-hidden">
							<img class="img-fluid" src="img/teacher/mt.jpg">
							<div
								class="team-overlay position-absolute top-50 start-50 translate-middle d-flex align-items-center justify-content-center">
								<div class="d-flex align-items-center justify-content-start">
									<a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-twitter fw-normal"></i></a> <a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-facebook-f fw-normal"></i></a> <a
										class="btn btn-lg btn-primary btn-lg-square border-inner rounded-0 mx-1"
										href="#"><i class="fab fa-linkedin-in fw-normal"></i></a>
								</div>
							</div>
						</div>
						<div class="border-inner text-center p-4">
							<h4 class="text-uppercase text-primary">황혜경</h4>
							<p class="text-white m-0">수학</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="cont_box">
			<div class="sec_title">
				<h3>추천 교재</h3>
			</div>
			<div class="flex_box">
				<div class="book">
					<img src="img/book/book1.JPG">
				</div>
				<div class="book">
					<img src="img/book/book2.JPG">
				</div>
				<div class="book">
					<img src="img/book/book3.JPG">
				</div>
				<div class="book">
					<img src="img/book/book4.JPG">
				</div>
			</div>
			<div class="book_shelf"></div>
		</div>
	</div>
	<script>
		let slideIndex = 0;
		showSlides();

		function showSlides() {
			let i;
			let slides = document.getElementsByClassName("mySlides");
			let dots = document.getElementsByClassName("dot");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" slide_active",
						"");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " slide_active";
			setTimeout(showSlides, 2000);
		}
	</script>
</body>
</html>
