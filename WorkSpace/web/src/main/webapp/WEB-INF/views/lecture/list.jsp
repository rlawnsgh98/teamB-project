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
	
	<div id="container py-5" style="margin-top: 100px; margin-bottom: 400px">
		
        <div class="row">
            <div class="col-lg-7 mx-auto bg-white rounded shadow">
            <h1>강의목록</h1>
		<table class="table table-hover" >
		
		<thead>
			<tr>
				<th scope="col" class="col-3">강의명</th>
				<th scope="col" class="col-3">과목</th>
				<c:if test="${loginInfo.type eq 'STUD' }">
					<th scope="col" class="col-3">담당강사</th>
				</c:if>
				<th scope="col" class="col-3">시간</th>
				
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td class="col-3"><a href="notice_list.le?lecture_code=${vo.lecture_code }">${vo.lecture_name}</a></td>
					<td class="col-3">${vo.subject_code }</td>
					<c:if test="${loginInfo.type eq 'STUD' }">
						<td class="col-3">${vo.teacher_name }</td>
					</c:if>
					<td class="col-3">${vo.timetable_code}교시(${vo.timetable_name })</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		</div>
	</div>
	

</body>
</html>