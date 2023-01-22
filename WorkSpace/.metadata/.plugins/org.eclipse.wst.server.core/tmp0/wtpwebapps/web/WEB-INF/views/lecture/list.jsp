<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">

	<link href="css/table.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>강의목록</title>
</head>

<body>
	
	<div id="container py-5">
		
        <div class="row">
            <div class="col-lg-7 mx-auto bg-white rounded shadow">
            <h1>강의목록</h1>
		<table class="table table-fixed table-hover" >
		
		<thead>
			<tr>
				<th scope="col" class="col-3">강의명</th>
				<th scope="col" class="col-3">과목</th>
				<th scope="col" class="col-3">담당강사</th>
				<th scope="col" class="col-3">시간</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td class="col-3"><a href="lecture_home.le?lecture_code=${vo.lecture_code }">${vo.lecture_name }</a></td>
					<td class="col-3">${vo.subject_code }</td>
					<td class="col-3">${vo.teacher_name }</td>
					<td class="col-3">${vo.timetable_code}교시</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		</div>
	</div>
	

</body>
</html>