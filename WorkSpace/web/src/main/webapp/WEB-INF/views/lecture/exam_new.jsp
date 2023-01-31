<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
href="css/member.css?<%=new java.util.Date()%>">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>시험 등록</h3>
	
	<div id="container py-5">
		<div class="col-lg-7 mx-auto bg-white rounded shadow exam-new-container">
		
			<form method='post' action='exam_insert.le' enctype='multipart/form-data'>
			<input type='hidden' value='${lecture.lecture_code}' name='lecture_code'/>
			<input type='hidden' value='${lecture.subject_code}' name='subject'/>
				<table class="table">
					<tr>
						<th class="col-3 align-middle px-4 py-3">시험 제목</th>
						<td class="align-middle " colspan='3'>
							<input class='form-control' style = "width:100%" type="text"  name='exam_title'>
						</td>
					</tr>
					
					<tr>
						<th class="col-3 align-middle px-4 py-3">시험구분</th>
				
						<td class='align-middle'>
							<select class='form-select' name='exam_type'>
								<option value='1'>모의고사</option>
								<option value='2'>쪽지시험</option>
								<option value='3'>중간평가</option>
								<option value='4'>기말평가</option>
							</select>
						</td>
						
<!-- 						<th class="col-3 align-middle px-4 py-3">과목</th> -->
<!-- 						<td> -->
<%-- 							<input type='text' readonly value='${lecture.subject}'> --%>
<!-- 						</td> -->
					</tr>
					<tr>
						<th class='col-3 align-middle'>시작 일시</th>
						<td>
							<input type='text' name="startdate" class='date' readonly>
							<a id='delete' style="display: none;"><i class="font-r fa-regular fa-calendar-xmark"></i></a>
						</td>
						
						<th class='col-3 align-middle'>종료 일시</th>
						<td>
							<input type='text' name="duedate" class='date' readonly>
							<a id='delete' style="display: none;"><i class="font-r fa-regular fa-calendar-xmark"></i></a>
						</td>
					</tr>
					
					
				
				</table>
			</form>
			
			<div style='margin-bottom:20px;'>
				<a href='' class='btn-exam-empty mr-20 w-px120'>돌아가기</a>
				<a onClick='$("form").submit()' class='btn-exam-black w-px120'>등록하기</a>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

	<script>


		//날짜변경시 날짜삭제 버튼 나오게
		$('.date').change(function() {
			$(this).next().css('display', 'inline');
		});
		//날짜삭제 버튼 클릭시 날짜없애고, 날짜삭제 버튼도 안나오게
		$('#delete').click(function() {
			$(this).css('display', 'none');
			$(this).siblings('.date').val('');
		});

		//생년월일 특정날짜(만8세)까지만 선택가능하도록 제한
		var today = new Date();
		var endDay = new Date(today.getFullYear() - 8, today.getMonth(), today
				.getDate() - 1);
		var range = today.getFullYear() - 80 + ':' + endDay.getFullYear();
		
		$('.date').datepicker({
			yearRange : range,
			maxDate : endDay,
		});


	</script>	
</body>
</html>