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
		
			<form method='post' action='homework_new' enctype='multipart/form-data'>
				<table class="table">
					<tr>
						<th class="col-3 align-middle px-4 py-3">과제 제목</th>
						<td class="align-middle " colspan='3'>
							<input class='form-control' style = "width:100%" type="text"  name='title'>
						</td>
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
					
					<tr>
						<th class="col-3 align-middle px-4 py-3">
							<label for="profilepath">참고자료</label>
						</th>
						
						<td class="align-middle" colspan='3'>
							<input type='file' id='attach-file' style="border:none; padding: 0"
							accept="image/*" name='profilepath' class="w200">

							<a id='delete-file'><i class="font-r fa-solid fa-trash-can"></i></a>
						</td>
					</tr>
					<tr>
						<th class="col-3 align-middle">과제 설명</th>
						<td colspan='3'><textarea  name='content' class='form-control' ></textarea></td>
					</tr>
				</table>
			</form>
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