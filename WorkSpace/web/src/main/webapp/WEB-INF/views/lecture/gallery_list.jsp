<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lec_list_test</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/member.css?<%=new java.util.Date()%>">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
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
	line-height: 50px;
	font-size: 35px;
	color: black;
}

.list_top3>span>input[type="text"] {
	height: 50px !important;
	margin: 0;
}

.btn_search {
	height: 50px;
	padding: 10px 20px;
}

.boxes {
	width: 1200px;
	height: 330px;
	margin: 0 auto;
	border-top: 1px solid #000;
}

.profile_card {
	width: 280px;
	height: 300px;
	margin: 10px;
	float: left;
}

.cards-container {
	width: 280px;
	height: 300px;
	box-shadow: 0px 1px 2px 1px #000;
	overflow: hidden;
	border-radius: 10px;
}

.upper-container {
	height: 50px;
	background: #293859;
}

.lower-container {
	height: 300px;
	background: #FFF;
	text-align: center;
}

.lower-container>div {
	margin: 10px 0;
}

.lower-container h6 {
	color: #293859;;
	opacity: .9;
}

.lower-container>div>img {
	width: 100px;
	height: 100px;
}

.lower-container .btn {
	padding: 12px 20px;
	background: #293859;
	border: none;
	color: white;
	border-radius: 30px;
	font-size: 12px;
	text-decoration: none;
	font-weight: bold;
	transition: all .3s ease-in;
}

.lower-container .btn:hover {
	background: transparent;
	color: #293859;
	border: 2px solid #293859;
}
</style>
<body>
	<div id="container" class="ct_top">
		<div class="main_wrap">
			<h2 class="lnb_title text-center text-dark">강의 목록</h2>
			<div id="contet_area">
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
									<span class="material-symbols-outlined"><a
										href="gallery_list.le">gallery_thumbnail</a></span> <span
										class="material-symbols-outlined"><a
										href="just_list.le">list_alt</a></span>
								</div>
							</div>
						</div>
						<div class="boxes">
							<c:forEach items='${sys_lec_list}' var='vo'>
								<div class="profile_card">
									<div class="cards">
										<div class="cards-container">
											<div class="upper-container"></div>
											<div class="lower-container">
												<div>
													<h6>${vo.teacher_name}선생님</h6>
													<h4>${vo.lecture_name}</h4>
												</div>
												<div>
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
												<div>
													<a href="en_lec_detail.le" class="btn">상세보기</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>