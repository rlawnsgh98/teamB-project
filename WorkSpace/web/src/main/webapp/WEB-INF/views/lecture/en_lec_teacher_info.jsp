<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>en_lec_teacher_info</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
#container {
	width: 100%;
	overflow: hidden;
}

.main_wrap {
	width: 1010px;
	margin: 0 auto;
	position: relative;
	overflow: hidden;
	border: 1px solid #ccc;
	min-height: auto;
	box-sizing: border-box;
}

.teacher_details_dv {
	padding: 55px 20px;
	overflow: hidden;
	position: relative;
}

.teacher_view {
	float: left;
	width: 32%;
}

.teacher_appraisal {
	float: right;
	width: 68%;
}

.title {
	font-size: 23px;
	color: #333;
	margin-bottom: 30px;
	margin-left: 15px;
}

.icon {
	display: inline-block;
	min-width: 56px;
	height: 26px;
	text-align: center;
	font-size: 14px;
	color: #222;
	background-color: #fff;
	border: 1px solid #d5d5d5;
	border-radius: 3px;
	vertical-align: top;
	margin: 7.2px 10px 0 0;
	padding: 0 10px;
}

.img_box {
	width: 240px;
	margin-bottom: 45px;
	margin-left: 45px;
}

.img_box img {
	width: 240px;
}

.text_box {
	position: relative;
	padding-left: 32px;
}

.tit {
	position: relative;
	font-size: 18px;
	line-height: 32px;
	color: #0e82d5;
	height: 96px;
	overflow: hidden;
	padding-right: 25px;
}

.lecture_grade {
	border: 1px solid #d9d9d9;
	overflow: hidden;
}

.lecture_grade p {
	padding: 20px 0 20px 30px;
	border-bottom: 1px solid #d9d9d9;
}

.lecture_grade p>span {
	display: inline-block;
	font-size: 20px;
	color: #222;
}

.lecture_grade p>span:first-child {
	margin-right: 35px;
}

.pink {
	color: #ff4089;
}

.blue {
	color: #0085ea;
}

.lecture_grade p>span>strong {
	display: inline-block;
	font-size: 30px;
	font-weight: bold;
	margin-left: 30px;
}

.lecture_grade ul {
	float: left;
	width: 100%;
	height: 88px;
	background-color: #f9f9f9;
	padding: 0 30px;
	margin: 0;
	text-align: left;
}

.lecture_grade ul li {
	font-size: 14px;
	margin-top: 15px;
	overflow: hidden;
}

.reply {
	margin-left: 10px;
}

.teacher_graph_dv {
	width: 100%;
	overflow: hidden;
	margin-top: 35px;
	display: flex;
}

.teacher_graph_dv p {
	font-size: 20px;
	color: #222;
	margin: 70px 16px;
}

.real_graph {
	background-color: #ccc;
	width: 400px;
	height: 190px;
}

.real_graph img {
	width: 400px;
	height: 190px;
}
</style>
<body>
	<div id="container">
		<div class="main_wrap">
			<div class="teacher_details_dv">
				<div class="teacher_view">
					<p class="title">
						<span class="icon">국어</span> <strong>박선향</strong><span>선생님</span>
					</p>
					<div class="img_box">
						<img src="img/teacher/kt.jpg">
					</div>
					<div class="text_box">
						<p class="tit">듣기만 해도 이해가 되는 국어!</p>
					</div>
				</div>
				<div class="teacher_appraisal pc_view">
					<div class="lecture_grade">
						<p>
							<span>강의 만족도 <strong class="pink">99%</strong></span> <span>학습
								Q/A 답변율 <strong class="blue">99%</strong>
							</span>
						</p>
						<ul>
							<li><span> <img
									src="https://mid.ebs.co.kr/images/middle/respond/sub/rating_5.png">
									<span class="reply">이 강의를 추천합니다.</span>
							</span></li>
							<li><span> <img
									src="https://mid.ebs.co.kr/images/middle/respond/sub/rating_5.png">
									<span class="reply">쌤, 수고하셨어요!! 강의 재밌어요~</span>
							</span></li>
						</ul>
					</div>
					<div class="teacher_graph_dv">
						<p>수강생 분포</p>
						<div class="real_graph">
							<img src="img/teacher/real_graph.png">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>