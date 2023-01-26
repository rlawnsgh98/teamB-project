<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>open_lecture</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.min.js"></script>
<style>
#container {
	position: relative;
	width: 100%;
	margin: 0 auto;
}

.main_wrap {
	width: 1200px;
	margin: 0 auto;
	overflow: hidden;
	min-height: 620px;
	margin: 0 auto;
}

.sub_nav_wrap {
	display: flex;
	border-bottom: 1px solid #cccccc;
	padding: 10px 0;
}

.sub_nav1 {
	width: 60%;
	height: 50px;
	line-height: 50px;
	background-color: #fff;
}

.sub_nav2 {
	width: 40%;
	height: 50px;
	line-height: 50px;
	background-color: #fff;
}

.sub_nav1>ul>li>span {
	color: #000;
	padding-right: 10px;
}

.sub_nav1>ul>li {
	float: left;
	padding: 0 20px; /*수정*/
}

.sub_nav2>ul>li {
	float: right;
	padding: 0 20px;
}

#open_lecture_list_wrap {
	display: flex;
	height: 50px;
	text-align: left;
	align-items: center;
	margin: 10px 30px 0;
}

.open_lecture_list1 {
	width: 90%;
	height: 50px;
}

.open_lecture_list2 {
	width: 10%;
	height: 50px;
}

.open_lecture_list1>h5, .open_lecture_list2>span {
	line-height: 50px;
}

.open_lecture_list2>span {
	padding: 10px;
	font-size: 20px;
}

.portlet-body {
	border: 1px solid #cccccc;
	border-radius: 10px;
	background-color: #fff;
	overflow: hidden;
	margin: 0 30px;
}

.portlet-body>.table>thead {
	background-color: #506eaf;
	border-radius: 10px;
	color: #fff;
}

.portlet-body>.table>thead>tr>th {
	padding: 20px 10px;
}

.table tr:last-child th, .table tr:last-child td {
	border-bottom: none;
}

.table {
	margin-bottom: 0;
}

.table>tbody>tr:hover {
	background-color: #d2d2d2;
}

#open_lecture_info_wrap {
	height: 50px;
	text-align: left;
	margin: 10px 30px 0;
}

.open_lecture_title>h5 {
	height: 50px;
	line-height: 50px;
}

.open_lecture_table {
	float: left;
	border: 1px solid #cccccc;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0px 0px 1px #000;
	margin-left: 30px;
}

.open_lecture_table tr {
	border: 1px solid #cccccc;
}

.open_lecture_table>tbody>tr>th {
	background-color: #293859;
	color: #fff;
	padding: 20px;
}

.open_lecture_table>tbody>tr>td {
	width: 300px;
}

.open_lecture_table>tbody>tr>td>input[type=text], .open_lecture_table>tbody>tr>td>select
	{
	width: 90%;
}

.btn_cs {
	float: left;
	height: 200px;
}

.btn_cs>a:first-child {
	margin-left: 10px;
	margin-top: 30px;
}

.btn_cs>a:last-child {
	margin-left: 10px;
	margin-top: 120px;
}

.btn_cs>a {
	position: absolute;
	transition: all .3s ease-in;
	border-radius: 30px;
	padding: 10px;
	background: #293859;
	color: #fff !important;
	border-radius: 30px;
	border: 1px solid #293859;
}

.btn_cs>a:hover {
	background: transparent;
	color: #124567 !important;
	border: 1px solid #124567;
}

/* .btn_cs>a:first-child {
	bottom: 28.5%;
}

.btn_cs>a:last-child {
	bottom: 12%;
}
 */
.sub_nav2_btns {
	height: 50px;
}

.sub_nav2_btns>li>a {
	transition: all .3s ease-in;
	border-radius: 30px;
	border: 1px solid #506eaf;
	padding: 0 10px;
	background: #506eaf;
	color: #fff !important;
}

.sub_nav2_btns>li>a:hover {
	background: transparent;
	color: #124567 !important;
	border: 1px solid #124567;
}
</style>
</head>
<body>
	<h1 class="d-none">홈-강의관리-개설강의정보</h1>
	<div id="container">
		<div class="main_wrap">
			<div class="sub_nav_wrap">
				<nav class="sub_nav1">
					<ul>
						<li><span>개설년도</span> <span> <select
								class="select_year">
									<option>전체</option>
									<option>2023</option>
									<option>2022</option>
							</select></span></li>
						<li><span>과목</span> <span> <select
								class="select_subject">
									<option>전체</option>
									<option>국어</option>
									<option>수학</option>
									<option>영어</option>
							</select></span></li>
						<li><span>강사명</span> <span> <select
								class="select_teacher">
									<option>전체</option>
									<option>강사이름1</option>
									<option>강사이름2</option>
							</select></span></li>
					</ul>
				</nav>
				<nav class="sub_nav2">
					<ul class="sub_nav2_btns">
						<li><a>삭제</a></li>
						<li><a>수정</a></li>
						<li><a>등록</a></li>
						<li><a>조회</a></li>
					</ul>
				</nav>
			</div>
			<div id="open_lecture_list_wrap">
				<div class="open_lecture_list1">
					<h5>개설강의 목록</h5>
				</div>
				<div class="open_lecture_list2">
					<span><i class="fa-solid fa-caret-left"></i></span> <span>1</span>
					<span><i class="fa-solid fa-caret-right"></i></span>
				</div>
			</div>
			<div class="portlet-body">
				<table class="table">
					<colgroup>
						<col style="width: 5%">
						<col>
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 5%">
					</colgroup>
					<thead>
						<tr>
							<th>순번</th>
							<th>강의명</th>
							<th>시작일</th>
							<th>종료일</th>
							<th>강의실</th>
							<th>강사명</th>
							<th>과목명</th>
							<th>교시</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>1</th>
							<td>고1 수학</td>
							<td>23/01/02</td>
							<td>23/01/27</td>
							<td>101호</td>
							<td>강사1</td>
							<td>수학</td>
							<td>1</td>
						</tr>
						<tr>
							<th>12</th>
							<td>고2 영어</td>
							<td>23/01/02</td>
							<td>23/01/27</td>
							<td>101호</td>
							<td>강사1</td>
							<td>수학</td>
							<td>2</td>
						</tr>
						<tr>
							<th>25</th>
							<td>고3 수학</td>
							<td>23/01/02</td>
							<td>23/01/27</td>
							<td>101호</td>
							<td>강사1</td>
							<td>국어</td>
							<td>3</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="open_lecture_info_wrap">
				<div class="open_lecture_title">
					<h5>개설강의 상세정보</h5>
				</div>
			</div>
			<table class="open_lecture_table">
				<tr>
					<th>강의명</th>
					<td><input type="text" placeholder="고2 수학"></td>
				</tr>
				<tr>
					<th>시작일</th>
					<td><input type='text' name='startdate' class='date' readonly></td>
				</tr>
				<tr>
					<th>종료일</th>
					<td><input type='text' name='enddate' class='date' readonly></td>
				</tr>
			</table>
			<table class="open_lecture_table">
				<tr>
					<th>강사이름</th>
					<td><select class="select_tname">
							<option>강사이름1</option>
							<option>강사이름2</option>
					</select></td>
				</tr>
				<tr>
					<th>강의실</th>
					<td><select class="select_room">
							<option>R101</option>
							<option>R201</option>
					</select></td>
				</tr>
				<tr>
					<th>교시</th>
					<td><select class="select_tt">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
					</select></td>
				</tr>
			</table>
			<div class="btn_cs">
				<a>취소</a> <a>저장</a>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</body>
</html>