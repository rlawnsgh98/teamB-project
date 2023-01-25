<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/member.css?<%=new java.util.Date()%>">
<style>
.enrolment_lecture_box {
	width: 100%;
	max-width: 1200px;
	margin: 0 auto;
	overflow: hidden;
}

.tb_top {
	height: 50px;
	overflow: hidden;
	margin-bottom: 30px;
}

.list_top1 {
	overflow: hidden;
	float: left;
	height: 50px;
}

.search_select {
	width: 150px;
	height: 50px;
}

.list_top2, .list_top3 {
	overflow: hidden;
	float: right;
	height: 50px;
}

.btn_sort {
	float: right;
	text-align: right;
	line-height: 50px;
}

.btn_sort>span {
	margin-right: 10px;
}

.list_top3>span>input[type="text"] {
	height: 50px !important;
	margin: 0;
}

.btn_search {
	height: 50px;
	padding: 10px 20px;
}

.kor_color {
	background-color: red;
	width: 100%;
	height: 30px;
}

.eng_color {
	background-color: blue;
	width: 100%;
	height: 30px;
}

.math_color {
	background-color: green;
	width: 100%;
	height: 30px;
}

.card-group {
	margin-bottom: 10px;
	gap: 10px;
}

.en_lec_btn {
	width: 100%;
}
</style>
</head>
<body>
	<h1 class="d-none">홈-수강신청-강의목록</h1>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<h2 class="lnb_title text-center text-dark">강의목록</h2>
			<ul id="lnb" class="lnb_list">
				<li id="lnb_enrolment_lecture_all"><a href="#전체"
					class="btn btn-dark rounded-pill text-white"> 전체 </a></li>
				<li id="lnb_enrolment_lecture_kor"><a href="#국어"
					class="btn btn-outline-dark rounded-pill text-dark"> 국어 </a></li>
				<li id="lnb_enrolment_lecture_eng"><a href="#영어"
					class="btn btn-outline-dark rounded-pill text-dark"> 영어 </a></li>
				<li id="lnb_enrolment_lecture_math"><a href="#수학"
					class="btn btn-outline-dark rounded-pill text-dark"> 수학 </a></li>
			</ul>
			<div id="contet_area">
				<div class="path">
					<ol class='path_list'>
						<li>수강신청</li>
						<li class="last">강의목록</li>
					</ol>
				</div>
				<div class="content_body">
					<div class="enrolment_lecture_box">
						<div class="tb_top">
							<div class="list_top1">
								<select class="search_select" name="scid">
									<option>전체</option>
									<option>국어</option>
									<option>수학</option>
									<option>영어</option>
								</select>
							</div>
							<div class="list_top3">
								<span> <select class="search_select" name="s_field">
										<option>전체</option>
										<option>과정명</option>
										<option>과정내용</option>
								</select>
								</span> <span> <input type="text">
								</span> <span> <a href="#"
									class="btn btn-dark text-white btn_search">검색</a>
								</span>
							</div>
							<div class="list_top2">
								<div class="btn_sort">
									<span><a href="#갤러리형">갤러리형</a></span> <span><a
										href="#리스트형">리스트형</a></span>
								</div>
							</div>
						</div>
						<div class="card-group">
							<div class="card">
								<div class="eng_color"></div>
								<div class="card-body">
									<h5 class="card-title">영어(강사이름)</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.(수업내용)</p>
									<a href="#" class="btn btn-dark text-white en_lec_btn">수강신청</a>
								</div>
							</div>
							<div class="card">
								<div class="kor_color"></div>
								<div class="card-body">
									<h5 class="card-title">국어(강사이름)</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.(수업내용)</p>
									<a href="#" class="btn btn-dark text-white en_lec_btn">수강신청</a>
								</div>
							</div>
							<div class="card">
								<div class="math_color"></div>
								<div class="card-body">
									<h5 class="card-title">수학(강사이름)</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.(수업내용)</p>
									<a href="#" class="btn btn-dark text-white en_lec_btn">수강신청</a>
								</div>
							</div>
						</div>
						<div class="card-group">
							<div class="card">
								<div class="eng_color"></div>
								<div class="card-body">
									<h5 class="card-title">영어(강사이름)</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.(수업내용)</p>
									<a href="#" class="btn btn-dark text-white en_lec_btn">수강신청</a>
								</div>
							</div>
							<div class="card">
								<div class="math_color"></div>
								<div class="card-body">
									<h5 class="card-title">수학(강사이름)</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.(수업내용)</p>
									<a href="#" class="btn btn-dark text-white en_lec_btn">수강신청</a>
								</div>
							</div>
							<div class="card">
								<div class="kor_color"></div>
								<div class="card-body">
									<h5 class="card-title">국어(강사이름)</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.(수업내용)</p>
									<a href="#" class="btn btn-dark text-white en_lec_btn">수강신청</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>