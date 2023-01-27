<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>공지 작성</h3>
	
	<div id="container">
		<div class="col-lg-7 mx-auto bg-white rounded shadow">
			<form method='post' action="notice_insert.le">
				<table class="table">
					<tr>
						<th class="col-3 align-middle px-4 py-3">공지제목</th>
						<td class="align-middle"><input class='form-control' type="text"  name='title'></td>
					</tr>
					
					<tr>
						<th class="col-3 align-middle px-4 py-3">공지내용</th>
						<td>
							<textarea class="form-control px-4 py-3" style="height:300px" name='content'></textarea>
						</td>
					</tr>
				</table>
				<input type="hidden" name="writer" value="${loginInfo.member_code }">
				<input type="hidden" name="lecture_code" value="${lecture_info.lecture_code}">
				<input type="hidden" name="category" value="no">
			</form>
				<div class='btnSet'>
					<a class='btn-fill save'>작성완료</a>
					<a class='btn-empty cancel'>취소</a>
				</div>
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