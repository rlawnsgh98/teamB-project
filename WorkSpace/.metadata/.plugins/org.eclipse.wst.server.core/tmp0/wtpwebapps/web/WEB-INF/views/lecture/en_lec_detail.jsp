<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>design_test_ver4</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
#container {
	width: 100%;
	overflow: hidden;
}

#container2 {
	width: 100%;
	overflow: hidden;
}

.main_wrap {
	width: 1200px;
	margin: 0 auto;
	position: relative;
	overflow: hidden;
	height: 350px;
}

.main_wrap2 {
	width: 1020px;
	margin: 0 auto;
	position: relative;
	overflow: hidden;
}
</style>

<style>
.pm_detail_top {
	position: relative;
	overflow: hidden;
}

.pm_detail_top .img {
	float: left;
	width: 40%;
}

.pm_detail_top .img img {
	width: 300px;
	height: 340px;
}

.lecture {
	position: relative;
	float: left;
	width: 60%;
	text-align: left;
	padding: 80px 0;
}

.icons {
	margin-bottom: 15px;
}

.lecture h2 {
	color: #222;
	font-size: 26px;
	font-weight: bold;
	margin-bottom: 20px;
	padding-right: 60px;
}

.lecture .name {
	margin-bottom: 40px;
}

.lecture .name>strong {
	font-size: 24px;
	color: #222;
	vertical-align: middle;
}

.lecture .name>span {
	font-size: 20px;
	color: #999;
	vertical-align: middle;
}

.lecture .name .btn {
	display: inline-block;
	margin-left: 10px;
	vertical-align: middle;
	width: 24px;
	height: 24px;
	background: #1988cc
		url('https://mid.ebs.co.kr/images/middle/respond/premium/ico_home.png')
		50% 50% no-repeat;
	background-size: 16px auto;
}

.lecture .btns a {
	float: left;
	margin-right: 20px;
	display: block;
	width: 170px;
	height: 60px;
	line-height: 60px;
	border: 1px solid #e84c4c;
	color: #fff;
	font-size: 20px;
	background-color: #e84c4c;
	box-sizing: border-box;
	padding: 0 15px;
	position: relative;
	transition: all 0.15s;
	text-align: center;
}

.en_table table {
	width: 100%;
}

.en_table table tbody tr {
	border: 1px solid #ddd;
}

.en_table table tbody tr th {
	color: #000;
	padding: 10px 0;
}

.en_table table tbody tr td {
	text-align: left;
	padding: 15px 20px;
}

.en_progress {
	position: relative;
	height: 30px;
}

.en_bar {
	background-color: #ff612a;
	border-radius: 8px;
	height: 16px;
	width: 100%;
}

.en_bar .data {
	background-color: #0179b6;
	height: 16px;
	border-radius: 8px;
}

.percent {
	position: absolute;
	left: 0;
	top: 22px;
	line-height: 1.3;
	color: #222;
	font-size: 15px;
}

.percent.p1 {
	left: 0;
	text-align: left;
}

.percent.p2 {
	right: 0;
	text-align: right;
}

.pm_tabs_view {
	height: 50px;
	margin-top: 40px;
}

.pm_tabs_view ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

.pm_tabs_view li {
	float: left;
	width: 16.66666%;
	position: relative;
	box-sizing: border-box;
	border: 1px solid #ddd;
	border-bottom: 1px solid #e84c4c;
	background-color: #f3f3f3;
}

.pm_tabs_view li.on {
	border: 1px solid #e84c4c;
	border-top-width: 5px;
	border-bottom: none;
	background-color: #fff;
}

.pm_tabs_view li.on a {
	color: #222;
	height: 46px;
	line-height: 46px;
	background-color: #fff;
	text-align: center;
}

.pm_tabs_view a {
	color: #555;
	font-size: 18px;
	height: 48px;
	line-height: 48px;
	text-align: center;
}

#pmLectContent {
	padding: 50px 20px 50px;
}

.pm_view_section .tit {
	font-size: 26px;
	color: #222;
	position: relative;
	background-color: #fff;
	margin-bottom: 10px;
	text-align: left;
	background-color: #fff;
}

.pm_view_section .tit b {
	display: inline-block;
	background-color: #fff;
	position: relative;
	padding-right: 20px;
}

.pm_view_section .tit span {
	color: #bbb;
	font-size: 13px;
	display: block;
	text-transform: uppercase;
}

.pm_view_section .tit:after {
	content: '';
	display: block;
	width: 100%;
	height: 0;
	border-bottom: 4px dotted #eee;
	position: absolute;
	left: 140px;
	top: 17px;
}

.pm_view_section .cont {
	font-size: 15px;
	color: #777;
	line-height: 1.6;
	padding: 0 0 0 170px;
	position: relative;
	min-height: 120px;
	text-align: left;
}

.pm_view_section .cont+.tit {
	margin-top: 20px;
}
</style>
<body>
	<div id="container">
		<div class="main_wrap">
			<div class="sub_wrap">
				<div class="pm_detail_top">
					<div class="img">
						<!-- <img src="img/teacher/kt.jpg"> -->
						<c:choose>
							<c:when test="${vo.subject_code eq 'KOR'}">
								<img src="img/teacher/kt.jpg">
							</c:when>
							<c:when test="${vo.subject_code eq 'ENG'}">
								<img src="img/teacher/et.jpg">
							</c:when>
							<c:when test="${vo.subject_code eq 'MATH'}">
								<img src="img/teacher/mt.jpg">
							</c:when>
						</c:choose>
					</div>
					<div class="lecture">
						<h2>${vo.lecture_name}</h2>
						<div class="name">
							<strong>${vo.teacher_name}</strong> <span>선생님</span> <a
								href="en_lec_teacher_info.le" class="btn"></a>
						</div>
						<div class="btns">
							<a class="btn1"
								href="en_lec_insert.le?lecture_code=${vo.lecture_code}&member_code=${loginInfo.member_code}"
								onclick="enrollment_kt();">수강신청</a> <a class="btn1">교재구매</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="container2">
		<div class="main_wrap2">
			<div class="en_table">
				<table>
					<tr>
						<th>수강대상</th>
						<td>중학3/내신기본</td>
					</tr>
					<tr>
						<th>수강기간</th>
						<td>22/12/30 ~ 23/02/01</td>
					</tr>
					<tr>
						<th>강의교재</th>
						<td>EBS 중학 뉴런 국어3</td>
					</tr>
					<tr>
						<th>강좌구성</th>
						<td>
							<div class="en_progress">
								<div class="en_bar">
									<div class="data" style="width: 80%"></div>
								</div>
								<div class="percent p1">
									<strong>80%</strong> <span>개념설명</span>
								</div>
								<div class="percent p2">
									<strong>20%</strong> <span>문제풀이</span>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div id="container2">
		<div class="main_wrap2">
			<div class="pm_tabs_view">
				<ul>
					<li class="on"><a>강의소개</a></li>
					<li><a>강의목록</a></li>
					<li><a>공지사항</a></li>
					<li><a>학습Q/A</a></li>
					<li><a>수강후기</a></li>
					<li><a>자료실</a></li>
				</ul>
			</div>
			<div class="pm_view_section" id="pmLectContent">
				<div class="tit">
					<b> 강의 범위 <span>lecture scope</span>
					</b>
				</div>
				<div class="cont">
					• 중학교 3학년 국어 교과서 전범위 <br> • 3학년 영역 - 문학,읽기,쓰기,문법,듣기·말하기
				</div>
				<div class="tit">
					<b> 수강대상 <span>lecture target</span>
					</b>
				</div>
				<div class="cont">
					• 기본 핵심 개념 학습을 통해 3학년 국어 성적을 미리 잡고 싶은 학생 <br> • 한 학기 교고 핵심 개념을
					미리 공부하고 싶은 학생
				</div>
				<div class="tit">
					<b> 강좌특징 <span>lecture feature</span>
					</b>
				</div>
				<div class="cont">
					• 단기간에 3학년 국어 교과서의 개념을 정리해 주는 강좌! <br> • 2015 개정 교육과정의 핵심 사항이
					반영된 전략적인 강좌!
				</div>
			</div>
		</div>
	</div>
	<script>
	 function enrollment_kt(){
		 if(${empty loginInfo.id}){
			 alert('로그인 먼저 해주세요.');
		 }else if(${not empty loginInfo.id && loginInfo.type == 'STUD'}) {
			 alert('${loginInfo.member_name}님, 수강신청이 완료되었습니다.');
		 }else {
			 alert('잘못된 접근입니다.');
		 }
	 }
	</script>
</body>
</html>