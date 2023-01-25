<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>design_test_ver1</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
#container {
	background-color: #3bbbf3;
	width: 100%;
	overflow: hidden;
}

.main_wrap {
	width: 980px;
	margin: 0 auto;
	position: relative;
	overflow: hidden;
}

.sub_wrap {
	overflow: hidden;
	padding: 80px 0;
}

.wrap1 {
	float: left;
	background-color: black;
	overflow: hidden;
	width: 300px;
	height: 500px;
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
	background-color: blue;
}

.wrap2_2 {
	float: left;
	margin-left: 15px;
	margin-bottom: 15px;
	width: 270px;
	height: 240px;
	background-color: green;
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