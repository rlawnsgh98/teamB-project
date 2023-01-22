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
	<h3>공지 작성</h3>
	
	<div id="container py-5">
		<div class="col-lg-7 mx-auto bg-white rounded shadow">
		
			<form method='post' action='notice_write' enctype='multipart/form-data'>
				<table class="table">
					<tr>
						<th class="col-3 align-middle px-4 py-3">영상제목</th>
						<td class="align-middle">
							<input class='form-control' style = "width:100%" type="text"  name='title'>
						</td>
					</tr>
					
					<tr>
						<th class="col-3 align-middle px-4 py-3">
							<label for="profilepath">영상 업로드</label>
						</th>
						<td class="align-middle">
							<div class='align'>
								<label>
									<input type='file' id='attach-file' style="border:none; padding: 0"
									accept="image/*" name='profilepath' class="w200">
								</label> 
								<span id='preview'></span> <a id='delete-file'><i
								class="font-r fa-solid fa-trash-can"></i></a>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>						
</body>
</html>