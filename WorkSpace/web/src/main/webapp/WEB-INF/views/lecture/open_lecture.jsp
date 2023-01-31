<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<!-- datepicker start -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- datepicker end -->
<style>
#container {
	position: relative;
	width: 100%;
	margin: 0 auto;
	min-height: 700px;
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
	text-align: left;
	margin-left: 30px;
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
	padding: 0 20px;
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

.btn_cs {
	text-align: center;
	margin: 30px 0;
}

.btn_cs a {
	transition: all .3s ease-in;
	border-radius: 5px;
	padding: 10px 20px;
	background: #293859;
	color: #fff !important;
	border: 1px solid #293859;
	margin: 10px;
}

.btn_cs a:hover {
	background: transparent;
	color: #124567 !important;
	border: 1px solid #124567;
}
</style>
<style>
.modal_en, .modal_mo, .modal_del {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 200px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.modal-content {
	background-color: #fefefe;
	margin: auto;
	border: 1px solid #888;
	width: 70%;
	text-align: right;
	overflow: hidden;
}

.modal-content2 {
	background-color: #fefefe;
	margin: auto;
	border: 1px solid #888;
	width: 30%;
	text-align: right;
	overflow: hidden;
}

.modal-content h3 {
	text-align: center;
	margin-bottom: 20px;
}

.modal-content2 h3{
	text-align: center;
	margin-bottom: 20px;
	margin-top: 30px;
	margin-left: 40px;
}

.modal-content span, .modal-content2 span {
	padding-right: 20px;
	overflow: hidden;
}

.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

#open_lec_table {
	text-align: left;
	margin: 0 auto;
}

#open_lec_table>tbody>tr {
	border: 1px solid #cccccc;
}

#open_lec_table>tbody>tr>th {
	background-color: #293859;
	text-align: center;
	color: #fff;
	padding: 10px 20px;
}

#open_lec_table>tbody>tr>td {
	padding: 10px;
}

#open_lec_table>tbody>tr>td>input[type=date], #open_lec_table>tbody>tr>td>select
	{
	width: 100%;
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
						<form id="searchForm" action="open_lecture.le" method="post"
							style="display: inline-block;">
							<input type="hidden" name="member_code"
								value="${loginInfo.member_code}">
							<li><span>개설년도</span> <span> <select
									name="select_year">
										<option value="" ${select_year eq '' ? 'selected':''}>전체</option>
										<option value="2023" ${select_year eq '2023' ? 'selected':''}>2023</option>
										<option value="2022" ${select_year eq '2022' ? 'selected':''}>2022</option>
								</select>
							</span></li>
							<li><span>과목</span> <span><select
									name="select_subject">
										<option value="" ${select_subject eq '' ? 'selected':''}>전체</option>
										<option value="KOR" ${select_subject eq 'KOR' ? 'selected':''}>국어</option>
										<option value="MATH"
											${select_subject eq 'MATH' ? 'selected':''}>수학</option>
										<option value="ENG" ${select_subject eq 'ENG' ? 'selected':''}>영어</option>
								</select> </span></li>
						</form>
					</ul>
				</nav>
				<nav class="sub_nav2">
					<ul class="sub_nav2_btns">
						<li><a id="del_btn">삭제</a></li>
						<li><a id="mo_btn">수정</a></li>
						<!-- Trigger/Open The Modal -->
						<li><a id="en_btn">등록</a></li>
						<li><a id="search_btn">조회</a></li>
					</ul>
				</nav>
			</div>
			<div id="open_lecture_list_wrap">
				<div class="open_lecture_list1">
					<h5>강의 목록</h5>
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
							<th>코드</th>
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
						<c:forEach items='${te_lec_list}' var='vo'>
							<tr>
								<th>${vo.lecture_code}</th>
								<td>${vo.lecture_name}</td>
								<td>${vo.startdate}</td>
								<td>${vo.enddate}</td>
								<td>${vo.room_code}</td>
								<td>${vo.teacher_name}</td>
								<td>${vo.subject_code}</td>
								<td>${vo.timetable_code}</td>
							</tr>
						</c:forEach>
						<c:if test="${empty te_lec_list}">
							<td colspan="8">검색 조건 해당하는 강의가 없습니다.</td>
						</c:if>
					</tbody>
				</table>
			</div>
			<!-- The Modal : 등록 -->
			<div id="myModal_en" class="modal_en">
				<!-- Modal content -->
				<div class="modal-content">
					<span class="close close_en">&times;</span>
					<h3>강의 개설</h3>
					<form id="en_lecForm" action="open_new_lecture" method="post">
						<input type="hidden" name="teacher_code"
							value="${loginInfo.member_code}">
						<table id="open_lec_table">
							<tr>
								<th>강의명</th>
								<td colspan="4"><input type="text" name="lecture_name"
									style="width: 100%;"></td>
							</tr>
							<tr>
								<th>과목명</th>
								<td><select name="subject_code">
										<option value="KOR">국어</option>
										<option value="ENG">영어</option>
										<option value="MATH">수학</option>
								</select></td>
								<th>강사명</th>
								<td><input type="text" value="${loginInfo.member_name}"
									readonly style="border: none;" name="teacher_name"></td>
							</tr>
							<tr>
								<th>시작일</th>
								<td>
									<!-- <input type="date" name="startdate"> --> <input
									type="text" id="en_sdate" name="startdate">
								</td>
								<th>종료일</th>
								<td>
									<!-- <input type="date" name="enddate"> --> <input type="text"
									id="en_edate" name="enddate">
								</td>
							</tr>
							<tr>
								<th>강의실</th>
								<td><select name="room_code">
										<option value="R101">R101</option>
										<option value="R201">R201</option>
										<option value="R301">R301</option>
										<option value="R401">R401</option>
								</select></td>
								<th>교시</th>
								<td><select name="timetable_code">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
								</select></td>
							</tr>
						</table>
					</form>
					<div class="btn_cs">
						<a class="btn_cs_en_cancel">취소</a> <a id="btn_cs_en_save">저장</a>
					</div>
				</div>
			</div>
			<!-- The Modal : 등록 - END -->
			<!-- The Modal : 수정 -->
			<div id="myModal_mo" class="modal_mo">
				<!-- Modal content -->
				<div class="modal-content">
					<span class="close close_mo">&times;</span>
					<h3>강의 정보 수정</h3>
					<form id="mo_lecForm" action="modify_lecture" method="post">
						<input type="hidden" name="teacher_code"
							value="${loginInfo.member_code}">
						<table id="open_lec_table">
							<tr>
								<th>강의코드</th>
								<td><select name="lecture_code">
									<c:forEach items="${lec_code_list}" var="l">
										<option value="${l.lecture_code}">${l.lecture_code}</option>
									</c:forEach>
								</select></td>
								<th>강의명</th>
								<td><input type="text" name="lecture_name" style="width: 100%;"></td>
							</tr>
							<tr>
								<th>과목명</th>
								<td><select name="subject_code">
										<option value="KOR">국어</option>
										<option value="ENG">영어</option>
										<option value="MATH">수학</option>
								</select></td>
								<th>강사명</th>
								<td><input type="text" value="${loginInfo.member_name}"
									readonly style="border: none;" name="teacher_name"></td>
							</tr>
							<tr>
								<th>시작일</th>
								<td>
									<!-- <input type="date" name="startdate"> --> <input
									type="text" id="mo_sdate" name="startdate">
								</td>
								<th>종료일</th>
								<td>
									<!-- <input type="date" name="enddate"> --> <input type="text"
									id="mo_edate" name="enddate">
								</td>
							</tr>
							<tr>
								<th>강의실</th>
								<td><select name="room_code">
										<option value="R101">R101</option>
										<option value="R201">R201</option>
										<option value="R301">R301</option>
										<option value="R401">R401</option>
								</select></td>
								<th>교시</th>
								<td><select name="timetable_code">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
								</select></td>
							</tr>
						</table>
					</form>
					<div class="btn_cs">
						<a class="btn_cs_mo_cancel">취소</a> <a id="btn_cs_mo_save">저장</a>
					</div>
				</div>
			</div>
			<!-- The Modal : 수정 - END -->
			<!-- The Modal : 삭제 -->
			<div id="myModal_del" class="modal_del">
				<!-- Modal content -->
				<div class="modal-content2">
					<span class="close close_del">&times;</span>
					<h3>강의 삭제</h3>
					<form id="del_lecForm" action="delete_lecture" method="post">
						<input type="hidden" name="teacher_code"
							value="${loginInfo.member_code}">
						<table id="open_lec_table">
							<tr>
								<th>강의코드</th>
								<td>
									<select name="lecture_code">
										<c:forEach items="${lec_code_list}" var="l">
											<option value="${l.lecture_code}">${l.lecture_code}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
					</form>
					<div class="btn_cs">
						<a class="btn_cs_del_cancel">취소</a> <a id="btn_cs_del_save">확인</a>
					</div>
				</div>
			</div>
			<!-- The Modal : 삭제 - END -->
		</div>
	</div>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		/* 조회 */
		var searchForm = $('#searchForm');
		$('#search_btn').on("click", function(e) {
			searchForm.submit();
		});
		
		/* 등록 */
		$('.btn_cs_en_cancel').on('click', function() {
			modal_en.style.display = "none";
		});
		var en_lecForm = $('#en_lecForm');
		$('#btn_cs_en_save').on("click", function(e) {
			en_lecForm.submit();
		});
		
		/* 수정 */
		$('.btn_cs_mo_cancel').on('click', function() {
			modal_mo.style.display = "none";
		});
		var mo_lecForm = $('#mo_lecForm');
		$('#btn_cs_mo_save').on("click", function(e) {
			mo_lecForm.submit();
		});

		/* 삭제 */
		$('.btn_cs_del_cancel').on('click', function() {
			modal_del.style.display = "none";
		});
		var del_lecForm = $('#del_lecForm');
		$('#btn_cs_del_save').on("click", function(e) {
			del_lecForm.submit();
		});
	</script>
	<script>
		<!-- The Modal : 등록 -->
		var modal_en = document.getElementById("myModal_en");
		var en_btn = document.getElementById("en_btn");
		var span = document.getElementsByClassName("close_en")[0];
		en_btn.onclick = function() {
			modal_en.style.display = "block";
		}
		span.onclick = function() {
			modal_en.style.display = "none";
		}
		window.onclick = function(event) {
			if (event.target == modal_en) {
				modal_en.style.display = "none";
			}
		}
		
		<!-- The Modal : 수정 -->
		// Get the modal
		var modal_mo = document.getElementById("myModal_mo");

		var mo_btn = document.getElementById("mo_btn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close_mo")[0];

		// When the user clicks the button, open the modal 
		mo_btn.onclick = function() {
			modal_mo.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal_mo.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal_mo) {
				modal_mo.style.display = "none";
			}
		}
		
		<!-- The Modal : 삭제 -->
		// Get the modal
		var modal_del = document.getElementById("myModal_del");

		var del_btn = document.getElementById("del_btn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close_del")[0];

		// When the user clicks the button, open the modal 
		del_btn.onclick = function() {
			modal_del.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal_del.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal_del) {
				modal_del.style.display = "none";
			}
		}
	</script>
	<script>
	<!-- datepicker start -->
	$(document).ready(function () {
	    $.datepicker.regional['ko'] = {
	        closeText: '닫기',
	        prevText: '이전달',
	        nextText: '다음달',
	        currentText: '오늘',
	        monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
	        '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
	        monthNamesShort: ['1월','2월','3월','4월','5월','6월',
	        '7월','8월','9월','10월','11월','12월'],
	        dayNames: ['일','월','화','수','목','금','토'],
	        dayNamesShort: ['일','월','화','수','목','금','토'],
	        dayNamesMin: ['일','월','화','수','목','금','토'],
	        weekHeader: 'Wk',
	        dateFormat: 'yy-mm-dd',
	        firstDay: 0,
	        isRTL: false,
	        showMonthAfterYear: true,
	        yearSuffix: '',
	        showOn: 'both',
	        buttonText: "달력",
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	        yearRange: 'c-99:c+99',
	    };
	    $.datepicker.setDefaults($.datepicker.regional['ko']);

	    /* 등록 */
	    $('#en_sdate').datepicker();
	    $('#en_sdate').datepicker("option", "maxDate", $("#en_edate").val());
	    $('#en_sdate').datepicker("option", "onClose", function ( selectedDate ) {
	        $("#en_edate").datepicker( "option", "minDate", selectedDate );
	    });

	    $('#en_edate').datepicker();
	    $('#en_edate').datepicker("option", "minDate", $("#en_sdate").val());
	    $('#en_edate').datepicker("option", "onClose", function ( selectedDate ) {
	        $("#en_sdate").datepicker( "option", "maxDate", selectedDate );
	    });
	    
	    /* 수정 */
	    $('#mo_sdate').datepicker();
	    $('#mo_sdate').datepicker("option", "maxDate", $("#en_edate").val());
	    $('#mo_sdate').datepicker("option", "onClose", function ( selectedDate ) {
	        $("#mo_edate").datepicker( "option", "minDate", selectedDate );
	    });

	    $('#mo_edate').datepicker();
	    $('#mo_edate').datepicker("option", "minDate", $("#mo_sdate").val());
	    $('#mo_edate').datepicker("option", "onClose", function ( selectedDate ) {
	        $("#mo_sdate").datepicker( "option", "maxDate", selectedDate );
	    });
	});
	<!-- datepicker end -->
	</script>
</body>
</html>