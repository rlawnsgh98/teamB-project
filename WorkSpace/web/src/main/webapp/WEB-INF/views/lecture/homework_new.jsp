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
<h3>과제 등록</h3>
	
	<div id="container py-5">
		<div class="col-lg-7 mx-auto bg-white rounded shadow">
		
			<form method='post' action='homework_insert.le' enctype='multipart/form-data'>
				<table class="table">
					<tr>
						<th class="col-3 align-middle px-4 py-3">과제 제목</th>
						<td class="align-middle " colspan='3'>
							<input class='form-control' style = "width:100%; height:30px" type="text"  name='title'>
						</td>
					</tr>
					
					<tr>
						<th class='col-3 align-middle'>시작 일시</th>
						<td>
							<input type='text' name="writedate" class='date' readonly>
							<a id='delete' style="display: none;"><i class="font-r fa-regular fa-calendar-xmark"></i></a>
						</td>
						
						<th class='col-3 align-middle'>종료 일시</th>
						<td>
							<input type='text' name="duedate" class='date' readonly>
							<a id='delete' style="display: none;"><i class="font-r fa-regular fa-calendar-xmark"></i></a>
						</td>
					</tr>
					
					<tr>
						<th class="col-3 align-middle px-4 py-3">
							<label for="profilepath">참고자료</label>
						</th>
						
						<td class="align-middle" colspan='3'>
							<input type='file' id='attach-file' style="border:none; padding: 0"
							 name='profilepath' class="w200">

							<a id='delete-file'><i class="font-r fa-solid fa-trash-can"></i></a>
						</td>
					</tr>
					<tr>
						<th class="col-3 align-middle">과제 설명</th>
						<td colspan='3'><textarea  name='content' class='form-control'></textarea></td>
					</tr>
				</table>
				<input type="hidden" name="member_code" value="${loginInfo.member_code }">
				<input type="hidden" name="lecture_code" value="${lecture_info.lecture_code}">
			</form>
			<div class='btnSet'>
				<a class='btn-fill save'>작성완료</a>
				<a class='btn-empty cancel'>취소</a>
			</div>			
			
		</div>
	</div>
	
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

	<script>

		var today = new Date();
		var endDay = new Date(today.getFullYear(), today.getMonth()+12, today.getDate());
		var range = today.getFullYear() + ':' + endDay.getFullYear();
		
		$('.date').datepicker({
			yearRange : range,
			maxDate : endDay,
		});

		
		$('.save').on('click', function(){
			$('form').submit();			
			
		});
		
		$('.cancel').on('click', function(){
			history.go(-1);
		});

	</script>	
</body>
</html>