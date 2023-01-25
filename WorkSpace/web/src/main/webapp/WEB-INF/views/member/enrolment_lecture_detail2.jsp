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
	<h1 class="d-none">홈-수강신청-강의정보</h1>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<h2 class="lnb_title text-center text-dark">강의정보</h2>
			<div id="contet_area">
				<div class="path">
					<ol class='path_list'>
						<li>수강신청</li>
						<li class="last">강의정보</li>
					</ol>
				</div>
				<div class="content_body">
					<div class="enrolment_lecture_box">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>