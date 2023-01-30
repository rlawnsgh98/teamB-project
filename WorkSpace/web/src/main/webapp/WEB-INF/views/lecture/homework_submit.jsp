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
	<h3>과제 제출</h3>
	
	<div class="container py-5">
		<div class="col-lg-7 mx-auto bg-white rounded shadow">
			<form method='post' action='homework_submit_insert.le' enctype='multipart/form-data'>
				<input type="hidden" name="member_code" value="${loginInfo.member_code }">
				<input type="hidden" name="homework_code" value="${info.homework_code }">
				
				<table class="table">
					<tr>
						<th class="col-3 align-middle">
							<label>과제 설명</label>
						</th>
						<td><textarea  name='content' class='form-control'></textarea></td>
					</tr>
					<tr>
						<th class="col-3">과제 업로드</th>
						<td>
							<div class='align'>
								<label> <input type='file' id='attach-file' style="border:none; padding: 0"
								 name='file' class="w200">
								</label> <span id='preview'></span> <a id='delete-file'><i
								class="font-r fa-solid fa-trash-can"></i></a>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class='btnSet'>
				<a class='btn-fill save'>제출하기</a>
				<a class='btn-empty cancel'>취소</a>
		</div>
	</div>		
	<script>
		$('.save').on('click', function(){
			$('form').submit();			
			
		});
		
		$('.cancel').on('click', function(){
			history.go(-1);
		});
	</script>						
</body>
</html>