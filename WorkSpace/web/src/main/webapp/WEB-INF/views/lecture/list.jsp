<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의목록</title>
</head>

<body>
	<h1>강의목록</h1>
	${loginInfo }
	<li><strong> ${loginInfo.member_name }</strong></li>
	
	<table>
		<tr>
			<th>강의명</th>
			<th>과목</th>
			<th>담당강사</th>
			<th>시간</th>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td><a href='info.le?lecture_code='${vo.lecture_code }'>${vo.lecture_name }</a></td>
				<td>${vo.subject_code }</td>
				<td>${vo.teacher_name }</td>
				<td>${vo.timetable_code}교시</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>